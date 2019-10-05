package com.imustacm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: wangJianBo
 * Date: 2019/10/6 6:43
 * Content:
 */
@Controller
@RequestMapping("/hello")
public class Demo {
    @RequestMapping("/demo")
    public String Demo1(){
        return "success";
    }
}
