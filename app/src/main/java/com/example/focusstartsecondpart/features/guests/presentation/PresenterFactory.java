package com.example.focusstartsecondpart.features.guests.presentation;

import com.example.focusstartsecondpart.App.client.Api;
import com.example.focusstartsecondpart.App.client.Client;
import com.example.focusstartsecondpart.features.guests.data.GuestsDataSource;
import com.example.focusstartsecondpart.features.guests.data.GuestsDataSourceImpl;
import com.example.focusstartsecondpart.features.guests.data.GuestsRepositoryImpl;
import com.example.focusstartsecondpart.features.guests.data.network.GuestsLoader;
import com.example.focusstartsecondpart.features.guests.data.network.GuestsLoaderImpl;
import com.example.focusstartsecondpart.features.guests.domain.GuestsInteractor;
import com.example.focusstartsecondpart.features.guests.domain.GuestsInteractorImpl;
import com.example.focusstartsecondpart.features.guests.domain.GuestsRepository;

public class PresenterFactory {

    static GuestsActivityPresenter createPresenter(){

        final Api api = Client.getInstance().getApi();
        final GuestsLoader guestsLoader = new GuestsLoaderImpl(api);
        final GuestsDataSource guestsDataSource = new GuestsDataSourceImpl(guestsLoader);
        final GuestsRepository guestsRepository = new GuestsRepositoryImpl(guestsDataSource);
        final GuestsInteractor guestsInteractor = new GuestsInteractorImpl(guestsRepository);

        return new GuestsActivityPresenter(guestsInteractor);
    }
}
