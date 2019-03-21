package com.ua.stomat.appservices.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public interface MainService {

    ModelAndView getUnloginZoneData();

    ResponseEntity<?> getClientsToInform();
}
