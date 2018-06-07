package com.android.teaching.chatapp.models;

public class MessageModel {

    private String username;
    private String text;

    public MessageModel(String username, String text) {
        this.username = username;
        this.text = text;
    }

    public MessageModel() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
