<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="dao" class="br.com.projetoloja.controller.CtrlProduto"/>
<c:import url="msg.jsp"></c:import>

<br>
<div class="container">
    
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
          <!-- Indicators -->
          <ol class="carousel-indicators">
            <li data-target="#" data-slide-to="0" class="active"></li>
            <li data-target="#" data-slide-to="1"></li>
            <li data-target="#" data-slide-to="2"></li>
          </ol>

          <!-- Wrapper for slides -->
          <div class="carousel-inner">
            <div class="item active">
              <img class="d-block img-fluid" src="imagens/slide1.jpg" alt="">
            </div>

            <div class="item">
              <img class="d-block img-fluid" src="imagens/slide2.jpg" alt="">
            </div>

            <div class="item">
              <img class="d-block img-fluid" src="imagens/slide3.jpg" alt="">
            </div>
          </div>

          <!-- Left and right controls -->
          <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
   
</div>
<br>
<div class="container prod">
        <div class="row">     
          <c:forEach items="${dao.listar('')}" var="p">
            <div class="col-md-2 prod2">
               <a href="sys?logica=ProdutoLogica&action=desc&id=${p.id}">
                <img class="img-responsive" src="img/${p.foto1}" title="" alt="">
                <h2 class="nome"><b>${p.nome}</b></h2> 
                </a>
                <h4 class="valor">
                    R$
                    <f:formatNumber minFractionDigits="2" currencySymbol="R$">
                        ${p.valor}
                    </f:formatNumber>
                </h4>
               
            </div>
          </c:forEach>
        </div>
</div>
         

<br>