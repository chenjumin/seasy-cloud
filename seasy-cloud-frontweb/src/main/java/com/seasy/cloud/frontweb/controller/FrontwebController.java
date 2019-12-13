package com.seasy.cloud.frontweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seasy.cloud.base.Address;
import com.seasy.cloud.base.User;
import com.seasy.cloud.frontweb.feignclient.UserFeignClient;

@RestController
public class FrontwebController {
	@Autowired
    UserFeignClient userFeignClient;

	@GetMapping("/user/{id}")
	public String getUser(@PathVariable(value="id") Long id){
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
}
