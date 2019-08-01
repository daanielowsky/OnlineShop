package com.github.daanielowsky.OnlineShop.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomepageController {

    @GetMapping("/")
    public String homepageScreen(){
        return "homepage";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "loginpage";
    }

    @GetMapping("register")
    public String registerPage(){
        
    }
}
