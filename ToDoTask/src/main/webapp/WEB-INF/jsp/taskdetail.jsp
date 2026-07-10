<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>ToDoタスク詳細</title>

<style>
.title {
    color:red;
}

.error {
    color: red;
}
</style>

</head>

<body>

<h1 class="title">※※ ToDoタスク管理 ※※</h1>


<!-- 画面モード -->
<c:choose>

    <c:when test="${mode == 'insert'}">
        <h2>【新規登録】</h2>
    </c:when>

    <c:when test="${mode == 'updateDelete'}">
        <h2>【変更・削除】</h2>
    </c:when>

    <c:when test="${mode == 'update'}">
        <h2>【変更】</h2>
    </c:when>

    <c:otherwise>
        <h2>【画面表示エラー】</h2>
    </c:otherwise>

</c:choose>


<form method="post">

<input type="hidden"
       name="mode"
       value="${mode}">


<table border="1">

    <!-- タスクID -->
    <tr>
        <th>タスクID</th>

        <td>
            <c:choose>

                <c:when test="${mode == 'insert'}">
                    （新規）
                </c:when>

                <c:otherwise>

                    <c:out value="${task.taskId}" />

                    <input type="hidden"
                           name="taskId"
                           value="${task.taskId}">

                </c:otherwise>

            </c:choose>
        </td>
    </tr>


    <!-- タスク名称 -->
    <tr>
        <th>タスク名称</th>

        <td>
            <input type="text"
                   name="taskName"
                   value="<c:out value='${task.taskName}' />">
        </td>
    </tr>


    <!-- タスク内容 -->
    <tr>
        <th>タスク内容</th>

        <td>
            <textarea name="taskContents"
                      rows="4"
                      cols="50"><c:out value="${task.taskContents}" /></textarea>
        </td>
    </tr>


    <!-- タスク期限 -->
    <tr>
        <th>タスク期限</th>

        <td>
            <input type="text"
                   name="taskLimitdate"
                   value="<c:choose><c:when test='${not empty taskLimitdateValue}'><c:out value='${taskLimitdateValue}' /></c:when><c:otherwise><c:out value='${task.taskLimitdate}' /></c:otherwise></c:choose>"
                   placeholder="YYYY-MM-DD">
        </td>
    </tr>


    <!-- タスク担当者 -->
    <tr>
        <th>タスク担当者</th>

        <td>
            <input type="text"
                   name="taskUser"
                   value="<c:out value='${task.taskUser}' />">
        </td>
    </tr>


    <!-- タスク状況 -->
    <tr>
        <th>タスク状況</th>

        <td>
            <select name="taskStatus">

                <c:forEach var="status"
                           items="${statusList}">

                    <option value="${status.taskStatus}"
                        ${status.taskStatus == task.taskStatus
                            ? 'selected'
                            : ''}>

                        <c:out value="${status.taskLabel}" />

                    </option>

                </c:forEach>

            </select>
        </td>
    </tr>

</table>


<br>


<!-- ボタン -->
<c:choose>

    <c:when test="${mode == 'insert'}">

        <button type="submit"
                formaction="${pageContext.request.contextPath}/taskInsert">

            登録する

        </button>

    </c:when>


    <c:when test="${mode == 'updateDelete'}">

        <button type="submit"
                formaction="${pageContext.request.contextPath}/taskUpdate">

            変更する

        </button>

        <br><br>

        <button type="submit"
                formaction="${pageContext.request.contextPath}/taskDelete"
                onclick="return confirm('このタスクを削除しますか？');">

            削除する

        </button>

    </c:when>


    <c:when test="${mode == 'update'}">

        <button type="submit"
                formaction="${pageContext.request.contextPath}/taskUpdate">

            変更する

        </button>

    </c:when>

</c:choose>

</form>


<br>


<a href="${pageContext.request.contextPath}/tasklist">
    ●タスク一覧へ
</a>


<!-- 複数のエラーメッセージ -->
<c:if test="${not empty errorList}">

    <div class="error">

        <c:forEach var="errorMessage"
                   items="${errorList}">

            <p>
                <c:out value="${errorMessage}" />
            </p>

        </c:forEach>

    </div>

</c:if>


<!-- 1件のエラーメッセージ -->
<c:if test="${not empty errorMsg}">

    <p class="error">
        <c:out value="${errorMsg}" />
    </p>

</c:if>


</body>
</html>