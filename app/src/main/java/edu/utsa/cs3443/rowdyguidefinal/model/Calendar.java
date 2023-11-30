/**
 * The Calendar class represents a calendar in the Rowdy Guide application. It manages
 * calendar events, mapping them to specific dates and providing methods for retrieving
 * and manipulating event data.
 *
 *
 * @author Kailey Perrino
 */
package edu.utsa.cs3443.rowdyguidefinal.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Calendar {

    // Calendar components
    Event calendarEvent;
    ArrayList<Event> eventList;
    HashMap<String, ArrayList<Event>> dateToEventList;

    /**
     * Constructs a Calendar object with default values and initializes
     * the eventList and dateToEventList collections.
     */
    public Calendar() {
        this.calendarEvent = new Event("name", "date", "time", "", "", "", "");
        this.eventList = new ArrayList<>();
        this.dateToEventList = new HashMap<>();
    }

    /**
     * Maps an event to its corresponding date in the dateToEventList.
     *
     * @param e The event to be mapped to its date.
     */
    public void mapToDay(Event e) {
        if (dateToEventList.containsKey(e.getEventDate())) {
            dateToEventList.get(e.getEventDate()).add(e);
        } else {
            ArrayList<Event> theList = new ArrayList<>();
            theList.add(e);
            dateToEventList.put(e.getEventDate(), theList);
        }
    }

    /**
     * Gets the currently set calendar event.
     *
     * @return The current calendar event.
     */
    public Event getCalendarEvent() {
        return calendarEvent;
    }

    /**
     * Sets the calendar event to the specified event.
     *
     * @param calendarEvent The event to set as the calendar event.
     */
    public void setCalendarEvent(Event calendarEvent) {
        this.calendarEvent = calendarEvent;
    }

    /**
     * Gets the mapping of dates to lists of events.
     *
     * @return The date-to-event mapping.
     */
    public HashMap<String, ArrayList<Event>> getDateToEventList() {
        return dateToEventList;
    }

    /**
     * Sets the date-to-event mapping to the specified mapping.
     *
     * @param dateToEventList The new date-to-event mapping.
     */
    public void setDateToEventList(HashMap<String, ArrayList<Event>> dateToEventList) {
        this.dateToEventList = dateToEventList;
    }

    /**
     * Creates a new calendar event with the specified attributes,
     * maps it to its date, and returns the created event.
     *
     * @param name The name of the event.
     * @param date The date of the event.
     * @param time The time of the event.
     * @return The newly created calendar event.
     */
    public Event makeCalendarEvent(String name, String date, String time) {
        Event e = new Event(name, date, time, "", "", "", "");
        mapToDay(e);
        return e;
    }

    /**
     * Gets the list of events in the calendar.
     *
     * @return The list of events.
     */
    public ArrayList<Event> getEventList() {
        return eventList;
    }

    /**
     * Sets the list of events in the calendar to the specified list.
     *
     * @param eventList The new list of events.
     */
    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }

    /**
     * Adds a list of events to the existing list of events in the calendar.
     *
     * @param events The list of events to add.
     */
    public void addListOfEventsToList(ArrayList<Event> events) {
        for (Event e : events) {
            addEventToList(e);
        }
    }

    /**
     * Adds a single event to the list of events in the calendar.
     *
     * @param e The event to add to the list.
     */
    public void addEventToList(Event e) {
        this.eventList.add(e);
    }
}
