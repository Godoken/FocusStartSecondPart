package com.example.focusstartsecondpart.features.guests.domain;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;

public class GuestsInteractorImpl implements GuestsInteractor {

    private GuestsRepository guestsRepository;

    public GuestsInteractorImpl(GuestsRepository guestsRepository) {
        this.guestsRepository = guestsRepository;
    }

    @Override
    public Single<List<Guest>> loadGuests(int id) {
        return guestsRepository.loadGuests(id);
    }

    @Override
    public SingleObserver<Guest> updateGuest() {
        return guestsRepository.updateGuest();
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
