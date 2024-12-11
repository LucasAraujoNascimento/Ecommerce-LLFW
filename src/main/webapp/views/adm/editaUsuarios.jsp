<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="DAO.DAOUsuarios"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Usuario" %>


<%


    DAOUsuarios dao = new DAOUsuarios();
	Usuario usuario = new Usuario();
    List<Usuario> listaUsuarios = dao.listarUsuario();

%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../css/editaUsuario.css">
<title>Edita Usuário</title>
</head>
<body>
   
   		<%@ include file="../../includes/menuAdm.jsp" %>

    <div class="usuarios">
        <h2>Usuários Cadastrados</h2>
        <table border="1" cellspacing="0" cellpadding="5">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Admin</th>
                    <th>Nome</th>
                    <th>Sobrenome</th>
                    <th>Email</th>
                    <th>Celular</th>
                    <th>Genero</th>
                    <th>Estado</th>
                    <th>Cidade</th>
                    <th>Rua</th>
                </tr>
            </thead>
            <tbody>
            <% for(Usuario usuarios : listaUsuarios) {%>
                <tr>
                    <td><c:out value="<%=usuarios.getId()%>" /></td>
                    <td><c:out value="<%=usuarios.isAdmin()%>" /></td>
                    <td><c:out value="<%=usuarios.getNome()%>" /></td>
                    <td><c:out value="<%=usuarios.getSobrenome()%>" /></td>
                    <td><c:out value="<%=usuarios.getEmail()%>" /></td>
                    <td><c:out value="<%=usuarios.getCelular()%>" /></td>
                    <td><c:out value="<%=usuarios.getGenero()%>" /></td>
                    <td><c:out value="<%=usuarios.getEstado()%>" /></td>
                    <td><c:out value="<%=usuarios.getCidade()%>" /></td>
                    <td><c:out value="<%=usuarios.getRua()%>" /></td>
                    <td><a href="atualizarCliente.jsp?id=<%=usuarios.getId()%>">Editar</a></td>
                    <td><a href="${pageContext.request.contextPath}/DeleteUsuario?id=<%= usuarios.getId() %>">Excluir</a></td>
                </tr>
              <% } %>
            </tbody>
        </table>
    </div>

	<%@ include file="../../includes/footer.jsp" %>


</body>
</html>