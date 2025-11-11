package com.example.chatapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.chatapp.model.Reply;
import com.example.chatapp.util.DataStore;

public class ReplyDao {
    private static final String DB_PATH = "db/replies.json";
    private static ReplyDao instance;
    private int nextId = 1;
    private List<Reply> replies;

    private ReplyDao() {
        this.replies = new ArrayList<Reply>();
    };

    public static ReplyDao getInstance() {
        if (instance == null) {
            instance = DataStore.load(DB_PATH, ReplyDao.class);
        }
        if (instance == null) {
            instance = new ReplyDao();
        }
        return instance;
    }

    public List<Reply> findAll() {
        return this.replies;
    }

    public List<Reply> findByMessageId(int messageId) {
        return this.replies.stream()
                .filter(reply -> reply.getMessageId() == messageId)
                .toList();
    }

    public Reply findById(int id) {
        return this.replies.stream()
                .filter(reply -> reply.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void create(int messageId, String content, String senderName) {
        Reply reply = new Reply(this.nextId, messageId, content, senderName);
        this.replies.add(reply);
        this.nextId++;
        DataStore.save(DB_PATH, this);
    }

    public void deleteByMessageId(int messageId) {
        this.replies.removeIf(reply -> reply.getMessageId() == messageId);
        DataStore.save(DB_PATH, this);
    }

    public void update(int id, String content, String senderName) {
        Reply reply = findById(id);
        if (reply != null) {
            reply.setContent(content);
            reply.setSenderName(senderName);
            DataStore.save(DB_PATH, this);
        }
    }
}
