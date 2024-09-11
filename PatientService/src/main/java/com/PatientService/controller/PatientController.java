package com.PatientService.controller;

import com.PatientService.dto.AppointmentDTO;
import com.PatientService.dto.AppointmentRequestDTO;
import com.PatientService.entity.Appointment;
import com.PatientService.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/all")
    public List<AppointmentDTO> getAllAppointments() {
        return patientService.getAllAppointments();
    }

    @PostMapping("/book")
    public Appointment bookAppointment(@RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        return patientService.bookAppointment(appointmentRequestDTO);
    }

    @DeleteMapping("/cancel/{appointmentId}")
    public void cancelAppointment(@PathVariable String appointmentId) {
        patientService.cancelAppointment(appointmentId);
    }
}
