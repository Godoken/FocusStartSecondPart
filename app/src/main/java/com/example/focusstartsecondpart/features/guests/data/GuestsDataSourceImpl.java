package com.example.focusstartsecondpart.features.guests.data;

import com.example.focusstartsecondpart.App;
import com.example.focusstartsecondpart.features.guests.data.network.GuestsLoader;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GuestsDataSourceImpl implements GuestsDataSource {

    private GuestsLoader guestsLoader;

    public GuestsDataSourceImpl(GuestsLoader guestsLoader) {
        this.guestsLoader = guestsLoader;
    }

    @Override
    public void loadGuests(Observer<List<Guest>> listObserver, int id) {
        loadGuestsFromNet(id);
        loadGuestsFromDatabase(listObserver);
    }

    @Override
    public void updateGuest(Observable<Guest> guestObservable) {
        guestObservable.subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Guest>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Guest guest) {
                        App.getDataBase().getDatabaseDao().updateGuest(guest);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void loadGuestsFromDatabase(Observer<List<Guest>> listObserver){
        App.getDataBase().getDatabaseDao().getAllGuests()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listObserver);
    }

    private void loadGuestsFromNet(int id){
        Observer<List<Guest>> listObserver = new Observer<List<Guest>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(List<Guest> guests) {
                App.getDataBase().getDatabaseDao().insertAllGuests(guests);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };
        guestsLoader.loadGuests(listObserver, id);
    }
}
