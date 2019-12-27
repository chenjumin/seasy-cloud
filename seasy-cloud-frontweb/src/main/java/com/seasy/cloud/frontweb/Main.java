package com.seasy.cloud.frontweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.seasy.cloud.base.LoggingLevelRefresher;

@EnableEurekaClient
@EnableFeignClients
@EnableApolloConfig
@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	@Bean
	public LoggingLevelRefresher getLoggingLevelRefresher(){
		return new LoggingLevelRefresher();
	}
}
