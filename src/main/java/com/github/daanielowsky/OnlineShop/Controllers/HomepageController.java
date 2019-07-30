package com.github.daanielowsky.OnlineShop.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomepageController {

    @GetMapping("/")
    @ResponseBody
    public String homepageScreen(){
        return "HELLO TO MY WORKING WEBAPP";
    }
}
