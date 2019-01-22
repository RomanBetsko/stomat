package com.ua.stomat.appservices.service.impl;

import com.ua.stomat.appservices.dao.ClientDao;
import com.ua.stomat.appservices.service.MainService;
import com.ua.stomat.appservices.service.OrderCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class MainServiceImpl implements MainService {

    @Autowired
    private ClientDao clientDao;
    @Autowired
    private OrderCardService orderCardService;

    @Override
    @Transactional
    public ModelAndView getUnloginZoneData() {
        Map<String, Object> params = new HashMap<>();
        params.put("books", clientDao.findAll());
        return new ModelAndView("unloginzone", params);
    }

    @Override
    @Transactional
    public ModelAndView readerView() {
        Map<String, Object> params = new HashMap<>();
        params.put("books", clientDao.findAll());
        //todo refactor when will added multiusers
        params.put("orderCard", orderCardService.getCard(1));
        return new ModelAndView("reader", params);
    }
}
