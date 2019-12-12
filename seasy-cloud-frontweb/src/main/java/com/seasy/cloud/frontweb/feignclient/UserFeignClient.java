package com.seasy.cloud.frontweb.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="seasy-cloud-userservice")
public interface UserFeignClient {
	@GetMapping("/user/{id}")
	String get(@PathVariable(value="id") Long id);
}
