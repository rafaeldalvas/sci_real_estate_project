<%-- 
    Trabalho SI 6º Período - Prof. Marco Antonio
    Autores:
    João Paulo Bonetti
    Rafael Dalvas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8"/>
        <title>Cadastro de imóveis disponíveis para venda</title>
    </head>
    <body>
        <h1>Cadastro de imóveis para venda</h1>
        <form method="post" action="ManterImovelVendaController?acao=confirmarOperacao&operacao=${operacao}">
            <pre>
                CADASTRO DE IMÓVEIS PARA VENDA
                
                ID Imóvel: <input type="text" size="35" maxlength="10" name="txtId" value ="${vender.idImovel}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>><br>
                Cidade: <input type="text" size="35" maxlength="30" name="txtCidade" value ="${vender.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br>
                CEP: <input type="text" size="35" maxlength="10" name="txtCep" value ="${vender.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br>
                Logradouro: <input type="text" size="30" maxlength="50" name="txtLogradouro" value ="${vender.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br>         
                Número: <input type="text" size="35" maxlength="5" name="txtNumero" value ="${vender.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br>
                Área: <input type="text" size="35" maxlength="10" placeholder="Em m²" name="txtArea" value ="${vender.area}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br>
                Número de quartos: <input type="text" size="10" maxlength="4" name="txtNumQuartos" value ="${vender.nQuartos}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br>
                Número de banheiros: <input type="text" size="35" maxlength="4" name="txtNumBanheiros" value ="${vender.nBanheiros}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br>
                Valor venda (anunciado): <input type="text" size="10" maxlength="6" name="txtValorAnunciado" value ="${vender.precoAnunciado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br>
                
                <input type="submit" value="Concluir" name="txtEnviar" value ="">
            </pre>
        </form>
    </body>
</html>
