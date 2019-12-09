package com.seasy.cloud.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@GetMapping("/user/{id}")
	public String get(@PathVariable(value="id") Long id){
		return "seasy-cloud-userservice:4001:" + id;
	}
}
