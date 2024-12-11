package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOProdutos;
import model.Produtos;

@WebServlet("/CadastrarProduto")
public class CadastrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DAOProdutos dao = new DAOProdutos();

    public CadastrarProduto() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Método GET não é suportado.");
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			dao.cadastrarProdutos(produtos);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().println("Erro ao cadastrar o Produto no banco de dados.");
		}
		
		
		
	}

}
