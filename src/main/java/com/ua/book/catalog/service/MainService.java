package com.ua.book.catalog.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public interface MainService {

    ModelAndView getUnloginZoneData();

    ModelAndView readerView();
}
