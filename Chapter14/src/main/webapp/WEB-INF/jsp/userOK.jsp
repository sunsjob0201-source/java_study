<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account"  %>
<%
Account account = (Account)request.getAttribute("account");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録完了</title>
</head>
<body>

<h1>ユーザー登録完了</h1>

<% if (account != null) {  %>
    <p><%= account.getName() %>さんを登録しました。</p>
<% } %>

<p>
    <a href="LoginServlet">ログイン画面へ</a>
</p>

</body>
</html>