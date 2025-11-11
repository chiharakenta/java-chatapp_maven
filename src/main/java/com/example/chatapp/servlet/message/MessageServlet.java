package com.example.chatapp.servlet.message;

import java.io.IOException;
import java.util.List;

import com.example.chatapp.dto.MessageWithReply;
import com.example.chatapp.service.MessageService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
    private MessageService messageService = MessageService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MessageWithReply> messages = messageService.findAllWithReply();
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        String senderName = request.getParameter("senderName");
        messageService.create(content, senderName);
        response.sendRedirect(request.getContextPath() + "/MessageServlet");
    }
}
