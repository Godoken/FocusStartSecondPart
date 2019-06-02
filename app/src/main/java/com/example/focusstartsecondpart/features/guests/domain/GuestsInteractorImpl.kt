package com.example.focusstartsecondpart.features.guests.domain

import com.example.focusstartsecondpart.features.guests.domain.model.Guest
import com.example.focusstartsecondpart.features.guests.domain.model.Result
import com.example.focusstartsecondpart.features.guests.domain.model.VerifiedMember
import io.reactivex.Single
import java.util.*

class GuestsInteractorImpl(private val guestsRepository: GuestsRepository) : GuestsInteractor {

    override fun loadGuests(id: Int): Single<List<Guest>> {
        return guestsRepository.loadGuests(id)
    }

    override fun loadProfile(guest: Guest): ArrayList<String> {

        val stringArrayList = ArrayList<String>()

        stringArrayList.add(guest.firstName)
        stringArrayList.add(guest.lastName)
        stringArrayList.add(guest.phone)

        return stringArrayList
    }

    override fun updateGuest(eventId: Int, guest: Guest): Single<Result> {
        val verifiedMember = VerifiedMember(guest.id, guest.visited, "16.10.1999")
        val verifiedMemberList = ArrayList<VerifiedMember>()
        verifiedMemberList.add(verifiedMember)

        return guestsRepository.updateGuest(eventId, guest, verifiedMemberList)
    }
}
