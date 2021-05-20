package com.ua.stomat.appservices.config;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;

public class UrlLocaleResolver implements LocaleResolver {

    private static final String URL_LOCALE_ATTRIBUTE_NAME = "URL_LOCALE_ATTRIBUTE_NAME";

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String uri = request.getRequestURI();

        String prefixEn = request.getServletContext().getContextPath() + "/en/";
        String prefixRu = request.getServletContext().getContextPath() + "/ru/";
        String prefixUk = request.getServletContext().getContextPath() + "/uk/";
        String prefixPl = request.getServletContext().getContextPath() + "/pl/";

        Locale locale = null;

        // English
        if (uri.startsWith(prefixEn)) {
            locale = Locale.ENGLISH;
        }
        // Rus
        else if (uri.startsWith(prefixRu)) {
            locale = new Locale("ru");
        }
        // Ukrainian
        else if (uri.startsWith(prefixUk)) {
            locale = new Locale("uk", "UA");
        }
        else if (uri.startsWith(prefixPl)) {
            locale = new Locale("pl");
        }

        if (locale != null) {
            request.getSession().setAttribute(URL_LOCALE_ATTRIBUTE_NAME, locale);
        }
        if (locale == null) {
            locale = (Locale) request.getSession().getAttribute(URL_LOCALE_ATTRIBUTE_NAME);
            if (locale == null) {
                locale = new Locale("uk", "UA");
                request.getSession().setAttribute(URL_LOCALE_ATTRIBUTE_NAME, locale);
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        // Nothing
    }

}
