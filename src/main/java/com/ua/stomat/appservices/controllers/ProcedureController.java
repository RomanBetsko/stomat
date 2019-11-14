package com.ua.stomat.appservices.controllers;

import com.ua.stomat.appservices.service.ProcedureService;
import com.ua.stomat.appservices.validator.ClientProcedureCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProcedureController {

    private static final String ADMIN_PATH = "/admin";

    private ProcedureService procedureService;

    public ProcedureController(ProcedureService procedureService) {
        this.procedureService = procedureService;
    }

    @PostMapping(ADMIN_PATH + "/procedure/create")
    public ModelAndView cleateProcedure(@RequestBody ClientProcedureCriteria request, Errors errors) {
        return procedureService.addProcedure(errors);
    }
}
