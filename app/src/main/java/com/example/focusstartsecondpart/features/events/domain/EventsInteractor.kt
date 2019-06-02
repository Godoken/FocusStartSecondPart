package com.example.focusstartsecondpart.features.events.domain

import com.example.focusstartsecondpart.features.events.domain.model.Event

import io.reactivex.Single

interface EventsInteractor {
    fun loadEvents(): Single<List<Event>>
}
