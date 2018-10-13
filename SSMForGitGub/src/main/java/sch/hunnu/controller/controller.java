package sch.hunnu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sch.hunnu.service.service;

@Controller
public class controller {

	@Autowired
	private service service;
	
	@RequestMapping(value="/head",method=RequestMethod.GET)
	public String head(){
		
		System.out.println("head run to homePage");
		return "jsp/hello";
		
	} 
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(HttpServletRequest request){
		
		System.out.println("head run to homePage");
		//request.setAttribute("girl", service.selectById(8));
		//System.out.println(service.selectById(8));
		request.setAttribute("girl", service.selectByIdXml(8));
		System.out.println(service.selectByIdXml(8));
		
		return "index";
		
	} 
}
