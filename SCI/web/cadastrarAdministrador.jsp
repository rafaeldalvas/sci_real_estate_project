<%-- 
    Document   : cadastrarFuncionario
    Created on : 10/09/2019, 19:31:26
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
        <title>Cadastro de administradores do site</title>
    </head>
    <body>
        <h1 style="text-align: center;margin-top: 22px;margin-bottom: 7.5rem;">Cadastro de administrador</h1>
        <div class="container">
            <form method="post" action="ManterAdministradorController?acao=confirmarOperacao&operacao=${operacao}">
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Matrícula:</label> 
                    <div class="col-sm-3">
                        <input type="text" size="35" class="form-control" maxlength="5" name="txtMatricula" value ="${administrador.matricula}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>> 
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Nome:</label>
                    <div class="col-sm-3">
                        <input type="text" size="35" class="form-control" maxlength="255" name="txtNome" value ="${administrador.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Nome:</label>
                    <div class="col-sm-3">
                        <input type="text" size="35" class="form-control" maxlength="9" name="txtSexo" value ="${administrador.sexo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Telefone:</label>
                    <div class="col-sm-3">        
                        <input type="text" size="35" class="form-control" maxlength="20" name="txtTelefone" value ="${administrador.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                    </div>
                </div>    
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Email:</label>
                    <div class="col-sm-3">
                        <input type="text" size="35" class="form-control" maxlength="30" name="txtEmail" value ="${administrador.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                    </div>
                </div>    
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Cidade:</label>
                    <div class="col-sm-3">
                        <input type="text" size="35" class="form-control" maxlength="30" name="txtCidade" value ="${administrador.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                    </div>
                </div>    
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Estado:</label>
                    <div class="col-sm-3">
                        <input type="text" size="35" class="form-control" maxlength="30" name="txtEstado" value ="${administrador.estado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                    </div>
                </div>    
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">CEP:</label>
                    <div class="col-sm-3">
                        <input type="text" size="35" class="form-control" maxlength="9" name="txtCep" value ="${administrador.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                    </div>
                </div>    
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Logradouro:</label>
                    <div class="col-sm-3">
                        <input type="text" size="35" class="form-control" maxlength="60" name="txtLogradouro" value ="${administrador.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                    </div>
                </div>    
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Número:</label>
                    <div class="col-sm-3">
                        <input type="text" size="35" class="form-control" maxlength="5" name="txtNumero" value ="${administrador.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                    </div>
                </div>    
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">CPF:</label>
                    <div class="col-sm-3">
                        <input type="text" size="35" class="form-control" maxlength="14" name="txtCpf" value ="${administrador.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                    </div>
                </div>    
                <div class="form-group row">
                    <label class="col-form-label col-sm-2">Nível Cargo:</label>
                    <div class="col-sm-3">
                        <input type="text" size="35" class="form-control" maxlength="14" name="txtNivelCargo" value ="${administrador.nivelCargo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                    </div>
                </div>    
                <div class="row col-md-6">
                    <a href="PesquisaAdministradorController" class="btn btn-dark">Voltar</a>
                    <input class="btn btn-primary" type="submit" style="margin-left: 293px;" value="Concluir" name="enviar">
                </div>
            </form>
        </div>
    </body>
</html>