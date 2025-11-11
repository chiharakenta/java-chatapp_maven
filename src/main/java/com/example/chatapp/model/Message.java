package com.example.chatapp.model;

import java.io.Serializable;

public class Message implements Serializable{
    private int id;
    private String content;
    private String senderName;

    public Message(int id, String content, String senderName) {
        this.id = id;
        this.content = content;
        this.senderName = senderName;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
}
