package com.vishrut.VacciNation.model;

import com.vishrut.VacciNation.Enum.VaccineBrand;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
public class Dose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String applicationNo;//from user while registering

    @Enumerated(value = EnumType.STRING)
    VaccineBrand vaccineBrand;

    String serialNo;

    @CreationTimestamp
    Date dateOfVaccination;

    @ManyToOne
    @JoinColumn
    Patient patient;
}
