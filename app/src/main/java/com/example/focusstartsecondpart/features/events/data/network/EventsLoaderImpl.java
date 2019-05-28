package com.example.focusstartsecondpart.features.events.data.network;

import com.example.focusstartsecondpart.features.retrofit.Api;
import com.example.focusstartsecondpart.features.retrofit.Client;
import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;

public class EventsLoaderImpl implements EventsLoader{

    private Api api;

    @Override
    public void loadEvents(Observer<List<Event>> listObserver) {
        api = Client.getInstance().getApi();

        api.getEventList()
                //.observeOn(Schedulers.io())
                //.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())
                .subscribe(listObserver);

    }
}
