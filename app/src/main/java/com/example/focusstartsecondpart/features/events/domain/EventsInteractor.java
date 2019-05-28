package com.example.focusstartsecondpart.features.events.domain;

import com.example.focusstartsecondpart.features.events.domain.model.Event;
import com.example.focusstartsecondpart.support.Carry;

import java.util.List;

import io.reactivex.Observer;

public interface EventsInteractor {

    void loadEvents(Observer<List<Event>> listObserver);
}
