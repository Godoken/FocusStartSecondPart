package com.example.focusstartsecondpart.features;

public abstract class BasePresenter<View extends InterfaceView> {

    protected View view;

    public void attachView(View view){
        this.view = view;
        onViewReady();
    }

    public void detachView(){
        this.view = null;
    }

    protected void onViewReady(){

    }
}
