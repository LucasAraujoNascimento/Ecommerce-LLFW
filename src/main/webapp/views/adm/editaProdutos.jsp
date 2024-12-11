<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="DAO.DAOProdutos" %>
<%@ page import="model.Produtos" %>

<%
	DAO.DAOProdutos dao = new DAO.DAOProdutos();
    List<Produtos> listaProdutos = dao.listarProdutos();
%>
    
    
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../css/editaProduto.css">
<title>Administrador</title>
</head>
<body>

	<%@ include file="../../includes/menuAdm.jsp" %>

	<div class="container-produtos">
    	   	<%for (Produtos produto : listaProdutos) {%>
	    <div class="card-produto">
	        <img src="../../img/img produtos/<%= produto.getId() %>.jpeg" alt="<%= produto.getNome() %>">
	        <h3><%= produto.getNome() %></h3>
	        <p>R$<%= produto.getValor() %></p>
	        <p><%= produto.getDescricao() %></p>
	        <div class="botoes">
	            <button class="btn-comprar"><a href="${pageContext.request.contextPath}/views/adm/atualizaProduto.jsp?id=<%=produto.getId()%>">Editar</a></button>
	            <button class="btn-carrinho"><a href="${pageContext.request.contextPath}/DeleteProduto?id=<%=produto.getId()%>">Excluir</a></button>
	        </div>
	    </div>
	    <% } %>
	</div>
    

    <%@ include file="../../includes/footer.jsp" %>

</body>
</html>