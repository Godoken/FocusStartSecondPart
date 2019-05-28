package com.example.focusstartsecondpart.support;

public interface Carry<T> {

    void onSuccess(T result);

    void onFailure(Throwable throwable);

}
