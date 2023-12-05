package com.codewithcaleb.spring_boot_mastery_001;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello")
    public String helloWorld(){
        return "Hello World!";
    }
 }
