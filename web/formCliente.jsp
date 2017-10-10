<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">
    
    <div class="col-lg-12 menuForm">
        <div class="col-md-5"></div>
        <div class="col-md-2">
        <c:import url="msg.jsp"/>
        </div>
        <div class="col-md-5"></div>
    </div>
    
        <div class="col-lg-12">
            <div class="col-md-2"></div>
            <h2 class="col-md-8 menuForm2">Cadastre-se!</h2>
            <div class="col-md-2"></div>
        </div>
        <div class="col-lg-12 menuForm3">
            <div class="col-md-2"></div>
            <div class="col-md-8">
            <form action="sys" method="POST">
                <input type="hidden" name="action" value="cad">
                <input type="hidden" name="logica" value="ClienteLogica">
                <div class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" name="nome" class="form-control" value="${cliente.nome}">
                </div>
                <div class="form-group">
                    <label for="email">E-mail</label>
                    <input type="email" name="email" class="form-control" value="${cliente.email}">
                </div>
                <div class="form-group">
                    <label for="cep">CEP</label>
                    <input type="text" name="cep" class="form-control" onblur="pesquisacep(this.value)" id="cep" value="${cliente.endereco.cep}">
                </div>
                <div class="form-group">
                    <label for="logradouro">Endere�o</label>
                    <input type="text" name="logradouro" class="form-control" id="rua" value="${cliente.endereco.logradouro}">
                </div>
                <div class="form-group">
                    <label for="bairro">Bairro</label>
                    <input type="text" name="bairro" class="form-control" id="bairro" value="${cliente.endereco.bairro}">
                </div>
                <div class="form-group">
                    <label for="Cidade">Cidade</label>
                    <input type="text" name="cidade" class="form-control" id="cidade" value="${cliente.endereco.cidade}">
                </div>
                <div class="form-group">
                    <label for="uf">Estado</label>
                    <input type="text" name="uf" class="form-control" id="uf" value="${cliente.endereco.uf}">
                </div>
                <div class="form-group">
                    <label for="numero">Numero</label>
                    <input type="text" name="numero" class="form-control" value="${cliente.numero}">
                </div>
                <div class="form-group">
                    <label for="complemnto">Complemento</label>
                    <input type="text" name="complemento" class="form-control" value="${cliente.complemento}">
                </div>
                <div class="form-group">
                    <label for="pws1">Senha</label>
                    <input type="password" name="pws1" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pws2">Confirma��o de Senha</label>
                    <input type="password" name="pws2" class="form-control">
                </div>

                <div class="form-group">
                    <button class="btn btn-primary">Salvar</button>
                    <button type="reset" class="btn btn-danger" onclick="history.back()">Cancelar</button>
                </div>


            </form>
            <script src="js/ceps.js"></script>
        </div>
                <div class="col-md-2"></div>
        </div>
</div>
            