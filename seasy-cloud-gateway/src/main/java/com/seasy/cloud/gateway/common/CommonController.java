package com.seasy.cloud.gateway.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;

@RestController
public class CommonController {
	Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@ApolloConfig
	private Config config;

	@GetMapping("/testApollo")
	public String testApollo(){
		return getPrefix() + " : test apollo!";
	}
	
	private String getPrefix(){
		return config.getProperty("app-prefix", "");
	}
}
