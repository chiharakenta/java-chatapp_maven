<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Hello World</h1>

    <ul>
        <c:forEach var="message" items="${messages}">
            <li>${message}</li>
        </c:forEach>
    </ul>
</body>
</html>