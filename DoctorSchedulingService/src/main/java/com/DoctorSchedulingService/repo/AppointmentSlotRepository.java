package com.DoctorSchedulingService.repo;

import com.DoctorSchedulingService.entity.AppointmentSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AppointmentSlotRepository extends JpaRepository<AppointmentSlot, Long> {

    // Find all available slots for a doctor
    List<AppointmentSlot> findByDoctorIdAndIsAvailableTrue(String doctorId);

    // Find available slots for a doctor within a specific time range
    List<AppointmentSlot> findByDoctorIdAndIsAvailableTrueAndDateTimeBetween(String doctorId, Timestamp start, Timestamp end);
}
