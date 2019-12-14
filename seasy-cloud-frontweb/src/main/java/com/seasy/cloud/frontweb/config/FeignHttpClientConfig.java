package com.seasy.cloud.frontweb.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(FeignAutoConfiguration.class)
@ConditionalOnProperty(value = "feign.httpclient.enabled", matchIfMissing = true)
public class FeignHttpClientConfig {	
	@Bean(destroyMethod="close")
	public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager(){
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setMaxTotal(100);
		connectionManager.setDefaultMaxPerRoute(50);
		return connectionManager;
	}
	
	@Bean
	public HttpClientBuilder httpClientBuilder(HttpClientConnectionManager connectionManager){
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(5000)
				.setSocketTimeout(2000)
				.setConnectionRequestTimeout(2000)
				.build();
		
		HttpClientBuilder builder = HttpClientBuilder.create();
		builder.setConnectionManager(connectionManager);
		builder.setDefaultRequestConfig(requestConfig);
		builder.setRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
		return builder;
	}
	
	@Bean
	public HttpClient httpClient(HttpClientBuilder httpClientBuilder){
		return httpClientBuilder.build();
	}
}
