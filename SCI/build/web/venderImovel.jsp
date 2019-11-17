<%-- 
    Document   : venderImovel
    Created on : 10/09/2019, 19:32:50
    Author     : joao.bonetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8"/>
        <title>Vender Imovel</title>
    </head>
    <body>
        <h1 align="center">Vender Imovel</h1>	
        <form method="post" action="ManterVendidosController?acao=confirmarOperacao&operacao=${operacao}">
            <pre>
                ID Venda: <input type="text" size="35" maxlength="255" name="txtIdVenda" value="${vendido.idVenda}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>> <br>
                Imovel vendido: <select name="optImovelVendido">  
                    <option value="0" <c:if test="${vendidos.imovelVendido.idImovel == null}"> selected</c:if>> </option>  
                    <c:forEach items="${imoveis}" var="imovel">
                        <option value="${imovel.idImovel}" <c:if test="${vendido.imovelVendido.idImovel == imovel.idImovel}"> selected</c:if>>${imovel.idImovel}</option>  
                    </c:forEach>
                </select> <br>

                Corretor Responsável: <select name="optResponsavelVenda">
                    <option value="0" <c:if test="${vendidos.responsavelVenda.matricula == null}"> selected</c:if>> </option>  
                    <c:forEach items="${corretores}" var="corretor">
                        <option value="${corretor.matricula}" <c:if test="${vendido.responsavelVenda.matricula == corretor.matricula}"> selected</c:if>>${corretor.matricula}</option>  
                    </c:forEach>
                </select> <br>

                Nome comprador: <input type="text" size="35" maxlength="255" name="txtNomeComprador" value="${vendido.nomeComprador}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                CPF comprador: <input type="text" size="15" maxlength="255" name="txtCpfComprador" value="${vendido.cpfComprador}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                Valor entrada: <input type="text" size="10" maxlength="255" name="txtValorEntrada" value="${vendido.valorEntrada}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                Nº de parcelas: <input type="text" size="2" maxlength="2" name="txtNumPercelas" value="${vendido.numPercelas}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                Valor parcelas: <input type="text" size="2" maxlength="2" name="txtValorParcela" value="${vendido.valorParcela}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                Valor venda: <input type="text" size="2" maxlength="2" name="txtvalorVenda" value="${vendido.valorVenda}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                Data venda: <input type="text" size="2" maxlength="2" name="txtDataVenda" value="${vendido.dataVenda}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>

                <input type="submit" value="Efetuar a venda" name="txtEnviar">

            </pre>
        </form>
    </body>
</html>
