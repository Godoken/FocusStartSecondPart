package com.example.focusstartsecondpart.features.events.domain.model;

public class Guest {

    private String firstName;
    private String lastName;
    private String text;

    Guest(String firstName, String lastName, String text){
        this.firstName = firstName;
        this.lastName = lastName;
        this.text = text;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getText() {
        return text;
    }
}
