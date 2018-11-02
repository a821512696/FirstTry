package sch.hunnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("sch.hunnu.*")
@ServletComponentScan("sch.hunnu.filter")
public class HunnuApplication {

    public static void main(String[] args) {

        SpringApplication.run(HunnuApplication.class, args);
        System.out.println("over");

    }


}
