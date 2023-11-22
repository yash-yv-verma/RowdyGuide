package edu.utsa.cs3443.rowdyguidefinal.model;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;
    private String name;
    private String classification;
    private String email;
    private String contact;

    public User(){
        this.username = "";
        this.password = "";
        this.name = "";
        this.classification = "";
        this.email = "";
        this.contact = "";
    }
    public User(String username, String password, String name, String classification, String email, String contact) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.classification = classification;
        this.email = email;
        this.contact = contact;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.name = "null";
        this.classification = "null";
        this.email = "null";
        this.contact = "null";

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public String toString(){
        return name;
    }
}
