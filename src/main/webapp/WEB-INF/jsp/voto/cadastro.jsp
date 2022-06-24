<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container mt-3">
		<h2>Cadastramento de Voto</h2>
		<form action="/voto/incluir" method="post">
			<div class="form-group">
				<label>Eleitor:</label> <select class="form-control"
					name="eleitor.id">
					<c:forEach var="e" items="${eleitores}">
						<option value="${e.id}">${e.nome}</option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">
				<label>Eleição:</label> <select class="form-control"
					name="eleicao.id">
					<option value="${eleicao.id}">${eleicao.descricao}</option>
				</select>
			</div>

			<div class="form-group">
				<label>Candidato:</label> <select class="form-control"
					name="candidato.id">
					<c:forEach var="c" items="${candidatos}">
						<option value="${c.id}">${c.nome}</option>
					</c:forEach>
				</select>
			</div>

			<div class="mb-3 mt-3">
				<label>Localização:</label> <input type="text" class="form-control"
					placeholder="Entre com a sua localização" name="localizacao"
					value="Localiza">
			</div>
			<br />
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>

	</div>


</body>
</html>