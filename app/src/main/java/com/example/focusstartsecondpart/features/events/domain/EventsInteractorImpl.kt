package com.example.focusstartsecondpart.features.events.domain

import com.example.focusstartsecondpart.features.events.domain.model.Event
import io.reactivex.Observable

import io.reactivex.Single

class EventsInteractorImpl(private val eventsRepository: EventsRepository) : EventsInteractor {
    override fun loadEvents(): Single<List<Event>> {
        return eventsRepository.loadEvents()
                .toObservable()
                .flatMap { listEvent: List<Event> -> Observable.fromIterable(listEvent) }
                .filter { event: Event -> event.status != -2 }
                .toList()
    }
}
