package com.vishrut.VacciNation.controller;

import com.vishrut.VacciNation.dto.Request.PatientRequest;
import com.vishrut.VacciNation.dto.Response.PatientResponse;
import com.vishrut.VacciNation.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    //API to add patient
    @PostMapping
    public ResponseEntity addPatient(@RequestBody PatientRequest patientRequest){
         PatientResponse patient = patientService.addPatient(patientRequest);
         return  new ResponseEntity(patient, HttpStatus.CREATED);
    }

    //API to get patient details
    @GetMapping
    public ResponseEntity getPatient(@RequestParam("email") String email){
        try{
            PatientResponse patinet = patientService.getPatient(email);
            return new ResponseEntity(patinet,HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
