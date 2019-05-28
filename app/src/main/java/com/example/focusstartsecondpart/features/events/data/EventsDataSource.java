package com.example.focusstartsecondpart.features.events.data;

import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Observer;

public interface EventsDataSource {
    void loadEvents(Observer<List<Event>> listObserver);
}
