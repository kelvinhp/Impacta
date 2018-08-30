<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Disciplinas</title>
</head>
<body>
	<h1>Lista de Disciplinas por Curso</h1>

	<table>
		<tr>
			<th>ID</th>
			<th>DESCRI��O</th>
			<th>CARGA HOR�RIA</th>
			<th>Op��es</th>
		</tr>

		<c:forEach var="disciplina" items="${listaDisciplinas}">
			<tr>
				<td>${disciplina.id}</td>
				<td>${disciplina.descricao}</td>
				<td>${disciplina.ch}</td>
				<td>
					<a href=<c:url value="/disciplina/remover?id=${disciplina.id}"/>>Remover Disciplina</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>