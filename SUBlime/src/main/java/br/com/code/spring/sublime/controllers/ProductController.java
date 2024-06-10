package br.com.code.spring.sublime.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
