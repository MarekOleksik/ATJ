<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NBPApi</title>
</head>
<body bgcolor="f0f0f0">
<br>
<h1 align ="center">Wynik obliczenia:</h1>
<br>
<h2 align ="center"><font color="0f0058">Średni kurs sprzedaży  <%=request.getAttribute("code")%> z tabeli  <%=request.getAttribute("table")%> z ostatnich <%=request.getAttribute("topCount")%> notowań wynosi:  <%=request.getAttribute("averageAsk")%> PLN
</font></h2>
<br>
</body>

</html>