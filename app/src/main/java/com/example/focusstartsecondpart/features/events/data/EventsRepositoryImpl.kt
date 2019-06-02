package com.example.focusstartsecondpart.features.events.data

import com.example.focusstartsecondpart.features.events.domain.EventsRepository
import com.example.focusstartsecondpart.features.events.domain.model.Event
import io.reactivex.Single

class EventsRepositoryImpl(private val eventsDataSource: EventsDataSource) : EventsRepository {

    override fun loadEvents(): Single<List<Event>> {
        return eventsDataSource.loadEvents()
    }


}