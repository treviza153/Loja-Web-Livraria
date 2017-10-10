<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="msg.jsp"></c:import>
    
<div class="container prod"> 
    <div class="row">
        <div class="thumbnail col-md-12 desc">
                <img class="img-responsive imgProd" src="img/${produto.foto1}" title="" alt="">
                <div class="col-md-6">
                    <h2 class="nome"><b>${produto.nome}</b></h2> 
                    <h4 class="descricao text-justified">${produto.descricao}</h4>
                </div>
                
                
                <div class="col-md-6">
                    <h1 class="pull-right text-success">
                        R$
                        <f:formatNumber minFractionDigits="2" currencySymbol="R$">
                            ${produto.valor}
                        </f:formatNumber>
                        <br><br><br><button type="submit" class="btn btn-success pull-right"> COMPRAR </button>
                    </h1>
                    
                </div>
            </div>
            </div>
    </div>
