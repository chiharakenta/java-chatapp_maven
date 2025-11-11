package com.example.chatapp.model;

import java.io.Serializable;

public class Reply implements Serializable {
    private int id;
    private int messageId;
    private String content;
    private String senderName;

    public Reply(int id, int messageId, String content, String senderName) {
        this.id = id;
        this.messageId = messageId;
        this.content = content;
        this.senderName = senderName;
    }

    public int getId() {
        return id;
    }

    public int getMessageId() {
        return messageId;
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
