package com.example.chatapp.servlet.reply;

import java.io.IOException;

import com.example.chatapp.service.ReplyService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ReplyMessageServlet")
public class ReplyMessageServlet extends HttpServlet {
    private ReplyService replyService = ReplyService.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 入力の受取
        int messageId = Integer.parseInt(request.getParameter("messageId"));
        String content = request.getParameter("content");
        String senderName = request.getParameter("senderName");

        // 返信を作成
        replyService.create(messageId, content, senderName);

        // メッセージ一覧にリダイレクト
        response.sendRedirect(request.getContextPath() + "/MessageServlet");
    }
}
