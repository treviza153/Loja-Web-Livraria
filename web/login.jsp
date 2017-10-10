<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">
    
    <c:import url="msg.jsp"/>  
    
    <div class="col-lg-12">
        <div class="col-md-2"></div>
        <h2 class="col-md-8 menuLog">Identifica��o</h2>
        <div class="col-md-2"></div>
    </div>
    <div class="col-lg-12 menuLog2">
        <div class="col-md-2"></div>
        <div class="container col-md-3">
            <form action="sys" method="POST" class="form">
                <input type="hidden" name="action" value="log">
                <input type="hidden" name="logica" value="ClienteLogica">
                <legend>J� tenho cadastro</legend>

                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input type="email" class="form-control" name="email" placeholder="Email" value="${cliente.email}">
                </div>
                    <br>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="password" type="password" class="form-control" name="pws" placeholder="Password">
                </div>
                <div class="form-group checkbox menuLog3">  
                    <label><input type="checkbox" name="remember"> Lembrar de mim</label>
                    <p class="pull-right"><a href="index.jsp?p=esqueci">Esqueci minha senha!</a></p>
                </div>
                <div class="form-group">
                    <button class="btn btn-group-justified"> Confirmar </button>
                </div>
            </form>     
        </div>

                <div class="col-md-1"></div>
                
        <div class="container col-md-4" style="">
            <form action="ServletCliente" method="POST" class="form">
                <legend>N�o tenho cadastro</legend>
                <div class="form-group">
                    <h5 class="menuLog4">Para comprar em nosso site � preciso realizar um cadastro. Atrav�s dele voc� far� parte do Programa de Fidelidade Sarraiva Plus. E tamb�m ficar� por dentro das novidades, ofertas e promo��es.</h5>
                </div>
                <div class="form-group menuLog5">
                    <a  class="btn btn-group-justified" href="index.jsp?p=cadCliente"> Criar cadastro </a>
                </div>
            </form>
        </div>
        <div class="col-md-2"></div>
    </div>
<script src="js/ceps.js"></script>
</div>