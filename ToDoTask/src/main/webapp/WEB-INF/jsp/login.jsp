<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDoTask</title>

<style>
.title {
    color:red;
}
</style>
</head>
<body>

<h1 class="title">※※  ToDoタスク管理  ※※</h1>

<form action="Login" method="post">

ユーザーID：
<input type="text" name="user_id"><br>

パスワード：
<input type="password" name="user_pass"><br><br>

<input type="submit" value="ログイン">
</form>

<hr>

</body>
</html>