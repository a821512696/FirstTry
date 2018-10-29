package sch.hunnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("sch.hunnu.*")
public class UploadFileApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(UploadFileApplication.class, args);
		System.out.println("UploadFileApplication over!");
	}
}
