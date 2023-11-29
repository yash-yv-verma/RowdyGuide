/**
 * The Event class represents a calendar event in the Rowdy Guide application.
 *
 * This class implements Serializable to allow objects of this class to be
 * converted into a byte stream for various purposes, such as saving and restoring state.
 *
 *
 * @author KingKong
 */
package edu.utsa.cs3443.rowdyguidefinal.model;

import java.io.Serializable;

public class Event implements Serializable {

    // Event attributes
    private String eventName;
    private String eventDate;
    private String eventTime;
    private String eventLocation;
    private String eventDescription;
    private String eventTicketPrice;
    private String eventType;

    /**
     * Constructs an Event object with the specified attributes.
     *
     * @param eventName The name of the event.
     * @param eventDate The date of the event.
     * @param eventTime The time of the event.
     * @param eventLocation The location of the event.
     * @param eventDescription The description of the event.
     * @param eventTicketPrice The ticket price of the event.
     * @param eventType The type/category of the event.
     */
    public Event(String eventName, String eventDate, String eventTime,
                 String eventLocation, String eventDescription,
                 String eventTicketPrice, String eventType) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
        this.eventTicketPrice = eventTicketPrice;
        this.eventType = eventType;
    }

    /**
     * Gets the name of the event.
     *
     * @return The name of the event.
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets the name of the event.
     *
     * @param eventName The name to set for the event.
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Gets the date of the event.
     *
     * @return The date of the event.
     */
    public String getEventDate() {
        return eventDate;
    }

    /**
     * Sets the date of the event.
     *
     * @param eventDate The date to set for the event.
     */
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * Gets the time of the event.
     *
     * @return The time of the event.
     */
    public String getEventTime() {
        return eventTime;
    }

    /**
     * Sets the time of the event.
     *
     * @param eventTime The time to set for the event.
     */
    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    /**
     * Gets the location of the event.
     *
     * @return The location of the event.
     */
    public String getEventLocation() {
        return eventLocation;
    }

    /**
     * Sets the location of the event.
     *
     * @param eventLocation The location to set for the event.
     */
    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    /**
     * Gets the description of the event.
     *
     * @return The description of the event.
     */
    public String getEventDescription() {
        return eventDescription;
    }

    /**
     * Sets the description of the event.
     *
     * @param eventDescription The description to set for the event.
     */
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    /**
     * Gets the ticket price of the event.
     *
     * @return The ticket price of the event.
     */
    public String getEventTicketPrice() {
        return eventTicketPrice;
    }

    /**
     * Sets the ticket price of the event.
     *
     * @param eventTicketPrice The ticket price to set for the event.
     */
    public void setEventTicketPrice(String eventTicketPrice) {
        this.eventTicketPrice = eventTicketPrice;
    }

    /**
     * Gets the type/category of the event.
     *
     * @return The type/category of the event.
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Sets the type/category of the event.
     *
     * @param eventType The type/category to set for the event.
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
