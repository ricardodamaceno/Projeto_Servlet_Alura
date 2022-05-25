<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url  value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<c:import url="logout-parcial.jsp"></c:import>

	<form action="${linkEntradaServlet }" method="post">
	nome: <input type="text" name="nome" />
	<input type="hidden" name="acao" value="NovaEmpresa">
	<input type="submit" />
	</form>
</body>
</html>