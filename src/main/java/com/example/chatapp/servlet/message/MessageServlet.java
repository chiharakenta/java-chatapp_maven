package com.example.chatapp.servlet.message;

import java.io.IOException;
import java.util.List;

import com.example.chatapp.model.Message;
import com.example.chatapp.model.MessageDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
    private MessageDao messageDao = MessageDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Message> messages = messageDao.findAll();
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        String senderName = request.getParameter("senderName");
        messageDao.create(content, senderName);
        response.sendRedirect(request.getContextPath() + "/MessageServlet");
    }
}
