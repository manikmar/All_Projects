package com.ace.cigna.DemoApp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestAPI {
    Logger logger = LoggerFactory.getLogger(TestRestAPI.class);
    @GetMapping("/get")
    public String getData(){
        logger.info("enter into getData");
        return "Hello World";
    }
}
