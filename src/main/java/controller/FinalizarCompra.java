package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CompraDAO;
import model.Carrinho;
import model.Compra;
import model.Usuario;

@WebServlet("/FinalizarCompra")
public class FinalizarCompra extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Carrinho> carrinhoList = (List<Carrinho>) session.getAttribute("carrinhoList");
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        if (carrinhoList == null || carrinhoList.isEmpty() || usuario == null) {
            response.sendRedirect("views/carrinho/carrinho.jsp");
            return;
        }

        CompraDAO compraDAO = new CompraDAO();

        for (Carrinho item : carrinhoList) {
            Compra compra = new Compra();
            compra.setIdUsuario(usuario.getId());
            compra.setIdProduto(item.getIdProduto());
            compra.setNomeProduto(item.getNome());
            compra.setValorProduto(item.getPreco());
            compra.setQuantidade(item.getQuantidade());

            compraDAO.salvarCompra(compra);
        }

        carrinhoList.clear();
        session.setAttribute("carrinhoList", carrinhoList);

        response.sendRedirect("views/carrinho/sucesso.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
