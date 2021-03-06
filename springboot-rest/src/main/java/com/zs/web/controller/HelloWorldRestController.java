package com.zs.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HellWorld {@link RestController}
 */
@RestController
public class HelloWorldRestController {

    @GetMapping(value = "/hello-world")
    public String helloWorld(){
        return "Hello,World";
    }

//    @CrossOrigin("*")
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
