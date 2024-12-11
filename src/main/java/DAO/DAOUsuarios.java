package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import utils.ConnectionFactory;

public class DAOUsuarios {

	ConnectionFactory connection = new ConnectionFactory();
	
	public boolean cadastrarUsuario(Usuario usuario){
		String sql = "INSERT INTO Usuario (Nome, Sobrenome, Email, Senha, Celular, Cidade, Estado, rua, genero) VALUES (?, ? ,? ,?, ?, ?, ?, ?, ?)";
		try(Connection con = connection.conectar();
				PreparedStatement inserir = con.prepareStatement(sql)){
			inserir.setString(1, usuario.getNome());
			inserir.setString(2, usuario.getSobrenome());
			inserir.setString(3, usuario.getEmail());
			inserir.setString(4, usuario.getSenha());
			inserir.setString(5, usuario.getCelular());
			inserir.setString(6, usuario.getCidade());
			inserir.setString(7, usuario.getEstado());
			inserir.setString(8, usuario.getRua());
			inserir.setString(9, usuario.getGenero());
			int linhasAfetadas = inserir.executeUpdate();
			if(linhasAfetadas > 0) {
				System.out.println("valor Inserido");
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public Usuario verificaLogin(String email, String senha) throws SQLException{
		String sql = "SELECT * FROM Usuario WHERE Email = ? AND Senha = ?";
		try(Connection con = connection.conectar(); 
				PreparedStatement receber = con.prepareStatement(sql)){
			receber.setString(1, email);
			receber.setString(2, senha);
			ResultSet rs = receber.executeQuery();
			
			if(rs.next()) {
				Usuario usuario = new Usuario();
	            usuario.setEmail(rs.getString("Email"));
	            usuario.setSenha(rs.getString("Senha"));
	            return usuario;
			}else {
				return null;
			}
		}
	}
	
	public List<Usuario> listarUsuario ()throws SQLException{
		
		List<Usuario> lista = new ArrayList<>();
		String sql = "SELECT * FROM Usuario";

		
		try(Connection con = connection.conectar();
				PreparedStatement receber = con.prepareStatement(sql);
				ResultSet rs = receber.executeQuery()){
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id_Usuario"));
				usuario.setAdmin(rs.getBoolean("isAdmin"));
				usuario.setNome(rs.getString("Nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setCelular(rs.getString("celular"));
				usuario.setCidade(rs.getString("cidade"));
				usuario.setEstado(rs.getString("estado"));
				usuario.setRua(rs.getString("rua"));
				usuario.setGenero(rs.getString("genero"));
				lista.add(usuario);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return lista;
	}
	
	public Usuario listaUm(int id) throws SQLException{
		String sql = "SELECT * FROM Usuario WHERE id_usuario = ?";
		try(Connection con = connection.conectar();
				PreparedStatement receber = con.prepareStatement(sql)){
			receber.setInt(1, id);
			ResultSet rs = receber.executeQuery();
			if(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id_Usuario"));
				usuario.setAdmin(rs.getBoolean("isAdmin"));
				usuario.setNome(rs.getString("Nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setCelular(rs.getString("celular"));
				usuario.setCidade(rs.getString("cidade"));
				usuario.setEstado(rs.getString("estado"));
				usuario.setRua(rs.getString("rua"));
				usuario.setGenero(rs.getString("genero"));
				return usuario;
			}else {
				return null;
			}
		}
		
	}
	
	public boolean atualizaUsuario(Usuario usuario, int id) {
		String sql = "UPDATE Usuario SET isAdmin = ?, nome = ?, sobrenome = ?, email = ?, celular = ?, estado = ?, cidade = ?, rua = ?, genero = ? WHERE id_Usuario = ?";
		try(Connection con = connection.conectar();
				PreparedStatement atualizar = con.prepareStatement(sql)) {
			
				atualizar.setBoolean(1, usuario.isAdmin());
				atualizar.setString(2, usuario.getNome());
				atualizar.setString(3, usuario.getSobrenome());
				atualizar.setString(4, usuario.getEmail());
				atualizar.setString(5, usuario.getCelular());
				atualizar.setString(6, usuario.getEstado());
				atualizar.setString(7, usuario.getCidade());
				atualizar.setString(8, usuario.getRua());
				atualizar.setString(9, usuario.getGenero());
				atualizar.setInt(10, id);
				
				int linhasAfetadas = atualizar.executeUpdate();
		        if(linhasAfetadas > 0) {
		        	System.out.println("Valor Atualizado");
		        	return true;
		        }else {
		        	return false;
		        }
			
		} catch (Exception e) {
	        System.out.println(e);
	        return false;
		}
	}
	
	public boolean deleteUsuario(int id) {
		String sql = "DELETE FROM Usuario WHERE id_Usuario = ?";
		try(Connection con = connection.conectar();
				PreparedStatement delete = con.prepareStatement(sql)) {
				delete.setInt(1, id);
				int linhasAfetadas = delete.executeUpdate();
				if(linhasAfetadas > 0) {
					System.out.println("Valor Excluido");
					return true;
				}else {
					return false;
				}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	

	
	

}
