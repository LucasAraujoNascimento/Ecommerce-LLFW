package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOUsuarios;


@WebServlet("/DeleteUsuario")
public class DeleteUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAOUsuarios dao = new DAOUsuarios();

    public DeleteUsuario() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			dao.deleteUsuario(id);
			response.sendRedirect(request.getContextPath() + "/views/adm/editaUsuarios.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Erro ao excluir o produto no banco de dados.");
		}

	}




}
