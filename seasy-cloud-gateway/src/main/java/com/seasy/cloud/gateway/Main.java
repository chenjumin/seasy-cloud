package com.seasy.cloud.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.seasy.cloud.base.web.DefaultWebMvcConfig;
import com.seasy.cloud.gateway.filter.Custom1GatewayFilterFactory;

@RestController
@EnableEurekaClient
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
	
	/**
	 * 服务路由的负载均衡策略
	 */
	@Bean
	public IRule feignRule(){
	    return new RandomRule();
	}
	
	/**
	 * 自定义过滤器
	 */
//	@Bean
//	@Order(0) //指定执行的顺序：数字越小，优先级越高
//	public AuthFilter getAuthFilter(){
//		return new AuthFilter();
//	}
//	
//	@Bean
//	@Order(1)
//	public DefaultGlobalFilter getDefaultGlobalFilter(){
//		return new DefaultGlobalFilter();
//	}
	
	@Bean
	public Custom1GatewayFilterFactory getPreGatewayFilterFactory(){
		return new Custom1GatewayFilterFactory();
	}
	
}
