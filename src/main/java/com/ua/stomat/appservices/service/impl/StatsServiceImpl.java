package com.ua.stomat.appservices.service.impl;

import com.ua.stomat.appservices.dao.AppointmentRepository;
import com.ua.stomat.appservices.dao.DoctorRepository;
import com.ua.stomat.appservices.entity.Appointment;
import com.ua.stomat.appservices.entity.Doctor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

@Service
public class StatsServiceImpl {

    private DoctorRepository doctorRepository;
    private AppointmentRepository appointmentRepository;

    public StatsServiceImpl(DoctorRepository doctorRepository, AppointmentRepository appointmentRepository) {
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
    }


    public void getStatistics(Map<String, Object> params) {
        Doctor doc = doctorRepository.findById(1);
        Date now = new GregorianCalendar().getTime();

        LocalDateTime localDateTime = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        Date todayStart = new GregorianCalendar(localDateTime.getYear(), localDateTime.getMonthValue() - 1, localDateTime.getDayOfMonth()).getTime();
        List<Appointment> appointments = appointmentRepository.findByDateToGreaterThanEqualAndDateToLessThanEqual
                (new Timestamp(todayStart.getTime()), new Timestamp(now.getTime()));

        int todayEarn = appointments.stream().mapToInt(Appointment::getPrice).sum();

        params.put("totalClients", doc.getTotalClients());
        params.put("totalAppointments", doc.getTotalAppointments());
        params.put("totalProcedures", doc.getTotalProcedures());
        params.put("todayEarn", todayEarn);
    }
}
