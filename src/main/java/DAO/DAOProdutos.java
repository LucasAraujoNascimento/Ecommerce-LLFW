package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produtos;
import model.Usuario;
import utils.ConnectionFactory;


public class DAOProdutos {
	
	ConnectionFactory connection = new ConnectionFactory();
	
	public void cadastrarProdutos(Produtos produtos) throws SQLException{
		String sql = "INSERT INTO Produto (nome, marca, modelo, quantidade_estoque, descricao, valor) VALUES (?, ?, ?, ?, ?, ?)";
				try(Connection con = connection.conectar();
						PreparedStatement inserir = con.prepareStatement(sql)){
					inserir.setString(1, produtos.getNome());
					inserir.setString(2, produtos.getMarca());
					inserir.setString(3, produtos.getModelo());
					inserir.setString(4, produtos.getEstoque());
					inserir.setString(5, produtos.getDescricao());
					inserir.setString(6, produtos.getValor());
					inserir.executeUpdate();
					
				}catch(Exception e) {
					System.out.println(e);
				}
				
				
	}
	
	
	public List<Produtos> listarProdutos() throws SQLException {
	    List<Produtos> lista = new ArrayList<>();
	    String sql = "SELECT * FROM Produto";
	    
	    try (Connection con = connection.conectar();
	         PreparedStatement stmt = con.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            Produtos produto = new Produtos();
	            produto.setId(rs.getInt("id_Produto"));
	            produto.setNome(rs.getString("nome"));
	            produto.setMarca(rs.getString("marca"));
	            produto.setModelo(rs.getString("modelo"));
	            produto.setEstoque(rs.getString("quantidade_estoque"));
	            produto.setDescricao(rs.getString("descricao"));
	            produto.setValor(rs.getString("valor"));
	            lista.add(produto);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return lista;
	}
	

	
	public Produtos listaUm(int id) throws SQLException{
		String sql = "SELECT * FROM Produto WHERE id_Produto = ?";
		try(Connection con = connection.conectar();
				PreparedStatement receber = con.prepareStatement(sql)){
			receber.setInt(1, id);
			ResultSet rs = receber.executeQuery();
			if(rs.next()) {
				Produtos produto = new Produtos();
	            produto.setId(rs.getInt("id_Produto"));
	            produto.setNome(rs.getString("nome"));
	            produto.setMarca(rs.getString("marca"));
	            produto.setModelo(rs.getString("modelo"));
	            produto.setEstoque(rs.getString("quantidade_estoque"));
	            produto.setDescricao(rs.getString("descricao"));
	            produto.setValor(rs.getString("valor"));
				return produto;
			}else {
				return null;
			}
		}
		
	}
	
	public boolean atualizaUsuario(Produtos produto, int id) {
		String sql = "UPDATE Produto SET nome = ?, marca = ?, modelo = ?,quantidade_estoque = ?, descricao = ?, valor = ? WHERE id_Produto = ?";
		try(Connection con = connection.conectar();
				PreparedStatement inserir = con.prepareStatement(sql)) {
			
					inserir.setString(1, produto.getNome());
					inserir.setString(2, produto.getMarca());
					inserir.setString(3, produto.getModelo());
					inserir.setString(4, produto.getEstoque());
					inserir.setString(5, produto.getDescricao());
					inserir.setString(6, produto.getValor());
					inserir.setInt(7, id);
				
				int linhasAfetadas = inserir.executeUpdate();
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
	
	public boolean deletaProduto(int id) {
		String sql = "DELETE FROM produto WHERE id_Produto = ?";
		try (Connection con = connection.conectar();
				PreparedStatement delete = con.prepareStatement(sql)){
				delete.setInt(1,id);
				int linhasAlteradas = delete.executeUpdate();
				if(linhasAlteradas > 0) {
					System.out.println("Valor Excluido");
					return true;
				}else {
					return false;
				}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
	}
	

}
