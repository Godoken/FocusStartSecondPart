package com.example.focusstartsecondpart.features.events.data;

import com.example.focusstartsecondpart.App;
import com.example.focusstartsecondpart.features.events.data.network.EventsLoader;
import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class EventsDataSourceImpl implements EventsDataSource {

    private EventsLoader eventsLoader;
    private Observable<List<Event>> listToUI;

    private SingleObserver<List<Event>> singleObserver;
    private Single<List<Event>> listSingle;

    public EventsDataSourceImpl(EventsLoader eventsLoader) {
        this.eventsLoader = eventsLoader;
    }

    @Override
    public Observable<List<Event>> loadEvents() {
        loadEventsFromNet();

        listToUI = listSingle.toObservable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        return listToUI;
    }

    private void loadEventsFromNet() {
        listSingle  = eventsLoader.loadEvents();
        singleObserver = new SingleObserver<List<Event>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onSuccess(List<Event> events) {
                if (events.size() != 0){
                    App.getDataBase().getDatabaseDao().updateAllEvents(events);
                } else {
                    onError(new Throwable());
                }
            }

            @Override
            public void onError(Throwable e) {
            }
        };
        listSingle.subscribeOn(Schedulers.io())
                .subscribe(singleObserver);
    }

    @Override
    public Observable<List<Event>> loadEventsFromDatabase() {
         listToUI = App.getDataBase().getDatabaseDao().getAllEvents().toObservable()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
         return listToUI;
    }
}
