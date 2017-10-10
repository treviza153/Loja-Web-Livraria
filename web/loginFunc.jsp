<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">
    
    <c:import url="msg.jsp"/>  
    
    <div class="col-lg-12">
        <div class="col-md-4"></div>
        <h2 class="col-md-4 logFunc">Identificação Funcionário</h2>
        <div class="col-md-4"></div>
    </div>
    <div class="col-lg-12 logFunc2">
        <div class="col-md-4"></div>
        <div class="container col-md-4">
            <form action="sys" method="POST" class="form">
                <input type="hidden" name="action" value="log">
                <input type="hidden" name="logica" value="FuncionarioLogica">

                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input type="email" class="form-control" name="email" placeholder="Email" value="${funcionario.email}">
                </div>
                    <br>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="password" type="password" class="form-control" name="pws" placeholder="Password">
                </div>
                <div class="form-group checkbox logFunc3">  
                    <label><input type="checkbox" name="remember"> Lembrar de mim</label>
                    <p class="pull-right"><a href="index.jsp?p=esqueci">Esqueci minha senha!</a></p>
                </div>
                <div class="form-group">
                    <button class="btn btn-group-justified"> Confirmar </button>
                </div>
            </form>     
        </div>
    <div class="col-md-4"></div>
</div>