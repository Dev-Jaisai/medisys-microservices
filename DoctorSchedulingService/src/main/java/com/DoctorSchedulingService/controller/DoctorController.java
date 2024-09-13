package com.DoctorSchedulingService.controller;

import com.DoctorSchedulingService.entity.Appointment;
import com.DoctorSchedulingService.entity.AppointmentSlot;
import com.DoctorSchedulingService.entity.Doctor;
import com.DoctorSchedulingService.service.DoctorService;
import com.DoctorSchedulingService.service.AppointmentSlotService;
import com.DoctorSchedulingService.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentSlotService appointmentSlotService;

    @Autowired
    private AppointmentService appointmentService;

    // 1. Get all available doctors and their available slots
    @GetMapping("/available")
    public List<Doctor> getAvailableDoctors(@RequestParam(required = false) String specialization,
                                            @RequestParam(required = false) Timestamp date) {
        return doctorService.getAvailableDoctors(specialization, date);
    }

    // 2. Book an appointment slot for a patient
    @PostMapping("/{doctorId}/appointments")
    public Appointment bookAppointment(@PathVariable String doctorId,
                                       @RequestBody Appointment appointmentRequest) {
        return appointmentService.bookAppointment(doctorId, appointmentRequest);
    }

    // 3. Cancel an appointment by appointmentId
    @DeleteMapping("/{doctorId}/appointments/{appointmentId}/cancel")
    public String cancelAppointment(@PathVariable String doctorId, @PathVariable String appointmentId) {
        return appointmentService.cancelAppointment(appointmentId);
    }

    // 4. Get details of a specific doctor, including their appointment slots
    @GetMapping("/{doctorId}")
    public Doctor getDoctorDetails(@PathVariable String doctorId) {
        return doctorService.getDoctorDetails(doctorId);
    }

    // 5. Add or update doctor information
    @PostMapping
    public Doctor addOrUpdateDoctor(@RequestBody Doctor doctor) {
        return doctorService.addOrUpdateDoctor(doctor);
    }

    // 6. Add or update doctor's appointment slots
    @PostMapping("/{doctorId}/slots")
    public List<AppointmentSlot> addOrUpdateAppointmentSlots(@PathVariable String doctorId,
                                                             @RequestBody List<AppointmentSlot> slots) {
        return appointmentSlotService.addOrUpdateSlots(doctorId, slots);
    }
}
