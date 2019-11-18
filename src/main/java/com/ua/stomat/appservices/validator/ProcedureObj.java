package com.ua.stomat.appservices.validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureObj {
    private String name;
    private Integer price;
}
