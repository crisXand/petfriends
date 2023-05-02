<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file = "/WEB-INF/views/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Now <c:out value = "${now }"/></p>
	<c:forEach  var="pet" items="${pets}">
		<c:out value="${pet.name}">asd</c:out>
	</c:forEach>
</body>
</html>