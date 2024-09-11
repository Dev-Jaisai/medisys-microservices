package com.PatientService.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    private String appointmentId;
    private String doctorId; // Reference ID from Doctor Scheduling Service
    private Timestamp appointmentTime;
    private String remarks;
    private boolean isCanceled;
}
