<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="listener.SiteEV"  %>
<% 
SiteEV siteEV = (SiteEV)application.getAttribute("siteEV");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>湊くんのページ</title>
</head>
<body>
<h1>湊くんのページへようこそ</h1>
<P>
<a href="MinatoIndex?action=like">よいね</a>:
<%= siteEV.getLike() %>人
<a href="MinatoIndex?action=dislike">よくないね</a>:
<%= siteEV.getDislike() %>人
</P>
<h2>湊くんとは！？</h2>
<p>・・・</p>



</body>
</html>