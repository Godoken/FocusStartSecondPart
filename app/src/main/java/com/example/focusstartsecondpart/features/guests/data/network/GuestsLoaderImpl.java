package com.example.focusstartsecondpart.features.guests.data.network;

import com.example.focusstartsecondpart.App.client.Api;
import com.example.focusstartsecondpart.App.client.Client;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;
import com.example.focusstartsecondpart.features.guests.domain.model.Result;
import com.example.focusstartsecondpart.features.guests.domain.model.VerifiedMember;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class GuestsLoaderImpl implements GuestsLoader {

    private Api api;

    public GuestsLoaderImpl(Api api){
        this.api = api;
    }

    @Override
    public Single<List<Guest>> loadGuests(int id) {
        return api.getGuestList(106, Client.getInstance().getCftToken())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Single<Result> updateGuest(int eventId, List<VerifiedMember> verifiedMemberList) {
        return api.updateGuest(eventId, Client.getInstance().getCftToken(), verifiedMemberList)
                .subscribeOn(Schedulers.io());
    }
}
