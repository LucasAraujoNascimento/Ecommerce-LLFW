<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Relatório</title>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
</head>
<body>
    <%@ include file="../../includes/menu.jsp" %>
    <h2>Compra Realizada com Sucesso!</h2>
    <p>Total da compra: R$<%= request.getAttribute("total") %></p>
    <a href="index.jsp"><button>Voltar à loja</button></a>
    <%@ include file="../../includes/footer.jsp" %>
</body>
</html>
