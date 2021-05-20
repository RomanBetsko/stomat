package com.ua.stomat.appservices.service.impl;

import com.google.common.collect.ImmutableMap;
import com.ua.stomat.appservices.service.EmailService;
import com.ua.stomat.appservices.utils.MailContentCreator;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final MailContentCreator mailContentCreator;

    @Override
    public void newAppointmentMessage(String firstName, String lastName, String date, String time, String phone) {
        String text = mailContentCreator.create(ImmutableMap.of(
                "newAppointmentText", "Клієнт: " + lastName + " " + firstName + " бажає записатися на: " + date + "  " + time,
                "phone", phone
        ), "new-appointment-template");
//        String text = "Клієнт: " + lastName + " " + firstName + " бажає записатися на: " + date + "  " + time + ". Номер телефона для підтвердження: " + phone;
        String subject = "New Appointment";
        sendEmailLetter("betskostomat@gmail.com", text, subject);
    }

    private void sendEmailLetter(String mailTo, String text, String subject) {
        MimeMessagePreparator msgPrepare = mimeMessage -> {
            MimeMessageHelper messageContext = new MimeMessageHelper(mimeMessage);
            messageContext.setTo(mailTo);
            messageContext.setSubject(subject);
            messageContext.setText(text, true);
        };
        javaMailSender.send(msgPrepare);
    }
}
