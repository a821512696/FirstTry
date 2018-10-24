package sch.hunnu.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.hunnu.Utils.buildCheckPic;
import sch.hunnu.Utils.buildStr;
import sch.hunnu.service.picService;

@Controller
public class controller {

	@Autowired
	private picService service;
	
	@GetMapping("/index")
	public String index(){
		System.out.println("index run!");
		return "index";
	}
	
	
	@GetMapping("/check")
	public String check(){
		System.out.println(" check run !");
		return "check";
	}
	
	
	@GetMapping("/getpic")
	@ResponseBody				//直接显示输出流的内容，不进行渲染。
	public void getPic(HttpServletResponse response,HttpServletRequest request){
	
		service.buildCheckPic(request,response);	//执行制作验证码,保存验证码
	
	}
 
	@GetMapping("/submit")
	@ResponseBody				//直接显示输出流的内容，不进行渲染。
	public String submit(HttpServletRequest request){
	
		if(service.doCheck(request))return "1";	//执行制作验证码,保存验证码
		else return "0";
	}
}
