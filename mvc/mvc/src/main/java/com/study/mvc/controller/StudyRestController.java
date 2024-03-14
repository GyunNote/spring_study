package com.study.mvc.controller;

import com.study.mvc.dto.HelloDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class StudyRestController {

    @GetMapping("/hello/test")
    public String hello(HelloDto helloDto){
        System.out.println(helloDto);

        return "hello";
    }
}
