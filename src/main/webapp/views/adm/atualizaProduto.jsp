<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="DAO.DAOProdutos"%>
<%@ page import="model.Produtos"%>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	DAOProdutos dao = new DAOProdutos();
	Produtos produto = dao.listaUm(id);%>

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
            <form action="${pageContext.request.contextPath}/AtualizaProduto" method="post">
                <h2>Atualiza Produto</h2>
                <input type="hidden" name="id" value="<%=produto.getId()%>">
                
                <label for="nome">Nome do Produto:</label>
                <input type="text" id="nome" name="nome" value="<%=produto.getNome()%>" required>
                
                <label for="marca">Marca do Produto:</label>
                <input type="text" id="marca" name="marca" value="<%=produto.getMarca()%>" required>
                
                <label for="modelo">Modelo do Produto:</label>
                <input type="text" id="modelo" name="modelo" value="<%=produto.getModelo()%>" required>
                
                <label for="estoque">Quantidade em Estoque:</label>
                <input type="text" id="estoque" name="estoque" value="<%=produto.getEstoque()%>" required>

                <label for="descricao">Descrição do Produto:</label>
                <input type="text" id="descricao" name="descricao" value="<%=produto.getDescricao()%>" required>

                <label for="valor">Valor do Produto:</label>
                <input type="text" id="valor" name="valor" step="0.01" value="<%=produto.getValor()%>" required>


                <button type="submit">Atualizar Produto</button>
            </form>
        </section>
    </main>



    <%@ include file="../../includes/footer.jsp" %>


</body>
</html>