package com.xidian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringBoot01 {
    @RequestMapping("/hello1")
    public String hello(@RequestParam(name="name",required = false,defaultValue = "jojo")String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }
}
