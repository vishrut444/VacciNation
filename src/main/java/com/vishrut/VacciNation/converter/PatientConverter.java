package com.vishrut.VacciNation.converter;

import com.vishrut.VacciNation.dto.Request.PatientRequest;
import com.vishrut.VacciNation.dto.Response.PatientResponse;
import com.vishrut.VacciNation.model.Patient;

public class PatientConverter {

    public static Patient patientRequestToPatient(PatientRequest patientRequest){
        return Patient.builder()
                .name(patientRequest.getName())
                .age(patientRequest.getAge())
                .gender(patientRequest.getGender())
                .email(patientRequest.getEmail())
                .mobile(patientRequest.getMobile())
                .vaccinated(false)
                .build();
    }

    public static PatientResponse patientToPatientResponse(Patient patient){
        return PatientResponse.builder()
                .name(patient.getName())
                .age(patient.getAge())
                .gender(patient.getGender())
                .mobile(patient.getMobile())
                .vaccinated(patient.isVaccinated())
                .applicationNo(patient.getApplicationNo())
                .build();
    }
}
