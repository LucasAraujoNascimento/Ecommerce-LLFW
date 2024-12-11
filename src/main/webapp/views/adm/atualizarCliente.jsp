<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="DAO.DAOUsuarios" %>
<%@ page import="model.Usuario" %>

<% 	
	int id = Integer.parseInt(request.getParameter("id"));
	DAOUsuarios dao = new DAOUsuarios();
	Usuario usuario = dao.listaUm(id);
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../css/add.css">
<title>Atualizar Cliente</title>
</head>
<body>
	
	<%@ include file="../../includes/menuAdm.jsp" %>
	
	
	<main>

		<section class="form-container">
			<form action="${pageContext.request.contextPath}/AtualizaUsuario" method="post">
				<h2>Atualizar Cliente</h2>
		        <input type="hidden" name="id" value="<%=usuario.getId()%>">
		        
		        <label for="admin">Admin: </label>
					<select class="adm" name="admin" id="admin">
					    <option value="false">Usuário</option>
		    			<option value="true">Administrador</option>
					</select>

		        
		        <label for="nome">Nome: </label>
		        <input type="text" name="nome" value="<%=usuario.getNome()%>">

		        
		        <label for="sobrenome">Sobrenome: </label>
		        <input type="text" name="sobrenome" value="<%=usuario.getSobrenome()%>">

		        
		        <label for="email">Email: </label>
		        <input type="text" name="email" value="<%=usuario.getEmail()%>">

		        
		        <label for="celular">Celular: </label>
		        <input type="text" name="celular" value="<%=usuario.getCelular()%>">

		        
		        <label>Gênero:</label><br>
		
				<input type="radio" name="genero" value="masculino" id="genero-masculino">
				<label for="genero-masculino">Masculino</label><br>
				
				<input type="radio" name="genero" value="feminino" id="genero-feminino">
				<label for="genero-feminino">Feminino</label><br>
				
				<input type="radio" name="genero" value="outros" id="genero-outros">
				<label for="genero-outros">Outros</label><br>
				
				<input type="radio" name="genero" value="none" id="genero-none">
				<label for="genero-none">Prefiro não responder</label>
				<br>

		        <label for="estado">Estado: </label>
		        <input type="text" name="estado" value="<%=usuario.getEstado()%>">

		        <label for="cidade">Cidade: </label>
		        <input type="text" name="cidade" value="<%=usuario.getCidade()%>">

		         <label for="rua">Rua: </label>
		        <input type="text" name="rua" value="<%=usuario.getRua()%>">

		        <button type="submit" value="Atualizar">Atualizar</button>
		        <br>
		        <button type="button" value="Cancelar" onclick="window.location.href='editaUsuarios.jsp';"/>Cancelar</button>
		
		    </form>
    	</section>
    </main>
    
    <%@ include file="../../includes/footer.jsp" %>
    
    
</body>
</html>