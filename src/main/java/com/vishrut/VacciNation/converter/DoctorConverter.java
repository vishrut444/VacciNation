package com.vishrut.VacciNation.converter;

import com.vishrut.VacciNation.dto.Request.DoctorRequest;
import com.vishrut.VacciNation.dto.Response.DoctorResponse;
import com.vishrut.VacciNation.model.Doctor;

public class DoctorConverter {

    public static Doctor doctorRequestToDoctor(DoctorRequest doctorRequest){
        return Doctor.builder()
                .name(doctorRequest.getName())
                .age(doctorRequest.getAge())
                .gender(doctorRequest.getGender())
                .mobile(doctorRequest.getMobile())
                .specialization(doctorRequest.getSpecialization())
                .email(doctorRequest.getEmail())
                .build();
    }

    public static DoctorResponse doctorToDoctorResponse(Doctor doctor){
        return DoctorResponse.builder()
                .name(doctor.getName())
                .specialization(doctor.getSpecialization())
                .mobile(doctor.getMobile())
                .build();
    }
}
