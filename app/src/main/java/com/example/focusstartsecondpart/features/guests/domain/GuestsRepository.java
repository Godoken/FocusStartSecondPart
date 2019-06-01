package com.example.focusstartsecondpart.features.guests.domain;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;

public interface GuestsRepository {
    Single<List<Guest>> loadGuests(int id);

    SingleObserver<Guest> updateGuest();

    void updateGuestToNet(int eventId, Guest guest);
}
