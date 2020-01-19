package com.soobinnn.eatgo.ex03_eatgo.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public String hello() {
        return "Hello, world!";
    }
}
