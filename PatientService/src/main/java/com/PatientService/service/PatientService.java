package com.PatientService.service;

import com.PatientService.dto.AppointmentRequestDTO;
import com.PatientService.entity.Appointment;
import com.PatientService.dto.AppointmentDTO;
import com.PatientService.repo.AppointmentRepository;
import com.PatientService.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        // Convert each Appointment entity to AppointmentDTO
        return appointments.stream()
                .map(appointment -> new AppointmentDTO(
                        appointment.getAppointmentId(),
                        appointment.getDoctorId(),
                        appointment.getAppointmentTime(),
                        appointment.getRemarks(),
                        appointment.isCanceled()))
                .collect(Collectors.toList());
    }
    public Appointment bookAppointment(AppointmentRequestDTO appointmentRequestDTO) {
        // Convert AppointmentRequestDTO to Appointment entity
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(UUID.randomUUID().toString()); // Generate a unique ID
        appointment.setDoctorId(appointmentRequestDTO.getDoctorId());
        appointment.setAppointmentTime(appointmentRequestDTO.getAppointmentTime());
        appointment.setRemarks(appointmentRequestDTO.getRemarks());
        appointment.setCanceled(false); // Set to false by default when booking a new appointment

        // Save the appointment in the repository
        return appointmentRepository.save(appointment);
    }

    public void cancelAppointment(String appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
