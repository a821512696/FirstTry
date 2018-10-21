package sch.hunnu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sch.hunnu.service.helloQueueSend;

@SpringBootApplication
@ComponentScan("sch.hunnu.*")
@RestController
public class SbRabbitMqApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SbRabbitMqApplication.class, args);
		System.out.println("rabbit over!");
	}
	
	
	@Autowired
	private helloQueueSend sender;
	
	
	@GetMapping("/direct")
	public String singleSendAndReceive(){
		System.out.println("let direct go!");
		return sender.send();
	}
	
	@GetMapping("/fanout")
	public String fanout(){
		System.out.println("let fanout go!");
		return sender.sendFanoutType();
	}
	
	
	
	/**
	 * 模糊匹配中的 *代表一个  #代表零个或多个
	 * .号用来分割单词如.A 这里其实有2个单词 空字符串和A
	 * B.B.C这里有3个单词 B B C
	 * B.B.这里有3个单词B B 空字符串
	 * 从我的测试结果来看空格也会算进去，而且还无法匹配！
	 * 尽量别用空格，因为我也没测试太多，也许某些情况下空格可以的吧。
	 */
	public static String[] patternOne={"A.123","A.","A.B","A.B.","A.B.C","B",".A"," A","A "};
	/*
	 * patten "A.#"  
	 * 测试结果发现：
	 * 用字母和数字和"."是安全的 用空格会出错
	 */
	@GetMapping("/topicA/{id}")
	public String topicOne(@PathVariable(value="id")int id){
		
		for(String one : patternOne){
		System.out.println(one);
		sender.sendTopicType(one);
		}
		return "请查看控制台";
	}
	
	
	public static String[] patternTwo={"B","B.","B.B","B.B.","B.B.C"};
	/*
	 * patten "B.*"
	 * 
	 * 测试结果发现：
	 * B可以
	 * B.可以  原因我觉得是 B."" 相当于空字符串也算一个单词吧
	 */
	@GetMapping("/topicB/{id}")
	public String topicTwo(@PathVariable(value="id")int id){
		
		for(String one : patternTwo){
			System.out.println(one);
			sender.sendTopicType(one);
			}
			return "请查看控制台";
	}
	
	public static String[] pattern3={"C","A","C.","C.A"};
	/*
	 * patten "C"
	 * 测试结果发现：
	 * 只能匹配C
	 */
	@GetMapping("/topic3/{id}")
	public String topic3(@PathVariable(value="id")int id){
		
		
		for(String one : pattern3){
			System.out.println(one);
			sender.sendTopicType(one);
			}
			return "请查看控制台";
	}
	
}
