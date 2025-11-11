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

    <form action="${pageContext.request.contextPath}/MessageServlet" method="post">
        お名前<br />
        <input type="text" name="senderName" /><br />
        メッセージ内容<br />
        <textarea name="content"></textarea><br />
        <button type="submit">送信</button>
    </form>

    <ul>
        <c:forEach var="message" items="${messages}">
            <hr />
            <li>
                <a href="${pageContext.request.contextPath}/MessageEditServlet?id=${message.id}">
                    ${message.content} <br />
                    (by ${message.senderName})
                </a>
                <form action="${pageContext.request.contextPath}/MessageDeleteServlet" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${message.id}" />
                    <button type="submit">削除</button>
                </form>
            </li>
            <%-- トグルで開く返信フォーム --%>
            <details>
                <summary>返信を見る</summary>
                <ul>
                    <c:forEach var="reply" items="${message.replies}">
                        <li>
                            ${reply.content} <br />
                            (by ${reply.senderName})
                        </li>
                    </c:forEach>
                    <hr />
                    <form action="${pageContext.request.contextPath}/ReplyServlet" method="post">
                        <input type="hidden" name="messageId" value="${message.id}" />
                        お名前<br />
                        <input type="text" name="senderName" /><br />
                        返信内容<br />
                        <textarea name="content"></textarea><br />
                        <button type="submit">この内容で返信する</button>
                    </form>
                </ul>
            </details>
        </c:forEach>
    </ul>
</body>
</html>