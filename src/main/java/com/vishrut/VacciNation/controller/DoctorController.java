package com.vishrut.VacciNation.controller;

import com.vishrut.VacciNation.Enum.Specialization;
import com.vishrut.VacciNation.dto.Request.DoctorRequest;
import com.vishrut.VacciNation.dto.Response.DoctorResponse;
import com.vishrut.VacciNation.exception.DoctorNotFoundException;
import com.vishrut.VacciNation.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    //API to add doctor
    @PostMapping
    public ResponseEntity addDoctor(@RequestBody DoctorRequest doctorRequest){
        DoctorResponse doctor = doctorService.addDoctor(doctorRequest);
        return new ResponseEntity(doctor, HttpStatus.CREATED);
    }

    //API to get doctor details

    //API to Remove doctor
    @DeleteMapping
    public String removeDoctor(@RequestParam("email") String email){
        try{
            doctorService.removeDoctor(email);
            return "Doctor removed Successfully!";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    //API to get all doctors By Specialization
    @GetMapping("/get-by-specialization")
    public ResponseEntity getBySpecialization(@RequestParam("specialization")Specialization specialization){
        try{
            List<DoctorResponse> doctors = doctorService.getBySpecialization(specialization);
            return new ResponseEntity(doctors,HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
