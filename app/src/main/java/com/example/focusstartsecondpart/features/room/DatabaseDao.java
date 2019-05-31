package com.example.focusstartsecondpart.features.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Update;

import com.example.focusstartsecondpart.features.events.domain.model.Event;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface DatabaseDao {

    @Query("SELECT * FROM event")
    Single<List<Event>> getAllEvents();

    @Update
    void updateAllEvents(List<Event> eventList);

    @Delete
    void deleteAllEvents(List<Event> events);

    @Query("SELECT * FROM guest")
    Single<List<Guest>> getAllGuests();

    @Update
    void updateAllGuests(List<Guest> guestList);

    @Delete
    void deleteAllGuests(List<Guest> guests);

    @Update
    void updateGuest(Guest guest);
}
