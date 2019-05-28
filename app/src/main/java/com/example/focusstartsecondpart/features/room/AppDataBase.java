package com.example.focusstartsecondpart.features.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.focusstartsecondpart.features.events.domain.model.Event;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

@Database(entities = {Event.class, Guest.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract DatabaseDao getDatabaseDao();
}
