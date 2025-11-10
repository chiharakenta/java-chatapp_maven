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

    @Override
    public String toString() {
        return this.id + ": " + this.content + "\n (by " + this.senderName + ")";
    }
}
