package sch.hunnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan("sch.hunnu.*")	

public class JavaMailQqApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaMailQqApplication.class, args);
		System.out.println("JavaMailQqApplication over");
	}
}
