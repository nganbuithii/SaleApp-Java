package com.btn.controllers;

import com.btn.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Map;

@Controller
public class StatsController {
    @Autowired
    private StatsService statsService;
    @GetMapping("/stats")
    public String StatsView(Model model, @RequestParam Map<String, String> params){
        // do du lieu
        String year = params.get("year");
        String period = params.getOrDefault("period","MONTH");

        model.addAttribute("RenvenueByProduct", this.statsService.statsRevenueByProduct());
        model.addAttribute("RevenueByPeriod", this.statsService.statsRevenueByPeriod(Integer.parseInt(year), period));


        return "stats";
    }
}
