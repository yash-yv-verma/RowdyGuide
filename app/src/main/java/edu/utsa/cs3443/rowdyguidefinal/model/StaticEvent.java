package edu.utsa.cs3443.rowdyguidefinal.model;

import java.util.ArrayList;

public class StaticEvent {
    public static Event event;
    public static ArrayList<Event> eventListStatic = new ArrayList<>();

    public static Event getEvent(){

        return event;
    }
}
