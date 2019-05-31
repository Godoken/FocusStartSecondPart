package com.example.focusstartsecondpart.features.guests.data;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;

public interface GuestsDataSource {
    Observable<List<Guest>> loadGuests(int id);

    SingleObserver<Guest> updateGuest();
}
