package sch.hunnu.Aspect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class controllerAop {
	
	private final static Logger logger = LoggerFactory.getLogger(controllerAop.class);	//使用spring自带的log框架
	
	@Pointcut("execution(public * sch.hunnu.controller.controller.*(..))")
	public void Pcut(){}
	
	//对请求进行检测 查看session里的用户是否存在 不存在则调用跳转页面
	@Before("Pcut()")
	public void after(JoinPoint joinPoint) throws Exception{
	//获取请求参数
	 ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	 HttpServletResponse response =attr.getResponse();
	 //获取请求对象
	 HttpServletRequest request = attr.getRequest();
 
	 HttpSession session = request.getSession();
	 if(session==null || session.getAttribute("currUser")==null){
		 //跳转到登陆界面
		 System.out.println("\n\n\n\n123123\n\n\n\n");
		 request.getRequestDispatcher("/returnToLogin").forward(request, response);
		 throw new Exception("登录信息过期");
	 }

	}
	
	
	
}
