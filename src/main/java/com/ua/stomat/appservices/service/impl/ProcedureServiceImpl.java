package com.ua.stomat.appservices.service.impl;

import com.ua.stomat.appservices.dao.ProcedureRepository;
import com.ua.stomat.appservices.entity.Procedure;
import com.ua.stomat.appservices.service.ProcedureService;
import com.ua.stomat.appservices.validator.ProcedureRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class ProcedureServiceImpl implements ProcedureService {

    private final ProcedureRepository procedureRepository;

    @Override
    public ModelAndView addProcedure(Errors errors) {
        Map<String, Object> params = new HashMap<>();
        return new ModelAndView("createprocedurefragment", params);
    }

    @Override
    public ModelAndView addProcedureByName(ProcedureRequest request) {
        Procedure procedure = procedureRepository.findByName(request.getProcedureName());
        Map<String, Object> params = new HashMap<>();
        params.put("procedureName", procedure.getName());
        params.put("procedurePrice", procedure.getPrice());
        params.put("procedureDescription", procedure.getDescription());
        return new ModelAndView("createprocedurefragment", params);
    }
}
