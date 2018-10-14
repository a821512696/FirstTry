package sch.hunnu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("sch.hunnu.*")
@MapperScan("sch.hunnu.dao")
public class SbMyBatisRedisApplication {

	public static void main(String[] args) {
		System.out.println("SBMyBatisRedis");
		SpringApplication.run(SbMyBatisRedisApplication.class, args);
		System.out.println("over");
	}
}
