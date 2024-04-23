package com.btn.controllers;

import com.btn.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class StatsController {
    @Autowired
    private StatsService statsService;
    @GetMapping("/stats")
    public String StatsView(Model model){
        // do du lieu
        model.addAttribute("RenvenueByProduct", this.statsService.statsRevenueByProduct());
        model.addAttribute("RevenueByMonth", this.statsService.statsRevenueByPeriod(LocalDate.now().getYear(),"MONTH"));

        return "stats";
    }
}
