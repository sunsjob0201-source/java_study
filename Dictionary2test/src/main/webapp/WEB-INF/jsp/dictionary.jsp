<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.EjDict, java.util.List"  %>
<%
String errorMsg = (String)request.getAttribute("errorMsg");
String errorMsg2 = (String)request.getAttribute("errorMsg2");
String word = (String)request.getAttribute("word");
String wordValue = word != null ? word : "";
String maxCount = (String) request.getAttribute("maxCount");
String maxCountValue = maxCount != null ? maxCount : "";
List<EjDict> ejDictList = (List<EjDict>) request.getAttribute("ejDictList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>英和辞書</title>
<style>
    h1 {
        background-color: #0070c0;
        color: white;
        font-size: 16px;
        padding: 8px;
    }
    
    .error {
        color: red;
        font-size: 14px;
    }
    
    .wordTitle {
        background-color: #0099ff;
        color: white;
        font-weight: bold;
        padding: 5px;
        margin-top: 10px;
    }
    
    .explanation {
        padding: 10px;
        border-bottom: 1px solid #ccc;
        white-space: pre-wrap;
    }
    </style>
    </head>
    
    <body>
    
    <h1>英和辞書</h1>

<form action="EjDictServlet" method="post">
    最大検索件数:
    <input type="text" name="maxCount" size="5"
        value="<%= maxCountValue %>">
        
    英単語:
    <input type="text" name="word"
        value="<%= wordValue %>">
        
    <button type="submit">検索</button>
</form>

<% if (errorMsg != null) { %>
    <p class="error"><%= errorMsg %></p>
<% } %>

<% if (errorMsg2 != null) { %>
    <p class="error"><%= errorMsg2 %></p>
<% } %>

<hr>

<% if (ejDictList != null) { %>
    <% for (EjDict ejDict : ejDictList) { %>
        <div class="wordTitle">
            <%= ejDict.getWord() %>
        </div>
        <div class="explanation">
            <%= ejDict.getExplanation() %>
        </div>
    <% } %>
<% } %>

</body>
</html>