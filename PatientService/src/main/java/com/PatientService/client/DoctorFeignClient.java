package com.PatientService.client;

import com.PatientService.dto.AppointmentRequestDTO;
import com.healthcare.dto.DoctorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "doctor-scheduling-service", url = "http://localhost:8081") // Replace with the actual service URL
public interface DoctorFeignClient {

    // Get available doctors and slots
    @GetMapping("/doctors/available")
    List<DoctorDTO> getAvailableDoctors();

    // Book an appointment with a doctor
    @PostMapping("/doctors/{doctorId}/appointments")
    String bookAppointment(@PathVariable String doctorId, @RequestBody AppointmentRequestDTO appointmentRequest);
}
