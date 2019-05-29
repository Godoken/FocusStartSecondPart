package com.example.focusstartsecondpart.features.guests.data.network;

import com.example.focusstartsecondpart.features.events.domain.model.Event;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Observer;

public interface GuestsLoader {

    void loadGuests(Observer<List<Guest>> listObserver, int id);
}
