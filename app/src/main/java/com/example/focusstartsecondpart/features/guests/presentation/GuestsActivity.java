package com.example.focusstartsecondpart.features.guests.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.focusstartsecondpart.R;
import com.example.focusstartsecondpart.features.BaseActivity;
import com.example.focusstartsecondpart.features.BasePresenter;
import com.example.focusstartsecondpart.features.InterfaceView;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class GuestsActivity extends BaseActivity implements GuestsListView {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private GuestsAdapter guestsAdapter;

    private GuestsActivityPresenter guestsActivityPresenter;
    private Observer<List<Guest>> listObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guests);

        initView();
    }

    @Override
    protected BasePresenter<GuestsListView> getPresenter() {
        guestsActivityPresenter = PresenterFactory.createPresenter();
        return guestsActivityPresenter;
    }

    @Override
    protected InterfaceView getInterfaceView() {
        return this;
    }

    private void initView() {

        progressBar = findViewById(R.id.guests_progress);
        recyclerView = findViewById(R.id.guests_recycle_view);

        guestsAdapter = new GuestsAdapter(this, new GuestsAdapter.SelectGuestListener() {
            @Override
            public void onGuestSelect(Guest guest) {
                guestsActivityPresenter.onGuestSelected(guest);
            }

            @Override
            public void onCheckedChange(Guest guest) {
                guestsActivityPresenter.onGuestVisitedChanged(guest);
            }
        });

        recyclerView.setAdapter(guestsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listObserver  = new Observer<List<Guest>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Guest> guests) {
                guestsAdapter.setGuests(guests);
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
    public void loadGuests() {
        int id = getIntent().getIntExtra("id", 0);
        guestsActivityPresenter.loadGuests(listObserver, id);
    }

    @Override
    public void loadInformation() {

    }
}
