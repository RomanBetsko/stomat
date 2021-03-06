package com.ua.stomat.appservices.validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureCriteria {

    private Integer id;
    private String name;
    private Integer price;
    private String description;
    private String doctor;

}