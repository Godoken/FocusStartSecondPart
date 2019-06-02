package com.example.focusstartsecondpart.features.guests.data.network;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;
import com.example.focusstartsecondpart.features.guests.domain.model.Result;
import com.example.focusstartsecondpart.features.guests.domain.model.VerifiedMember;

import java.util.List;

import io.reactivex.Single;

public interface GuestsLoader {
    Single<List<Guest>> loadGuests(int id);
    Single<Result> updateGuest(int id, List<VerifiedMember> verifiedMemberList);
}
