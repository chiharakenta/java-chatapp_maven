package com.example.chatapp.dto;

import java.util.List;

import com.example.chatapp.model.Message;
import com.example.chatapp.model.Reply;

public class MessageWithReply {
    private Message message;
    private List<Reply> replies;

    public MessageWithReply(Message message, List<Reply> replies) {
        this.message = message;
        this.replies = replies;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public int getId() {
        return this.message.getId();
    }

    public String getContent() {
        return this.message.getContent();
    }

    public String getSenderName() {
        return this.message.getSenderName();
    }
}
