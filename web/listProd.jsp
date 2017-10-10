<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="dao" class="br.com.projetoloja.controller.CtrlProduto"/>
<c:import url="msg.jsp"></c:import>

<br>
<div class="container prod">
        <div class="row">     
          <c:forEach items="${dao.listar('')}" var="p">
            <div class="col-md-2 prodd">
                <img class="img-responsive" src="img/${p.foto1}" title="" alt="">
                <h2 class="nome"><b>${p.nome}</b></h2> 
                </a>
                <h4 class="valor">
                    R$
                    <f:formatNumber minFractionDigits="2" currencySymbol="R$">
                        ${p.valor}
                    </f:formatNumber>
                </h4>
                <a href="sys?logica=ProdutoLogica&action=edit&id=${p.id}" class="btn btn-primary">Editar</a>
                <a href="sys?logica=ProdutoLogica&action=remove&id=${p.id}" class="btn btn-danger">Remover</a>
               
            </div>
          </c:forEach>
        </div>
</div>
         

<br>