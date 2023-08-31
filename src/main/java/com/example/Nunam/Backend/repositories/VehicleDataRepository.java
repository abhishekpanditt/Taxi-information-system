package com.example.Nunam.Backend.repositories;

import com.example.Nunam.Backend.entities.Vehicle;
import com.example.Nunam.Backend.entities.VehicleData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VehicleDataRepository extends JpaRepository<VehicleData, Integer> {

    List<VehicleData> findByVehicleAndTimeBetween(Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime);
}
