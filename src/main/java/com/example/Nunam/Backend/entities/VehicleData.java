package com.example.Nunam.Backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "vehicledata")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehicleData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private String status;
    private double speed;
    private String gpsLocation;
    private double loadCarrying;
    private Timestamp time;
}
