package com.ua.stomat.appservices.service.impl;

import com.ua.stomat.appservices.dao.ClientRepository;
import com.ua.stomat.appservices.entity.Appointment;
import com.ua.stomat.appservices.entity.Client;
import com.ua.stomat.appservices.service.MainService;
import com.ua.stomat.appservices.utils.AdminInfo;
import com.ua.stomat.appservices.validator.AjaxResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class MainServiceImpl implements MainService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AdminInfo adminInfo;

    @Override
    @Transactional
    public ModelAndView getUnloginZoneData() {
        Map<String, Object> params = new HashMap<>();
        params.put("clients", clientRepository.findAll());
        return new ModelAndView("unloginzone", params);
    }

    @Override
    public ResponseEntity<?> getClientsToInform() {

        //todo fix this
        AjaxResponseBody result = new AjaxResponseBody();

        List<Client> clientList = adminInfo.getClientsToInform();
        if(clientList.isEmpty()){
            result.setMsg("0");
        }else {
            result.setMsg(String.valueOf(clientList.size()));
        }


        return ResponseEntity.ok(result);
    }
}
