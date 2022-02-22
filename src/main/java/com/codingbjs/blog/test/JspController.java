package com.codingbjs.blog.test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

    @RequestMapping("/get/jsp")
    public String getJsp() {
        return "test";
    }
}
