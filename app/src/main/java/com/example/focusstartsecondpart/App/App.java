package com.example.focusstartsecondpart.App;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.focusstartsecondpart.App.database.AppDataBase;


public class App extends Application {

    private static AppDataBase dataBase;
    private static Context context;

    public static AppDataBase getDataBase() {
        return dataBase;
    }

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dataBase = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "app-database").build();
        context = getApplicationContext();
    }
}
