package com.example.Nunam.Backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Entity
@Table(name = "dailystatistics")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DailyStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private Date date;
    private int minutesTravelled;
    private int minutesIdle;
    private double distanceTravelled;
}