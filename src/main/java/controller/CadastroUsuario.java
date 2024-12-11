package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOUsuarios;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;


@WebServlet("/CadastroUsuario")
public class CadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAOUsuarios dao = new DAOUsuarios();
	

    public CadastroUsuario() {
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String email = request.getParameter("email");
		String numero = request.getParameter("numero");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String rua = request.getParameter("rua");
		String genero = request.getParameter("genero");
		String senha = request.getParameter("senha");
		

		Usuario usuario = new Usuario();
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
			dao.cadastrarUsuario(usuario);
			response.sendRedirect(request.getContextPath() + "/views/usuario/login.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			response.getWriter().println("Erro ao cadastrar o usuário no banco de dados.");
		}


	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Método GET não é suportado.");
        
    }
	

}
