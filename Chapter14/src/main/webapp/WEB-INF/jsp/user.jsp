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

<% if (errorMsg != null) { %>
    <p style="color:red;"><%= errorMsg %></p>
<% } %>

<form action="UserServlet" method="post">

<table>
<tr>
    <td>ユーザーID</td>
    <td><input type="text" name="userId"></td>
</tr>

<tr>
    <td>パスワード</td>
    <td><input type="password" name="pass"></td>
</tr>

<tr>
    <td>メールアドレス:</td>
    <td><input type="email" name="mail"></td>
</tr>

<tr>
    <td>姓名:</td>
    <td><input type="text" name="name"></td>
</tr>

<tr>
    <td>年齢:</td>
    <td><input type="number" name="age"></td>
</tr>

<tr>
    <td colspan="2">
        <input type="submit" value="登録">
    </td>
</tr>

</table>

</form>

<p><a href="WelcomeServlet">トップへ</a></p>
</body>
</html>