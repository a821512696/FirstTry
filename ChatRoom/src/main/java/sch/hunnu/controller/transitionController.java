package sch.hunnu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.hunnu.entity.user;
import sch.hunnu.service.ChatService;

@Controller
public class transitionController {
	@Autowired
	private ChatService service;
	
	@Resource(name="pubList")
	private List<String> list;

	//跳转到登录界面
	@GetMapping("/login")
	public String login(HttpServletRequest request){
		return "login";
	}
	
	//登陆检测
	@PostMapping("/loginCheck")
	@ResponseBody
	public String loginCheck(HttpServletRequest request){
		String acc = request.getParameter("acc");
		String pw = request.getParameter("pw");
		//调用dao的查询即可
		user p =service.loginCheck(acc, pw);
		if(p==null)return "0";
		else {
			request.getSession(true).setAttribute("currUser", p);  		//将信息保存在session中
			return "1";
		}
	}
	
	
	//跳转到登陆页面
	@GetMapping("/toLogin")
	public String toLogin(){
		return "login";
	}
	//跳转到登陆页面
		@GetMapping("/ssd")
		public String ssd() throws Exception{
			throw new Exception("我抛出来的错误");
			//return "login";
		}
		
	
	//跳转到过渡页面
	@GetMapping("/returnToLogin")
	public String returnToLogin(){
		return "returnToLogin";
	}
}
