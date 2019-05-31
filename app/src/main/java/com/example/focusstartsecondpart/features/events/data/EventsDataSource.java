package com.example.focusstartsecondpart.features.events.data;

import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Observable;

public interface EventsDataSource {
    Observable<List<Event>> loadEvents();
}
