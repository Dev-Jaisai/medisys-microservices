package com.DoctorSchedulingService.service;

import com.DoctorSchedulingService.entity.Doctor;
import com.DoctorSchedulingService.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Retrieve all available doctors, optionally filtering by specialization and date
    public List<Doctor> getAvailableDoctors(String specialization, Timestamp date) {
        if (specialization != null && !specialization.isEmpty()) {
            return doctorRepository.findBySpecialization(specialization);
        }
        return doctorRepository.findAll();  // Return all doctors if no filters are provided
    }

    // Get details of a specific doctor
    public Doctor getDoctorDetails(String doctorId) {
        return doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    // Add or update a doctor's information
    public Doctor addOrUpdateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
