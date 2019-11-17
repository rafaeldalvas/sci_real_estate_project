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
        <title>Pesquisa de imóveis para venda</title>
    </head>
    <body>
        <h1>Pesquisa de imóveis para venda</h1>

        <table border='1'>
            <tr>
                <th>ID Imovel</th>
                <th>Preço anunciado</th>
            </tr>
            <c:forEach items="${imoveis}" var="imovel">
                <tr>
                    <td> <c:out value="${imovel.idImovel}"/> </td>
                    <td> <c:out value="${imovel.precoAnunciado}"/> </td>
                    <td><a href="ManterImovelVendaController?acao=prepararOperacao&operacao=Editar&idImovel=<c:out value="${imovel.idImovel}"/>">Editar</a></td>
                    <td><a href="ManterImovelVendaController?acao=prepararOperacao&operacao=Excluir&idImovel=<c:out value="${imovel.idImovel}"/>">Excluir</a></td
                </tr>
            </c:forEach>
        </table>
        <br>
        <form action="ManterImovelVendaController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Inserir">
        </form>

    </body>

</html>
