package sch.hunnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.hunnu.service.service;

@Controller
public class controller {

	
	@Autowired
	service service ;
	@GetMapping("/hostPage")
	public String toHost(){
		return "thymeleaf/index";
	}
	
	
	/**
	 * 打印出指定记录到 http responseBody中
	 * @param myPhone
	 * @return
	 */
	@GetMapping("/getUser/{phone}")
	@ResponseBody
	public String getUserByPhone(@PathVariable(value="phone")String myPhone){
		return service.selectByPhone(myPhone).toString();
		
	}
	
	
}
