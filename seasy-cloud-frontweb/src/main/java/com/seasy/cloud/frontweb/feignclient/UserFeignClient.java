package com.seasy.cloud.frontweb.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.seasy.cloud.base.Address;
import com.seasy.cloud.base.User;

@FeignClient(name="seasy-cloud-userservice", fallbackFactory=UserFeignClientFallbackFactory.class)
public interface UserFeignClient {
	@GetMapping("/user/{id}")
	String get(@PathVariable(value="id") Long id);
	
	@GetMapping("/user/query")
	String query(@RequestParam(value="name") String name);

	@PostMapping("/user/add")
	User add(@RequestBody User user);
	
	@GetMapping("/address/list")
	List<Address> getAllAddress();
}
