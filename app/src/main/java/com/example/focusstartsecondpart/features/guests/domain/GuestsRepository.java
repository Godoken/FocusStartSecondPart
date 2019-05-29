package com.example.focusstartsecondpart.features.guests.domain;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

public interface GuestsRepository {
    void loadGuests(Observer<List<Guest>> listObserver, int id);

    void updateGuest(Observable<Guest> guestObservable);
}
