package com.example.focusstartsecondpart.features.guests.domain.model;

public class Result {

    private boolean result;
    private String message;

    public Result(boolean result, String message){
        this.result = result;
        this.message = message;
    }

    public void setResult(boolean result){
        this.result = result;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public boolean isResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
