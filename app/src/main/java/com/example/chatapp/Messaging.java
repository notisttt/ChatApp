package com.example.chatapp;

public class Messaging {

    private String UserEmail;
    private String message;
    private String DateTime;


    public Messaging(){

    }

    public Messaging(String userEmail, String message, String dateTime) {
        UserEmail = userEmail;
        this.message = message;
        DateTime = dateTime;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }
}
