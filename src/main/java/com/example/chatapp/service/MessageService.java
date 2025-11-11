package com.example.chatapp.service;

import java.util.List;
import java.util.ArrayList;

import com.example.chatapp.dao.MessageDao;
import com.example.chatapp.dao.ReplyDao;
import com.example.chatapp.dto.MessageWithReply;
import com.example.chatapp.model.Message;
import com.example.chatapp.model.Reply;

public class MessageService {
    private MessageDao messageDao = MessageDao.getInstance();
    private ReplyDao replyDao = ReplyDao.getInstance();
    private static MessageService instance;

    /* シングルトン化 */
    private MessageService() {}
    public static MessageService getInstance() {
        if (instance == null) {
            instance = new MessageService();
        }
        return instance;
    }
    /* シングルトンここまで */

    public List<MessageWithReply> findAllWithReply() {
        List<Message> messages = messageDao.findAll();
        List<MessageWithReply> messagesWithReply = new ArrayList<>();
        for (Message message : messages) {
            List<Reply> replies = replyDao.findByMessageId(message.getId());
            messagesWithReply.add(new MessageWithReply(message, replies));
        }
        return messagesWithReply;
    }
    
    public void create(String content, String senderName) {
        messageDao.create(content, senderName);
    }

    public Message findById(int id) {
        Message message = messageDao.findById(id);
        return message;
    }

    public void update(int id, String content, String senderName) {
        messageDao.update(id, content, senderName);
    }
    
    public void delete(int id) {
        replyDao.deleteByMessageId(id);
        messageDao.delete(id);
    }
    /* データ操作ここまで */
}
