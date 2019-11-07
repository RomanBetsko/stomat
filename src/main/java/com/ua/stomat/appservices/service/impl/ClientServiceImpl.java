package com.ua.stomat.appservices.service.impl;

import com.ua.stomat.appservices.dao.ClientRepository;
import com.ua.stomat.appservices.dao.UploadFileRepository;
import com.ua.stomat.appservices.entity.Client;
import com.ua.stomat.appservices.entity.UploadFile;
import com.ua.stomat.appservices.service.ClientService;
import com.ua.stomat.appservices.validator.AddClientCriteria;
import com.ua.stomat.appservices.validator.AjaxResponseBody;
import org.apache.commons.io.FileUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private  ServletContext context;
    private  ClientRepository clientRepository;
    private  UploadFileRepository fileRepository;

    public ClientServiceImpl(ServletContext context, ClientRepository clientRepository, UploadFileRepository fileRepository) {
        this.context = context;
        this.clientRepository = clientRepository;
        this.fileRepository = fileRepository;
    }


    @Override
    public ResponseEntity<?> addClient(AddClientCriteria request, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        Client client = clientRepository.save(prepareClient(request));
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date dateOfBirth = null;
        try {
            dateOfBirth = simpleDateFormat.parse(request.getDateOfBirth());
        } catch (ParseException e) {

            //throw exeption
            e.printStackTrace();
        }
        client.setDateOfBirth(dateOfBirth);
        return client;
    }

    @Override
    public ModelAndView getClientsData() {
        Map<String, Object> params = new HashMap<>();
        params.put("clients", clientRepository.findAll());
        return new ModelAndView("clients", params);
    }

    @Override
    public ModelAndView getClientPage(Integer clientId) {
        Map<String, Object> params = new HashMap<>();
        Client client = clientRepository.findByClientId(clientId);

        params.put("client", client);
        return new ModelAndView("singleclient", params);
    }

    @Override
    public ResponseEntity<?> deleteClient(Integer id, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        clientRepository.deleteByClientId(id);
        result.setMsg("Клієнта було видалено");
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<?> upload(CommonsMultipartFile[] fileUpload, String clientId) {
        AjaxResponseBody result = new AjaxResponseBody();

        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload) {

                UploadFile uploadFile = new UploadFile();
                uploadFile.setFileName(aFile.getOriginalFilename());
                uploadFile.setData(aFile.getBytes());
                uploadFile.setClient(clientRepository.findByClientId(Integer.valueOf(clientId)));
                fileRepository.save(uploadFile);
            }
        }
        result.setMsg("Файл було завантажено");
        return ResponseEntity.ok(result);
    }

    @Override
    public void downloadFile(Integer fileId, HttpServletResponse response) {

        UploadFile uploadFile = fileRepository.findByFileId(fileId);
        String downloadFolder = context.getRealPath("/WEB-INF/downloads/");
        try {
            FileUtils.writeByteArrayToFile(new File(downloadFolder + uploadFile.getFileName()), uploadFile.getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path file = Paths.get(downloadFolder, uploadFile.getFileName());
        if (Files.exists(file)) {
//            String mimeType = MimetypesFileTypeMap
//                    .getDefaultFileTypeMap()
//                    .getContentType(file1.getFileName());
//            response.setContentType(mimeType);
            response.addHeader("Content-Disposition", "attachment; filename=" + uploadFile.getFileName());
            try {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } catch (IOException e) {
                System.out.println("Error :- " + e.getMessage());
            }
        } else {
            System.out.println("Sorry File not found!!!!");
        }
    }

}
