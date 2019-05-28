package com.example.focusstartsecondpart.features.events.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.focusstartsecondpart.R;
import com.example.focusstartsecondpart.features.BaseActivity;
import com.example.focusstartsecondpart.features.BasePresenter;
import com.example.focusstartsecondpart.features.InterfaceView;
import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class EventsActivity extends BaseActivity implements EventsListView {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private EventsAdapter eventsAdapter;

    private EventsActivityPresenter eventsActivityPresenter;
    private Observer<List<Event>> listObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    @Override
    protected BasePresenter<EventsListView> getPresenter() {
        eventsActivityPresenter = PresenterFactory.createPresenter();
        return eventsActivityPresenter;
    }

    @Override
    protected InterfaceView getInterfaceView() {
        return this;
    }

    private void initView() {

        progressBar = findViewById(R.id.events_progress);
        recyclerView = findViewById(R.id.events_recycle_view);

        eventsAdapter = new EventsAdapter(this, new EventsAdapter.SelectEventListener() {
            @Override
            public void onEventSelect(Event event) {
                eventsActivityPresenter.onEventSelected(event);
            }
        });

        listObserver  = new Observer<List<Event>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Event> events) {
                eventsAdapter.setEvents(events);
            }

            @Override
            public void onError(Throwable e) {
                showError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loadEvents() {
        eventsActivityPresenter.loadEvents(listObserver);
    }
}
