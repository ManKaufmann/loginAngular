package com.example.loginangular.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalloWorldController {
    @RequestMapping("/hallo")
    public String firstPage(){
        return "Hallo World";
    }
}
