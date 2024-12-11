package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAOUsuarios;
import model.Usuario;


@WebServlet("/LoginUsuario")
public class LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DAOUsuarios dao = new DAOUsuarios();

    public LoginUsuario() {
        super();
        
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("password");
		
		try {
			Usuario usuario = dao.verificaLogin(email, senha);
			if(usuario != null) {
				 HttpSession session = request.getSession();
	             session.setAttribute("usuarioLogado", usuario);
	             response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("views/usuario/login.jsp?erro=1");
				}
	        }catch (SQLException e) {
	            e.printStackTrace();
	            response.getWriter().println("Erro ao verificar o login no banco de dados.");
		}
	}
	
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.sendRedirect("views/usuario/login.jsp");
	    }
	
	
	
}