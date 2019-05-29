package com.example.focusstartsecondpart.features.events.data;

import com.example.focusstartsecondpart.App;
import com.example.focusstartsecondpart.features.events.data.network.EventsLoader;
import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class EventsDataSourceImpl implements EventsDataSource {

    private EventsLoader eventsLoader;

    public EventsDataSourceImpl(EventsLoader eventsLoader) {
        this.eventsLoader = eventsLoader;
    }

    @Override
    public void loadEvents(Observer<List<Event>> listObserver) {
        loadEventsFromNet();
        loadEventsFromDatabase(listObserver);
    }

    private void loadEventsFromDatabase(Observer<List<Event>> listObserver){
        App.getDataBase().getDatabaseDao().getAllEvents()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listObserver);
    }

    private void loadEventsFromNet(){
        Observer<List<Event>> listObserver = new Observer<List<Event>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(List<Event> events) {
                App.getDataBase().getDatabaseDao().insertAllEvents(events);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {

            }
        };
        eventsLoader.loadEvents(listObserver);
    }
}
