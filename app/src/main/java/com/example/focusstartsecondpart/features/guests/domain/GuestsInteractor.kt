package com.example.focusstartsecondpart.features.guests.domain

import com.example.focusstartsecondpart.features.guests.domain.model.Guest
import com.example.focusstartsecondpart.features.guests.domain.model.Result
import io.reactivex.Single
import java.util.*

interface GuestsInteractor {
    fun loadGuests(id: Int): Single<List<Guest>>

    fun loadProfile(guest: Guest): ArrayList<String>

    fun updateGuest(eventId: Int, guest1: Guest): Single<Result>
}
