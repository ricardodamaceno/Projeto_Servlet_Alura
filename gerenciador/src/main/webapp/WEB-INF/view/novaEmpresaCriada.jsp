<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>	
			<c:import url="logout-parcial.jsp"></c:import>
	
		<c:if test="${not empty empresa}">
            Empresa ${ empresa } cadastrada com sucesso!
    </c:if>


    Lista de empresas: <br />

    <ul>
        <c:forEach items="${empresas}" var="empresa">

            <li>
				${empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/> 
            	
            </li>
        </c:forEach>
    </ul>
	</body>
</html>