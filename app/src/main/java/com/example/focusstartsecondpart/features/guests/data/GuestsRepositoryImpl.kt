package com.example.focusstartsecondpart.features.guests.data

import com.example.focusstartsecondpart.features.guests.domain.GuestsRepository
import com.example.focusstartsecondpart.features.guests.domain.model.Guest
import com.example.focusstartsecondpart.features.guests.domain.model.Result
import com.example.focusstartsecondpart.features.guests.domain.model.VerifiedMember

import io.reactivex.Single

class GuestsRepositoryImpl(private val guestsDataSource: GuestsDataSource) : GuestsRepository {

    override fun loadGuests(id: Int): Single<List<Guest>> {
        return guestsDataSource.loadGuests(id)
    }

    override fun updateGuest(eventId: Int, guest: Guest, verifiedMemberList: List<VerifiedMember>): Single<Result> {
        return guestsDataSource.updateGuest(eventId, guest, verifiedMemberList)
    }
}
