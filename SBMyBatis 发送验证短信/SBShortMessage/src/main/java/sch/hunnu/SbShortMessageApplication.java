package sch.hunnu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("sch.hunnu.*")
@MapperScan("sch.hunnu.dao")
public class SbShortMessageApplication {

	public static void main(String[] args) {
		
		System.out.println("short message begin!");
		SpringApplication.run(SbShortMessageApplication.class, args);
		System.out.println("end!");
	}
}
