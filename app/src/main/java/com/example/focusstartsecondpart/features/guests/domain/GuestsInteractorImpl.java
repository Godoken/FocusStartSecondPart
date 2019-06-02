package com.example.focusstartsecondpart.features.guests.domain;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;
import com.example.focusstartsecondpart.features.guests.domain.model.Result;
import com.example.focusstartsecondpart.features.guests.domain.model.VerifiedMember;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

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
    public ArrayList<String> loadProfile(Guest guest) {

        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList.add(guest.getFirstName());
        stringArrayList.add(guest.getLastName());
        stringArrayList.add(guest.getPhone());

        return stringArrayList;
    }

    @Override
    public Single<Result> updateGuest(int eventId, Guest guest) {
        VerifiedMember verifiedMember = new VerifiedMember(guest.getId(), guest.getVisited(), "16.10.1999");
        List<VerifiedMember> verifiedMemberList = new ArrayList<>();
        verifiedMemberList.add(verifiedMember);

        return guestsRepository.updateGuest(eventId, guest, verifiedMemberList);
    }
}
