package com.btn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatsController {
    @GetMapping("/stats")
    public String StatsView(){
        return "stats";
    }
}
