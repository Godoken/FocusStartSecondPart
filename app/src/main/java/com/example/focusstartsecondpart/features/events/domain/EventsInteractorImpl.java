package com.example.focusstartsecondpart.features.events.domain;

import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Observable;

public class EventsInteractorImpl implements EventsInteractor {

    private EventsRepository eventsRepository;

    public EventsInteractorImpl(EventsRepository eventsRepository){
        this.eventsRepository = eventsRepository;
    }

    @Override
    public Observable<List<Event>> loadEvents() {
        return eventsRepository.loadEvents().
                filter(events -> events != null).
                filter(events -> events.size() != 0);
    }
}
