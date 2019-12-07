package com.ua.stomat.appservices.service;

import com.ua.stomat.appservices.validator.ProcedureRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

@Service
public interface ProcedureService {

    ModelAndView addProcedure(Errors errors);

    ModelAndView addProcedureByName(ProcedureRequest request);
}
