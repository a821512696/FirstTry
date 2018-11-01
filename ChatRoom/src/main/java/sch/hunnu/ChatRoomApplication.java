package sch.hunnu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("sch.hunnu.*")					//扫描组件	
@ServletComponentScan("sch.hunnu.servlet.*")	//扫描session监听接口
@MapperScan("sch.hunnu.dao")					//扫描dao层
public class ChatRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatRoomApplication.class, args);
		System.out.println("ChatRoomApplication over!");
	}
}
