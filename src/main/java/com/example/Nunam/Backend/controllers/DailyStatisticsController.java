package com.example.Nunam.Backend.controllers;

import com.example.Nunam.Backend.entities.DailyStatistics;
import com.example.Nunam.Backend.repositories.DailyStatisticsRepository;
import com.example.Nunam.Backend.services.DailyStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DailyStatisticsController {

    @Autowired
    private DailyStatisticsService dailyStatisticsService;

    @PostMapping("/insertStatistics")
    public void insertStatistics(@RequestBody DailyStatistics dailyStatistics) throws Exception {
        dailyStatisticsService.calculateAndInsertDailyStatistics();
    }

//    @GetMapping("/calculate-statistics")
//    public String calculateStatisticsManually() throws Exception {
//        dailyStatisticsService.calculateAndInsertDailyStatistics();
//        return "Statistics calculation initiated manually.";
//    }
}
