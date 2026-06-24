<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User,model.Mutter,java.util.List" %>

<%
User loginUser =
    (User) session.getAttribute("loginUser");

List<Mutter> mutterList =
    (List<Mutter>) request.getAttribute("mutterList");

String errorMsg =
    (String) request.getAttribute("errorMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>

<h1>どこつぶメイン</h1>

<p>
<%= loginUser.getName() %>さん、ログイン中
<a href="Logout">ログアウト</a>
</p>

<p>
<a href="Main">更新</a>
</p>

<form action="Main" method="post">
    <input type="text" name="text">
    <input type="submit" value="つぶやく">
</form>

<% if (errorMsg != null) { %>
    <p><%= errorMsg %></p>
<% } %>

<hr>

<% if (mutterList != null) { %>

    <% for (Mutter mutter : mutterList) { %>

        <p>
            <strong>
                <%= mutter.getUserName() %>
            </strong>
            ：
            <%= mutter.getText() %>
            <small>
                <%= mutter.getFormattedPostTime() %>
            </small>
            <form action="EditMutter"
                method="get"
                style="display:inline;">
                
                <input type="hidden"
                        name="id"
                        value="<%= mutter.getId() %>">
                <input type="submit"
                        value="編集">
             </form>       
             <form action="DeleteMutter"
                  method="post"
                  style="display:inline;">
                  
                  <input type="hidden"
                          name="id"
                          value="<%= mutter.getId() %>">
                  <input type="submit"
                          value="削除">
                          </form>
        </p>

    <% } %>

<% } else { %>

    <p>
        mutterListが取得できませんでした。
    </p>

<% } %>

</body>
</html>