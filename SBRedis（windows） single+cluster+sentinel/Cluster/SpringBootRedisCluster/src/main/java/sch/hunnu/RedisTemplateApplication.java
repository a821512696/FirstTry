package sch.hunnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("sch.hunnu.*")
public class RedisTemplateApplication {

	public static void main(String[] args) {
		System.out.println("RedisTemplateApplication");
		SpringApplication.run(RedisTemplateApplication.class, args);
		System.out.println("over");
	}
}
