package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOProdutos;
import model.Produtos;


@WebServlet("/AtualizaProduto")
public class AtualizaProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO.DAOProdutos dao = new DAOProdutos();

    public AtualizaProduto() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String estoque = request.getParameter("estoque");
		String descricao = request.getParameter("descricao");
		String valor = request.getParameter("valor");
		
		Produtos produtos = new Produtos();
		
		produtos.setNome(nome);
		produtos.setMarca(marca);
		produtos.setModelo(modelo);
		produtos.setEstoque(estoque);
		produtos.setDescricao(descricao);
		produtos.setValor(valor);
		
		try {
			dao.atualizaUsuario(produtos, id);
			response.sendRedirect(request.getContextPath() + "/views/adm/editaProdutos.jsp");
		} catch (Exception e) {
			response.getWriter().println("Erro ao atualizar o produto no banco de dados.");
		}
		
		
	}

}
