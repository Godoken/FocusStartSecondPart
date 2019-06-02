package com.example.focusstartsecondpart.features.guests.presentation;

import com.example.focusstartsecondpart.App.App;
import com.example.focusstartsecondpart.App.BasePresenter;
import com.example.focusstartsecondpart.R;
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

public class GuestsActivityPresenter extends BasePresenter<GuestsListView> {

    private GuestsInteractor guestsInteractor;
    private int eventId;

    public GuestsActivityPresenter(GuestsInteractor guestsInteractor){
        this.guestsInteractor = guestsInteractor;
    }

    @Override
    public void onViewReady(){
        view.loadGuests();
    }

    @Override
    public void detachView(){

    }

    public void loadGuests(int id){
        eventId = id;
        Observable<List<Guest>> listObservable  = guestsInteractor.loadGuests(id).toObservable();
        Observer<List<Guest>> listObserver = new Observer<List<Guest>>() {
            @Override
            public void onSubscribe(Disposable d) {view.showProgress(); }

            @Override
            public void onNext(List<Guest> guests) {
                if (guests.size() != 0){
                    view.setGuestsToAdapter(guests);
                } else {
                    view.showError(App.getContext().getString(R.string.error_guests_clear));
                }
            }

            @Override
            public void onError(Throwable e) {
                view.hideProgress();
                view.showError(App.getContext().getString(R.string.error_guest_list_server));
            }

            @Override
            public void onComplete() { view.hideProgress();}
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
            public void onSubscribe(Disposable d) { view.showProgress();}

            @Override
            public void onSuccess(Result apiResult) { view.hideProgress();}

            @Override
            public void onError(Throwable e) {
                view.hideProgress();
                view.showError(App.getContext().getString(R.string.error_guest_server));
            }
        };
        resultSingle
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(resultSingleObserver);
    }
}
