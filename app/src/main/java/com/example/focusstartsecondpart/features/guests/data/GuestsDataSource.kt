package com.example.focusstartsecondpart.features.guests.data

import com.example.focusstartsecondpart.features.guests.domain.model.Guest
import com.example.focusstartsecondpart.features.guests.domain.model.Result
import com.example.focusstartsecondpart.features.guests.domain.model.VerifiedMember

import io.reactivex.Single

interface GuestsDataSource {
    fun loadGuests(id: Int): Single<List<Guest>>
    fun updateGuest(eventId: Int, guest: Guest, verifiedMemberList: List<VerifiedMember>): Single<Result>
}
