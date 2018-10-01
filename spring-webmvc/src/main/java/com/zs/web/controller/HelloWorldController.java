package com.zs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    @RequestMapping
    public String index(@RequestParam int value, Model model) {
//        model.addAttribute("acceptLanguage", acceptLanguage);
//        model.addAttribute("jsessionId", jsessionId);
//        model.addAttribute("message","Hello,World");
        return "index";
    }

//    @ModelAttribute("acceptLanguage")
//    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage) {
//        return acceptLanguage;
//    }
//
//    @ModelAttribute("jsessionId")
//    public String jsessionId(@CookieValue("JSESSIONID") String jsessionId) {
//        return jsessionId;
//    }
//
//    @ModelAttribute("message")
//    public String message() {
//        return "Hello,World";
//    }
}
