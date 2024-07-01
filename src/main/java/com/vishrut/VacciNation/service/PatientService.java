package com.vishrut.VacciNation.service;

import com.vishrut.VacciNation.converter.PatientConverter;
import com.vishrut.VacciNation.dto.Request.PatientRequest;
import com.vishrut.VacciNation.dto.Response.PatientResponse;
import com.vishrut.VacciNation.exception.PatientNotFoundException;
import com.vishrut.VacciNation.model.Patient;
import com.vishrut.VacciNation.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientService {
    
    private final PatientRepository patientRepository;
    @Autowired
    JavaMailSender javaMailSender;

    public PatientResponse addPatient(PatientRequest patientRequest) {
        //dto -> model
        Patient patient = PatientConverter.patientRequestToPatient(patientRequest);
        ///generating application no
        patient.setApplicationNo(String.valueOf(UUID.randomUUID()));
        //saving patient to DB
        Patient savedPatient = patientRepository.save(patient);
        //sending mail
//        sendMail(savedPatient);
        //model -> dto
        return PatientConverter.patientToPatientResponse(savedPatient);
    }

    private void sendMail(Patient savedPatient) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("springtest444@gmail.com");
        simpleMailMessage.setTo(savedPatient.getEmail());
        simpleMailMessage.setSubject("Congratulations You are Registered Successfully");
        simpleMailMessage.setText("Congratulation "+savedPatient.getName()+" Your Registration has been Completed! and your application No is: "+savedPatient.getApplicationNo());
        javaMailSender.send(simpleMailMessage);
    }

    public PatientResponse getPatient(String email) {
        //find patient if not found
        Optional<Patient> optionalPatient = patientRepository.findByEmail(email);
        if(optionalPatient.isEmpty()) throw new PatientNotFoundException("Sorry No such Patient has Been Registered!");

        Patient patient = optionalPatient.get();
        //model -> dto
        return PatientConverter.patientToPatientResponse(patient);
    }
}
