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
<link rel="stylesheet" type="text/css" href="css/editaProduto.css">
<title>LLFW Artigos Esportivos</title>
</head>
<body>
    
    <%@ include file="includes/menuIndex.jsp" %>
    
    <div class="container-banners">
        <div class="imagem"><a href="#"><img src="img/2.png" alt="banner2"></a></div>
    </div>

    <div class="linha-divisao"><hr></div>
    
    
    <div class="container-produtos">
    	   	<%for (Produtos produto : listaProdutos) {%>
	    <div class="card-produto">
	        <img src="img/img produtos/<%= produto.getId() %>.jpeg" alt="<%= produto.getNome() %>">
	        <h3><%= produto.getNome() %></h3>
	        <p>R$<%= produto.getValor() %></p>
	        <p><%= produto.getDescricao() %></p>
	        <div class="botoes">
	        <button class="btn-comprar">Comprar</button>
	        	
	        	<a href="CriaCarrinho?id=<%=produto.getId()%>&nome=<%=produto.getNome()%>&valor=<%=produto.getValor()%>">
	            <button class="btn-carrinhoDois">Carrinho</button>
	            </a>
	            
	        </div>
	    </div>
	    <% } %>
	</div>

    <%@ include file="includes/footer.jsp" %>


</body>
</html>