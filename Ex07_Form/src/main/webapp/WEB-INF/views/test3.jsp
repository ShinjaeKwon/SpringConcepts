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
	out.println("#03 : Hello World");
%>
<br>
당신의 아이디는 ${member.id} 입니다.<br>
당신의 이름은 ${member.name} 입니다.
<!--모델의 객체 값이 아닌 커맨드 객체 변수의 속성값을 이용한다. -->

</body>
</html>