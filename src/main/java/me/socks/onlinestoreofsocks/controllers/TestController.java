package me.socks.onlinestoreofsocks.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public String ha() {
        return " работает ";
    }
    @GetMapping("/why")
    public String why (){
        return " and why ";
    }
}
