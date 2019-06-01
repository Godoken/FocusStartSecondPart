package com.example.focusstartsecondpart.App;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract <T extends InterfaceView> BasePresenter<T> getPresenter();
    protected abstract <T extends InterfaceView> T getInterfaceView();

    private BasePresenter<InterfaceView> basePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basePresenter = getPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        basePresenter.attachView(getInterfaceView());
    }

    @Override
    protected void onStop() {
        super.onStop();
        basePresenter.detachView();
    }
}
