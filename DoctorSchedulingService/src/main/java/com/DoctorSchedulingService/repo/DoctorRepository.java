package com.DoctorSchedulingService.repo;

import com.DoctorSchedulingService.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {
    // Custom methods can be added here if necessary
    // Example: Find doctors by specialization
    List<Doctor> findBySpecialization(String specialization);
}
