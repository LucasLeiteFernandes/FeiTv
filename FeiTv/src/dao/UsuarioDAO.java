/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author lucas
 */
public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    public void inserir(Usuario usuario) throws SQLException{
        String sql = "insert into tbusuarios (email, nome, senha) values('"
                + usuario.getEmail() + "', '"
                + usuario.getNome() + "', '"
                + usuario.getSenha() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }  
    public ResultSet consultar(Usuario user) throws SQLException{
        String sql = "select * from tbusuarios where email = ? and senha = ?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, user.getEmail());
        stat.setString(2, user.getSenha());
        stat.execute();
        ResultSet res = stat.getResultSet();
        return res;
    }
}
