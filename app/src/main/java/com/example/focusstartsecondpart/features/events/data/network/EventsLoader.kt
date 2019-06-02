package com.example.focusstartsecondpart.features.events.data.network

import com.example.focusstartsecondpart.features.events.domain.model.Event

import io.reactivex.Single

interface EventsLoader {
    fun loadEvents(): Single<List<Event>>
}
