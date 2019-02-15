package com.ua.stomat.appservices.service.impl;

import com.ua.stomat.appservices.dao.ClientRepository;
import com.ua.stomat.appservices.service.MainService;
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
    private ClientRepository clientDao;

    @Override
    @Transactional
    public ModelAndView getUnloginZoneData() {
        Map<String, Object> params = new HashMap<>();
        params.put("clients", clientDao.findAll());
        return new ModelAndView("unloginzone", params);
    }
}
