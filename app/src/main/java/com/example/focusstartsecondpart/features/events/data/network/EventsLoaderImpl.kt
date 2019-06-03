package com.example.focusstartsecondpart.features.events.data.network

import com.example.focusstartsecondpart.App.client.Api
import com.example.focusstartsecondpart.App.client.Client
import com.example.focusstartsecondpart.features.events.domain.model.Event

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class EventsLoaderImpl(private val api: Api) : EventsLoader {
    override fun loadEvents(): Single<List<Event>> {
        return api.getEventList(Client.getInstance().cftToken)
                .subscribeOn(Schedulers.io())
    }
}
