package edu.utsa.cs3443.rowdyguidefinal.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Calendar {

    Event calendarEvent;
    ArrayList<Event> eventList;
    HashMap<String, Event> dateToEvent;


    public Calendar(){
        this.calendarEvent = new Event("name", "date", "time");
        this.eventList = new ArrayList<>();
        this.dateToEvent = new HashMap<>();
    }
    public void mapToDay(Event e){
        dateToEvent.put(e.getDate(),e);
    }
    public Event getCalendarEvent() {
        return calendarEvent;
    }

    public void setCalendarEvent(Event calendarEvent) {
        this.calendarEvent = calendarEvent;
    }

    public HashMap<String, Event> getDateToEvent() {
        return dateToEvent;
    }

    public void setDateToEvent(HashMap<String, Event> dateToEvent) {
        this.dateToEvent = dateToEvent;
    }

    public Event makeCalendarEvent(String name, String date, String time){
        Event e = new Event(name, date, time);
        dateToEvent.put(e.getDate(),e);
        return e;
    }
    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }
    public void addEventToList(Event e){
        this.eventList.add(e);
    }

}
