<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../../css/cadastro.css">
<title>Formulário de Cadastro</title>
</head>
<body>
    <div class="container">
        <div class="form-image">
            <a href="${pageContext.request.contextPath}/index.jsp"><img src="../../img/CADASTRE-SE.png" alt="desconto"></a>
        </div>
        <div class="form">
            <form action="${pageContext.request.contextPath}/CadastroUsuario" method="post">
                <div class="form-header">
                    <div class="title">
                        <h1>Cadastre-se</h1>
                    </div>
                    <div class="login-button">
                        <button><a href="login.jsp">Entrar</a></button>
                    </div>
                </div>

                <div class="input-group">
                    <div class="input-box">
                        <label for="nome">Primeiro Nome</label>
                        <input id="nome" type="text" name="nome" placeholder="Digite seu primeiro nome" required>
                    </div>

                    <div class="input-box">
                        <label for="sobrenome">Sobrenome</label>
                        <input id="sobrenome" type="text" name="sobrenome" placeholder="Digite seu sobrenome" required>
                    </div>
                    <div class="input-box">
                        <label for="email">E-mail</label>
                        <input id="email" type="email" name="email" placeholder="Digite seu e-mail" required>
                    </div>

                    <div class="input-box">
                        <label for="numero">Celular</label>
                        <input id="numero" type="tel" name="numero" placeholder="(xx) xxxx-xxxx" required>
                    </div>

                    <div class="input-box">
                        <label for="estado">Estado</label>
                        <input id="estado" type="text" name="estado" placeholder="Digite seu estado" required>
                    </div>

                    <div class="input-box">
                        <label for="cidade">Cidade</label>
                        <input id="cidade" type="text" name="cidade" placeholder="Digite sua cidade" required>
                    </div>

                    <div class="input-box">
                        <label for="rua">Rua</label>
                        <input id="rua" type="text" name="rua" placeholder="Digite sua rua" required>
                    </div>

                    <div class="input-box">
                        <label for="senha">Senha</label>
                        <input id="senha" type="password" name="senha" placeholder="Digite sua senha" required>
                    </div>

                </div>

                <div class="gender-inputs">
                    <div class="gender-title">
                        <h6>Gênero</h6>
                    </div>

                    <div class="gender-group">
                        <div class="gender-input">
                            <input id="masculino" type="radio" name="genero" value="masculino">
                            <label for="masculino">Masculino</label>
                        </div>

                        <div class="gender-input">
                            <input id="feminino" type="radio" name="genero" value="feminino">
                            <label for="feminino">Feminino</label>
                        </div>

                        <div class="gender-input">
                            <input id="outros" type="radio" name="genero" value="outros">
                            <label for="outros">Outros</label>
                        </div>

                        <div class="gender-input">
                            <input id="none" type="radio" name="genero" value="none">
                            <label for="none">Prefiro não dizer</label>
                        </div>
                    </div>
                </div>

                <div class="continue-button">
                    <button type="submit"><p style="color:white;">Cadastrar</p></button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>