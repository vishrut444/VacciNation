package com.vishrut.VacciNation.controller;

import com.vishrut.VacciNation.Enum.Specialization;
import com.vishrut.VacciNation.dto.Response.AppointmentResponse;
import com.vishrut.VacciNation.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    //API to Book Appointment
    @PostMapping
    public ResponseEntity bookAppointment(@RequestParam("application-No") String applicationNo, @RequestParam("specializarion")Specialization specialization){
        try{
            AppointmentResponse appointment = appointmentService.bookAppointment(applicationNo,specialization);
            return new ResponseEntity(appointment, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    //API to get Appointment Details
    @GetMapping("/appointment-details")
    public ResponseEntity getAppointmentDetails(@RequestParam("application-no") String applicationNo){
        try{
            AppointmentResponse appointment = appointmentService.getAppointmentDetails(applicationNo);
            return new ResponseEntity(appointment,HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    //API to cancel an appointment
    @PutMapping("/cancell-appointment")
    public ResponseEntity cancelAppointment(@RequestParam("application-no") String applicationNo){
        try{
            AppointmentResponse appointment = appointmentService.cancelAppointment(applicationNo);
            return new ResponseEntity(appointment,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


}
