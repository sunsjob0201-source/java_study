<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.model.User"  %>

<%
User loginUser = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>

<style>
.title {
    color:red;
}
</style>
</head>
<body>

<h1 class="title">※※  ToDoタスク管理  ※※</h1>

<p>
ようこそ
<%= loginUser.getUserName()  %>さん
</p>

<p>
<a href="tasklist">・ TODOタスク一覧</a>
</p>

<p>
<a href="taskdetail?mode=insert">・ TODOタスク登録</a>
</p>

<form action="Logout" method="post">
<input type="submit" value="ログアウト">
</form>

<hr>

</body>
</html>