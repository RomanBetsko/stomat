package com.ua.stomat.appservices.service.tasks;

import com.ua.stomat.appservices.dao.ClientRepository;
import com.ua.stomat.appservices.entity.Appointment;
import com.ua.stomat.appservices.entity.Client;
import com.ua.stomat.appservices.utils.AdminInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Component
public class CheckAppointmentsRunnable implements Runnable {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AdminInfo adminInfo;

    @Override
    public void run() {

        List<Client> clients = clientRepository.findAll();
        List<Client> temp = new ArrayList<>();
        if (!adminInfo.getClientsToInform().isEmpty()) {
            // refreshed ClientsToInform data with new appointments
            adminInfo.refreshData();
            temp = adminInfo.getClientsToInform();
        }

        Date currentDate = new Date();
        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.minusDays(1);
        Date currentDateMinusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        localDateTime = localDateTime.minusMonths(6).plusDays(1);
        Date currentDateMinusSixMonths = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        localDateTime = localDateTime.plusMonths(5);
        Date currentDateMinusOneMonths = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        localDateTime = localDateTime.plusMonths(2);
        Date currentDatePlusOneMonths = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        checkDisableNotificationStatus(currentDate, clients);

        List<Client> clnnlist = clients.stream()
                .filter(cln -> !cln.isDisableNotification())
                .filter(cln -> (cln.getDisableNotificationDate() == null && currentDateMinusSixMonths.after(new Date(cln.getAppointments().get(0).getDateTo().getTime()))) ||
                               (cln.getDisableNotificationDate() != null && currentDateMinusSixMonths.after(new Date(cln.getAppointments().get(0).getDateTo().getTime()))))
                .collect(Collectors.toList());

        clnnlist.forEach(this::sendEmail);

        List<Client> clientsToInform = adminInfo.getClientsToInform();
        clientsToInform.addAll(clnnlist);
        adminInfo.setClientsToInform(clientsToInform);

        clnnlist.forEach(cln -> {
            cln.setDisableNotification(true);
            cln.setDisableNotificationDate(new Timestamp(currentDatePlusOneMonths.getTime()));
            clientRepository.save(cln);
        });
    }

    private void sendEmail(Client client) {

        final String user = "mozgoowisp@gmail.com";//change accordingly
        final String password = "Roman1995";//change accordingly

        String to = client.getEmail();
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Планове відвідування стоматолога");
            message.setText(emailText(client));

            //send the message
            Transport.send(message);

            System.out.println("message sent successfully...");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String emailText(Client client) {
        //todo зробити це повідомлення нормальною HTML сторінкою
        return "Шановний " +
                client.getFirstName() + " " + client.getThirdName() +
                System.getProperty("line.separator") +
                "Запрошуємо Вас на плановий огляд у стоматолога." +
                System.getProperty("line.separator") +
                System.getProperty("line.separator") +
                "записатись можете за телефонами: +380987184004, +380995142567 або за адресою: http://localhost:8080/international" +
                System.getProperty("line.separator") +
                System.getProperty("line.separator") +
                "З повагою лікар-стоматолог Назар Бецко";
    }


    private void checkDisableNotificationStatus(Date currentDate, List<Client> clients) {
        clients.stream()
                .filter(Client::isDisableNotification)
                .filter(client -> client.getDisableNotificationDate() != null)
                .filter(client -> client.getDisableNotificationDate().before(currentDate))
                .forEach(client -> client.setDisableNotification(false));
    }

}
