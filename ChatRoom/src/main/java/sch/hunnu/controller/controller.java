package sch.hunnu.controller;

import java.util.List; 

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.hunnu.entity.priChat;
import sch.hunnu.entity.priSend;
import sch.hunnu.entity.pubChat;
import sch.hunnu.entity.user;
import sch.hunnu.service.ChatService;
import sch.hunnu.utils.dateUtil;


@Controller
public class controller {
	
	@Autowired
	private ChatService service;
	
	@Resource(name="pubList")
	private List<String> list;
	
	
	//获取私聊内容
	@PostMapping("/getPri")
	@ResponseBody
	public List<priChat> getPri(HttpServletRequest request){
		String otherAcc = request.getParameter("otherAcc");
		HttpSession session =request.getSession();
		user p = (user) session.getAttribute("currUser");
		
		String myAcc = p.getAcc();
		return service.getPriChatContents(myAcc, otherAcc);
	}
	
	
	//获取公聊内容
		@PostMapping("/getPub")
		@ResponseBody
		public List<pubChat> getPub(HttpServletRequest request){
			String groupId = request.getParameter("groupId");
			 List<pubChat> ss = service.getPubChatNotes(groupId);
			 return ss;
		}
		
		//插入一条私聊数据
	@PostMapping("/newPri")
	@ResponseBody
	public String newPri(priSend p){
		System.out.println("私聊中插入数据为"+p.toString());
		p.setTime(dateUtil.getDateNow());
		
		if(service.insertIntoPriChat(p)==1){
			return "1";
		}else{
			return"0";
		}
	}
	
	//插入一条公聊数据
	@PostMapping("/newPub")
	@ResponseBody
	public String newPub(pubChat p){
		System.out.println("公聊中插入数据为"+p.toString());
		p.setTime(dateUtil.getDateNow());
		
		if(service.insertIntoPuChat(p)==1){
			return "1";
		}else{
			return"0";
		}
	}
	
	
	//跳转到聊天界面
	@GetMapping("/chat")
	public String chat(HttpServletRequest request){
		request.setAttribute("name", "李宏涛");
		return "chat";
	}	
	//跳转到主页（聊天）
	@GetMapping("/index")
	public String index(HttpServletRequest request){
		request.getSession(true);			//如果没有session则创建一个session
		return "index";
	}
	
	
	@PostMapping("/getList")
	@ResponseBody
	public List<user> getList(HttpServletRequest request){
		//从session里取出账号
		//查一下id和账号 结果保存在request里
		return service.getChatList("s1");
	}
	
	/**
	 * 用来监控session
	 * @param request
	 */
	@PostMapping("/sessionLife")
	@ResponseBody
	public String sessionLife(HttpServletRequest request){
		HttpSession session =request.getSession();		
		
		session.setAttribute("sLife",System.currentTimeMillis());	//更新收到响应的时间
		return "1";
		
	}
	
	
}
