package com.example.chatapp.servlet.reply;

import java.io.IOException;

import com.example.chatapp.service.ReplyService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ReplyDeleteServlet")
public class ReplyDeleteServlet extends HttpServlet {
    private ReplyService replyService = ReplyService.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        replyService.delete(id);
        response.sendRedirect(request.getContextPath() + "/MessageServlet");
    }
}
