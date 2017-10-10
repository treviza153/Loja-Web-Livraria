<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="msg.jsp"></c:import>

<br>
<br>
<div class="container-fluid">
        <div class="row">     
          <c:forEach items="${produtos}" var="p">
            <div class="card thumbnail col-md-2">
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