package com.seasy.cloud.userservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
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

@RestController
public class UserController {
	//apollo config
	@ApolloConfig
	private Config config;
	@Value("${userservice-key1:}")
	private String key1;
	
	@GetMapping("/user/{id}")
	public String get(@PathVariable(value="id") Long id){
		return  getPrefix() + id;
	}
	
	@GetMapping("/user/query")
	public String query(@RequestParam(value="name") String name){
		return getPrefix() + "名字=" + name;
	}

	@PostMapping("/user/add")
	public User add(@RequestBody User user){
		return user;
	}
	
	@GetMapping("/address/list")
	public List<Address> getAllAddress(){
		List<Address> list = new ArrayList<>();
		Address address1 = new Address("省1", "city1");
		Address address2 = new Address("province11", "市11");
		list.add(address1);
		list.add(address2);
		return list;
	}
	
	private String getPrefix(){
		return config.getProperty("app-prefix", "") + ":" + key1 + ":";
	}
}
