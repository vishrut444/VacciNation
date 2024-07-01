package com.vishrut.VacciNation.repository;

import com.vishrut.VacciNation.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

    Optional<Patient> findByEmail(String email);

    Optional<Patient> findByApplicationNo(String applicationNo);
}
