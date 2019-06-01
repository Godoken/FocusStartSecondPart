package com.example.focusstartsecondpart.features.guests.presentation;

import com.example.focusstartsecondpart.features.BasePresenter;
import com.example.focusstartsecondpart.features.guests.domain.GuestsInteractor;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GuestsActivityPresenter extends BasePresenter<GuestsListView> {

    private GuestsInteractor guestsInteractor;

    public GuestsActivityPresenter(GuestsInteractor guestsInteractor){
        this.guestsInteractor = guestsInteractor;
    }

    @Override
    public void onViewReady(){
        view.showProgress();
        view.loadGuests();
        view.hideProgress();
    }

    public void loadGuests(int id){

        Observable<List<Guest>> listObservable  = guestsInteractor.loadGuests(id).toObservable();

        Observer<List<Guest>> listObserver = new Observer<List<Guest>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Guest> guests) {
                view.setGuestsToAdapter(guests);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {

            }
        };

        listObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listObserver);
    }

    public void onGuestSelected(Guest guest) {
        view.loadInformation(guestsInteractor.loadProfile(guest));
    }

    public void onGuestVisitedChanged(Guest guest) {
        Single<Guest> guestSingle = Single.just(guest);
        SingleObserver<Guest> guestObserver = guestsInteractor.updateGuest();

        guestSingle
                .subscribeOn(Schedulers.io())
                .subscribe(guestObserver);

    }
}
