package com.ua.stomat.appservices.utils;

import lombok.Data;

@Data
public class CalendarEvent {

    private String title;
    private String start;
    private String end;
    private String description;
    private String url;

}
