<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="msg.jsp"></c:import>

    <form action="sys" method="post" class="container well" enctype="multipart/form-data">
        <!--Envio de logica e action via POST-->
        <input type="hidden" name="logica" value="ProdutoLogica"> 
    <c:if test="${empty alt}">
        <input type="hidden" name="action" value="cad"> 
    </c:if>
    <c:if test="${not empty alt}">
        <input type="hidden" name="action" value="alt"> 
        <input type="hidden" name="id" value="${produto.id}">         
    </c:if>    

    <fieldset class="form-group">
        <legend>Dados do Produto</legend>
        <label> Nome </label>
        <input type="text" name="nome" class="form-control" value="${produto.nome}" autofocus>
        <label> Descrição </label>
        <textarea name="descricao" class="form-control" value="${produto.descricao}" autofocus></textarea>
        <label> Quant. Min </label>
        <input type="number" name="quantmin" min="0" class="form-control" value="${produto.quantMin}">
        <label> Quant. Max </label>
        <input type="number" name="quantmax" min="0" class="form-control" value="${produto.quantMax}">
        <label> Quant. Atual </label>
        <input type="number" name="quantatual" min="0" class="form-control" value="${produto.quantAtual}">
        <label> Valor </label>
        <input type="number" name="valor" min="0.0" step="0.01" class="form-control" value="${produto.valor}">
        <label> Foto 1 </label>
        <input type="file" name="foto1" class="form-control" value="${produto.foto1}" >
        <label> Foto 2 </label>
        <input type="file" name="foto2" class="form-control" value="${produto.foto2}">
        <label> Foto 3 </label>
        <input type="file" name="foto3" class="form-control" value="${produto.foto3}">
    </fieldset>

    <fieldset class="form-group">
        <label> Status: </label>
        <div class="radio-inline">
            <label><input type="radio" name="ativo" class="" checked value="1"> Ativo  </label>
        </div>
        <div class="radio-inline">
            <label><input type="radio" name="ativo" class="" value="0"> Bloqueado  </label>
        </div>
    </fieldset>
    <p class="form-group">
        <button class="btn btn-primary">Cadastrar</button>
        <button class="btn btn-primary" onclick="history.back()">Cancelar</button>
    </p>
</form>
