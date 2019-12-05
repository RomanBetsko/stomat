package com.ua.stomat.appservices.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public interface MainService {

    ResponseEntity<?> informSize();

    ModelAndView getClientsToInform();

    ResponseEntity<?> deleteClientFromInform(Integer id, Errors errors);

    ModelAndView getStatistics();
}
