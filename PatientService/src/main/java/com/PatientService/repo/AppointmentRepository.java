package com.PatientService.repo;
import com.PatientService.entity.Appointment;
import com.PatientService.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, String> {
}
