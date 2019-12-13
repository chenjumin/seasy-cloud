package com.seasy.cloud.frontweb.feignclient;

import java.util.List;

import org.springframework.stereotype.Component;

import com.seasy.cloud.base.Address;
import com.seasy.cloud.base.User;

import feign.hystrix.FallbackFactory;

@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{
	@Override
	public UserFeignClient create(Throwable ex) {
		return new UserFeignClient() {
			@Override
			public String get(Long id) {
				showErrorReason();
				return null;
			}
			
			@Override
			public String query(String name) {
				return null;
			}
			
			@Override
			public User add(User user) {
				return null;
			}
			
			@Override
			public List<Address> getAllAddress() {
				return null;
			}
			
			private void showErrorReason(){
				System.out.println(ex.toString());
			}
		};
	}
}
