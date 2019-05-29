package com.example.focusstartsecondpart.features.guests.presentation;

import com.example.focusstartsecondpart.features.BasePresenter;
import com.example.focusstartsecondpart.features.guests.domain.GuestsInteractor;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

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

    public void loadGuests(Observer<List<Guest>> listObserver, int id){
        guestsInteractor.loadGuests(listObserver, id);
    }

    public void onGuestSelected(Guest guest) {
        view.loadInformation(guestsInteractor.loadProfile(guest));
    }

    public void onGuestVisitedChanged(Guest guest) {
        Observable<Guest> guestObservable = Observable.fromArray(guest);
        guestsInteractor.updateGuest(guestObservable);
    }
}
