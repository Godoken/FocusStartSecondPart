package com.example.focusstartsecondpart.features.guests.data;

import com.example.focusstartsecondpart.features.guests.domain.GuestsRepository;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Observer;

public class GuestsRepositoryImpl implements GuestsRepository {

    private GuestsDataSource guestsDataSource;

    public GuestsRepositoryImpl(GuestsDataSource guestsDataSource) {
        this.guestsDataSource = guestsDataSource;
    }

    @Override
    public void loadGuests(Observer<List<Guest>> listObserver, int id) {
        guestsDataSource.loadGuests(listObserver, id);
    }
}
