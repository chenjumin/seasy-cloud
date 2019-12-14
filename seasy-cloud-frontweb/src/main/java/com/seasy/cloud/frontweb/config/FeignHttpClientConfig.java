package com.seasy.cloud.frontweb.config;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignHttpClientConfig {
	@Bean
	public HttpClient httpClient(){
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(5000)
				.setSocketTimeout(2000)
				.setConnectionRequestTimeout(2000)
				.build();
		
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setMaxTotal(2000);
		connectionManager.setDefaultMaxPerRoute(100);
		
		HttpClientBuilder builder = HttpClientBuilder.create();
		builder.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());
		builder.setConnectionManager(connectionManager);
		builder.setDefaultRequestConfig(requestConfig);
		builder.setRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
		
		HttpClient client = builder.build();
		
		//启动定时器，定时回收过期的连接
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	connectionManager.closeExpiredConnections();
            	connectionManager.closeIdleConnections(5, TimeUnit.SECONDS);
            }
        }, 10 * 1000, 5 * 1000);
        System.out.println("===== Apache httpclient 初始化连接池===");
	
		return client;
	}
}
