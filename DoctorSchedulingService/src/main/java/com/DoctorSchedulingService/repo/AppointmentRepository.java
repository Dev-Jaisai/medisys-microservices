package com.DoctorSchedulingService.repo;

import com.DoctorSchedulingService.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String> {

    // Find appointments by doctorId
    List<Appointment> findByDoctorId(String doctorId);

    // Find appointment by appointmentSlotId
    Appointment findByAppointmentSlotId(String appointmentSlotId);
}
