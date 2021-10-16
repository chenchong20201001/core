package com.pingan.bill.core.controller;

import com.pingan.bill.core.dao.AuthDao;
import com.pingan.bill.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    private AuthDao authDao;
    @RequestMapping("/main")
    public String index(Model model){
        model.addAttribute("authorities",authDao.findAll());
        return "index";
    }
    private User getUserDetails(){
        SecurityContext ctx=SecurityContextHolder.getContext();
        Authentication auth=ctx.getAuthentication();
        return (User)auth.getPrincipal();
    }
}
