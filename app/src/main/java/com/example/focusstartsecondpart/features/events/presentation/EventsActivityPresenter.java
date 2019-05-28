package com.example.focusstartsecondpart.features.events.presentation;

import com.example.focusstartsecondpart.features.BasePresenter;
import com.example.focusstartsecondpart.features.events.domain.EventsInteractor;
import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Observer;


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

    public void loadEvents(Observer<List<Event>> listObserver){
        //view.showProgress();
        eventsInteractor.loadEvents(listObserver);
        //view.hideProgress();
    }

    public void onEventSelected(Event event) {

    }
}
