package com.PatientService.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequestDTO {
    private String doctorId;  // ID of the doctor with whom the appointment is to be booked
    private Timestamp appointmentTime; // Desired appointment time
    private String remarks; // Any additional remarks provided by the patient
}
