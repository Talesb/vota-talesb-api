<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AppMIT</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2>Cadastramento de Elei??es</h2>
	  
	  <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirma??o!</strong> ${mensagem}
		</div>	  
	  </c:if>

	  <form action="/eleicao" method="get">
	    <button type="submit" class="btn btn-primary">Novo</button>
	  </form>
	  
	  <hr>
		
	<c:if test="${not empty lista}">		
		<h2>Total de Eleicoes: ${lista.size()}</h2>
		  
		<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>ID</th>
		        <th>Descricao</th>
		        <th>Quantidade de votos</th>
		        <th>Quantidade de candidatos</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="s" items="${lista}">
			      <tr>
			        <td>${s.id}</td>
			        <td>${s.descricao}</td>
			        <td>${s.votos.size()}</td>
			        <td>${s.candidatos.size()}</td>
			        <td><a href="/eleicao/${s.id}/excluir">excluir</a></td>
			      </tr>
		      </c:forEach>		      
		    </tbody>
	  	</table>
    </c:if>	  	  

	<c:if test="${empty lista}">		
	  <h2>N?o existem eleicoes cadastradas!!!</h2>
	</c:if>

	</div>
</body>
</html>