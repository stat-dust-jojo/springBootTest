package com.xidian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringBoot01 {
    @RequestMapping("/")
    public String hello(){
        return "index";
    }
}
