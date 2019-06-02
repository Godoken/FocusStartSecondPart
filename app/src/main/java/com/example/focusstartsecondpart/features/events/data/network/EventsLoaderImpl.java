package com.example.focusstartsecondpart.features.events.data.network;

import com.example.focusstartsecondpart.App.client.Api;
import com.example.focusstartsecondpart.App.client.Client;
import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class EventsLoaderImpl implements EventsLoader{

    private Api api;

    public EventsLoaderImpl(Api api){
        this.api = api;
    }

    @Override
    public Single<List<Event>> loadEvents() {
        return api.getEventList(Client.getInstance().getCftToken())
               .subscribeOn(Schedulers.io());
    }
}
