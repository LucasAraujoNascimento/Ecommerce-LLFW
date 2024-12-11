<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../../css/login.css">
<title>Formulário de Login</title>
</head>
<body>
	<div class="container">
        <div class="form-image">
            <a href="${pageContext.request.contextPath}/index.jsp"><img src="../../img/BEMVINDO.png" alt="desconto"></a>
        </div>
        <div class="form">
            <form action="${pageContext.request.contextPath}/LoginUsuario" method="post">
                <div class="form-header">
                    <div class="title">
                        <h1>Entrar</h1>
                    </div>
                    <div class="login-button">
                        <button><a href="cadastro.jsp">Cadastrar</a></button>
                    </div>
                </div>

                <div class="input-group">

                    <div class="input-box">
                        <label for="email">E-mail</label>
                        <input id="email" type="email" name="email" placeholder="Digite seu e-mail" required>
                    </div>


                    <div class="input-box senha">
                        <label for="senha">Senha</label>
                        <input id="senha" type="password" name="password" placeholder="Digite sua senha" required>
                    </div>

                </div>


                <div class="continue-button">
                    <button type="submit"><p style="color:white;">Entrar</p></button>
                </div>
            </form>
            
            <c:if test="${param.erro == '1'}">
                <p style="color:red; margin-top:10px">Email ou senha incorretos!</p>
            </c:if>
            
        </div>
    </div>
</body>
</html>