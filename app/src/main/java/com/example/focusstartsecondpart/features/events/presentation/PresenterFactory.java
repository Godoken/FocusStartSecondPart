package com.example.focusstartsecondpart.features.events.presentation;

import com.example.focusstartsecondpart.App.client.Api;
import com.example.focusstartsecondpart.App.client.Client;
import com.example.focusstartsecondpart.features.events.data.EventsDataSource;
import com.example.focusstartsecondpart.features.events.data.EventsDataSourceImpl;
import com.example.focusstartsecondpart.features.events.data.EventsRepositoryImpl;
import com.example.focusstartsecondpart.features.events.data.network.EventsLoader;
import com.example.focusstartsecondpart.features.events.data.network.EventsLoaderImpl;
import com.example.focusstartsecondpart.features.events.domain.EventsInteractor;
import com.example.focusstartsecondpart.features.events.domain.EventsInteractorImpl;
import com.example.focusstartsecondpart.features.events.domain.EventsRepository;

public class PresenterFactory {

    static EventsActivityPresenter createPresenter(){

        final Api api = Client.getInstance().getApi();
        final EventsLoader eventsLoader = new EventsLoaderImpl(api);
        final EventsDataSource eventsDataSource = new EventsDataSourceImpl(eventsLoader);
        final EventsRepository eventsRepository = new EventsRepositoryImpl(eventsDataSource);
        final EventsInteractor eventsInteractor = new EventsInteractorImpl(eventsRepository);

        return new EventsActivityPresenter(eventsInteractor);
    }

}
