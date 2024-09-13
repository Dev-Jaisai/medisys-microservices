package com.PatientService.controller;

import com.PatientService.dto.AppointmentDTO;
import com.PatientService.dto.AppointmentRequestDTO;
import com.PatientService.entity.Appointment;
import com.PatientService.service.PatientService;
import com.healthcare.dto.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Get all appointments
    @GetMapping("/all")
    public List<AppointmentDTO> getAllAppointments() {
        return patientService.getAllAppointments();
    }

    // Book an appointment
    @PostMapping("/book")
    public Appointment bookAppointment(@RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        return patientService.bookAppointment(appointmentRequestDTO);
    }

    // Cancel an appointment
    @DeleteMapping("/cancel/{appointmentId}")
    public void cancelAppointment(@PathVariable String appointmentId) {
        patientService.cancelAppointment(appointmentId);
    }

    // Get available doctors
    @GetMapping("/doctors/available")
    public ResponseEntity<List<DoctorDTO>> getAvailableDoctors() {
        List<DoctorDTO> availableDoctors = patientService.getAvailableDoctors();
        return new ResponseEntity<>(availableDoctors, HttpStatus.OK);
    }

    // Book an appointment with a doctor
    @PostMapping("/doctors/book/{doctorId}")
    public ResponseEntity<String> bookAppointmentWithDoctor(@PathVariable String doctorId,
                                                            @RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        String response = patientService.bookAppointment(doctorId, appointmentRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
