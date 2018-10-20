package sch.hunnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sch.hunnu.entity.user;
import sch.hunnu.entity.user2;

@Configuration
public class test2 {

	@Bean("user2")
	public user2 getUser(user user11){
		
		return new user2("lht"+user11.getName(),21,"man"+user11.getSex(),user11.getPhone());
	}
}
