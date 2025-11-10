<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>チャットアプリ</h1>

    <form action="/MessageServlet" method="post">
        お名前<br />
        <input type="text" name="senderName" /><br />
        メッセージ内容<br />
        <textarea name="content"></textarea><br />
        <button type="submit">送信</button>
    </form>

    <ul>
        <c:forEach var="message" items="${messages}">
            <li>
                ${message.content} <br />
                (by ${message.senderName})
                <form action="/MessageDeleteServlet" method="post">
                    <input type="hidden" name="id" value="${message.id}" />
                    <button type="submit">削除</button>
                </form>
            </li>
        </c:forEach>
    </ul>
</body>
</html>