package com.vishrut.VacciNation.dto.Response;

import com.vishrut.VacciNation.Enum.AppointmentStatus;
import com.vishrut.VacciNation.Enum.Specialization;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AppointmentResponse {

    String appointmentId;

    Date dateOfAppointment;

    AppointmentStatus appointmentStatus;

    String patientName;

    boolean vaccinated;

    String doctorName;

    long doctorMobile;

    String doctorEmail;

    Specialization specialization;

}
