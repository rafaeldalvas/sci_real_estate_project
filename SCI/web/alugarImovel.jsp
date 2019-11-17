<%-- 
    Document   : alugarImovel.jsp
    Created on : 10/09/2019, 19:30:43
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
        <title>Alugar imóvel</title>
    </head>
    <body>
        <h1 style="text-align: center;margin-top: 22px;margin-bottom: 7.5rem;"">Alugar imóvel</h1>
        <div class="container">
        <form method="post" action="ManterAlugadosController?acao=confirmarOperacao&operacao=${operacao}">
            <div class="form-group row">
                <label class="col-form-label col-sm-2">ID Aluguel:</label>
                <div class="col-sm-1">
                <input type="text" class="form-control" name="txtIdAluguel" value="${aluguel.idAluguel}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-form-label col-sm-2">Imovel alugado:</label>
                <div class="col-sm-1">
                    <select name="optImovelAlugado" class="form-control">  
                        <option value="0" <c:if test="${aluguel.imovelAlugado.idImovel == null}"> selected</c:if>> </option>  
                        <c:forEach items="${alugados}" var="imovel">
                            <option value="${imovel.idImovel}" <c:if test="${aluguel.imovelAlugado.idImovel == imovel.idImovel}"> selected</c:if>>${imovel.idImovel}</option>  
                        </c:forEach>
                    </select> 
                </div>
            </div>
            <div class="form-group row">
                <label class="col-form-label col-sm-2"> Corretor Responsável:</label>
                <div class="col-sm-1">
                    <select name="optResponsavelAluguel" class="form-control">
                    <option value="0" <c:if test="${alugado.responsavelAluguel.matricula == null}"> selected</c:if>> </option>  
                    <c:forEach items="${corretores}" var="corretor">
                        <option value="${corretor.matricula}" <c:if test="${aluguel.responsavelAluguel.matricula == corretor.matricula}"> selected</c:if>>${corretor.matricula}</option>  
                    </c:forEach>
                    </select>  
                </div> 
            </div>
            <div class="form-group row">  
                <label class="col-form-label col-sm-2">Nome alugatário:</label> 
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtNomeAlugatario" value="${aluguel.nomeAlugatario}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                </div>
            </div>
            <div class="form-group row">
                <label class="col-form-label col-sm-2">CPF alugatário:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtCpfAlugatario" value="${aluguel.cpfAlugatario}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                </div>
            </div>
            <div class="form-group row">
                <label class="col-form-label col-sm-2">Valor de aluguel:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtValorAluguel" value="${aluguel.valorDeAluguel}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                </div>
            </div> 
            <div class="form-group row">
                <label class="col-form-label col-sm-2">Valor de calção:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtValorCalcao" value="${aluguel.valorCalcao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                </div>
            </div>
            <div class="row col-md-2">
                <input class="btn btn-primary" type="submit" value="Concluir" name="enviar">
            </div>
        </form>
    </div>
    </body>
</html>
