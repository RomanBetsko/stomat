package com.ua.stomat.appservices.service.impl;

import com.ua.stomat.appservices.service.UtilsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class UtilServiceImpl implements UtilsService {

    @Override
    public String getCurrentUrl(HttpServletRequest request) {
        String fullUrl = request.getRequestURL().toString();
        URL aURL = null;
        try {
            aURL = new URL(fullUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return (aURL != null ? aURL.getProtocol() : null) + "://" + (aURL != null ? aURL.getAuthority() : null);
    }
}
