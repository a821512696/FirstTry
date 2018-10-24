package sch.hunnu.service;

import java.awt.image.BufferedImage;  
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import sch.hunnu.Utils.buildCheckPic;
import sch.hunnu.Utils.buildStr;

@Service
public class picService {

	
	public void buildCheckPic(HttpServletRequest request,HttpServletResponse response){
		String str = buildStr.getCheckStr();	//生成验证码
		BufferedImage img =  buildCheckPic.buildPic(str);	//画出来验证码图片
		
	      try {
	    	request.getSession().setAttribute("checkStr", str);		//将验证码保存到session中以便用来验证
	    	System.out.println(request.getSession().getAttribute("checkStr"));
	    	
			ImageIO.write(img, "jpg", response.getOutputStream());	//验证码图片写入response输出流
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error: picService .buildCheckPic(HttpServletRequest request,HttpServletResponse response); ");
		}
	}
	
	public boolean doCheck(HttpServletRequest request){
		String userStr = request.getParameter("userStr").trim().toUpperCase();		//获取用户的输入然后大写
		String str = (String) request.getSession().getAttribute("checkStr");	//获取正确答案
		
		System.out.println(str+"          user: "+userStr);		
		
		//比较
		if(userStr!=null && !userStr.equals("")){
			if(userStr.equals(str))return true;
			else return false;
		}else{
			return false;
		}
	}
}
