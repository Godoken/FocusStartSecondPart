package com.example.focusstartsecondpart.features.guests.presentation;

import com.example.focusstartsecondpart.App.BasePresenter;
import com.example.focusstartsecondpart.features.guests.domain.GuestsInteractor;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;
import com.example.focusstartsecondpart.features.guests.domain.model.Result;

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
    private int eventId;

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
        eventId = id;
        Observable<List<Guest>> listObservable  = guestsInteractor.loadGuests(id).toObservable();
        Observer<List<Guest>> listObserver = new Observer<List<Guest>>() {
            @Override
            public void onSubscribe(Disposable d) { }

            @Override
            public void onNext(List<Guest> guests) {
                view.setGuestsToAdapter(guests);
            }

            @Override
            public void onError(Throwable e) {
                view.showError("Невозможно отобразить список участников");
            }

            @Override
            public void onComplete() { }
        };
        listObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listObserver);
    }

    public void onGuestSelected(Guest guest) {
        view.loadInformation(guestsInteractor.loadProfile(guest));
    }

    public void onGuestVisitedChanged(Guest guest) {
        Single<Result> resultSingle = guestsInteractor.updateGuest(eventId, guest);
        SingleObserver<Result> resultSingleObserver = new SingleObserver<Result>() {
            @Override
            public void onSubscribe(Disposable d) { }

            @Override
            public void onSuccess(Result apiResult) { }

            @Override
            public void onError(Throwable e) {
                view.showError("Отсутствует соединение с сервером");
            }
        };
        resultSingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(resultSingleObserver);

    }
}
