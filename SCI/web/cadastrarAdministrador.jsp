<%-- 
    Document   : cadastrarFuncionario
    Created on : 10/09/2019, 19:31:26
    Author     : joao.bonetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8"/>
        <title>Cadastro de administradores do site</title>
    </head>
    <body>
        <h1>Cadastro de administrador</h1>
        <form method="post" action="ManterAdministradorController?acao=confirmarOperacao&operacao=${operacao}">
            <pre>
                CADASTRO DE ADMINISTRADOR
                
                Matrícula: <input type="text" size="35" maxlength="5" name="txtMatricula" value ="${administrador.matricula}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>> <br>
                Nome: <input type="text" size="35" maxlength="255" name="txtNome"  value ="${administrador.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                Sexo: <input type="text" size="35" maxlength="9" name="txtSexo" value ="${administrador.sexo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                Telefone: <input type="text" size="35" maxlength="20" name="txtTelefone" value ="${administrador.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                Email: <input type="text" size="35" maxlength="30" name="txtEmail" value ="${administrador.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                Cidade: <input type="text" size="35" maxlength="30" name="txtCidade" value ="${administrador.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                Estado <input type="text" size="35" maxlength="30" name="txtEstado" value ="${administrador.estado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                CEP: <input type="text" size="35" maxlength="9" name="txtCep" value ="${administrador.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                Logradouro: <input type="text" size="35" maxlength="60" name="txtLogradouro" value ="${administrador.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                Número: <input type="text" size="35" maxlength="5" name="txtNumero" value ="${administrador.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                CPF: <input type="text" size="35" maxlength="14" name="txtCpf" value ="${administrador.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>
                Nível Cargo: <input type="text" size="35" maxlength="14" name="txtNivelCargo" value ="${administrador.nivelCargo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> <br>

                <input type="submit" value="Confirmar" name="enviar">
            </pre>
        </form>
    </body>
</html>