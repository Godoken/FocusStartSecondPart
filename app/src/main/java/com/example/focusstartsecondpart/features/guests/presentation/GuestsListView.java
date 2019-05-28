package com.example.focusstartsecondpart.features.guests.presentation;

import com.example.focusstartsecondpart.features.InterfaceView;

public interface GuestsListView extends InterfaceView {

    void showProgress();

    void hideProgress();

    void showError(String message);

    void loadInformation();

    void loadGuests();
}
