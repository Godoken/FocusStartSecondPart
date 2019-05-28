package com.example.focusstartsecondpart.features.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.focusstartsecondpart.features.events.domain.model.Event;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface DatabaseDao {

    @Query("SELECT * FROM event")
    Observable<List<Event>> getAllEvents();

    @Insert
    void insertAllEvents(List<Event> eventList);

    @Query("SELECT * FROM guest")
    Observable<List<Guest>> getAllGuests();

    @Insert
    void insertAllGuests(List<Event> eventList);
}
