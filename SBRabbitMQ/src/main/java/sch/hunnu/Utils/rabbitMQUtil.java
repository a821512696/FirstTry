package sch.hunnu.Utils;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class rabbitMQUtil {
	
	final static String queueName="hello";
	
	/*---------------direct方式（可以使用默认exchange）---------------*/
	@Bean
	public Queue helloQueue(){
		return new Queue("hello");
	}
	
	@Bean
	public DirectExchange directExchange(){
		return new DirectExchange("directType");
	}
	
	@Bean
	public Binding directBind(Queue helloQueue,DirectExchange directExchange){
		// 本绑定规则是 Exchange 使用的是direct模式 故而client提供的routekey需要等于本方法设置的routekey
		//.with("hello") 作用是设置了一个routekey 值为hello
		return BindingBuilder.bind(helloQueue).to(directExchange).with("hello");
		
	}
	
	/*---------------direct方式结束----------------------------------*/
	
	/*---------------fanout(广播)方式（自定义exchange）广播方式，即和exchange绑定的queue都会收到信息的----------------*/
	/*我创建了3个队列  一个exchange ,再将它们绑定起来*/
	@Bean
	public Queue fanoutA(){
		return new Queue("fan.A");
	}
	@Bean
	public Queue fanoutB(){
		return new Queue("fan.B");
	}
	@Bean
	public Queue fanoutC(){
		return new Queue("fan.C");
	}
	@Bean
	public FanoutExchange fanExchange(){
		return new FanoutExchange("fanoutType");
	}
	
	/*
	 * ps:这里的参数名字应当是要和 IOC容器里的对应的，而@Bean这个方式注入 默认id=方法名的 
	 *	所以这里参数的名字是fanExchange 和上面的方法名一致，当然也可以自己定义
	 */
	@Bean
	public Binding bindFanA(FanoutExchange fanExchange,Queue fanoutA){
		//这就将 队列fanoutA和FanoutExchange类型的fanExchange绑定了
		return BindingBuilder.bind(fanoutA).to(fanExchange);
	}
	
	@Bean
	public Binding bindFanB(FanoutExchange fanExchange,Queue fanoutB){
		//这就将 队列fanoutB和FanoutExchange类型的fanExchange绑定了
		return BindingBuilder.bind(fanoutB).to(fanExchange);
	}
	
	@Bean
	public Binding bindFanC(FanoutExchange fanExchange,Queue fanoutC){
		//这就将 队列fanoutC和FanoutExchange类型的fanExchange绑定了
		return BindingBuilder.bind(fanoutC).to(fanExchange);
	}
	/*-------------------------fanout方式结束---------------------------------*/
	
	/*-----------------Topic(转发)方式 (按照with后面给定的routekey模糊匹配 客户端提供的routekey)--------------*/
	
	@Bean
	public Queue topicOne(){
		return new Queue("topic.One");
	}
	
	@Bean
	public Queue topicTwo(){
		return new Queue("topic.Two");
	}
	
	@Bean
	public Queue topic3(){
		return new Queue("topic.3");
	}
	
	@Bean
	public TopicExchange topicExchange(){
		return new TopicExchange("topicType");
	}
	
	/**
	 * 符号#意味着0个或多个单词
	 * 所以A.# 可以匹配A 、A.B、A.B.C ...
	 * 故而 当生产客户端发送符合A.#匹配的routekey给 名字为topicType的exchange时，会将信息移交给名字为topicOne的队列进行后续处理
	 * @param topicOne
	 * @param topicExchange
	 * @return
	 */
	@Bean
	public Binding topicBindingOne(Queue topicOne,TopicExchange topicExchange){
		
		return BindingBuilder.bind(topicOne).to(topicExchange).with("A.#");
	}
	
	/**
	 *  *代表一个
	 *  所以符合B.*的匹配如B.A、B.c ....
	 *  
	 * @param topicTwo
	 * @param topicExchange
	 * @return
	 */
	@Bean
	public Binding topicBindingTwo(Queue topicTwo,TopicExchange topicExchange){
		
		return BindingBuilder.bind(topicTwo).to(topicExchange).with("B.*");
	}
	/*-----------------Topic(转发)方式 (按照with后面给定的routekey模糊匹配 客户端提供的routekey)结束--------------*/
	
	/**
	 * 测试一下 是不是只有 C才能匹配 
	 * @param topic3
	 * @param topicExchange
	 * @return
	 */
	@Bean
	public Binding topicBinding3(Queue topic3,TopicExchange topicExchange){
		
		return BindingBuilder.bind(topic3).to(topicExchange).with("C");
	}
	
	
	/*----------用user来做一对多，多对多的实现----------*/
	@Bean
	public Queue User(){
		return new Queue("user");
	}
	
	
	
	
	
	
	
	
}
