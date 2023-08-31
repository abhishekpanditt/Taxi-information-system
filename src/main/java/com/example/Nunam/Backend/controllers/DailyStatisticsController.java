package com.example.Nunam.Backend.controllers;

import com.example.Nunam.Backend.entities.DailyStatistics;
import com.example.Nunam.Backend.repositories.DailyStatisticsRepository;
import com.example.Nunam.Backend.services.DailyStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DailyStatisticsController {

    @Autowired
    private DailyStatisticsService dailyStatisticsService;

    @PostMapping("/insert_statistics")
    public void insertStatistics(@RequestBody DailyStatistics dailyStatistics) throws Exception {
        dailyStatisticsService.calculateAndInsertDailyStatistics();
    }

    @GetMapping("/get_daily_statistics")
    public void getDailyStatistics() throws Exception {
        dailyStatisticsService.calculateAndInsertDailyStatistics();
    }

    @GetMapping("/check_status")
    public String checkStatus() throws Exception {
        return "Application is running!";
    }
}
