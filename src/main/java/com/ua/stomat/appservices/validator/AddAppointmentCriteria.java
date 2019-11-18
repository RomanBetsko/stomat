package com.ua.stomat.appservices.validator;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class AddAppointmentCriteria implements Serializable {

    private Integer clientId;
    @NotEmpty(message = "Не вказана назва")
    private String name;
    private @NotEmpty(message = "Не вказано дату та час З") String dateFrom;
    private @NotEmpty(message = "Не вказано дату та час З") String dateTo;
    private String description;
    private String clinic;
    private List<ProcedureCriteria> procedureCriteria;

    public AddAppointmentCriteria(Integer clientId, @NotEmpty(message = "Не вказана назва") String name, @NotEmpty(message = "Не вказано дату та час З") String dateFrom,
                                  @NotEmpty(message = "Не вказано дату та час З") String dateTo, String description, String clinic, List<ProcedureCriteria> procedureCriteria) {
        this.clientId = clientId;
        this.name = name;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.description = description;
        this.clinic = clinic;
        this.procedureCriteria = procedureCriteria;
    }

}
