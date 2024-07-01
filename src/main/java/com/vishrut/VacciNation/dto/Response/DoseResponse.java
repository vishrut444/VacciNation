package com.vishrut.VacciNation.dto.Response;

import com.vishrut.VacciNation.Enum.VaccineBrand;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoseResponse {

    String applicationNo;

    String patientName;

    boolean vaccinated;

    VaccineBrand vaccineBrand;

    Date dateOfVaccination;
}
