package com.seasy.cloud.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.seasy.cloud.base.web.DefaultWebMvcConfig;

@EnableEurekaClient
@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	@Bean
	public DefaultWebMvcConfig getDefaultWebMvcConfig(){
		return new DefaultWebMvcConfig();
	}
}
