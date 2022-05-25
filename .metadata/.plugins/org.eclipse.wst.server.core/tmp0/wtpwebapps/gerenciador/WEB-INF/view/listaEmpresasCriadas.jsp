<%@ page import="java.util.List,br.com.alura.gerenciador.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<body>
	
		<c:import url="logout-parcial.jsp"></c:import>
	
	Usuario Logado: ${usuarioLogado.login }
	<br>
	<br>
	<br>
	
	<c:if test="${not empty empresa}">
            Empresa ${ empresa } cadastrada com sucesso!
    </c:if>

		Lista de Empresas: <br />
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>${empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
					<a href="/gerenciador/entrada?acao=MostraEmpresas&id=${empresa.id}">Editar</a>
					<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">Remove</a>
				</li>
			</c:forEach>
		
		</ul>
	</body>
</html>