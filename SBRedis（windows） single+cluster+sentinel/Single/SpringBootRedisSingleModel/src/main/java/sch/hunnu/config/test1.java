package sch.hunnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sch.hunnu.entity.user;

@Configuration
public class test1 {

	@Bean("user1")
	public user getUser(){
		
		return new user("lht",21,"man","18075147438");
	}
	

	@Bean("user11")
	public user getUser11(){
		
		return new user("lht11",21,"man11","1807514743811");
	}
}
