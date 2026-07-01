<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String errorMsg = (String)request.getAttribute("errorMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>

<h1>ユーザー登録</h1>

<% if(errorMsg != null){ %>
<p><%= errorMsg %></p>
<% } %>

<form action="RegisterUser" method="post">

ユーザー名：
<input type="text" name="name"><br><br>

パスワード：
<input type="password" name="pass"><br><br>

<input type="submit" value="登録">

</form>

<p>
<a href="index.jsp">トップへ</a>
</p>

</body>
</html>