package com.example.chatapp.service;

import com.example.chatapp.dao.ReplyDao;
import com.example.chatapp.model.Reply;

public class ReplyService {
    
    /* フィールド */
    private ReplyDao replyDao = ReplyDao.getInstance();
    private static ReplyService instance;
    /* フィールドここまで */


    /* シングルトン化 */
    private ReplyService() {}
    public static ReplyService getInstance() {
        if (instance == null) {
            instance = new ReplyService();
        }
        return instance;
    }
    /* シングルトンここまで */


    /* データ操作 */
    public void create(int messageId, String content, String senderName) {
        replyDao.create(messageId, content, senderName);
    }
    public Reply findById(int id) {
        return replyDao.findById(id);
    }
    public void update(int id, String content, String senderName) {
        replyDao.update(id, content, senderName);
    }
    /* データ操作ここまで */
}
