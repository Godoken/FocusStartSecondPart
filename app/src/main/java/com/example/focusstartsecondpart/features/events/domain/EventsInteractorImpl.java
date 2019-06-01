package com.example.focusstartsecondpart.features.events.domain;

import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Single;

public class EventsInteractorImpl implements EventsInteractor {

    private EventsRepository eventsRepository;

    public EventsInteractorImpl(EventsRepository eventsRepository){
        this.eventsRepository = eventsRepository;
    }

    @Override
    public Single<List<Event>> loadEvents() {
        return eventsRepository.loadEvents();//.
                //filter(events -> events != null).
                //filter(events -> events.size() != 0);
    }

    /*@Override
    public Single<List<Event>> loadEventsFromDatabase() {
        return eventsRepository.loadEventsFromDatabase();
                //.subscribeOn(Schedulers.io())
                //.observeOn(AndroidSchedulers.mainThread())//.
                //.filter(events -> events != null).
                //.filter(events -> events.size() != 0);
    }*/
}
