package com.example.focusstartsecondpart.features.guests.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.focusstartsecondpart.App.BaseActivity;
import com.example.focusstartsecondpart.App.BasePresenter;
import com.example.focusstartsecondpart.App.InterfaceView;
import com.example.focusstartsecondpart.R;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;
import com.example.focusstartsecondpart.features.profiles.presentation.ProfileActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuestsActivity extends BaseActivity implements GuestsListView {

    @BindView(R.id.guests_progress)
    ProgressBar progressBar;

    @BindView(R.id.guests_recycle_view)
    RecyclerView recyclerView;

    private GuestsAdapter guestsAdapter;
    private GuestsActivityPresenter guestsActivityPresenter;

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
        ButterKnife.bind(this);

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
        guestsActivityPresenter.loadGuests(id);
    }

    @Override
    public void setGuestsToAdapter(List<Guest> guestList) {
        guestsAdapter.setGuests(guestList);
    }

    @Override
    public void loadInformation(ArrayList<String> stringArrayList) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("profile", stringArrayList);
        startActivity(intent);
    }
}
