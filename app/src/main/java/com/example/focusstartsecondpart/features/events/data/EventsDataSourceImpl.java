package com.example.focusstartsecondpart.features.events.data;

import com.example.focusstartsecondpart.App.App;
import com.example.focusstartsecondpart.features.events.data.network.EventsLoader;
import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Single;

public class EventsDataSourceImpl implements EventsDataSource {

    private EventsLoader eventsLoader;

    public EventsDataSourceImpl(EventsLoader eventsLoader) {
        this.eventsLoader = eventsLoader;
    }

    @Override
    public Single<List<Event>> loadEvents() {
        return loadEventsFromNet()
                .onErrorResumeNext(throwable -> loadEventsFromDatabase());
    }

    private Single<List<Event>> loadEventsFromNet() {
        return eventsLoader.loadEvents().doOnSuccess(events -> {
            App.getDataBase().getDatabaseDao().insertAllEvents(events);
        });
    }
    private Single<List<Event>> loadEventsFromDatabase() {
         return App.getDataBase().getDatabaseDao().getAllEvents();
    }
}
