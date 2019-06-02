package com.example.focusstartsecondpart.features.events.domain

import com.example.focusstartsecondpart.features.events.domain.model.Event

import io.reactivex.Single

class EventsInteractorImpl(private val eventsRepository: EventsRepository) : EventsInteractor {

    override fun loadEvents(): Single<List<Event>> {
        return eventsRepository.loadEvents()
    }
}
