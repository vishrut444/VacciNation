package com.vishrut.VacciNation.service;

import com.vishrut.VacciNation.Enum.VaccineBrand;
import com.vishrut.VacciNation.converter.DoseConverter;
import com.vishrut.VacciNation.dto.Response.DoseResponse;
import com.vishrut.VacciNation.exception.PatientNotFoundException;
import com.vishrut.VacciNation.model.Dose;
import com.vishrut.VacciNation.model.Patient;
import com.vishrut.VacciNation.repository.DoctorRepository;
import com.vishrut.VacciNation.repository.DoseRepository;
import com.vishrut.VacciNation.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoseService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final DoseRepository doseRepository;

    public DoseResponse addDose(String applicationNo, VaccineBrand vaccineBrand) {
        //check if patient is registered
        Optional<Patient> optionalPatient = patientRepository.findByApplicationNo(applicationNo);
        if(optionalPatient.isEmpty()) throw new PatientNotFoundException("Patient has not been registered yet!");

        Patient patient = optionalPatient.get();

        //check if patient is already vaccinated
        if(patient.isVaccinated()) throw new RuntimeException("Patient is already vaccinated!");

        patient.setVaccinated(true);

        Dose dose = new Dose();
        dose.setVaccineBrand(vaccineBrand);
        dose.setSerialNo(String.valueOf(UUID.randomUUID()));
        dose.setApplicationNo(patient.getApplicationNo());
        dose.setPatient(patient);//setting FK

        //saving Dose and Patient updated status
        doseRepository.save(dose);
        patientRepository.save(patient);

        return DoseConverter.doseToDoseResponse(dose);
    }
}
