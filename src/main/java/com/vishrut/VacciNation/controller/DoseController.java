package com.vishrut.VacciNation.controller;

import com.vishrut.VacciNation.Enum.VaccineBrand;
import com.vishrut.VacciNation.dto.Response.DoseResponse;
import com.vishrut.VacciNation.service.DoseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dose")
public class DoseController {

    private final DoseService doseService;

    //API to add dose
    @PostMapping
    public ResponseEntity addDose(@RequestParam("application-no") String applicationNo, @RequestParam("vaccine-Brand")VaccineBrand vaccineBrand){
        try{
            DoseResponse dose = doseService.addDose(applicationNo,vaccineBrand);
            return new ResponseEntity(dose, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
