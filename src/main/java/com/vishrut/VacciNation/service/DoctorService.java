package com.vishrut.VacciNation.service;

import com.vishrut.VacciNation.Enum.Specialization;
import com.vishrut.VacciNation.converter.DoctorConverter;
import com.vishrut.VacciNation.dto.Request.DoctorRequest;
import com.vishrut.VacciNation.dto.Response.DoctorResponse;
import com.vishrut.VacciNation.exception.DoctorNotFoundException;
import com.vishrut.VacciNation.model.Doctor;
import com.vishrut.VacciNation.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorResponse addDoctor(DoctorRequest doctorRequest) {
        //dto -> model
        Doctor doctor = DoctorConverter.doctorRequestToDoctor(doctorRequest);
        //saving doctor
        Doctor savedDoctor = doctorRepository.save(doctor);
        //model -> dto
        return DoctorConverter.doctorToDoctorResponse(savedDoctor);
    }

    public void removeDoctor(String email) {
        Optional<Doctor> optionalDoctor = doctorRepository.findByEmail(email);
        if(optionalDoctor.isEmpty()) throw new DoctorNotFoundException("Sorry Doctor is Not Present!");

        Doctor doctor = optionalDoctor.get();
        //remove the doctor from DB
        doctorRepository.delete(doctor);
    }


    public List<DoctorResponse> getBySpecialization(Specialization specialization) {
        List<Doctor> doctors = doctorRepository.findAll();
        if(doctors.isEmpty()){
            throw new DoctorNotFoundException("There are no Doctors with "+specialization+" As a Specialization!");
        }
        List<DoctorResponse> doctorResponses = new ArrayList<>();
        for(Doctor doctor:doctors){
            if(doctor.getSpecialization().equals(specialization)){
                doctorResponses.add(DoctorConverter.doctorToDoctorResponse(doctor));
            }
        }
        return doctorResponses;
    }
}
