<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="entrada" var="linkEntradaAteraEmpresa"></c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<c:import url="logout-parcial.jsp"></c:import>

	<form action="${linkEntradaAteraEmpresa }" method="post">
	nome: <input type="text" name="nome" value="${empresa.nome }" />
	<input type="hidden" name="id" value="${empresa.id }">
	<input type="hidden" name="acao" value="AlteraEmpresa">
	<input type="submit" />
	</form>
</body>
</html>