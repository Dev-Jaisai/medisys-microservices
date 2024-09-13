package com.DoctorSchedulingService.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;  // Auto-generated primary key

    @Column  // Setting column length to 255
    private String appointmentSlotId;  // Reference to the appointment slot

    @Column  // Setting column length to 255
    private String doctorId;  // Reference to the doctor

    @Column  // Setting column length to 255
    private String patientId;  // Reference to the patient

    @Column  // Setting column length to 500 for additional remarks
    private String remarks;  // Any additional remarks from the patient

    @Column  // Setting column length to 50 for status
    private String status;  // Status of the appointment (BOOKED, CANCELED, etc.)
}
