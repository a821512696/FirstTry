package sch.hunnu.servlet.utils;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

import sch.hunnu.threads.sessionThread;


@WebListener
public class sessionListener implements HttpSessionListener{
	
	Logger log = LoggerFactory.getLogger(sessionListener.class);
	
	@Resource(name="pubList")
	private List<String>  list ;
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		
		HttpSession session = event.getSession();
		
		list.add(event.getSession().getId());				//session生成后就放在list里
		session.setAttribute("sLife",System.currentTimeMillis());	//保存当前时间
		
		//当session 新建以后就开启一个线程 进行检查页面是否超时了 (超时时间为2分钟)
		Thread t = new Thread(new sessionThread(session));
		t.setDaemon(true);  								//设置为后台进程
		t.start();					
		
		System.out.println("session: "+session.getId()+" 开始了!");
		System.out.println("/n/n/n/n sessionTime is: "+session.getMaxInactiveInterval()+"/n/n/n/n");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		
		System.out.println(" session :"+session.getId()+" 结束了!");
		
		list.remove(session.getId());				//session消亡后就从list移出
		
		//进行user移出操作
	}

	 
}
