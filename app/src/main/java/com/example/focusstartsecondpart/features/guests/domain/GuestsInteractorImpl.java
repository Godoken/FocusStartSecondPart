package com.example.focusstartsecondpart.features.guests.domain;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.ArrayList;
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

    @Override
    public ArrayList<String> loadProfile(Guest guest) {

        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList.add(guest.getFirstName());
        stringArrayList.add(guest.getLastName());
        stringArrayList.add(guest.getPhone());

        return stringArrayList;
    }
}
