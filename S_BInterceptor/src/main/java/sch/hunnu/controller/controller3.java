package sch.hunnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller3 {



    @GetMapping("/index")
    public String index(){
        System.out.println("run /index");
        return "index";
    }


    @GetMapping("/Interceptor1/index")
    public String index2(){
        System.out.println("/Interceptor1/index");
        return "index2";
    }

}
