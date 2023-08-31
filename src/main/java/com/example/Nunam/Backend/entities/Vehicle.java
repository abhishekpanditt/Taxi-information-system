package com.example.Nunam.Backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String vehicleNumber;
    private double loadCapacity;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    List<VehicleData> vehicleDataList = new ArrayList<>();

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    List<DailyStatistics> dailyStatisticsList = new ArrayList<>();
}

