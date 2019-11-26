<%-- 
    Document   : venderImovel
    Created on : 10/09/2019, 19:32:50
    Author     : joao.bonetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8"/>
        <title>Vender Imovel</title>
    </head>
    <body>
        <h1 style="text-align: center;margin-top: 22px;margin-bottom: 7.5rem;">Vender Imovel</h1>
        <div class="container">	
            <form method="post" action="ManterVendidosController?acao=confirmarOperacao&operacao=${operacao}">
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">ID Venda:</label>
                    <div class="col-sm-1">
                    <input type="text" class="form-control" name="txtIdVenda" value="${vendido.idVenda}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Imovel vendido:</label>
                    <div class="col-sm-1">
                        <select name="optImovelVendido" class="form-control">  
                            <option value="0" <c:if test="${vendidos.imovelVendido.idImovel == null}"> selected</c:if>> </option>  
                            <c:forEach items="${imoveis}" var="imovel">
                                <option value="${imovel.idImovel}" <c:if test="${vendido.imovelVendido.idImovel == imovel.idImovel}"> selected</c:if>>${imovel.idImovel}</option>  
                            </c:forEach>
                        </select> 
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Corretor Responsável:</label>
                    <div class="col-sm-1">
                        <select name="optResponsavelVenda" class="form-control">
                            <option value="0" <c:if test="${vendidos.responsavelVenda.matricula == null}"> selected</c:if>> </option>  
                            <c:forEach items="${corretores}" var="corretor">
                                <option value="${corretor.matricula}" <c:if test="${vendido.responsavelVenda.matricula == corretor.matricula}"> selected</c:if>>${corretor.matricula}</option>  
                            </c:forEach>
                        </select> 
                    </div>
                </div>
                <div class="form-group row"> 
                    <label class="col-form-label col-sm-2">Nome comprador:</label> 
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="txtNomeComprador" value="${vendido.nomeComprador}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                    </div>
                </div>
                <div class="form-group row"> 
                    <label class="col-form-label col-sm-2">CPF comprador:</label> 
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="txtCpfComprador" value="${vendido.cpfComprador}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                    </div>
                </div>
                    <div class="form-group row"> 
                        <label class="col-form-label col-sm-2">Valor entrada:</label> 
                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="txtValorEntrada" value="${vendido.valorEntrada}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>
                    </div>    
                    <div class="form-group row"> 
                        <label class="col-form-label col-sm-2">Nº de parcelas:</label> 
                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="txtNumPercelas" value="${vendido.numPercelas}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                        </div>
                    </div>    
                    <div class="form-group row"> 
                        <label class="col-form-label col-sm-2">Valor parcelas:</label> 
                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="txtValorParcela" value="${vendido.valorParcela}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                        </div>
                    </div>
                    <div class="form-group row"> 
                        <label class="col-form-label col-sm-2">Valor venda:</label> 
                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="txtvalorVenda" value="${vendido.valorVenda}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                        </div>
                    </div>
                    <div class="form-group row"> 
                        <label class="col-form-label col-sm-2">Data venda:</label> 
                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="txtDataVenda" value="${vendido.dataVenda}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                        </div>
                    </div>
                    <div class="row col-md-6">
                        <a href="PesquisaVendidosController" class="btn btn-dark">Voltar</a>
                       <input class="btn btn-primary" type="submit" style="margin-left: 293px;" value="Concluir" name="txtEnviar">
                    </div>
                </pre>
            </form>
        </div>
    </body>
</html>
