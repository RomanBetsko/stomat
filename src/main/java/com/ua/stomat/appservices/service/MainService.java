package com.ua.stomat.appservices.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public interface MainService {

    ModelAndView getUnloginZoneData();

    ModelAndView readerView();
}
