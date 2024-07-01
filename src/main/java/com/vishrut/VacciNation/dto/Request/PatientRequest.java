package com.vishrut.VacciNation.dto.Request;

import com.vishrut.VacciNation.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientRequest {

    String name;

    int age;

    String email;

    Gender gender;

    long mobile;

}
