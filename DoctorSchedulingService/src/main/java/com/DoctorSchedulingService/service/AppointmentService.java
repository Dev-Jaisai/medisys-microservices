package com.DoctorSchedulingService.service;

import com.DoctorSchedulingService.entity.Appointment;
import com.DoctorSchedulingService.entity.AppointmentSlot;
import com.DoctorSchedulingService.repo.AppointmentRepository;
import com.DoctorSchedulingService.repo.AppointmentSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentSlotRepository appointmentSlotRepository;

    // Book an appointment slot for a patient
    public Appointment bookAppointment(String doctorId, Appointment appointmentRequest) {
        // Find the slot
        AppointmentSlot slot = appointmentSlotRepository.findById(Long.valueOf(appointmentRequest.getAppointmentSlotId()))
                .orElseThrow(() -> new RuntimeException("Appointment slot not found"));

        // Check if the slot is available
        if (!slot.isAvailable()) {
            throw new RuntimeException("Appointment slot is already booked");
        }

        // Mark the slot as unavailable
        slot.setAvailable(false);
        appointmentSlotRepository.save(slot);

        // Create the appointment
        appointmentRequest.setDoctorId(doctorId);
        appointmentRequest.setStatus("BOOKED");
        return appointmentRepository.save(appointmentRequest);
    }

    // Cancel an appointment and free up the slot
    public String cancelAppointment(String appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        // Free the slot
        AppointmentSlot slot = appointmentSlotRepository.findById(Long.valueOf(appointment.getAppointmentSlotId()))
                .orElseThrow(() -> new RuntimeException("Appointment slot not found"));
        slot.setAvailable(true);
        appointmentSlotRepository.save(slot);

        // Delete the appointment
        appointmentRepository.delete(appointment);
        return "Appointment canceled successfully";
    }
}
