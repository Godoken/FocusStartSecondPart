package com.example.focusstartsecondpart.features.guests.domain.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public final class Guest {

    @NonNull
    @PrimaryKey private int id;
    private String firstName;
    private String lastName;
    private String phone;

    Guest(int id, String firstName, String lastName, String phone){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
