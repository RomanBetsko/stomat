package com.ua.stomat.appservices.validator;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;


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

    public AddAppointmentCriteria() {
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public List<ProcedureCriteria> getProcedureCriteria() {
        return procedureCriteria;
    }

    public void setProcedureCriteria(List<ProcedureCriteria> procedureCriteria) {
        this.procedureCriteria = procedureCriteria;
    }
}
