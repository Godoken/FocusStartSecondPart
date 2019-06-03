package com.example.focusstartsecondpart.features.guests.data.network

import com.example.focusstartsecondpart.features.guests.domain.model.Guest
import com.example.focusstartsecondpart.features.guests.domain.model.Result
import com.example.focusstartsecondpart.features.guests.domain.model.VerifiedMember

import io.reactivex.Single

interface GuestsLoader {
    fun loadGuests(id: Int): Single<List<Guest>>
    fun updateGuest(eventId: Int, verifiedMemberList: List<VerifiedMember>): Single<Result>
}
