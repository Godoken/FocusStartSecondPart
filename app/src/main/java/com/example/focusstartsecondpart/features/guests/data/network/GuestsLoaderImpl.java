package com.example.focusstartsecondpart.features.guests.data.network;

import com.example.focusstartsecondpart.App.client.Api;
import com.example.focusstartsecondpart.App.client.Client;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;
import com.example.focusstartsecondpart.features.guests.domain.model.VerifiedMember;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class GuestsLoaderImpl implements GuestsLoader {

    private Api api;

    @Override
    public Single<List<Guest>> loadGuests(int id) {
        api = Client.getInstance().getApi();

        return api.getGuestList(106, Client.getInstance().getCftToken())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public void updateGuest(int eventId, Guest guest) {
        api = Client.getInstance().getApi();

        int guestId = guest.getId();
        boolean isVisited;
        String date = "16.10.1999";

        if (guest.isVisited()){
            isVisited = false;
        } else {
            isVisited = true;
        }

        VerifiedMember verifiedMember = new VerifiedMember(guestId, isVisited, date);

        api.updateGuest(eventId, Client.getInstance().getCftToken(), verifiedMember);
    }
}
