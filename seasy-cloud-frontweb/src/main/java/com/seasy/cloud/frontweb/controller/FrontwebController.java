package com.seasy.cloud.frontweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.seasy.cloud.frontweb.feignclient.UserFeignClient;

@RestController
public class FrontwebController {
	@Autowired
    UserFeignClient userFeignClient;

	@GetMapping("/user/{id}")
	public String getUser(@PathVariable(value="id") Long id){
		String result = userFeignClient.get(id);
		System.out.println("result=" + result);
		result = result + " : " + System.currentTimeMillis();
		return result;
	}
}
