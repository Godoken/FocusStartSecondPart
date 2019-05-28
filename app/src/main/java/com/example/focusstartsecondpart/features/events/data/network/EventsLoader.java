package com.example.focusstartsecondpart.features.events.data.network;

import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Observer;

public interface EventsLoader {

    void loadEvents(Observer<List<Event>> listObserver);
}