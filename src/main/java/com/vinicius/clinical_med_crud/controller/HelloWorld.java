package com.vinicius.clinical_med_crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")

public class HelloWorld {

    @GetMapping
    public String olhaMundo(){
       return "Olá mundo";
    }
}
 