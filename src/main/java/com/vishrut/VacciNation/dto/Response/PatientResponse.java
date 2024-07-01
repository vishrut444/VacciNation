package com.vishrut.VacciNation.dto.Response;

import com.vishrut.VacciNation.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientResponse {

    String applicationNo;

    String name;

    int age;

    Gender gender;

    long mobile;

    boolean vaccinated;
}
