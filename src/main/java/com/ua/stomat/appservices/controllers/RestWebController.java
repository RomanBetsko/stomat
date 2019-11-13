package com.ua.stomat.appservices.controllers;

import com.ua.stomat.appservices.service.AppointmentService;
import com.ua.stomat.appservices.service.impl.StatsServiceImpl;
import com.ua.stomat.appservices.validator.EarnGraph;
import com.ua.stomat.appservices.validator.ProcedureGraph;
import com.ua.stomat.appservices.validator.StatisticData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class RestWebController {

    private AppointmentService appointmentService;
    private StatsServiceImpl statsService;

    public RestWebController(AppointmentService appointmentService, StatsServiceImpl statsService) {
        this.appointmentService = appointmentService;
        this.statsService = statsService;
    }

    @GetMapping(value = "/event/all")
    public String getEvents(HttpServletRequest request) {
        return appointmentService.getCalendarAppointments(request);
    }

    @GetMapping(value = "/appointmentsGraph")
    public List<StatisticData> appointmentsGraph() {
        return appointmentService.getAppointmentsStatistic();
    }

    @GetMapping(value = "/earnGraph")
    public List<EarnGraph> earnGraph() {
        return appointmentService.getEarnStatistic();
    }

    @GetMapping(value = "/procedureGraph")
    public List<ProcedureGraph> procedureGraph() {
        return appointmentService.getProcedureStatistic();
    }
}
