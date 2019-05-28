package com.example.focusstartsecondpart.features.events.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface DatabaseDao {

    @Query("SELECT * FROM event")
    Observable<List<Event>> getAllEvents();

    @Insert
    void insertAll(List<Event> eventList);
}
