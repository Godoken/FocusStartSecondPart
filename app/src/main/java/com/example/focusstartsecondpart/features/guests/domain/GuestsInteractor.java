package com.example.focusstartsecondpart.features.guests.domain;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Observer;

public interface GuestsInteractor {
    void loadGuests(Observer<List<Guest>> listObserver);
}
