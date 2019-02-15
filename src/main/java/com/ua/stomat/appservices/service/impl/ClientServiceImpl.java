package com.ua.stomat.appservices.service.impl;

import com.ua.stomat.appservices.dao.ClientRepository;
import com.ua.stomat.appservices.entity.Client;
import com.ua.stomat.appservices.service.ClientService;
import com.ua.stomat.appservices.validator.AddClientCriteria;
import com.ua.stomat.appservices.validator.AjaxResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ResponseEntity<?> addClient(AddClientCriteria request, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        Client client = clientRepository.save(prepareClient(request));
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        result.setMsg(client.getClientId().toString());
        return ResponseEntity.ok(result);
    }


    private Client prepareClient(AddClientCriteria request) {
        Client client = new Client();
        client.setFirstName(request.getFirstName());
        client.setSecondName(request.getSecondName());
        client.setThirdName(request.getThirdName());
        client.setEmail(request.getEmail());
        client.setPhone(request.getPhone());
        client.setSex(request.getSex());
        client.setDateOfBirth(request.getDateOfBirth());
        return client;
    }

    @Override
    public ModelAndView getClientsData() {
        Map<String, Object> params = new HashMap<>();
        List<Client> a = clientRepository.findAll();
        params.put("clients", clientRepository.findAll());
        return new ModelAndView("clients", params);
    }

    @Override
    public ResponseEntity<?> deleteBook(Integer bookId, Integer customerId, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        //clientDao.getByAddedBy(customerId).stream().filter(book -> book.getClientId() == bookId).forEach(book -> clientDao.deleteBook(bookId));
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        result.setMsg("Good result, book was deleted");
        return ResponseEntity.ok(result);
    }

    @Override
    public ModelAndView getClientPage(Integer clientId) {
        Map<String, Object> params = new HashMap<>();
        params.put("client", clientRepository.findByClientId(clientId));
        return new ModelAndView("singleclient", params);
    }

}
