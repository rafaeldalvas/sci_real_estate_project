<%-- 
    Trabalho SI 6º Período - Prof. Marco Antonio
    Autores:
    João Paulo Bonetti
    Rafael Dalvas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8"/>
        <title>Cadastro de imóveis disponíveis para venda</title>
    </head>
    <body>
        <h1 style="text-align: center;margin-top: 22px;margin-bottom: 7.5rem;">Cadastro de imóveis para venda</h1>
        <div class="container">
            <form method="post" action="ManterImovelVendaController?acao=confirmarOperacao&operacao=${operacao}">
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">ID Imóvel:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="txtId" value ="${vender.idImovel}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Cidade:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="txtCidade" value ="${vender.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">CEP:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="txtCep" value ="${vender.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Logradouro:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="txtLogradouro" value ="${vender.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>  
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Número:</label>
                    <div class="col-sm-3">       
                        <input type="text" class="form-control"name="txtNumero" value ="${vender.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Área:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" placeholder="Em m²" name="txtArea" value ="${vender.area}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Número de quartos:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control"name="txtNumQuartos" value ="${vender.nQuartos}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Número de banheiros:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control"name="txtNumBanheiros" value ="${vender.nBanheiros}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Valor anúncio:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control"name="txtValorAnunciado" value ="${vender.precoAnunciado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                </div>
                <div class="row col-md-6">
                    <a href="PequisaImovelVendaController" class="btn btn-dark">Voltar</a>
                    <input class="btn btn-primary" type="submit" value="Concluir" style="margin-left: 293px;"  name="txtEnviar">
                </div>
            </form>
        </div>
    </body>
</html>
