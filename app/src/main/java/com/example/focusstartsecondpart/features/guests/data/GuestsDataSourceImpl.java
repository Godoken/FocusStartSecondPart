package com.example.focusstartsecondpart.features.guests.data;

import com.example.focusstartsecondpart.features.guests.data.network.GuestsLoader;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Observer;

public class GuestsDataSourceImpl implements GuestsDataSource {

    private GuestsLoader guestsLoader;

    public GuestsDataSourceImpl(GuestsLoader guestsLoader) {
        this.guestsLoader = guestsLoader;
    }

    @Override
    public void loadGuests(Observer<List<Guest>> listObserver) {

    }
}
