package com.vishrut.VacciNation.repository;

import com.vishrut.VacciNation.model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose,Integer> {
}
