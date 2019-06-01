package com.example.focusstartsecondpart.features.events.presentation;

import com.example.focusstartsecondpart.App.BasePresenter;
import com.example.focusstartsecondpart.features.events.domain.EventsInteractor;
import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


public class EventsActivityPresenter extends BasePresenter<EventsListView> {

    private EventsInteractor eventsInteractor;

    public EventsActivityPresenter(EventsInteractor eventsInteractor){
        this.eventsInteractor = eventsInteractor;
    }

    @Override
    public void onViewReady(){
        view.showProgress();
        view.loadEvents();
        view.hideProgress();
    }

    public void loadEvents(){
        Observable<List<Event>> listObservable = eventsInteractor.loadEvents().toObservable();

        Observer<List<Event>> listObserver  = new Observer<List<Event>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(List<Event> events) {
                view.setEventsToAdapter(events);
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

    public void onEventSelected(Event event) {
        view.loadGuests(event.getId());
    }
}
