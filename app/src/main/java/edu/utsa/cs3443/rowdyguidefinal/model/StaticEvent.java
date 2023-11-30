/**
 * @author Kailey Perrino
 */
package edu.utsa.cs3443.rowdyguidefinal.model;

import java.util.ArrayList;

public class StaticEvent {
    public static Event event;
    public static ArrayList<Event> eventListStatic = new ArrayList<>();

    public static void setEvent(Event event) {
        StaticEvent.event = event;
    }

    public static ArrayList<Event> getEventListStatic() {
        return eventListStatic;
    }

    public static void setEventListStatic(ArrayList<Event> eventListStatic) {
        StaticEvent.eventListStatic = eventListStatic;
    }

    public static Event getEvent(){

        return event;
    }
}
