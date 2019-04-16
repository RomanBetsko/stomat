package com.ua.stomat.appservices.controllers;

import com.ua.stomat.appservices.service.ClientService;
import com.ua.stomat.appservices.validator.AddClientCriteria;
import com.ua.stomat.appservices.validator.DeleteClientCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
public class ClientController {

    private static final String ADMIN_PATH = "/admin";

    @Autowired
    private ClientService clientService;

    @PostMapping(ADMIN_PATH + "/addNewClient")
    public ResponseEntity<?> addNewClient(@RequestBody @Valid AddClientCriteria request, Errors errors) {
        return clientService.addClient(request, errors);
    }

    @GetMapping(ADMIN_PATH + "/client")
    public ModelAndView getClient(@RequestParam(name = "id") Integer id) {
        return clientService.getClientPage(id);
    }

    @GetMapping(ADMIN_PATH + "/clients")
    public ModelAndView getClientsView() {
        return clientService.getClientsData();
    }

    @PostMapping(ADMIN_PATH + "/delete/client")
    public ResponseEntity<?> deleteClient(@RequestBody @Valid DeleteClientCriteria request, Errors errors) {
        return clientService.deleteClient(request.getId(), errors);
    }

    @PostMapping(ADMIN_PATH + "/doUpload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("clientId") String clientId,
                                              @RequestParam("files") CommonsMultipartFile[] uploadfiles) throws Exception {

        String uploadedFileName = Arrays.stream(uploadfiles).map(CommonsMultipartFile::getOriginalFilename)
                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));

        if (StringUtils.isEmpty(uploadedFileName)) {
            return new ResponseEntity<java.io.Serializable>("Будь лака виберіть файл!", HttpStatus.OK);
        }

        return clientService.upload(uploadfiles, clientId);
    }
}
