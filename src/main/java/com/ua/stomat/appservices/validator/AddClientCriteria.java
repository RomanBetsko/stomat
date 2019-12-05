package com.ua.stomat.appservices.validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddClientCriteria {

    @NotEmpty(message = "Не вказано ім'я!")
    private String firstName;
    @NotEmpty(message = "Не вказано прізвище!")
    private String secondName;
    @NotEmpty(message = "Не вказано по-батькові!")
    private String thirdName;
    @Email(message = "Не вірний email!")
    private String email;
    @NotEmpty(message = "Не вказаний телефон!")
    private String phone;
    private String dateOfBirth;
    private String sex;
    @NotEmpty(message = "Не вказано звідки клієнт дізнався про клініку!")
    private String resource;
}