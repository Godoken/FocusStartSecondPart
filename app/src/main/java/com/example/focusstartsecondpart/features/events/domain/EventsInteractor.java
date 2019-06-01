package com.example.focusstartsecondpart.features.events.domain;

import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Single;

public interface EventsInteractor {

    Single<List<Event>> loadEvents();

    //Single<List<Event>> loadEventsFromDatabase();
}
