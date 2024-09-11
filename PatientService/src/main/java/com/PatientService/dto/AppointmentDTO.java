package com.PatientService.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private String appointmentId;
    private String doctorId;
    private Timestamp appointmentTime;
    private String remarks;
    private boolean isCanceled;
}
