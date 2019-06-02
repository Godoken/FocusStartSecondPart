package com.example.focusstartsecondpart.features.events.data;

import com.example.focusstartsecondpart.features.events.domain.EventsRepository;
import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Single;

public class EventsRepositoryImpl implements EventsRepository {

    private EventsDataSource eventsDataSource;

    public EventsRepositoryImpl(EventsDataSource eventsDataSource){
        this.eventsDataSource = eventsDataSource;
    }

    @Override
    public Single<List<Event>> loadEvents() {
        return eventsDataSource.loadEvents();
    }
}
