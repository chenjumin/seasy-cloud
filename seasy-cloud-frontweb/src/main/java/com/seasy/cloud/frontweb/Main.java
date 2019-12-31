package com.seasy.cloud.frontweb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.seasy.cloud.base.web.DefaultWebMvcConfig;

@RestController
@EnableEurekaClient
@EnableFeignClients
@EnableApolloConfig
@SpringBootApplication
public class Main {
	@Value("${spring.application.name}")
	private String appname;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	@Bean
	public DefaultWebMvcConfig getDefaultWebMvcConfig(){
		return new DefaultWebMvcConfig();
	}
	
	@GetMapping("/index")
	public String index(){
		return appname;
	}
}
