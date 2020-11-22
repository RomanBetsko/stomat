package com.ua.stomat.appservices.validator;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Validated
public class NewAppointmentCriteria {

    @NotNull
    @NotEmpty
    private String firstName;
    private String lastName;
    @NotNull
    @NotEmpty
    private String phone;
    private String date;
    private String time;
}
