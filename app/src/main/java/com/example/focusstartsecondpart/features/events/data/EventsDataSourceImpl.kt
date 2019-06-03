package com.example.focusstartsecondpart.features.events.data

import com.example.focusstartsecondpart.App.App
import com.example.focusstartsecondpart.features.events.data.network.EventsLoader
import com.example.focusstartsecondpart.features.events.domain.model.Event

import io.reactivex.Single

class EventsDataSourceImpl(private val eventsLoader: EventsLoader) : EventsDataSource {

    override fun loadEvents(): Single<List<Event>> {
        return loadEventsFromNet()
                .onErrorResumeNext {loadEventsFromDatabase() }
    }

    private fun loadEventsFromNet(): Single<List<Event>> {
        return eventsLoader.loadEvents()
                .doOnSuccess { events -> App.getDataBase().databaseDao.insertAllEvents(events) }
    }

    private fun loadEventsFromDatabase(): Single<List<Event>> {
        return App.getDataBase().databaseDao.allEvents
    }
}
