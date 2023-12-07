package main.java.com.nhom1.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class Hello {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World";
    }
}
