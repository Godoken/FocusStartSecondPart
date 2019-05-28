package com.example.focusstartsecondpart.features.events.presentation;

import com.example.focusstartsecondpart.features.InterfaceView;

public interface EventsListView extends InterfaceView {

    void showProgress();

    void hideProgress();

    void showError(String message);

    void loadEvents();
}
