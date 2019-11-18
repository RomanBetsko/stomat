package com.ua.stomat.appservices.validator;

import lombok.Data;

@Data
public class DeleteAppointmentCriteria {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
