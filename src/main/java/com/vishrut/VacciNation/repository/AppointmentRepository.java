package com.vishrut.VacciNation.repository;

import com.vishrut.VacciNation.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    Optional<Appointment> findByApplicationNo(String applicationNo);
}
