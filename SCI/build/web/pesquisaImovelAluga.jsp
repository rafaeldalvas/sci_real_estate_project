<%-- 
    Document   : pesquisaImovelAluga
    Created on : 18/09/2019, 19:49:06
    Author     : joao.bonetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de imoveis para aluguel</title>
    </head>
    <body>
        <h1>Pesquisa de imoveis para aluguel</h1>
        
        <table border="1">
            <tr>
                <th>ID Imovel</th>
                <th>Valor anunciado</th>
            </tr>
            <c:forEach items="${imoveisAlug}" var="imovelAlug">
                <tr>
                    <td> <c:out value="${imovelAlug.idImovel}"/></td>
                    <td> <c:out value="${imovelAlug.valorAnunciado}"/></td>
                    <td><a href="ManterImovelAlugaController?acao=prepararOperacao&operacao=Editar&idImovel=<c:out value="${imovelAlug.idImovel}"/>">Editar</a></td>
                    <td><a href="ManterImovelAlugaController?acao=prepararOperacao&operacao=Excluir&idImovel=<c:out value="${imovelAlug.idImovel}"/>">Excluir</a></td
                </tr>
            </c:forEach>          
        </table>
        
        <form action="ManterImovelAlugaController?acao=prepararOperacao&operacao=Incluir" method="post">
            <br>
            <input type="submit" name="btnIncluir" value="Inserir">
        </form>
    </body>
</html>
