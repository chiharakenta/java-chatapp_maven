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
    <h1>返信の編集</h1>

    <form action="${pageContext.request.contextPath}/ReplyEditServlet" method="post">
        <input type="hidden" name="id" value="${reply.id}" />
        お名前<br />
        <input type="text" name="senderName" value="${reply.senderName}" /><br />
        メッセージ内容<br />
        <textarea name="content">${reply.content}</textarea><br />
        <button type="submit">更新</button>
    </form>
</body>
</html>