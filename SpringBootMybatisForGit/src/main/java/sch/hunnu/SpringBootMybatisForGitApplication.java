package sch.hunnu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("sch.hunnu.*")		//扫描组件 如@service  @configuration @component等等
@MapperScan("sch.hunnu.dao")		//扫描dao层 这样 dao接口就不用加@Mapper了
public class SpringBootMybatisForGitApplication {

	public static void main(String[] args) {
		System.out.println("ModelForGit");
		SpringApplication.run(SpringBootMybatisForGitApplication.class, args);
		System.out.println("End");
	}
}
