package com.example.focusstartsecondpart.features.guests.data.network

import com.example.focusstartsecondpart.App.client.Api
import com.example.focusstartsecondpart.App.client.Client
import com.example.focusstartsecondpart.features.guests.domain.model.Guest
import com.example.focusstartsecondpart.features.guests.domain.model.Result
import com.example.focusstartsecondpart.features.guests.domain.model.VerifiedMember

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class GuestsLoaderImpl(private val api: Api) : GuestsLoader {

    override fun loadGuests(id: Int): Single<List<Guest>> {
        return api.getGuestList(106, Client.getInstance().cftToken)
                .subscribeOn(Schedulers.io())
    }

    override fun updateGuest(eventId: Int, verifiedMemberList: List<VerifiedMember>): Single<Result> {
        return api.updateGuest(eventId, Client.getInstance().cftToken, verifiedMemberList)
                .subscribeOn(Schedulers.io())
    }
}
