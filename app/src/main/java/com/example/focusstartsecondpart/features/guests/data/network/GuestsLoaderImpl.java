package com.example.focusstartsecondpart.features.guests.data.network;

import com.example.focusstartsecondpart.features.guests.domain.model.Guest;
import com.example.focusstartsecondpart.features.retrofit.Api;
import com.example.focusstartsecondpart.features.retrofit.Client;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class GuestsLoaderImpl implements GuestsLoader {

    private Api api;

    @Override
    public Single<List<Guest>> loadGuests(int id) {
        api = Client.getInstance().getApi();

        return api.getGuestList(106, Client.getInstance().getCftToken())
                .subscribeOn(Schedulers.newThread());
    }
}
