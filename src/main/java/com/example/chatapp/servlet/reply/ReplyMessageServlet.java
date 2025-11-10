package com.example.chatapp.servlet.reply;

import java.io.IOException;

import com.example.chatapp.model.Message;
import com.example.chatapp.model.MessageDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ReplyMessageServlet")
public class ReplyMessageServlet extends HttpServlet {
    private MessageDao messageDao = MessageDao.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int messageId = Integer.parseInt(request.getParameter("messageId"));
        String content = request.getParameter("content");
        String senderName = request.getParameter("senderName");
        Message message = messageDao.findById(messageId);
        if (message != null) {
            messageDao.reply(content, senderName, messageId);
        }
        response.sendRedirect(request.getContextPath() + "/MessageServlet");
    }
}
