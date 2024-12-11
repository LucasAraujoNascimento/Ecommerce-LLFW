<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Carrinho" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../../css/editaUsuario.css">
    <title>Carrinho de Compras</title>
</head>
<body>
    <%@ include file="../../includes/menu.jsp" %>

    <div class="container-carrinho">
    <br>
        <h2>Seu Carrinho</h2>
        <table border="1">
            <tr>
                <th>Produto</th>
                <th>Quantidade</th>
                <th>Preço Unitário</th>
                <th>Subtotal</th>
                <th>Ações</th>
            </tr>
            <% 
                List<Carrinho> carrinhoList = (List<Carrinho>) session.getAttribute("carrinhoList");
                double total = 0;

                if (carrinhoList != null && !carrinhoList.isEmpty()) {
                    for (Carrinho item : carrinhoList) {
                        double subtotal = Double.parseDouble(item.getPreco()) * Integer.parseInt(item.getQuantidade());
                        total += subtotal;
            %>
            <tr>
                <td><%= item.getNome() %></td>
                <td><%= item.getQuantidade() %></td>
                <td>R$<%= item.getPreco() %></td>
                <td>R$<%= String.format("%.2f", subtotal) %></td>
                <td>
                    <a href="${pageContext.request.contextPath}/CriaCarrinho?action=remover&id=<%= item.getIdProduto() %>">Remover</a>
                </td>
            </tr>
            <% 
                    }
                } else {
            %>
            <tr>
                <td colspan="5">Carrinho vazio!</td>
            </tr>
            <% } %>
        </table>
        <h3>Total: R$<%= String.format("%.2f", total) %></h3>
        <div>
            <a href="${pageContext.request.contextPath}/CriaCarrinho?action=limpar">Limpar Carrinho</a>
            <a href="${pageContext.request.contextPath}/index.jsp">Continuar Comprando</a>
            <a href="${pageContext.request.contextPath}/FinalizarCompra">Finalizar Compra</a>
        </div>
    </div>
	<br>
    <%@ include file="../../includes/footer.jsp" %>
</body>
</html>
