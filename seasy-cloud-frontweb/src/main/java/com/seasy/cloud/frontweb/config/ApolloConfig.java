package com.seasy.cloud.frontweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seasy.cloud.base.LoggingLevelRefresher;

@Configuration
public class ApolloConfig {
	@Bean
	public LoggingLevelRefresher getLoggingLevelRefresher(){
		return new LoggingLevelRefresher();
	}
}
