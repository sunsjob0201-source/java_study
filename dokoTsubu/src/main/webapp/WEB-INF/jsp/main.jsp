<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Mutter, java.util.List, java.time.LocalDateTime" %>
<%
User loginUser = (User)session.getAttribute("loginUser");

List<Mutter> mutterList =
    (List<Mutter>)application.getAttribute("mutterList");

String errorMsg = (String)request.getAttribute("errorMsg");

LocalDateTime lastReadTime =
    (LocalDateTime)request.getAttribute("lastReadTime");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
<style>
body {
    max-width: 700px;
    margin: auto;
    padding: 10px;
}

.mutter {
    border-bottom: 1px solid #ddd;
    padding: 10px;
}

.topLine {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
}

.text {
    flex: 1;
    overflow-wrap: break-word;
    word-break: break-word;
    margin-right: 10px;
}

.time {
    color: gray;
    font-size: 0.8em;
    margin-top: 4px;
}

.deleteForm {
    display: inline;
}

.unread {
    background-color: #fff8dc;
    border-left: 4px solid orange;
}

.unreadLabel {
    color: orange;
    font-weight: bold;
    margin-left: 5px;
}
</style>
</head>
<body>

<h1>どこつぶメイン</h1>

<p>
<%= loginUser.getName() %>さん、ログイン中
<a href="Logout">ログアウト</a>
</p>

<p><a href="Main">更新</a></p>

<form action="Main" method="post">
    <input type="text" name="text">
    <input type="submit" value="つぶやく">
</form>

<% if (errorMsg != null) { %>
    <p><%= errorMsg %></p>
<% } %>

<% for (Mutter mutter : mutterList) { %>

<%
boolean unread =
    lastReadTime != null &&
    mutter.getPostTime().isAfter(lastReadTime);
%>

<div class="mutter <%= unread ? "unread" : "" %>">

    <div class="topLine">

        <div class="text">
            <strong><%= mutter.getUserName() %></strong>
            : <%= mutter.getText() %>

            <% if (unread) { %>
                <span class="unreadLabel">NEW</span>
            <% } %>
        </div>

        <% if (mutter.getUserName().equals(loginUser.getName())) { %>
            <form action="DeleteMutter"
                  method="post"
                  class="deleteForm">

                <input type="hidden"
                       name="id"
                       value="<%= mutter.getId() %>">

                <input type="submit"
                       value="削除">
            </form>
        <% } %>

    </div>

    <div class="time">
        投稿時間 : <%= mutter.getFormattedTime() %>
    </div>

</div>

<% } %>

</body>
</html>