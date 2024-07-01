package com.vishrut.VacciNation.dto.Response;

import com.vishrut.VacciNation.Enum.Specialization;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoctorResponse {

    String name;

    Specialization specialization;

    long mobile;
}
