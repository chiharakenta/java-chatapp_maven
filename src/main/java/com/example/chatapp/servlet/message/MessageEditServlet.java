package com.example.chatapp.servlet.message;

import java.io.IOException;

import com.example.chatapp.model.Message;
import com.example.chatapp.service.MessageService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MessageEditServlet")
public class MessageEditServlet extends HttpServlet {
    private MessageService messageService = MessageService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Message message = messageService.findById(id);
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/views/messages/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String content = request.getParameter("content");
        String senderName = request.getParameter("senderName");
        messageService.update(id, content, senderName);
        response.sendRedirect(request.getContextPath() + "/MessageServlet");
    }
}
