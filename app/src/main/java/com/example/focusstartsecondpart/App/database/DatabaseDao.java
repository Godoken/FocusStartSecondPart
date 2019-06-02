package com.example.focusstartsecondpart.App.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllEvents(List<Event> eventList);

    @Query("SELECT * FROM guest WHERE eventId = :eventId")
    Single<List<Guest>> getAllGuestsByEventId(int eventId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllGuests(List<Guest> guestList);

    @Update
    void updateGuest(Guest guest);
}
