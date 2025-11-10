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

@WebServlet("/MessageDeleteServlet")
public class MessageDeleteServlet extends HttpServlet {
    private MessageDao messageDao = MessageDao.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        messageDao.delete(id);
        response.sendRedirect(request.getContextPath() + "/MessageServlet");
    }
}
