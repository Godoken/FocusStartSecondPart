package com.example.focusstartsecondpart.features.events.domain.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public final class Event {

    @NonNull
    @PrimaryKey private int id;
    private String title;
    private String description;

    public Event(int id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
