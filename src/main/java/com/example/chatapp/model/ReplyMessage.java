package com.example.chatapp.model;

import java.io.Serializable;

public class ReplyMessage implements Serializable {
    private int id;
    private String content;
    private String senderName;

    public ReplyMessage(int id, String content, String senderName) {
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
}
