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
		<h2>Cadastramento de Candidato</h2>


		<form action="/candidato/incluir" method="post">
			<div class="mb-3 mt-3">
				<label>Número:</label> <input type="number" class="form-control"
					placeholder="Entre com o seu número" name="numero">
			</div>

			<div class="mb-3 mt-3">
				<label>Nome:</label> <input type="text" class="form-control"
					placeholder="Entre com o seu nome" name="nome">
			</div>
			
			<c:if test="${not empty eleicoes}">
		  	<label>Eleição:</label>
		  	<select class="form-control mt-3"  name="eleicao.id">
		    	<c:forEach var="e" items="${eleicoes}">
		    	<option value="${e.id}">${e.descricao}</option>
		    	</c:forEach>
		  	</select>
		  	</c:if>
		  
			<c:if test="${empty eleicoes}">
				<c:set var="botao" value="disabled"/>
		  		<label>Não existem Eleições cadastradas!!!</label>
		  	</c:if>
			
			<br />
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>

</body>
</html>