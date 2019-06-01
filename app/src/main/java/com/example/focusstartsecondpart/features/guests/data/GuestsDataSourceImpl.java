package com.example.focusstartsecondpart.features.guests.data;

import com.example.focusstartsecondpart.App;
import com.example.focusstartsecondpart.features.guests.data.network.GuestsLoader;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

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
    public SingleObserver<Guest> updateGuest() {
        return new SingleObserver<Guest>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onSuccess(Guest guest) {
                App.getDataBase().getDatabaseDao().updateGuest(guest);
            }

            @Override
            public void onError(Throwable e) {
            }
        };
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
