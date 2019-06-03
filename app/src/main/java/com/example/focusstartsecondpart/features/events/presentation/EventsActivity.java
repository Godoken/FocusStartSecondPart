package com.example.focusstartsecondpart.features.events.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.focusstartsecondpart.App.BaseActivity;
import com.example.focusstartsecondpart.App.BasePresenter;
import com.example.focusstartsecondpart.App.InterfaceView;
import com.example.focusstartsecondpart.R;
import com.example.focusstartsecondpart.features.events.domain.model.Event;
import com.example.focusstartsecondpart.features.guests.presentation.GuestsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsActivity extends BaseActivity implements EventsListView {

    @BindView(R.id.events_progress)
    ProgressBar progressBar;

    @BindView(R.id.events_recycle_view)
    RecyclerView recyclerView;

    private EventsAdapter eventsAdapter;

    private EventsActivityPresenter eventsActivityPresenter;

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
        ButterKnife.bind(this);
        eventsAdapter = new EventsAdapter(this, event -> eventsActivityPresenter.onEventSelected(event));
        recyclerView.setAdapter(eventsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
    public void setEventsToAdapter(List<Event> eventList) {
        eventsAdapter.setEvents(eventList);
    }

    @Override
    public void loadEvents() {
        eventsActivityPresenter.loadEvents();
    }

    @Override
    public void loadGuests(int id) {
        Intent intent = new Intent(this, GuestsActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        eventsActivityPresenter.onBackPressed();
    }

    @Override
    public void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                this);
        quitDialog.setTitle(R.string.on_back_pressed);

        quitDialog.setPositiveButton(R.string.yes, (dialog, which) -> finish());

        quitDialog.setNegativeButton(R.string.no, (dialog, which) -> {
        });
        quitDialog.show();
    }
}
