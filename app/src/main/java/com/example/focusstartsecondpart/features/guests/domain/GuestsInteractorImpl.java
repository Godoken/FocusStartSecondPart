package com.example.focusstartsecondpart.features.guests.domain;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class GuestsInteractorImpl implements GuestsInteractor {

    private GuestsRepository guestsRepository;

    public GuestsInteractorImpl(GuestsRepository guestsRepository) {
        this.guestsRepository = guestsRepository;
    }

    @Override
    public void loadGuests(Observer<List<Guest>> listObserver, int id) {
        guestsRepository.loadGuests(listObserver, id);
    }

    @Override
    public void updateGuest(Observable<Guest> guestObservable) {
        guestsRepository.updateGuest(guestObservable);
    }
}
