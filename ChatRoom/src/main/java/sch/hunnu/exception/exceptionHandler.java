package sch.hunnu.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ControllerAdvice + @ExceptionHandler 全局处理 Controller 层异常
 * @author Hi
 *
 */

@ControllerAdvice(basePackages="sch.hunnu.controller")
public class exceptionHandler  {
	
	
	Logger log = LoggerFactory.getLogger(exceptionHandler.class);
	
	//异常处理器
	@ExceptionHandler(value= Exception.class)  	//异常处理器 处理 Exception的异常
	@ResponseBody
	public JsonResult handlergirlAgeException(Exception e){
		
		log.error("gloablExceptionDeal", e.getMessage());
		
		return new JsonResult("-1", e.getMessage(), "failed");
	}
	
	
}
