package com.example.focusstartsecondpart.features.guests.data.network;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Single;

public interface GuestsLoader {

    Single<List<Guest>> loadGuests(int id);

    void updateGuest(int id, Guest guest);
}
