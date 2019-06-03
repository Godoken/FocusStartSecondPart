package com.example.focusstartsecondpart.features.profiles.presentation

import com.example.focusstartsecondpart.App.BasePresenter

class ProfileActivityPresenter(private val profile: ArrayList<String>) : BasePresenter<ProfileView>() {

    public override fun onViewReady() {
        view.showProgress()
        view.showProfile(profile[0], profile[1], profile[2])
        view.hideProgress()
    }
}
