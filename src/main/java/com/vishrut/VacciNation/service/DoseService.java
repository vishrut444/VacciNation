package com.vishrut.VacciNation.service;

import com.vishrut.VacciNation.Enum.VaccineBrand;
import com.vishrut.VacciNation.dto.Response.DoseResponse;
import com.vishrut.VacciNation.repository.DoctorRepository;
import com.vishrut.VacciNation.repository.DoseRepository;
import com.vishrut.VacciNation.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoseService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final DoseRepository doseRepository;

    public DoseResponse addDose(String applicationNo, VaccineBrand vaccineBrand) {

    }
}
