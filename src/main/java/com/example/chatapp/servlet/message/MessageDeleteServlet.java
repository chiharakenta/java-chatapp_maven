package com.example.chatapp.servlet.message;

import java.io.IOException;

import com.example.chatapp.service.MessageService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MessageDeleteServlet")
public class MessageDeleteServlet extends HttpServlet {
    private MessageService messageService = MessageService.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        messageService.delete(id);
        response.sendRedirect(request.getContextPath() + "/MessageServlet");
    }
}
