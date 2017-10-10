<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">

        <title>Sarraiva.com.br Administração</title>

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/link.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="indexFunc.jsp"><img class="img-responsive logsarraiva" src="imagens/sarraidex.png"></a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav menuu">
                        <li><a href="indexFunc.jsp">Home</a></li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Produtos<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-header">GERENCIAR</li>
                                <li class="divider"></li>
                                <li><a href="indexFunc.jsp?p=cadProduto">Cadastrar Produto</a></li>
                                <li><a href="indexFunc.jsp?p=listProd">Listar Produtos</a></li>
                            </ul>
                        </li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">${nome}</a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-header"></li>
                                <li><a href="#">Configuração de Conta</a></li>
                                <li><a href="sys?logica=ClienteLogica&action=off">Sair</a></li>
                            </ul>
                        </li>


                    </ul>
                </div>
            </div>
        </nav>

        <div>
            <section>
                <c:choose>
                    <c:when test="${param.p == 'cadProduto'}">
                        <c:set var="pagina" value="formProduto.jsp"/>
                    </c:when>   
                    <c:when test="${param.p == 'listProd'}">
                        <c:set var="pagina" value="listProd.jsp"/>
                    </c:when>   
                    <c:when test="${param.p == ''}">
                        <c:set var="pagina" value=""/>
                    </c:when>   
                    <c:otherwise>
                        <c:set var="pagina" value="inicioFunc.jsp"/>
                    </c:otherwise>
                </c:choose>
                <c:import url="${pagina}"></c:import>

            </section>
        </div>

        <div class="container-fluid col-md-12 backgroundfooter">


            <div class="col-md-12 rfooter">
                <h5 class="rcfooter container">   

                    Sarraiva.com.br é uma empresa do grupo Sarraiva e Wesley Sarradão S.A., CNPJ nº 74.015.784/4571-04, Rua Sem Asfalto, nº 22, Queimados – RJ.</h5>
            </div>
        </div>







        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>

