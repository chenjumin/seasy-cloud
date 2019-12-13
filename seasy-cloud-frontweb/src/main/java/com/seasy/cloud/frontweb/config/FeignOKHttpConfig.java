package com.seasy.cloud.frontweb.config;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

@Configuration
@ConditionalOnClass(OkHttpClient.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignOKHttpConfig {
	@Bean
	public okhttp3.OkHttpClient okHttpClient(){
		return new okhttp3.OkHttpClient.Builder()
				.connectTimeout(10, TimeUnit.SECONDS)
				.readTimeout(10, TimeUnit.SECONDS)
				.writeTimeout(10, TimeUnit.SECONDS)
				.retryOnConnectionFailure(true)
				.connectionPool(new ConnectionPool())
				.build();
	}
}
