package com.seasy.cloud.gateway.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 熔断器控制类
 */
@RestController
public class HystrixController {
	@GetMapping("/hystrixCommandFallback")
	public Response hystrixCommandFallback(){
		Response response = new Response(100, "服务暂时不可用");
		return response;
	}
}
