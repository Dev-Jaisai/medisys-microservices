package com.DoctorSchedulingService.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This allows the database to auto-generate the ID
    private Long doctorId;

    @Column  // or just @Column
    private String contactInfo;

    @Column  // or just @Column
    private String name;

    @Column  // or just @Column
    private String specialization;
}
