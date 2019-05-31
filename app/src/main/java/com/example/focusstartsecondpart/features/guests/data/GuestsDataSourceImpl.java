package com.example.focusstartsecondpart.features.guests.data;

import com.example.focusstartsecondpart.App;
import com.example.focusstartsecondpart.features.guests.data.network.GuestsLoader;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GuestsDataSourceImpl implements GuestsDataSource {

    private GuestsLoader guestsLoader;
    private Observable<List<Guest>> listToUI;

    private SingleObserver<List<Guest>> singleObserver;
    private Single<List<Guest>> listSingle;

    public GuestsDataSourceImpl(GuestsLoader guestsLoader) {
        this.guestsLoader = guestsLoader;
    }

    @Override
    public Observable<List<Guest>> loadGuests(int id) {
        loadGuestsFromNet(id);
        listToUI = listSingle.toObservable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        return listToUI;
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

    private void loadGuestsFromNet(int id){

        listSingle = guestsLoader.loadGuests(id);
        singleObserver = new SingleObserver<List<Guest>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onSuccess(List<Guest> guests) {
                if (guests.size() != 0){
                    App.getDataBase().getDatabaseDao().updateAllGuests(guests);
                } else {
                    onError(new Throwable());
                }
            }

            @Override
            public void onError(Throwable e) {
            }
        };
        listSingle.subscribeOn(Schedulers.io())
                .subscribe(singleObserver);
    }
}
