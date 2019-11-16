<%-- 
    Document   : pesquisaAlugados
    Created on : 24/09/2019, 18:21:59
    Author     : joao.bonetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de imóveis que foram alugados</title>
    </head>
    <body>
        <h1>Pesquisa de imóveis que foram alugados</h1>
        
        <table border="1">
            <tr>
                <th>ID Aluguel</th>
                <th>Valor de Aluguel</th>
            </tr>
            <c:forEach items="${alugados}" var="aluguel">
                <tr>
                    <td> <c:out value="${aluguel.idAluguel}"/> </td>
                    <td> <c:out value="${aluguel.valorDeAluguel}"/> </td>
                    <td><a href="ManterAlugadosController?acao=prepararOperacao&operacao=Editar&idAluguel=<c:out value="${aluguel.idAluguel}"/>">Editar</a></td>
                    <td><a href="ManterAlugadosController?acao=prepararOperacao&operacao=Excluir&idAluguel=<c:out value="${aluguel.idAluguel}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        
        <form action="ManterAlugadosController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
