<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    
    <title>Sarraiva.com.br - Sua Loja de Livros, Funks e MEMES</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/link.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <script>
       
    $(document).scroll(function() {
        var y = $(this).scrollTop();
        if (y > 250) { //em pixels
          $('.form2')
            .css({
              'display': 'block'
            });
        } else {
          $('.form2')
            .css({
              'display': 'none'
            });
        }
      });
    
    </script>
    
    <body>
       <div class="divAffix">
        
        <div class="container">
            <div class="row">
                <div class=" col-md-12 text-center">
                    <img class="img-responsive logo" src="imagens/sarradao_1.png">
                </div>              
            </div>
        </div>
           
                <nav class="navbar navbar-inverse nav2 container" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bar1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="bar1">
                <ul class="nav navbar-nav">
                      <li><a href="index.jsp">Nossas Lojas</a></li>
                      <li><a href="index.jsp">Atendimento</a></li>
                      <li><a href="index.jsp">Meus Pedidos</a></li>
                </ul>
                    
                   <form class="navbar-form navbar-left" action="sys" role="search">
                        <button class="btn btn-default butaoPesquisa" type="submit">
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                        <div class="form-group">
                            <input class="input-large pesquisa" name="nome" maxlength="100" placeholder="O que você procura?" type="text"/>
                        </div> 
                       <input type="hidden" name="logica" value="ProdutoLogica">   
                       <input type="hidden" name="action" value="listProd"> 
                    </form>
                 <ul class="nav navbar-nav social">
                    <li><a href="https://www.facebook.com/"><img class="imgSocial" src="imagens/face.png"></a></li>
                    <li><a href="https://twitter.com/?lang=pt"><img class="imgSocial" src="imagens/twitter.png"></a></li>
                    <li><a href="https://www.instagram.com/?hl=pt-br"><img class="imgSocial"  src="imagens/insta.png"></a></li>
                </ul>
                    
                </div>
            </nav>
            </div>
           <nav class="container-fluid navbar-inverse menu" data-spy="affix" data-offset-top="250">
            <ul class="nav navbar-nav">
              <li><a href="index.jsp">Home</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Livros <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li class="dropdown-header">CATEGORIAS</li>
                  <li class="divider"></li>
                  <li><a href="#">Romance</a></li>
                  <li><a href="#">Comédia</a></li>
                  <li><a href="#">Aventura</a></li>
                  <li><a href="#">Ação</a></li>
                  <li><a href="#">Quadrinhos</a></li>
                  <li><a href="#">Ficção</a></li>
                </ul>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">E-books <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li class="dropdown-header">CATEGORIAS</li>
                  <li class="divider"></li>
                  <li><a href="#">Romance</a></li>
                  <li><a href="#">Comédia</a></li>
                  <li><a href="#">Aventura</a></li>
                  <li><a href="#">Ação</a></li>
                  <li><a href="#">Quadrinhos</a></li>
                  <li><a href="#">Ficção</a></li>
                </ul>
              </li>
              <li><a href="index.jsp">Informática</a></li>
              <li><a href="index.jsp">Jogos</a></li>
              <li><a href="index.jsp">Promoções</a></li>
            </ul>
            <form class="navbar-form navbar-left form2" action="sys" role="search">
                <button class="btn btn-default butaoPesquisa" type="submit">
                    <i class="glyphicon glyphicon-search"></i>
                </button>
                <div class="form-group">
                    <input class="input-large pesquisa" name="nome" maxlength="100" placeholder="O que você procura?" type="text"/>
                </div> 
                <input type="hidden" name="logica" value="ProdutoLogica">   
                <input type="hidden" name="action" value="listProd"> 
                    </form>
            <c:if test="${empty sessionScope.id}">
            <ul class="nav navbar-nav navbar-right">
              <li><a href="index.jsp?p=login"><span class="glyphicon glyphicon-user log" data-toggle="collapse"></span>Entre ou Cadastre-se!</a></li>
            </ul>
            </c:if>

            <c:if test="${not empty sessionScope.id}">
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
            </c:if>
            </nav>  
        


        <section>
            <c:choose>
                <c:when test="${param.p == 'inicioProd'}">
                    <c:set var="pagina" value="inicioProd.jsp"/>
                </c:when>   
                <c:when test="${param.p == 'descProduto'}">
                    <c:set var="pagina" value="descProduto.jsp"/>
                </c:when>   
                <c:when test="${param.p == 'cadProduto'}">
                    <c:set var="pagina" value="formProduto.jsp"/>
                </c:when>
                <c:when test="${param.p == 'cadCliente'}">
                    <c:set var="pagina" value="formCliente.jsp"/>
                </c:when>   
                <c:when test="${param.p == 'cadFuncionario'}">
                    <c:set var="pagina" value="formFuncionario.jsp"/>
                </c:when>   
                <c:when test="${param.p == 'login'}">
                    <c:set var="pagina" value="login.jsp"/>
                </c:when>   
                <c:when test="${param.p == 'loginFunc'}">
                    <c:set var="pagina" value="loginFunc.jsp"/>
                </c:when>   
                <c:when test="${param.p == 'indexFunc'}">
                    <c:set var="pagina" value="indexFunc.jsp"/>
                </c:when>   
                <c:when test="${param.p == 'relCliente'}">
                    <c:set var="pagina" value="reportCliente.jsp"/>
                </c:when>   
                <c:when test="${param.p == 'relFuncionario'}">
                    <c:set var="pagina" value="reportFuncionario.jsp"/>
                </c:when>     
                <c:otherwise>
                    <c:set var="pagina" value="inicio.jsp"/>
                </c:otherwise>
            </c:choose>
            <c:import url="${pagina}"></c:import>

        </section>
            
            
        
        
        <div class="container-fluid col-md-12 backgroundfooter">
            <div class="container fulter">
                <div class="col-md-12">                
                    <div class="col-md-3">
                        <h6 class="titlefooter">INSTITUCIONAL</h6><br>
                        <a href="" class="contfooter"> Sobre a Sarraiva.com.br </a><br>
                        <a href="" class="contfooter"> Política de Privacidade </a><br>
                        <a href="" class="contfooter"> Trabalhe Conosco </a><br>
                        <a href="index.jsp?p=loginFunc" class="contfooter"> Login Funcionário </a><br>
                    </div>
                    <div class="col-md-3">
                        <h6 class="titlefooter">AJUDA</h6><br>
                        <a href="" class="contfooter"> Entregas </a><br>
                        <a href="" class="contfooter"> FAQ </a><br>
                        <a href="" class="contfooter"> Tire suas dúvidas </a><br>
                    </div>

                    <div class="col-md-3">
                        <h6 class="titlefooter">FALE CONOSCO</h6><br>
                        <a href="" class="contfooter"> Envie-nos uma mensagem </a><br>
                        <a href="" class="contfooter"> Contatos </a><br>
                        <a href="" class="contfooter"> Sugestões: tips@sarraiva.com.br </a><br>
                    </div>
                    <div class="col-md-3">
                        <h6 class="titlefooter">CENTRAL DE RELACIONAMENTO</h6><br>
                        <h6 class="hfooter">Telefone<br></h6> 
                        <h5 class="contfooter"> (21)4202-8922<br><br></h5>
                        <h6 class="hfooter">E-mail<br></h6> 
                        <h5 class="contfooter">centralrel@sarraiva.com.br<br></h5>
                    </div>
                </div>


                <div class="col-md-12">
                    <div class="col-md-6 teste">
                        <table>
                            <h6 class="titlefooter">FORMAS DE PAGAMENTO</h6>
                            <tr>
                                <td class="imgfooter">
                                    <img src="imagens/b1.png">
                                </td>
                                <td class="imgfooter">
                                    <img src="imagens/b2.png">
                                </td>
                                <td class="imgfooter">
                                    <img src="imagens/b3.png">
                                </td>
                                <td class="imgfooter">
                                    <img src="imagens/b4.png">
                                </td>
                            </tr>

                            <tr>
                                <td class="imgfooter">
                                    <img src="imagens/b5.png">
                                </td>
                                <td class="imgfooter">
                                    <img src="imagens/b6.png">
                                </td>
                                <td class="imgfooter">
                                    <img src="imagens/b7.png">
                                </td>
                                <td class="imgfooter">
                                    <img src="imagens/b8.png">
                                </td>
                            </tr>

                        </table>
                    </div>
                </div>





                <div class="col-md-12 rfooter">
                    <h5 class="rcfooter">
                        As ofertas são válidas por tempo determinado e/ou enquanto durarem os estoques. Nosso serviço de entregas não permite encomendas feitas com endereçamento de Caixa Postal.
                        *As ligações efetuadas para o nosso Televendas possui custo de telefonema local, acrescido de imposto local, conforme Estado de origem.
                        Essa tarifa de ligação para o Televendas não é valida para ligações realizadas com DDD.

                        Sarraiva.com.br é uma empresa do grupo Sarraiva e Wesley Sarradão S.A., CNPJ nº 74.015.784/4571-04, Rua Sem Asfalto, nº 22, Queimados – RJ.</h5>
                </div>
            </div>
        </div>
        
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
     
    </body>
</html>
