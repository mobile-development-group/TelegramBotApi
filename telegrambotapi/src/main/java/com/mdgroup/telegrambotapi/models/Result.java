package com.mdgroup.telegrambotapi.models;

public class Result {

    private int message_id;

    private Chat chat;

    private double date;

    private Photo[] photo;

    private String text;

    private String caption;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }

    public Photo[] getPhoto() {
        return photo;
    }

    public void setPhoto(Photo[] photo) {
        this.photo = photo;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}