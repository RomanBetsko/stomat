package com.ua.stomat.appservices.validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAppointmentCriteria {

    private String name;
    private Integer id;
    private String description;
    private List<ProcedureCriteria> procedureCriteria;
}
