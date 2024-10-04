package edu.psu.swen888.listviewpractice;

import java.io.Serializable;

public class Event implements Serializable {
    private String title;
    private String type;
    private int numberOfTeams;
    private String currentRecord;
    private String currentRecordHolder;
    private int currentRecordYear;

    public Event(String title, String type, int numberOfTeams, String currentRecord, String currentRecordHolder, int currentRecordYear){
        this.title = title;
        this.type = type;
        this.numberOfTeams = numberOfTeams;
        this.currentRecord = currentRecord;
        this.currentRecordHolder = currentRecordHolder;
        this.currentRecordYear = currentRecordYear;
    }

    //getter methods for the event details

    public String getTitle(){
        return title;
    }
    public String getType(){
        return type;
    }
    public int getNumberOfTeams(){
        return numberOfTeams;
    }
    public String getCurrentRecord(){return currentRecord;}
    public String getCurrentRecordHolder(){return currentRecordHolder;}
    public int getCurrentRecordYear(){return currentRecordYear;}
}
