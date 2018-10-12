package sch.hunnu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {

	
	@GetMapping("/Home_Page")
	public String toHome(){
		return "thymeleaf/index";
	}
	
	
	@PostMapping("/check")
	@ResponseBody
	public String check(HttpServletRequest request){
		String tel = request.getParameter("tel");
		System.out.println(tel);
		System.out.println("check  is running !!!");
		return "信息发送失败";
	}
}
