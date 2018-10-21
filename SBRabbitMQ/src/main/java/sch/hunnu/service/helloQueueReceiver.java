package sch.hunnu.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import sch.hunnu.entity.User;

@Service		//将本类注入IOC 当然前提是启动类要扫描本包

public class helloQueueReceiver {
	/*------------监听使用默认exchange 且以direct方式 绑定的hello的队列-------------*/
	@RabbitListener(queues="hello")			//被本注释修饰的方法 用来 监听名字为hello的队列
	public void dealHello(String message){
		System.out.println("我是消费者 我接受的数据 :"+message+"\n");
	}
	
	
	 
	
	/*------------监听名字为fanoutType的exchange 所绑定的那 3个队列--------*/
	@RabbitListener(queues="fan.A")			 
	public void dealfanA(String message){
		System.out.println("我是消费者 我接受的数据 来自队列fan.A:"+message+"\n");
	}
	
	@RabbitListener(queues="fan.B")			 
	public void dealfanB(String message){
		System.out.println("我是消费者 我接受的数据 来自队列fan.B:"+message+"\n");
	}
	
	@RabbitListener(queues="fan.C")			 
	public void dealfanC(String message){
		System.out.println("我是消费者 我接受的数据 来自队列fan.C:"+message+"\n");
	}
	
	
	/*------------监听名字为topicType的exchange 所绑定的那 2个队列--------*/
	@RabbitListener(queues="topic.One")			 
	public void dealtopicOne(String message){
		System.out.println("我是消费者 我接受的数据 来自队列topic.One:"+message+"\n");
	}
	
	@RabbitListener(queues="topic.Two")			 
	public void dealtopicTwo(String message){
		System.out.println("我是消费者 我接受的数据 来自队列topic.Two:"+message+"\n");
	}
	@RabbitListener(queues="topic.3")			 
	public void dealtopic3(String message){
		System.out.println("我是消费者 我接受的数据 来自队列topic.3:"+message+"\n");
	}
	
	
	/*------------------1 to N  ,N to N----------------------*/
	
	@RabbitListener(queues="user")			 
	public void dealuser1(User p){
		System.out.println("我是消费者1 我接受的数据 来自队列topic.3:"+p.toString()+"\n");
	}
	
	
	@RabbitListener(queues="user")			 
	public void dealuser2(User p){
		System.out.println("我是消费者2 我接受的数据 来自队列topic.3:"+p.toString()+"\n");
	}
	
}
