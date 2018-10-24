package sch.hunnu.service;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sch.hunnu.Utils.dateUtil;
import sch.hunnu.entity.User;

/**
 * 本类用来对hello队列进行发送信息
 * AmqpTemplate 的 API 如下
 * https://docs.spring.io/spring-amqp/docs/1.5.6.RELEASE/api/org/springframework/amqp/core/AmqpTemplate.html
 * @author Hi
 *
 */
@Service
public class helloQueueSend {
	
	@Autowired
	private AmqpTemplate rabbit;
	
	
	public String send(){
		
		String message = "id = "+(int)(Math.random()*10)+"  Hello World!"+dateUtil.getDate();
		System.out.println("我是生产者 我生产的数据："+message+"\n");
		//发送信息 到名字为hello的队列
		//ps : 
		//convertAndSend(String routingKey, Object message)
		//将Java对象转换为Amqp Message并将其发送到具有特定路由键的默认交换。这里使用的direct方式 即routekey = queueName
		this.rabbit.convertAndSend("directType","hello",message);
		return "我是生产者 我生产的数据："+message;
	}
	
	
	public String sendFanoutType(){
		String message = "id = "+(int)(Math.random()*10)+"   Hello World!"+dateUtil.getDate();
		String str = "我是生产者 我生产的数据："+message+"  By fanout type\n";
		System.out.println(str);
		//因为是fanout方式 故而 routekey可以填空的，反正也用不到了。
		this.rabbit.convertAndSend("fanoutType", "", message);
		return str;
		
	}
	
	/**
	 * 
	 * 根据客户端传过来的参数routekey 进行模糊匹配（匹配的模式串见 rabbitMQUtil.java） 进而将信息发送给匹配成功的队列
	 * @param routekey
	 * @return
	 */
	public String sendTopicType(String routekey){
		String message = "id = "+(int)(Math.random()*10)+"   Hello World!"+dateUtil.getDate();
		String str = "我是生产者 我生产的数据："+message+"  By topic type\n";
		System.out.println(str);
		//因为是topic方式 故而 传入routeKey
		this.rabbit.convertAndSend("topicType", routekey, message);
		return str;
		
	}
	
	
	public String sendUser(User p){
		String str = "我是生产者1 我生产的数据："+p.toString();
		System.out.println(str);
		//默认路由方式 （可能是direct吧）exchange不写就意味着使用默认路由了，这会发送给名字为user的这个队列
		this.rabbit.convertAndSend("user", p);
		return str;
	}
	
	public String sendUser2(User p){
		String str = "我是生产者2 我生产的数据："+p.toString();
		System.out.println(str);
		//默认路由方式 （可能是direct吧）exchange不写就意味着使用默认路由了，这会发送给名字为user的这个队列
		this.rabbit.convertAndSend("user", p);
		return str;
	}
	
	
	
}
