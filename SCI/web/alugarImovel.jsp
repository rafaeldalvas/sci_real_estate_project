<%-- 
    Document   : alugarImovel.jsp
    Created on : 10/09/2019, 19:30:43
    Author     : joao.bonetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8"/>
        <title>Alugar imóvel</title>
    </head>
    <body>
        <h1 style="text-align: center">Alugar imóvel</h1>
        <form method="post" action="ManterAlugadosController?acao=confirmarOperacao&operacao=${operacao}">
            <pre>
                ID Aluguel: <input type="text" size="35" maxlength="255" name="txtIdAluguel" value="${aluguel.idAluguel}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>> <br>
                Imovel alugado: <select name="optImovelAlugado">  
                    <option value="0" <c:if test="${aluguel.imovelAlugado.idImovel == null}"> selected</c:if>> </option>  
                    <c:forEach items="${alugados}" var="imovel">
                        <option value="${imovel.idImovel}" <c:if test="${aluguel.imovelAlugado.idImovel == imovel.idImovel}"> selected</c:if>>${imovel.idImovel}</option>  
                    </c:forEach>
                </select> <br>

                Corretor Responsável: <select name="optResponsavelAluguel">
                    <option value="0" <c:if test="${alugado.responsavelAluguel.matricula == null}"> selected</c:if>> </option>  
                    <c:forEach items="${corretores}" var="corretor">
                        <option value="${corretor.matricula}" <c:if test="${aluguel.responsavelAluguel.matricula == corretor.matricula}"> selected</c:if>>${corretor.matricula}</option>  
                    </c:forEach>
                </select> <br>
                Nome alugatário: <input type="text" size="35" maxlength="255" name="txtNomeAlugatario" value="${aluguel.nomeAlugatario}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                CPF alugatário: <input type="text" size="35" maxlength="255" name="txtCpfAlugatario" value="${aluguel.cpfAlugatario}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                Valor de alguel: <input type="text" size="35" maxlength="255" name="txtValorAluguel" value="${aluguel.valorDeAluguel}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                Valor de calção: <input type="text" size="35" maxlength="255" name="txtValorCalcao" value="${aluguel.valorCalcao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>

                <input type="submit" value="Efetuar o aluguel" name="enviar">
            </pre>
        </form>
    </body>
</html>
