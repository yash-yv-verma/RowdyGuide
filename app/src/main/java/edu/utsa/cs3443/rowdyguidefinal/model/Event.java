package edu.utsa.cs3443.rowdyguidefinal.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Event implements Serializable {
    private String name;
    private String date;
    private String time;

    public Event(String name, String date, String time){
        this.name = name;
        this.date = date;
        this.time = time;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
