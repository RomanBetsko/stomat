package com.ua.stomat.appservices.controllers;

import com.ua.stomat.appservices.entity.UploadFile;
import com.ua.stomat.appservices.service.ClientService;
import com.ua.stomat.appservices.validator.AddClientCriteria;
import com.ua.stomat.appservices.validator.DeleteClientCriteria;
import com.ua.stomat.appservices.validator.DownloadFileCriteria;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.*;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.stream.Collectors;

@Controller
public class ClientController {

    private static final String ADMIN_PATH = "/admin";

    @Autowired
    private ClientService clientService;
    @Autowired
    private ServletContext context;

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


    //todo рефакторинг усього + видалення тимчасових файлів + правильний тип для різних форматів
    @RequestMapping(value = ADMIN_PATH + "/client/downloadFile/{file}", method= RequestMethod.GET)
    public void downloader(@PathVariable("file") Integer fileId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        UploadFile file1 = clientService.downloadFile(fileId);
        String downloadFolder = context.getRealPath("/WEB-INF/downloads/");
        FileUtils.writeByteArrayToFile(new File(downloadFolder + file1.getFileName()), file1.getData());
        Path file = Paths.get(downloadFolder, file1.getFileName());
        if (Files.exists(file)) {
//            String mimeType = MimetypesFileTypeMap
//                    .getDefaultFileTypeMap()
//                    .getContentType(file1.getFileName());
//            response.setContentType(mimeType);
            response.addHeader("Content-Disposition", "attachment; filename=" + file1.getFileName());
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
