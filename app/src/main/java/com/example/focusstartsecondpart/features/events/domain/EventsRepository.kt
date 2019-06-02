package com.example.focusstartsecondpart.features.events.domain

import com.example.focusstartsecondpart.features.events.domain.model.Event

import io.reactivex.Single

interface EventsRepository {
    fun loadEvents(): Single<List<Event>>
}
