package com.example.chatapp.servlet.reply;

import java.io.IOException;

import com.example.chatapp.model.Reply;
import com.example.chatapp.service.ReplyService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ReplyEditServlet")
public class ReplyEditServlet extends HttpServlet {
    private ReplyService replyService = ReplyService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Reply reply = replyService.findById(id);
        request.setAttribute("reply", reply);
        request.getRequestDispatcher("/WEB-INF/views/replies/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String content = request.getParameter("content");
        String senderName = request.getParameter("senderName");
        replyService.update(id, content, senderName);
        
        // メッセージ一覧へリダイレクト
        response.sendRedirect(request.getContextPath() + "/MessageServlet");
    }
}
