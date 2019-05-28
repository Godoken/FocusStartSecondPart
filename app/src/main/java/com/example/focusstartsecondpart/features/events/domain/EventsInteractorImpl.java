package com.example.focusstartsecondpart.features.events.domain;

import com.example.focusstartsecondpart.features.events.domain.model.Event;
import com.example.focusstartsecondpart.support.Carry;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class EventsInteractorImpl implements EventsInteractor {

    private EventsRepository eventsRepository;

    public EventsInteractorImpl(EventsRepository eventsRepository){
        this.eventsRepository = eventsRepository;
    }

    @Override
    public void loadEvents(Observer<List<Event>> listObserver) {
        eventsRepository.loadEvents(listObserver);
    }
}
