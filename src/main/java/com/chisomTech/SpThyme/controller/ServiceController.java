package com.chisomTech.SpThyme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceController {

    @GetMapping("/service")
    public String home() {
        return "service";
    }
}