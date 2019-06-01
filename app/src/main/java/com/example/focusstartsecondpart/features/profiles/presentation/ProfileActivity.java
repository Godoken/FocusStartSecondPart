package com.example.focusstartsecondpart.features.profiles.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.focusstartsecondpart.App.BaseActivity;
import com.example.focusstartsecondpart.App.BasePresenter;
import com.example.focusstartsecondpart.App.InterfaceView;
import com.example.focusstartsecondpart.R;

import java.util.ArrayList;

public class ProfileActivity extends BaseActivity implements ProfileView {

    ProfileActivityPresenter profileActivityPresenter;

    private ProgressBar progressBar;

    private TextView firstNameTextView;
    private TextView lastNameTextView;
    private TextView phoneNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initView();
    }

    @Override
    protected  BasePresenter<ProfileView> getPresenter() {
        profileActivityPresenter = PresenterFactory.createPresenter();
        return profileActivityPresenter;
    }

    @Override
    protected InterfaceView getInterfaceView() {
        return this;
    }


    private void initView() {
        progressBar = findViewById(R.id.profile_progress);

        firstNameTextView = findViewById(R.id.firstName);
        lastNameTextView = findViewById(R.id.lastName);
        phoneNumberTextView = findViewById(R.id.phone);
    }

    @Override
    public void showProfile() {
        ArrayList<String> stringArrayList = getIntent().getStringArrayListExtra("profile");

        firstNameTextView.setText(stringArrayList.get(0));
        lastNameTextView.setText(stringArrayList.get(1));
        phoneNumberTextView.setText(stringArrayList.get(2));
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        firstNameTextView.setVisibility(View.GONE);
        lastNameTextView.setVisibility(View.GONE);
        phoneNumberTextView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        firstNameTextView.setVisibility(View.VISIBLE);
        lastNameTextView.setVisibility(View.VISIBLE);
        phoneNumberTextView.setVisibility(View.VISIBLE);
    }
}
