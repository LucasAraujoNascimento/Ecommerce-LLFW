<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../css/add.css">
<title>Administrador</title>
</head>
<body>
	
	<%@ include file="../../includes/menuAdm.jsp" %>


    <main>
        <section class="form-container">
            <form action="${pageContext.request.contextPath}/CadastrarProduto" method="post">
                <h2>Cadastro de Produto</h2>
                
                <label for="nome">Nome do Produto:</label>
                <input type="text" id="nome" name="nome" required>
                
                <label for="marca">Marca do Produto:</label>
                <input type="text" id="marca" name="marca" required>
                
                <label for="modelo">Modelo do Produto:</label>
                <input type="text" id="modelo" name="modelo" required>
                
                <label for="estoque">Quantidade em Estoque:</label>
                <input type="text" id="estoque" name="estoque" required>

                <label for="descricao">Descrição do Produto:</label>
                <input type="text" id="descricao" name="descricao" required>

                <label for="valor">Valor do Produto:</label>
                <input type="text" id="valor" name="valor" step="0.01" required>


                <button type="submit">Cadastrar Produto</button>
            </form>
        </section>
    </main>



    <%@ include file="../../includes/footer.jsp" %>


</body>
</html>