package com.ua.stomat.appservices.service;

import com.ua.stomat.appservices.entity.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public interface MainService {

    ModelAndView getUnloginZoneData();

    ModelAndView readerView();

    Test getTest();
}
