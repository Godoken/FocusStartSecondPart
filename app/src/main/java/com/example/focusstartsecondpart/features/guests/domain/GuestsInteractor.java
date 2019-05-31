package com.example.focusstartsecondpart.features.guests.domain;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;

public interface GuestsInteractor {
    Observable<List<Guest>> loadGuests(int id);

    SingleObserver<Guest> updateGuest();

    ArrayList<String> loadProfile(Guest guest);
}
