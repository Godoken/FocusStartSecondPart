package com.example.focusstartsecondpart.features.retrofit;

import com.example.focusstartsecondpart.features.events.domain.model.Event;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("api/v1/Events/registration")
    Single<List<Event>> getEventList(@Query("token") String token);

    @GET("api/v1/Registration/members/event/{eventId}")
    Single<List<Guest>> getGuestList(@Path("eventId") int id, @Query("token") String token);


}