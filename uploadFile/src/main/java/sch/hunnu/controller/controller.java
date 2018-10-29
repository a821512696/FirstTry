package sch.hunnu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.hunnu.utils.uploadFileUtils;

@Controller
public class controller {

	@GetMapping("/index")
	public String index(){
		
		return "index";
	}
	
	@GetMapping("/form")
	public String form(){
		return "form";
	}
	

	@GetMapping("/form2")
	public String form2(){
		return "form2";
	}
	
	@PostMapping("/fileOne")
	@ResponseBody
	public String fileOne(HttpServletRequest request) throws IOException{
		return uploadFileUtils.uploadFiles(request);
		 
	}
	
	@PostMapping("/fileMany")
	@ResponseBody
	public String fileMany(HttpServletRequest request) throws IOException{
		return uploadFileUtils.uploadFiles(request);
		 
	}
}
