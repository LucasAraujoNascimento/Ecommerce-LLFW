package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrinho;

@WebServlet("/CriaCarrinho")
public class CriaCarrinho extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CriaCarrinho() {
        super();
    }

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        List<Carrinho> carrinhoList = (List<Carrinho>) session.getAttribute("carrinhoList");

        if (carrinhoList == null) {
            carrinhoList = new ArrayList<>();
            session.setAttribute("carrinhoList", carrinhoList);
        }

        try {
            if ("limpar".equalsIgnoreCase(action)) {
                carrinhoList.clear();
                response.sendRedirect(request.getContextPath() + "/views/carrinho/carrinho.jsp");
                return;
            }

            if ("remover".equalsIgnoreCase(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                carrinhoList.removeIf(item -> item.getIdProduto() == id);
                response.sendRedirect(request.getContextPath() + "/views/carrinho/carrinho.jsp");
                return;
            }

            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            double valor = Double.parseDouble(request.getParameter("valor"));

            Carrinho itemExistente = carrinhoList.stream()
                .filter(item -> item.getIdProduto() == id)
                .findFirst()
                .orElse(null);

            if (itemExistente != null) {
                int novaQuantidade = Integer.parseInt(itemExistente.getQuantidade()) + 1;
                itemExistente.setQuantidade(String.valueOf(novaQuantidade));
            } else {
                Carrinho novoItem = new Carrinho();
                novoItem.setIdProduto(id);
                novoItem.setNome(nome);
                novoItem.setPreco(String.valueOf(valor));
                novoItem.setQuantidade("1");
                carrinhoList.add(novoItem);
            }

            response.sendRedirect(request.getContextPath() + "/views/carrinho/carrinho.jsp");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/views/carrinho/erro.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
