<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.User" %>

<%
User user = (User)request.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了</title>
</head>
<body>

<h1>ユーザー登録完了</h1>

<p>
<%= user.getName() %> さんを登録しました。
</p>

<p>
<a href="index.jsp">トップへ</a>
</p>

</body>
</html>