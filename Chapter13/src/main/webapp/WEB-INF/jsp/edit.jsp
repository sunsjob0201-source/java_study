<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Mutter"  %>

<%
Mutter mutter =
(Mutter)request.getAttribute("mutter");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>つぶやき編集</title>
</head>
<body>

<h1>つぶやき編集</h1>

<form action="EditMutter" method="post">

    <input type="hidden"
            name="id"
            value="<%= mutter.getId() %>">
            
    <input type="text"
            name="text"
            value="<%= mutter.getText() %>">
            
    <input type="submit"
            value="更新">
            
</form>

<p>
<a href="Main">戻る</a>
</p> 

</body>
</html>