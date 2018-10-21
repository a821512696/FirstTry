package sch.hunnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sch.hunnu.entity.User;
import sch.hunnu.service.helloQueueSend;

@RestController
public class controller {
	@Autowired
	private helloQueueSend sender;
	
	/**
	 * 1对多
	 * 测试结果看
	 * spring.rabbitmq.listener.simple.prefetch=1
	 * 起作用了
	 * 每个队列一次只接受一次信息，处理完后才能继续接受信息
	 * @return
	 */
	@GetMapping("/oneToMore")
	public String oneToMore(){
		User p;
		for(int i =0;i<10;i++){
			p= new User("lht"+i,"man", 21);
			sender.sendUser(p);
			//System.out.println("我是生产者1 我发送的数据是 ："+p.toString());
		}
		return "请查看控制台~ o(^▽^)o";
	}
	
	/**
	 *	测试结果来看确实能达到多对多，接受者一起处理的效果。 
	 *
	 * @return
	 */
	@GetMapping("/MoreToMore")
	public String MoreToMore(){
		User p;
		for(int i =0;i<10;i++){
			p= new User("lht"+i,"man1", 21);
			sender.sendUser(p);
			p.setSex("man2");
			sender.sendUser2(p);
			//System.out.println("我是生产者1 我发送的数据是 ："+p.toString());
		}
		return "请查看控制台~ o(^▽^)o";
	}
}
