package com.example.focusstartsecondpart.features.guests.domain;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;
import com.example.focusstartsecondpart.features.guests.domain.model.Result;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public interface GuestsInteractor {
    Single<List<Guest>> loadGuests(int id);

    ArrayList<String> loadProfile(Guest guest);

    Single<Result> updateGuest(int eventId, Guest guest1);
}
