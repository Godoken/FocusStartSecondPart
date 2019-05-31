package com.example.focusstartsecondpart.features.events.domain;

import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;
import java.util.Optional;

import io.reactivex.Observable;

public interface EventsRepository {
    Observable<List<Event>> loadEvents();

    Observable<List<Event>> loadEventsFromDatabase();
}
