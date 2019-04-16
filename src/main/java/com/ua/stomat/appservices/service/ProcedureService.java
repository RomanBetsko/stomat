package com.ua.stomat.appservices.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

@Service
public interface ProcedureService {

    ModelAndView addProcedure(Errors errors);
}
