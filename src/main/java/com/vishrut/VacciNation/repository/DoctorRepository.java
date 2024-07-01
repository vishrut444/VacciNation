package com.vishrut.VacciNation.repository;

import com.vishrut.VacciNation.Enum.Specialization;
import com.vishrut.VacciNation.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Optional<Doctor> findByEmail(String email);

    Optional<Doctor> findBySpecialization(Specialization specialization);
}
