package com.example.Nunam.Backend.repositories;

import com.example.Nunam.Backend.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}