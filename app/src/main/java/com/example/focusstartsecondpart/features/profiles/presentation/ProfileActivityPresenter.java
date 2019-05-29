package com.example.focusstartsecondpart.features.profiles.presentation;

import com.example.focusstartsecondpart.features.BasePresenter;

public class ProfileActivityPresenter extends BasePresenter<ProfileView> {

    public ProfileActivityPresenter(){

    }

    @Override
    public void onViewReady(){
        view.showProgress();
        view.showProfile();
        view.hideProgress();
    }
}
