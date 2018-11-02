package sch.hunnu.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class controller2 {


    @GetMapping("/Hi2")
    public String Hi(){

        return "Hello World2!";
    }




    }
