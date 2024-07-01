package com.vishrut.VacciNation.dto.Request;

import com.vishrut.VacciNation.Enum.Gender;
import com.vishrut.VacciNation.Enum.Specialization;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoctorRequest {

    String name;

    int age;

    Gender gender;

    long mobile;

    String email;

    Specialization specialization;

}
