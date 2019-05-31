package com.example.focusstartsecondpart.features.guests.data;

import com.example.focusstartsecondpart.features.guests.domain.GuestsRepository;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;
import java.util.Optional;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;

public class GuestsRepositoryImpl implements GuestsRepository {

    private GuestsDataSource guestsDataSource;

    public GuestsRepositoryImpl(GuestsDataSource guestsDataSource) {
        this.guestsDataSource = guestsDataSource;
    }

    @Override
    public Observable<List<Guest>> loadGuests(int id) {
        return guestsDataSource.loadGuests(id);
    }

    @Override
    public SingleObserver<Guest> updateGuest() {
        return guestsDataSource.updateGuest();
    }

    @Override
    public Observable<List<Guest>> loadGuestsFromDatabase(int id) {
        return guestsDataSource.loadEventsFromDatabase(id);
    }
}
