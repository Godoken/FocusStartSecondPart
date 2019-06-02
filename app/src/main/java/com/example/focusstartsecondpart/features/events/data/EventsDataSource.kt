package com.example.focusstartsecondpart.features.events.data

import com.example.focusstartsecondpart.features.events.domain.model.Event
import io.reactivex.Single

interface EventsDataSource {
    fun loadEvents(): Single<List<Event>>
}