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
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    @NotEmpty
    private String phone;
    @NotNull
    @NotEmpty
    private String date;
    @NotNull
    @NotEmpty
    private String time;
}
