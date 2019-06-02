package com.example.focusstartsecondpart.features.events.presentation;

import com.example.focusstartsecondpart.App.App;
import com.example.focusstartsecondpart.App.BasePresenter;
import com.example.focusstartsecondpart.R;
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
        view.loadEvents();
    }

    public void loadEvents(){
        Observable<List<Event>> listObservable = eventsInteractor.loadEvents().toObservable();
        Observer<List<Event>> listObserver  = new Observer<List<Event>>() {
            @Override
            public void onSubscribe(Disposable d) {view.showProgress(); }

            @Override
            public void onNext(List<Event> events) {
                if (events.size() != 0){
                    view.setEventsToAdapter(events);
                } else {
                    view.showError(App.getContext().getString(R.string.error_event_list_clear));
                }
            }

            @Override
            public void onError(Throwable e) {
                view.hideProgress();
                view.showError(App.getContext().getString(R.string.error_events_list_server));
            }

            @Override
            public void onComplete() {view.hideProgress(); }
        };
        listObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listObserver);
    }

    public void onEventSelected(Event event) {
        view.loadGuests(event.getId());
    }

    public void onBackPressed() {
        view.showProgress();
        view.openQuitDialog();
        view.hideProgress();
    }
}
