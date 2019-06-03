package com.example.focusstartsecondpart.features.profiles.presentation;

import java.util.ArrayList;

public class PresenterFactory {

    static ProfileActivityPresenter createPresenter(ArrayList<String> profile){
        return new ProfileActivityPresenter(profile);
    }
}
