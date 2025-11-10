package com.example.chatapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Message implements Serializable{
    private int id;
    private String content;
    private String senderName;
    private List<ReplyMessage> replies;

    public Message(int id, String content, String senderName) {
        this.id = id;
        this.content = content;
        this.senderName = senderName;
        this.replies = new ArrayList<ReplyMessage>();
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

    public List<ReplyMessage> getReplies() {
        return replies;
    }

    public void reply(int id, String content, String senderName) {
        ReplyMessage reply = new ReplyMessage(id, content, senderName);
        this.replies.add(reply);
    }
}
