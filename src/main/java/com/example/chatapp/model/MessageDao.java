package com.example.chatapp.model;

import java.util.ArrayList;
import java.util.List;

import com.example.chatapp.util.DataStore;

public class MessageDao {
    private static final String DB_PATH = "db/messages.json";
    private static MessageDao instance;
    private int nextId = 1;
    private int nextReplyId = 1;
    private List<Message> messages;

    private MessageDao() {};

    public static MessageDao getInstance() {
        if (instance == null) {
            instance = DataStore.load(DB_PATH, MessageDao.class);
        }
        if (instance == null) {
            instance = new MessageDao();
            instance.messages = new ArrayList<Message>();
        }
        return instance;
    }

    public List<Message> findAll() {
        return this.messages;
    }

    public Message findById(int id) {
        return this.messages.stream()
            .filter(message -> message.getId() == id)
            .findFirst()
            .orElse(null);
    }

    public void create(String content, String senderName) {
        Message message = new Message(this.nextId, content, senderName);
        this.messages.add(message);
        this.nextId++;
        DataStore.save(DB_PATH, this);
    }

    public void update(int id, String content, String senderName) {
        Message message = this.findById(id);
        if (message != null) {
            message.setContent(content);
            message.setSenderName(senderName);
            DataStore.save(DB_PATH, this);
        }
    }

    public void delete(int id) {
        this.messages.removeIf(message -> message.getId() == id);
        DataStore.save(DB_PATH, this);
    }

    public void reply(String content, String senderName, int messageId) {
        Message message = this.findById(messageId);
        if (message != null) {
            message.reply(this.nextReplyId, content, senderName);
            this.nextReplyId++;
            DataStore.save(DB_PATH, this);
        }
    }
}
