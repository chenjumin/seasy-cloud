package com.seasy.cloud.frontweb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.seasy.cloud.base.Address;
import com.seasy.cloud.base.User;
import com.seasy.cloud.frontweb.feignclient.UserFeignClient;

@RestController
public class FrontwebController {
	Logger logger = LoggerFactory.getLogger(FrontwebController.class);
	
	@Autowired
    UserFeignClient userFeignClient;
	
	@ApolloConfig
	private Config config;

	@GetMapping("/user/{id}")
	public String getUser(@PathVariable(value="id") Long id){
		logger.debug("logger level is debug: id={}", id);
		logger.warn("logger level is warn: id={}", id);
		
		return userFeignClient.get(id) + " : " + System.currentTimeMillis();
	}
	
	@GetMapping("/user/query")
	public String query(@RequestParam(value="name") String name){
		return userFeignClient.query(name);
	}

	@PostMapping("/user/add")
	public User add(@RequestBody User user){
		return userFeignClient.add(user);
	}
	
	@GetMapping("/address/list")
	public List<Address> getAllAddress(){
		return userFeignClient.getAllAddress();
	}

	@GetMapping("/testApollo")
	public String testApollo(){
		return getPrefix() + " : test apollo!";
	}
	
	private String getPrefix(){
		return config.getProperty("app-prefix", "");
	}
}
