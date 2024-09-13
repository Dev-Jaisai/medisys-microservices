package com.DoctorSchedulingService.service;

import com.DoctorSchedulingService.entity.AppointmentSlot;
import com.DoctorSchedulingService.repo.AppointmentSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentSlotService {

    @Autowired
    private AppointmentSlotRepository appointmentSlotRepository;

    // Add or update appointment slots for a doctor
    public List<AppointmentSlot> addOrUpdateSlots(String doctorId, List<AppointmentSlot> slots) {
        slots.forEach(slot -> slot.setDoctorId(doctorId));
        return appointmentSlotRepository.saveAll(slots);
    }

    // Find available appointment slots for a specific doctor
    public List<AppointmentSlot> getAvailableSlotsForDoctor(String doctorId) {
        return appointmentSlotRepository.findByDoctorIdAndIsAvailableTrue(doctorId);
    }
}
