<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1> select 페이지~!!</h1>

	<c:forEach var="dto" items="${list}">
	${dto.num} ${dto.id} ${dto.orgname} ${dto.reg} <br />
		<hr />
	</c:forEach>


</body>
</html>