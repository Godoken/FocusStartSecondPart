package com.example.focusstartsecondpart.App.client;

import com.example.focusstartsecondpart.features.events.domain.model.Event;
import com.example.focusstartsecondpart.features.guests.domain.model.Guest;
import com.example.focusstartsecondpart.features.guests.domain.model.Result;
import com.example.focusstartsecondpart.features.guests.domain.model.VerifiedMember;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("api/v1/Events/registration")
    Single<List<Event>> getEventList(@Query("token") String token);

    @GET("api/v1/Registration/members/event/{eventId}")
    Single<List<Guest>> getGuestList(@Path("eventId") int id, @Query("token") String token);

    @POST("api/v1/Registration/members/event/{eventId}/confirmation")
    Single<Result> updateGuest(@Path("eventId") int id, @Query("token") String token, @Body List<VerifiedMember> listVerifiedMember);
}