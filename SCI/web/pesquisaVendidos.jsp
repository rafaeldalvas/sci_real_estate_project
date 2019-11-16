<%-- 
    Document   : pesquisaVendidos
    Created on : 24/09/2019, 18:07:11
    Author     : joao.bonetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de imóveis vendidos</title>
    </head>
    <body>
        <h1>Pesquisa de imóveis vendidos</h1>
        
        <table border="1">
            <tr>
                <th>ID Venda</th>
                <th>Valor da venda</th>
            </tr>
            <c:forEach items="${vendas}" var="vendas">
                <tr>
                    <td> <c:out value="${vendas.idVenda}"/> </td>
                    <td> <c:out value="${vendas.valorVenda}"/> </td>
                    <td><a href="ManterVendidosController?acao=prepararOperacao&operacao=Editar&idVenda=<c:out value="${vendas.idVenda}"/>">Editar</a></td>
                    <td><a href="ManterVendidosController?acao=prepararOperacao&operacao=Excluir&idVenda=<c:out value="${vendas.idVenda}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <form action="ManterVendidosController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
        
    </body>
</html>
