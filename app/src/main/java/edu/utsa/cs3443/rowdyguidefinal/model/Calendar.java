package edu.utsa.cs3443.rowdyguidefinal.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Calendar {

    Event calendarEvent;
    ArrayList<Event> eventList;
    HashMap<String, ArrayList<Event>> dateToEventList;


    public Calendar(){
        this.calendarEvent = new Event("name", "date", "time");
        this.eventList = new ArrayList<>();
        this.dateToEventList = new HashMap<>();
    }
    public void mapToDay(Event e){
        if(dateToEventList.containsKey(e.getDate())){
            dateToEventList.get(e.getDate()).add(e);
        }
        else{
            ArrayList<Event> theList = new ArrayList<>();
            theList.add(e);
            dateToEventList.put(e.getDate(),theList);
        }

    }
    public Event getCalendarEvent() {
        return calendarEvent;
    }

    public void setCalendarEvent(Event calendarEvent) {
        this.calendarEvent = calendarEvent;
    }

    public HashMap<String, ArrayList<Event>> getDateToEventList() {
        return dateToEventList;
    }

    public void setDateToEventList(HashMap<String, ArrayList<Event>> dateToEventList) {
        this.dateToEventList = dateToEventList;
    }

    public Event makeCalendarEvent(String name, String date, String time){
        Event e = new Event(name, date, time);
        mapToDay(e);
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
