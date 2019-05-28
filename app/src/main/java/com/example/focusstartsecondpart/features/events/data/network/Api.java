package com.example.focusstartsecondpart.features.events.data.network;

import com.example.focusstartsecondpart.features.events.domain.model.Event;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {

    @GET("api/v1/Events/registration?token=cftte@mtest20!9")
    Observable<List<Event>> getEventList();
    //
}
