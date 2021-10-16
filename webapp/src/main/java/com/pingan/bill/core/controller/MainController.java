package com.pingan.bill.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
//    @GetMapping(value="/")
//    public String index(){
//        return "login";
//    }
    @GetMapping(value="/home")
    public String home(){
        return "home";
    }
    @GetMapping(value="/login")
    public String login(){
        return "home";
    }
    @GetMapping(value="/hello")
    public String hello(){
        return "hello";
    }
}
