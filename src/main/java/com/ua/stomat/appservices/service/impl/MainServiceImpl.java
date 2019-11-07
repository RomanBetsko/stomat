package com.ua.stomat.appservices.service.impl;

import com.ua.stomat.appservices.dao.ClientRepository;
import com.ua.stomat.appservices.entity.Client;
import com.ua.stomat.appservices.service.MainService;
import com.ua.stomat.appservices.utils.AdminInfo;
import com.ua.stomat.appservices.validator.AjaxResponseBody;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class MainServiceImpl implements MainService {

    private final ClientRepository clientRepository;
    private final AdminInfo adminInfo;

    public MainServiceImpl(ClientRepository clientRepository, AdminInfo adminInfo) {
        this.clientRepository = clientRepository;
        this.adminInfo = adminInfo;
    }

    @Override
    @Transactional
    public ModelAndView getUnloginZoneData() {
        Map<String, Object> params = new HashMap<>();
        params.put("clients", clientRepository.findAll());
        return new ModelAndView("unloginzone", params);
    }

    @Override
    public ResponseEntity<?> informSize() {

        //todo fix this
        AjaxResponseBody result = new AjaxResponseBody();

        List<Client> clientList = adminInfo.getClientsToInform();
        if (clientList.isEmpty()) {
            result.setMsg("0");
        } else {
            result.setMsg(String.valueOf(clientList.size()));
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ModelAndView getClientsToInform() {
        Map<String, Object> params = new HashMap<>();
        params.put("clients", adminInfo.getClientsToInform());
        return new ModelAndView("clientsToInform", params);
    }

    @Override
    public ResponseEntity<?> deleteClientFromInform(Integer id, Errors errors) {
        //todo refactor this
        AjaxResponseBody result = new AjaxResponseBody();
        List<Client> clientsToSet = adminInfo.getClientsToInform().stream().filter(client -> !client.getClientId().equals(id)).collect(Collectors.toList());
        adminInfo.setClientsToInform(clientsToSet);
        return ResponseEntity.ok(result);
    }
}
