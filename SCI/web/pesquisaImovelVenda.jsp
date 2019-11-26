<%-- 
    Document   : pesquisaImovelVenda
    Created on : 18/09/2019, 19:39:56
    Author     : joao.bonetti
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de imóveis para venda</title>
    </head>
    <body>
        <div class="container">     
            <div class="col-sm-12 mt-12">
                <div class="col-md-6 offset-md-3">
                    <div class="row">    
                        <div class="col-sm-12"><h2 style="margin-top: 80px;margin-bottom: 2.5rem;">Imóveis disponíveis para venda</h2></div>
                    </div>
                </div>
            <div class="row">
                <div class="col-md-6 offset-md-3">    
                    <table class="table table-bordered">
                        <tr class="table-active">
                            <th>ID Imovel</th>
                            <th>Preço anunciado</th>
                            <th></th>
                        </tr>
                        <c:forEach items="${imoveis}" var="imovel">
                            <tr>
                                <td class="col-sm-2"> <c:out value="${imovel.idImovel}"/> </td>
                                <td class="col-sm-2"> <c:out value="${imovel.precoAnunciado}"/> </td>
                                <td class="col-sm-1"><a class="btn btn-warning" href="ManterImovelVendaController?acao=prepararOperacao&operacao=Editar&idImovel=<c:out value="${imovel.idImovel}"/>"><em class="fa fa-pencil"></em></a>
                                <a class="btn btn-danger" href="ManterImovelVendaController?acao=prepararOperacao&operacao=Excluir&idImovel=<c:out value="${imovel.idImovel}"/>"><em class="fa fa-trash"></em></a></td>
                            </tr>
                        </c:forEach>
                    </table>
                        <form action="ManterImovelVendaController?acao=prepararOperacao&operacao=Incluir" method="post">
                            <a href="index.jsp" class="btn btn-dark">Voltar</a>
                            <input type="submit" class="btn btn-info add-new" style="margin-left: 383px;" name="btnIncluir" value="Inserir">
                        </form>
                    </div>
                </div>
            </div>
        </div> 
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>      
    </body>
</html>
