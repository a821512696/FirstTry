package sch.hunnu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {

	
	@GetMapping("/redis")
	public String returnRedis(){
		return "redis";
	}
	
}
