package com.example.focusstartsecondpart.features.guests.domain;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;

public class GuestsInteractorImpl implements GuestsInteractor {

    private GuestsRepository guestsRepository;

    public GuestsInteractorImpl(GuestsRepository guestsRepository) {
        this.guestsRepository = guestsRepository;
    }

    @Override
    public Observable<List<Guest>> loadGuests(int id) {
        return guestsRepository.loadGuests(id)
                .filter(guests -> guests != null)
                .filter(guests -> guests.size() != 0);
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

    @Override
    public Observable<List<Guest>> loadGuestsFromDatabase(int id) {
        return guestsRepository.loadGuestsFromDatabase(id)
                .filter(guests -> guests != null)
                .filter(guests -> guests.size() != 0);
    }
}
