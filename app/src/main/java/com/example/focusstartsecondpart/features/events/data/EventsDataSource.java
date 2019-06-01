package com.example.focusstartsecondpart.features.events.data;

import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Single;

public interface EventsDataSource {
    Single<List<Event>> loadEvents();
    //Single<List<Event>> loadEventsFromDatabase();
}
