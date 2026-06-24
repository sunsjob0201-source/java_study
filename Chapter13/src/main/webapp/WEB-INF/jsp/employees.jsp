<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員情報の表示</title>
</head>
<body>

<h1>従業員情報</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>名前</th>
        <th>年齢</th>
    </tr>

    <c:forEach var="emp" items="${empList}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.age}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>