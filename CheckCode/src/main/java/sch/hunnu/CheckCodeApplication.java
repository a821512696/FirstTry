package sch.hunnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("sch.hunnu.*")

public class CheckCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckCodeApplication.class, args);
		System.out.println("CheckCodeApplication over!");
	}
}
