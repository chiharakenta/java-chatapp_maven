package com.example.chatapp.servlet.message;

import java.io.IOException;
import com.example.chatapp.model.Message;
import com.example.chatapp.model.MessageDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MessageEditServlet")
public class MessageEditServlet extends HttpServlet {
    private MessageDao messageDao = MessageDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int messageId = Integer.parseInt(request.getParameter("id"));
        Message message = messageDao.findById(messageId);
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int messageId = Integer.parseInt(request.getParameter("id"));
        String content = request.getParameter("content");
        String senderName = request.getParameter("senderName");
        messageDao.update(messageId, content, senderName);
        response.sendRedirect(request.getContextPath() + "/MessageServlet");
    }
}
