package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOUsuarios;
import model.Usuario;


@WebServlet("/AtualizaUsuario")
public class AtualizaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DAO.DAOUsuarios dao = new DAOUsuarios();

    public AtualizaUsuario() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String email = request.getParameter("email");
		String numero = request.getParameter("celular");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String rua = request.getParameter("rua");
		String genero = request.getParameter("genero");
		String senha = request.getParameter("senha");
		

		Usuario usuario = new Usuario();
		usuario.setAdmin(admin);
		usuario.setNome(nome);
		usuario.setSobrenome(sobrenome);
		usuario.setEmail(email);
		usuario.setCelular(numero);
		usuario.setEstado(estado);
		usuario.setCidade(cidade);
		usuario.setRua(rua);
		usuario.setGenero(genero);
		usuario.setSenha(senha);
		

		try {
			dao.atualizaUsuario(usuario, id);
			response.sendRedirect(request.getContextPath() + "/views/adm/editaUsuarios.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			response.getWriter().println("Erro ao cadastrar o usuário no banco de dados.");
		}
		
		
	}

}
