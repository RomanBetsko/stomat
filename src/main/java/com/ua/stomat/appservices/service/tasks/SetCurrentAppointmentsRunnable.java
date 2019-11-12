//package com.ua.stomat.appservices.service.tasks;
//
//import com.ua.stomat.appservices.dao.AppointmentRepository;
//import com.ua.stomat.appservices.entity.Appointment;
//import com.ua.stomat.appservices.utils.AdminInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.util.Date;
//import java.util.List;
//
//@Component
//public class SetCurrentAppointmentsRunnable implements Runnable {
//
//    @Autowired
//    private AppointmentRepository appointmentRepository;
//    @Autowired
//    private AdminInfo adminInfo;
//
//
//    @Override
//    public void run() {
//        System.out.println(new Date() + " SetCurrentAppointmentsRunnable task started!");
//
//        LocalDateTime localDateTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//        localDateTime = localDateTime.minusMonths(2);
//        Date currentDateMinusTwoMonths = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
//
//        List<Appointment> appointments = appointmentRepository.findByDateFromGreaterThanEqual(new Timestamp(currentDateMinusTwoMonths.getTime()));
//
//        adminInfo.setCurrentAppointments(appointments);
//        System.out.println(new Date() + " appointments added to current appointment list!");
//    }
//}
