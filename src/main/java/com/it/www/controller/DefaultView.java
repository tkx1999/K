package com.it.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 进入首页
 */
@Controller
public class DefaultView {
    @RequestMapping(value = {"/","/index","/index.html"})
    public String home(){
        System.out.println("已进入首页");
        return "index";
    }
}
