<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("Model(sub) : Hello World");
%>
<br>

${ObjectTest}

<br>

${lists}

<br>
<br>

<c:forEach var="mylist" items="${lists}">
	${mylist} <br>
</c:forEach>

당신의 이름은 ${name} 입니다.


</body>
</html>