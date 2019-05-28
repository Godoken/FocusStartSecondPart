package com.example.focusstartsecondpart.features.retrofit;

import com.example.focusstartsecondpart.features.events.domain.model.Event;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {

    @GET("api/v1/Events/registration?token=cftte@mtest20!9")
    Observable<List<Event>> getEventList();

    @GET("api/v1/Registration/members/event/106?token=cftte@mtest20!9")
    Observable<List<Guest>> getGuestList();


}