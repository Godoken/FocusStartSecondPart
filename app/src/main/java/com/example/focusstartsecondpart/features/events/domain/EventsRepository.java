package com.example.focusstartsecondpart.features.events.domain;

import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Observer;

public interface EventsRepository {
    void loadEvents(Observer<List<Event>> listObserver);
}
