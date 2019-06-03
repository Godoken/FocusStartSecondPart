package com.example.focusstartsecondpart.features.profiles.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.focusstartsecondpart.App.BaseActivity;
import com.example.focusstartsecondpart.App.BasePresenter;
import com.example.focusstartsecondpart.App.InterfaceView;
import com.example.focusstartsecondpart.R;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class ProfileActivity extends BaseActivity implements ProfileView {

    ProfileActivityPresenter profileActivityPresenter;

    @BindView(R.id.profile_progress)
    ProgressBar progressBar;

    @BindViews({R.id.firstName, R.id.lastName, R.id.phone,
    R.id.hintName, R.id.hintLastName, R.id.hintPhone})
    List<View> listView;

    @BindView(R.id.firstName)
    TextView firstNameTextView;

    @BindView(R.id.lastName)
    TextView lastNameTextView;

    @BindView(R.id.phone)
    TextView phoneNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();
    }

    @Override
    protected  BasePresenter<ProfileView> getPresenter() {
        profileActivityPresenter = PresenterFactory.createPresenter(getIntent().getStringArrayListExtra("profile"));
        return profileActivityPresenter;
    }

    @Override
    protected InterfaceView getInterfaceView() {
        return this;
    }

    private void initView() {
        ButterKnife.bind(this);
    }

    @Override
    public void showProfile(String firstName, String lastName, String phoneNumber) {
        firstNameTextView.setText(firstName);
        lastNameTextView.setText(lastName);
        phoneNumberTextView.setText(phoneNumber);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.forEach(view -> view.setVisibility(View.GONE));
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        listView.forEach(view -> view.setVisibility(View.VISIBLE));
    }
}
