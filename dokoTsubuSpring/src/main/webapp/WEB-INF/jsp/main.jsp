<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.model.User, com.example.demo.model.Mutter, java.util.List, java.time.LocalDateTime" %>
<%
User loginUser = (User)session.getAttribute("loginUser");

List<Mutter> mutterList =
    (List<Mutter>) request.getAttribute("mutterList");

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
    background-color: #f5f7fa;
    font-family: sans-serif;
    margin: 0;
}

header {
    background: #2196F3;
    color: white;
    padding: 15px;
}

main {
    width: 760px;
    margin: 30px auto;
}

.loginInfo {
    margin-bottom: 15px;
}

textarea {
    width: 700px;
    height: 80px;
    border-radius: 8px;
    padding: 10px;
    font-size: 16px;
}

button,
input[type="submit"] {
    background: #2196F3;
    color: white;
    border: none;
    padding: 8px 18px;
    border-radius: 5px;
    cursor: pointer;
}

button:hover,
input[type="submit"]:hover {
    background: #1976D2;
}

.mutter {
    background: white;
    border-radius: 10px;
    padding: 15px;
    margin: 15px auto;
    width: 700px;
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    overflow-wrap: break-word;
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
    margin-top: 8px;
}

.deleteForm {
    text-align: right;
    margin-left: 10px;
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

.postImage {
    margin-top: 10px;
    max-width: 300px;
    border-radius: 8px;
    display: block;
}
</style>
</head>

<body>

<header>
    <h1>どこつぶメイン</h1>
</header>

<main>

<p class="loginInfo">
    <%= loginUser.getName() %>さん、ログイン中
    <a href="Logout">ログアウト</a>
</p>

<p><a href="Main">更新</a></p>

<form action="<%= request.getContextPath() %>/Main" method="post" enctype="multipart/form-data">
    <textarea name="text"></textarea><br>
    <input type="file" name="image" accept="image/*"><br><br>
    <button type="submit">投稿</button>
</form>

<% if (errorMsg != null) { %>
    <p><%= errorMsg %></p>
<% } %>

<% if (mutterList != null) { %>

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

                <% if (mutter.getImagePath() != null && !mutter.getImagePath().isEmpty()) { %>
                    <img class="postImage"
                         src="<%= request.getContextPath() %>/<%= mutter.getImagePath() %>">
                <% } %>
            </div>

            <% if (mutter.getUserName().equals(loginUser.getName())) { %>
                <form action="<%= request.getContextPath() %>/DeleteMutter"
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

<% } %>

</main>

</body>
</html>