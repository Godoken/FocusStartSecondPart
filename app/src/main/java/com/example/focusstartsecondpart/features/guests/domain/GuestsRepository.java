package com.example.focusstartsecondpart.features.guests.domain;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;
import com.example.focusstartsecondpart.features.guests.domain.model.Result;
import com.example.focusstartsecondpart.features.guests.domain.model.VerifiedMember;

import java.util.List;

import io.reactivex.Single;

public interface GuestsRepository {
    Single<List<Guest>> loadGuests(int id);
    Single<Result> updateGuest(int eventId, Guest guest, List<VerifiedMember> verifiedMemberList);
}
