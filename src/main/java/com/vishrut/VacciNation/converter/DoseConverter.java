package com.vishrut.VacciNation.converter;


import com.vishrut.VacciNation.dto.Response.DoseResponse;
import com.vishrut.VacciNation.model.Dose;

public class DoseConverter {
    public static DoseResponse doseToDoseResponse(Dose dose){
        return DoseResponse.builder()
                .applicationNo(dose.getApplicationNo())
                .patientName(dose.getPatient().getName())
                .vaccinated(dose.getPatient().isVaccinated())
                .vaccineBrand(dose.getVaccineBrand())
                .dateOfVaccination(dose.getDateOfVaccination())
                .build();
    }
}
