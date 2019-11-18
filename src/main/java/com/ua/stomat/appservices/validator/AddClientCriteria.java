package com.ua.stomat.appservices.validator;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
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

    public AddClientCriteria(@NotEmpty(message = "Не вказано ім'я!") String firstName, @NotEmpty(message = "Не вказано прізвище!") String secondName,
                             @NotEmpty(message = "Не вказано по-батькові!") String thirdName, String email, @NotEmpty(message = "Не вказаний телефон!") String phone,
                             String dateOfBirth, String sex) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }
}