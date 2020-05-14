package com.ua.stomat.appservices.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Component
public class MailContentCreator {

    private TemplateEngine templateEngine;

    @Autowired
    public MailContentCreator(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String create(Map<String, Object> map, String templateName) {
        Context context = new Context();
        context.setVariables(map);
        return templateEngine.process(templateName, context);
    }

}