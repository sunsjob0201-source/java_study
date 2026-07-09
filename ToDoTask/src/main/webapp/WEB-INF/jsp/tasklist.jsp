<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tasklist</title>

<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<h1>※※ ToDoタスク管理 ※※</h1>
<p>【ToDoタスク一覧】</p><br>

<table border="1">
    <tr>
        <th>タスクID</th>
        <th>タスク名称</th>
        <th>タスク内容</th>
        <th>タスク期限</th>
        <th>タスク担当者</th>
        <th>タスク状況</th>
        <th>詳細画面</th>
    </tr>
    
<c:forEach var="task" items="${taskList}">
    <tr>
        <td>${task.taskId}</td>
        <td>${task.taskName}</td>
        <td>${task.taskContents}</td>
        <td>${task.taskLimitdate}</td>
        <td>${task.taskUser}</td>
        <td>${task.taskLabel}</td>
        <td>
            <c:choose>
                <c:when test="${task.taskDelete != null}">
                <!-- 削除済み -->
                    削除済
                </c:when>
                
                <c:when test="${task.taskStatus == 1}">
                <!-- 着手中 -->
                    <a href="taskdetail?mode=updateDelete&taskId=${task.taskId}">変更・削除へ</a>
                </c:when>
                
                <c:otherwise>
                <!-- それ以外 -->
                    <a href="taskdetail?mode=update&taskId=${task.taskId}">変更へ</a>
                </c:otherwise>    
            </c:choose>
        </td>
    </tr>
</c:forEach>
</table>

<div class="footer-area">

    <div class="footer-left">
        <a href="taskdetail?mode=insert">●新規登録へ</a><br><br>
        <a href="menu">●メニューへ</a>
    </div>

    <div class="footer-right">
        <div class="login-line"></div>
        <div class="login-user">
            ログインユーザー名：${sessionScope.loginUser.userName}
        </div>
    </div>

</div>
 
</body>
</html>