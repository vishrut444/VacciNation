package com.vishrut.VacciNation.model;

import com.vishrut.VacciNation.Enum.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String appointmentId; //UUID

    String applicationNo;//when user registers the generated number

    @CreationTimestamp
    Date dateOfAppointment;

    @Enumerated(value = EnumType.STRING)
    AppointmentStatus appointmentStatus;

    @ManyToOne
    @JoinColumn
    Doctor doctor;

    @ManyToOne
    @JoinColumn
    Patient patient;

}
