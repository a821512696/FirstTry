package sch.hunnu.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Interceptor1")
public class controller {


    @GetMapping("/Hi")
    public String Hi(){
        System.out.println("我是/Hi 我被启动了 我很慌");
        return "Hello World!";
    }

}
