package com.example.focusstartsecondpart.features.guests.data;

import com.example.focusstartsecondpart.features.guests.domain.GuestsRepository;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;

public class GuestsRepositoryImpl implements GuestsRepository {

    private GuestsDataSource guestsDataSource;

    public GuestsRepositoryImpl(GuestsDataSource guestsDataSource) {
        this.guestsDataSource = guestsDataSource;
    }

    @Override
    public Single<List<Guest>> loadGuests(int id) {
        return guestsDataSource.loadGuests(id);
    }

    @Override
    public SingleObserver<Guest> updateGuest() {
        return guestsDataSource.updateGuest();
    }

    @Override
    public void updateGuestToNet(int eventId, Guest guest) {
        guestsDataSource.updateGuestToNet(eventId, guest);
    }

}
