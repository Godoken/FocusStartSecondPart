package com.example.focusstartsecondpart.features.guests.domain;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;

public interface GuestsInteractor {
    Single<List<Guest>> loadGuests(int id);

    SingleObserver<Guest> updateGuest();

    ArrayList<String> loadProfile(Guest guest);

    void updateGuestToNet(int eventId, Guest guest1);
}
