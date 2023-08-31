package com.example.Nunam.Backend.configurations;

import com.example.Nunam.Backend.services.DailyStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduledTasks {

    @Autowired
    private DailyStatisticsService dailyStatisticsService;

    @Scheduled(cron = "0 0 0 * * ?") // Runs at midnight every day
    public void runDataProcessingAtMidnight() throws Exception {
        dailyStatisticsService.calculateAndInsertDailyStatistics();
    }
}
