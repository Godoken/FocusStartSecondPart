package com.example.focusstartsecondpart.features.guests.presentation;

import com.example.focusstartsecondpart.App.InterfaceView;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.ArrayList;
import java.util.List;

public interface GuestsListView extends InterfaceView {

    void showProgress();

    void hideProgress();

    void showError(String message);

    void loadInformation(ArrayList<String> stringArrayList);

    void loadGuests();

    void setGuestsToAdapter(List<Guest> guestList);
}
