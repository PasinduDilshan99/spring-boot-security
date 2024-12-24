package com.spring.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class basicSecurityController {

    @GetMapping("")
    public String returnName(){
        return "Hello";
    }

    @GetMapping("/sessionId")
    public String getSessionId(HttpServletRequest httpServletRequest){
        return httpServletRequest.getSession().getId();
    }


}
