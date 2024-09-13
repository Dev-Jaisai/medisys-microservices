package com.PatientService.dto;

import com.healthcare.dto.AppointmentSlotDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    private String doctorId;
    private String name;
    private String specialization;
    private String contactInfo;
    private List<AppointmentSlotDTO> availableSlots;  // A list of available slots for this doctor
}
