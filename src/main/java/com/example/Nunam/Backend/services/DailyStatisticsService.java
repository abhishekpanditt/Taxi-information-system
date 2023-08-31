package com.example.Nunam.Backend.services;

import com.example.Nunam.Backend.entities.DailyStatistics;
import com.example.Nunam.Backend.entities.Vehicle;
import com.example.Nunam.Backend.entities.VehicleData;
import com.example.Nunam.Backend.repositories.DailyStatisticsRepository;
import com.example.Nunam.Backend.repositories.VehicleDataRepository;
import com.example.Nunam.Backend.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class DailyStatisticsService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleDataRepository vehicleDataRepository;

    @Autowired
    private DailyStatisticsRepository dailyStatisticsRepository;

    public void calculateAndInsertDailyStatistics() throws Exception {
        try {
            LocalDate currentDate = LocalDate.now();
            List<Vehicle> vehicles = vehicleRepository.findAll();

            for (Vehicle vehicle : vehicles) {
                List<VehicleData> dataForDay = vehicleDataRepository.findByVehicleAndTimeBetween(vehicle,
                        currentDate.atStartOfDay(),
                        currentDate.plusDays(1).atStartOfDay()
                );
                int minutesTravelled = 0;
                int minutesIdle = 0;
                double distanceTravelled = 0.0;

                for (int i = 1; i < dataForDay.size(); i++) {
                    VehicleData prevData = dataForDay.get(i - 1);
                    VehicleData currentData = dataForDay.get(i);

                    if (prevData.getStatus().equals("running") && currentData.getStatus().equals("running")) {
                        minutesTravelled++;
                        distanceTravelled += currentData.getSpeed() / 60.0;
                    } else {
                        minutesIdle++;
                    }
                }

                DailyStatistics statistics = new DailyStatistics();
                statistics.setVehicle(vehicle);
                statistics.setDate(Date.valueOf(currentDate));
                statistics.setMinutesTravelled(minutesTravelled);
                statistics.setMinutesIdle(minutesIdle);
                statistics.setDistanceTravelled(distanceTravelled);

                dailyStatisticsRepository.save(statistics);
            }
        } catch (Exception e) {
            // Log the exception
            throw new Exception("Some error occurred!!");
        }
    }
}

