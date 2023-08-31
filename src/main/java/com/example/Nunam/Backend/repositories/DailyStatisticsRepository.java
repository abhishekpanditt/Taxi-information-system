package com.example.Nunam.Backend.repositories;

import com.example.Nunam.Backend.entities.DailyStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyStatisticsRepository extends JpaRepository<DailyStatistics, Integer> {
}
