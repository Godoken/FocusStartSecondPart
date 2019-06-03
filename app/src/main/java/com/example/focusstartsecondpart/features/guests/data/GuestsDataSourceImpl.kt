package com.example.focusstartsecondpart.features.guests.data

import com.example.focusstartsecondpart.App.App
import com.example.focusstartsecondpart.features.guests.data.network.GuestsLoader
import com.example.focusstartsecondpart.features.guests.domain.model.Guest
import com.example.focusstartsecondpart.features.guests.domain.model.Result
import com.example.focusstartsecondpart.features.guests.domain.model.VerifiedMember

import io.reactivex.Single

class GuestsDataSourceImpl(private val guestsLoader: GuestsLoader) : GuestsDataSource {

    override fun loadGuests(id: Int): Single<List<Guest>> {
        return loadGuestsFromNet(id)
                .onErrorResumeNext { loadGuestsFromDatabase(id) }
    }

    override fun updateGuest(eventId: Int, guest: Guest, verifiedMemberList: List<VerifiedMember>): Single<Result> {
        return guestsLoader.updateGuest(eventId, verifiedMemberList)
                .doOnSuccess { App.getDataBase().databaseDao.updateGuest(guest) }
                .doOnError { App.getDataBase().databaseDao.updateGuest(guest) }
    }

    private fun loadGuestsFromNet(id: Int): Single<List<Guest>> {
        return guestsLoader.loadGuests(id).doOnSuccess { guests ->
            guests.forEach { guest -> guest.eventId = id }
            App.getDataBase().databaseDao.insertAllGuests(guests)
        }
    }

    private fun loadGuestsFromDatabase(id: Int): Single<List<Guest>> {
        return App.getDataBase().databaseDao.getAllGuestsByEventId(id)
    }
}
