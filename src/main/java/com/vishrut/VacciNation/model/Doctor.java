package com.vishrut.VacciNation.model;

import com.vishrut.VacciNation.Enum.Gender;
import com.vishrut.VacciNation.Enum.Specialization;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Enumerated(value = EnumType.STRING)
    Gender gender;

    long mobile;

    @Column(unique = true)
    String email;

    @Enumerated(value = EnumType.STRING)
    Specialization specialization;
}
