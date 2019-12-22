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
		UserFeignClientImpl userFeignClient = new UserFeignClientImpl();
		userFeignClient.setCause(ex);		
		return userFeignClient;
	}
	
	private class UserFeignClientImpl implements UserFeignClient{
		private Throwable cause;

		@Override
		public String get(Long id) {
			showErrorReason();
			return null;
		}
		
		@Override
		public String query(String name) {
			showErrorReason();
			return null;
		}
		
		@Override
		public User add(User user) {
			showErrorReason();
			return null;
		}
		
		@Override
		public List<Address> getAllAddress() {
			showErrorReason();
			return null;
		}
		
		private void showErrorReason(){
			System.out.println("进入熔断处理类...");
			if(getCause() != null){
				System.out.println(getCause().toString());
			}
		}
		
		public Throwable getCause() {
			return cause;
		}

		public void setCause(Throwable cause) {
			this.cause = cause;
		}
	}
	
}
