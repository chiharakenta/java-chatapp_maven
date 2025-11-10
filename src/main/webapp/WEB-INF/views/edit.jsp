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
    <h1>編集画面</h1>

    <form action="/MessageEditServlet" method="post">
        <input type="hidden" name="id" value="${message.id}" />
        お名前<br />
        <input type="text" name="senderName" value="${message.senderName}" /><br />
        メッセージ内容<br />
        <textarea name="content">${message.content}</textarea><br />
        <button type="submit">更新</button>
    </form>
</body>
</html>