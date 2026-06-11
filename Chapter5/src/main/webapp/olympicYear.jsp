<%@ page contentType="text/html; charset=UTF-8" %>
<%
String[] summerYears = {
    "1948","1952","1956","1960","1964","1968","1972","1976",
    "1980","1984","1988","1992","1996","2000","2004","2008",
    "2012","2016","2020","2024"
};

String[] winterYears = {
    "1948","1952","1956","1960","1964","1968","1972","1976",
    "1980","1984","1988","1992","1994","1998","2002","2006",
    "2010","2014","2018","2022","2026"
};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>オリンピックの開催地を検索</title>
<style>
table {
    border-collapse: collapse;
}
th, td {
    border: 1px solid black;
    padding: 1px;
    text-align: center;
}
</style>
</head>
<body>

<h1>オリンピック開催地を検索</h1>

<table>
<tr>
    <th>夏季オリンピック</th>
    <% for (String year : summerYears) { %>
        <td>
            <a href="OlympicList?season=summer&year=<%= year %>">
                <%= year %>
            </a>
        </td>
    <% } %>
</tr>

<tr>
    <th>冬季オリンピック</th>
    <% for (String year : winterYears) { %>
        <td>
            <a href="OlympicList?season=winter&year=<%= year %>">
                <%= year %>
            </a>
        </td>
    <% } %>
</tr>
</table>

</body>
</html>