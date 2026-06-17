<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp"  %>
<%
LocalDate date = LocalDate.now();
DateTimeFormatter formatter =
    DateTimeFormatter.ofPattern("MM月dd日");
String today = date.format(formatter);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= name %>さんの<%= today %>の運勢は・・・
</body>
</html>