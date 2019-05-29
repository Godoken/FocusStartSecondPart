package com.example.focusstartsecondpart.features.guests.data;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Observer;

public interface GuestsDataSource {
    void loadGuests(Observer<List<Guest>> listObserver, int id);
}
