package com.DoctorSchedulingService.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column  // Setting column length to 255
    private String appointmentSlotId;  // Auto-generated primary key

    @Column  // Setting column length to 255
    private String doctorId;  // Reference to the doctor

    private Timestamp dateTime;  // Date and time of the appointment slot

    private boolean isAvailable;  // True if the slot is available, false if it's booked
}
