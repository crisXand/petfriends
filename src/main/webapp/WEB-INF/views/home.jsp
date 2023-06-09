<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file = "/WEB-INF/views/include.jsp" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Mascotas</h1>
	<table>
		<thead>
			<tr><th>Nombre</th><th>Edad</th><th>Tipo</th></tr>
		</thead>
		<tbody>
			<c:forEach  var="pet" items="${pets}">
				
				<tr><td>${pet.name}</td><td>${pet.age}</td><td>${pet.typepet}</td></tr>
			</c:forEach>
		</tbody>
	</table>
	
	<form:form action = "/springjpaxml/pet" method = "POST" modelAttribute = "petModel">
		<table>
			<tr>
				<td><form:label path = "name"> Nombre </form:label></td>
				<td><form:input path = "name"></form:input></td>
			</tr>
			
			<tr>
				<td><form:label path = "name"> Edad </form:label> 
				<td><form:input path = "name"  type = "number"></form:input></td>
				
			</tr>
			
			<tr>
				<td><form:label path="typepet">Tipo</form:label></td>
				<td><form:select path="typepet">
					<form:option value="dog" label = "Perro"></form:option>
				</form:select></td>
			</tr>
			 <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
		</table>
	</form:form>
</body>
</html>