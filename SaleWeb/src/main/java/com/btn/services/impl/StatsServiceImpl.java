package com.btn.services.impl;

import com.btn.repositories.StatsRepository;
import com.btn.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsServiceImpl implements StatsService {
    @Autowired
    private StatsRepository statsRepository;
    @Override
    public List<Object[]> statsRevenueByProduct() {
        return this.statsRepository.statsRevenueByProduct();
    }

    @Override
    public List<Object[]> statsRevenueByPeriod(int year, String period) {
        return this.statsRepository.statsRevenueByPeriod(year, period);
    }
}
