package edu.utsa.cs3443.rowdyguidefinal.model;

import java.io.Serializable;

public class Event implements Serializable {
    private String name;
    private String date;
    private String time;

    public Event(String name, String date, String time){
        this.name = name;
        this.date = date;
        this.time = time;
    }

}
