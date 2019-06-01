package com.example.focusstartsecondpart.features.guests.domain.model;

public class VerifiedMember {

    private int id;
    private boolean isVisited;
    private String visitedDate;

    public VerifiedMember(int id, boolean isVisited, String visitedDate){
        this.id = id;
        this.isVisited = isVisited;
        this.visitedDate = visitedDate;
    }

    public int getId() {
        return id;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public String getVisitedDate() {
        return visitedDate;
    }
}
