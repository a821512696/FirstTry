package sch.hunnu.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class publicBean {

	@Bean("pubList")
	public List<String> list(){
		return new ArrayList<String>();
	}
}
