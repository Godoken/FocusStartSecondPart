package com.example.focusstartsecondpart.features.profiles.presentation

import com.example.focusstartsecondpart.App.BasePresenter

class ProfileActivityPresenter : BasePresenter<ProfileView>() {

    public override fun onViewReady() {
        view.showProgress()
        view.showProfile()
        view.hideProgress()
    }
}
