package com.example.focusstartsecondpart.features.guests.data;

import com.example.focusstartsecondpart.App.App;
import com.example.focusstartsecondpart.features.guests.data.network.GuestsLoader;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;
import com.example.focusstartsecondpart.features.guests.domain.model.Result;
import com.example.focusstartsecondpart.features.guests.domain.model.VerifiedMember;

import java.util.List;

import io.reactivex.Single;

public class GuestsDataSourceImpl implements GuestsDataSource {

    private GuestsLoader guestsLoader;

    public GuestsDataSourceImpl(GuestsLoader guestsLoader) {
        this.guestsLoader = guestsLoader;
    }

    @Override
    public Single<List<Guest>> loadGuests(int id) {
        return loadGuestsFromNet(id)
                .onErrorResumeNext(throwable -> loadGuestsFromDatabase(id));
    }

    @Override
    public Single<Result> updateGuest(int eventId, Guest guest, List<VerifiedMember> verifiedMemberList) {
        return guestsLoader.updateGuest(eventId, verifiedMemberList).doOnError(throwable -> {
            App.getDataBase().getDatabaseDao().updateGuest(guest);
        });
    }

    private Single<List<Guest>> loadGuestsFromNet(int id){
        return guestsLoader.loadGuests(id).doOnSuccess(guests -> {
            App.getDataBase().getDatabaseDao().insertAllGuests(guests);
        });
    }

    private Single<List<Guest>> loadGuestsFromDatabase(int id) {
        return App.getDataBase().getDatabaseDao().getAllGuests();
    }
}
