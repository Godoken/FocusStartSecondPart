package com.example.focusstartsecondpart.features.profiles.presentation;

import com.example.focusstartsecondpart.App.InterfaceView;

public interface ProfileView extends InterfaceView {
    void showProfile(String firstName, String lastName, String phoneNumber);
    void showProgress();
    void hideProgress();
}
