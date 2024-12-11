package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOProdutos;



@WebServlet("/DeleteProduto")
public class DeleteProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOProdutos dao = new DAOProdutos();

    public DeleteProduto() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			dao.deletaProduto(id);
			response.sendRedirect(request.getContextPath() + "/views/adm/editaProdutos.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Erro ao deletar o produto no banco de dados.");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
