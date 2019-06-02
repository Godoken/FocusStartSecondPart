package com.example.focusstartsecondpart.features.guests.data;

import com.example.focusstartsecondpart.features.guests.domain.GuestsRepository;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;
import com.example.focusstartsecondpart.features.guests.domain.model.Result;
import com.example.focusstartsecondpart.features.guests.domain.model.VerifiedMember;

import java.util.List;

import io.reactivex.Single;

public class GuestsRepositoryImpl implements GuestsRepository {

    private GuestsDataSource guestsDataSource;

    public GuestsRepositoryImpl(GuestsDataSource guestsDataSource) {
        this.guestsDataSource = guestsDataSource;
    }

    @Override
    public Single<List<Guest>> loadGuests(int id) {
        return guestsDataSource.loadGuests(id);
    }

    @Override
    public Single<Result> updateGuest(int eventId, Guest guest, List<VerifiedMember> verifiedMemberList) {
        return guestsDataSource.updateGuest(eventId, guest, verifiedMemberList);
    }
}
