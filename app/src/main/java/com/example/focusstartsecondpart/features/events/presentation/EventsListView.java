package com.example.focusstartsecondpart.features.events.presentation;

import com.example.focusstartsecondpart.App.InterfaceView;
import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

public interface EventsListView extends InterfaceView {

    void showProgress();

    void hideProgress();

    void showError(String message);

    void loadEvents();

    void loadGuests(int id);

    void setEventsToAdapter(List<Event> eventList);
}
