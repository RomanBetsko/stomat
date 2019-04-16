package com.ua.stomat.appservices.service.impl;

import com.ua.stomat.appservices.service.ProcedureService;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProcedureServiceImpl implements ProcedureService {
    @Override
    public ModelAndView addProcedure(Errors errors) {
        Map<String, Object> params = new HashMap<>();
        return new ModelAndView("createprocedurefragment", params);
    }
}
