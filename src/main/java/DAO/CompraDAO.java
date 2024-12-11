package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Compra;
import utils.ConnectionFactory;

public class CompraDAO {
	
	ConnectionFactory connection = new ConnectionFactory();

    public void salvarCompra(Compra compra) {
        String sql = "INSERT INTO compras (id_usuario, id_produto, nome_produto, valor_produto, quantidade, data_compra) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = connection.conectar(); 
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, compra.getIdUsuario());
            stmt.setInt(2, compra.getIdProduto());
            stmt.setString(3, compra.getNomeProduto());
            stmt.setString(4, compra.getValorProduto());
            stmt.setString(5, compra.getQuantidade());
            stmt.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
