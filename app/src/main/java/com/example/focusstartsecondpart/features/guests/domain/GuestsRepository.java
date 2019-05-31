package com.example.focusstartsecondpart.features.guests.domain;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;

public interface GuestsRepository {
    Observable<List<Guest>> loadGuests(int id);

    SingleObserver<Guest> updateGuest();
}
