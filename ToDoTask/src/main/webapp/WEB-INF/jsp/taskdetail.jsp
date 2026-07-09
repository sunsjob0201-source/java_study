<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tasklist</title>

</head>
<body>
<h1>※※ ToDoタスク管理 ※※</h1>

<p>
<c:choose>
    <c:when test="${mode == 'insert'}">
        【新規登録】
    </c:when>

    <c:when test="${mode == 'updateDelete'}">
        【変更・削除】
    </c:when>

    <c:otherwise>
        【変更】
    </c:otherwise>
</c:choose>
</p>

<form>

<table border="1">
    <tr>
        <th>タスクID</th>
        <td>新規</td>
    </tr>

    <tr>
        <th>タスク名称</th>
        <td><input type="text" name="taskName"></td>
    </tr>

    <tr>
        <th>タスク内容</th>
        <td><textarea name="taskContents"></textarea></td>
    </tr>

    <tr>
        <th>タスク期限</th>
        <td><input type="date" name="taskLimitdate"></td>
    </tr>

    <tr>
        <th>タスク担当者</th>
        <td><input type="text" name="taskUser"></td>
    </tr>

    <tr>
        <th>タスク状況</th>
        <td>
            <select name="taskStatus">
                <option value="0">未着手</option>
                <option value="1">着手</option>
                <option value="2">凍結</option>
                <option value="3">中断</option>
                <option value="9">完了</option>
            </select>
        </td>
    </tr>
</table>

<br>

<input type="submit" value="登録する">

</form>

<br>

<a href="tasklist">●タスク一覧へ</a>

</body>
</html>