<%-- 
    Document   : index.jsp
    Created on : 04/09/2019, 19:36:51
    Author     : joao.bonetti
                 rafael.dalvas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet'
    type='text/css'>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SCI</title>
</head>

<body>

    <div class="container" style="margin-top: 173px;">
        <div class="col-md-12">
            <div class="row" style="margin-bottom: 30px;">
                <div class="col-sm-4" style="margin-left: 185px;">
                    <div class="card " style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">Imóveis para venda</h5>
                            <p class="card-text">Controle de imóveis diponíveis para venda</p>
                            <a href="PequisaImovelVendaController" class="btn btn-primary">Entrar</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">Imóveis para aluguel</h5>
                            <p class="card-text">Controle de imóveis diponíveis para aluguel</p>
                            <a href="PesquisaImovelAlugaController" class="btn btn-primary">Entrar</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" style="margin-bottom: 30px;">
                <div class="col-sm-4" style="margin-left: 185px;">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">Imóveis Vendidos</h5>
                            <p class="card-text">Realizar a venda de imóveis</p>
                            <a href="PesquisaVendidosController" class="btn btn-primary">Entrar</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">Imoveis Alugados</h5>
                            <p class="card-text">Realizar o aluguel de imóveis</p>
                            <a href="PesquisaAlugadosController" class="btn btn-primary">Entrar</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4" style="margin-left: 185px;">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">Administradores</h5>
                            <p class="card-text">Controle de Administradores</p>
                            <a href="PesquisaAdministradorController" class="btn btn-primary">Entrar</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">Corretores</h5>
                            <p class="card-text">Controle de Corretores</p>
                            <a href="PesquisaCorretorController" class="btn btn-primary">Entrar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>

</html>