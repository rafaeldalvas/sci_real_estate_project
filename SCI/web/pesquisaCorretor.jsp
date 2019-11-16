<%-- 
    Document   : pesquisaImovelVenda
    Created on : 18/09/2019, 19:39:56
    Author     : joao.bonetti
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Corretores cadastrados</title>
    </head>
    <body>
        <h1>Corretores cadastrados no SCI</h1>

        <table border='1'>
            <tr>
                <th>Matrícula</th>
                <th>Nome</th>
            </tr>
            <c:forEach items="${corretores}" var="corretores">
                <tr>
                    <td> <c:out value="${corretores.matricula}"/> </td>
                    <td> <c:out value="${corretores.nome}"/> </td>
                    <td><a href="ManterCorretorController?acao=prepararOperacao&operacao=Editar&matricula=<c:out value="${corretores.matricula}"/>">Editar</a></td>
                    <td><a href="ManterCorretorController?acao=prepararOperacao&operacao=Excluir&matricula=<c:out value="${corretores.matricula}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>

        <form action="ManterCorretorController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>

    </body>

</html>