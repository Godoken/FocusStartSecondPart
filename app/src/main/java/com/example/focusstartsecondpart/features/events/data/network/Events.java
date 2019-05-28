package com.example.focusstartsecondpart.features.events.data.network;

import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

public class Events {

    private List<Event> eventList;

    public Events(List<Event> eventList){
        this.eventList = eventList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
