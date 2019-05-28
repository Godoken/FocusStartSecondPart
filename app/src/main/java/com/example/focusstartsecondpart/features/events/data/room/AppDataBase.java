package com.example.focusstartsecondpart.features.events.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.focusstartsecondpart.features.events.domain.model.Event;

@Database(entities = {Event.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract DatabaseDao getDatabaseDao();
}
