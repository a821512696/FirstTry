package sch.hunnu.controller;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {

	
	@GetMapping("/index")
	public String index(){
		System.out.println("index() run !");
		return "index";
	}
	
	/*
	 * 偷懒不想写前端- -
	 * 表单方式提交，获取toMailAddress ,title 和 bodyContent 然后调用工具类就行了...
	 * ajax 发一下 然后系统验证生成 验证码 然后发送邮件给 ajax传过来的toMailAddress即可 
	 * 成功或者失败的结果  再返回到responseBody里。
	 */
}
