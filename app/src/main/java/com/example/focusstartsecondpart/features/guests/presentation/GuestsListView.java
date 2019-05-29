package com.example.focusstartsecondpart.features.guests.presentation;

import com.example.focusstartsecondpart.features.InterfaceView;

import java.util.ArrayList;

public interface GuestsListView extends InterfaceView {

    void showProgress();

    void hideProgress();

    void showError(String message);

    void loadInformation(ArrayList<String> stringArrayList);

    void loadGuests();
}
