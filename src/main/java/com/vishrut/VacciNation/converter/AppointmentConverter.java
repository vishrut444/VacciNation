package com.vishrut.VacciNation.converter;

import com.vishrut.VacciNation.dto.Response.AppointmentResponse;
import com.vishrut.VacciNation.model.Appointment;

public class AppointmentConverter {

    public static AppointmentResponse appointmentToAppointmentResponse(Appointment appointment){
        return AppointmentResponse.builder()
                .appointmentId(appointment.getAppointmentId())
                .dateOfAppointment(appointment.getDateOfAppointment())
                .appointmentStatus(appointment.getAppointmentStatus())
                .patientName(appointment.getPatient().getName())
                .vaccinated(appointment.getPatient().isVaccinated())
                .doctorName(appointment.getDoctor().getName())
                .doctorMobile(appointment.getDoctor().getMobile())
                .doctorEmail(appointment.getDoctor().getEmail())
                .specialization(appointment.getDoctor().getSpecialization())
                .build();
    }
}
