/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Filme;
import model.Lista;
import model.Usuario;

/**
 *
 * @author lucas
 */
public class VideoDAO {
    private Connection conn;

    public VideoDAO(Connection conn) {
        this.conn = conn;
    }
    public void inserir(Filme filme) throws SQLException{
        String sql = "insert into tbfilmes (descricao, titulo, genero, horas, minutos, segundos, avaliacoes, nAvaliacoes) values('"
                + filme.getTitulo() + "', '"
                + filme.getDescricao() + "', '"
                + filme.getGenero() + "', '"
                + filme.getHoras() + "', '"
                + filme.getMinutos() + "', '"
                + filme.getSegundos() + "', '"
                + filme.getAvaliacoes() + "', '"
                + filme.getnAvaliacoes() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    } 
    
    public void inserir(String nome, String user) throws SQLException{
        String sql = "insert into tblistas (email, nome) values('"
                + user + "', '"
                + nome  + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }   
    
    public void inserir(String lista, String user, String titulo) throws SQLException{
        String nomeLista = "tb" + user + lista;
        String sql = "insert into "+ nomeLista + " (filme) values('"
                + titulo + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }   
    
    public void criarLista(String nome, String user) throws SQLException{
        String nomeLista = "tb" + user + nome;
        String sql = "DROP TABLE IF EXISTS public." + nomeLista + ";"
            + "CREATE TABLE IF NOT EXISTS public." + nomeLista
            + "("
            + "filme character varying"
            + ")";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public void inserir(Filme filme, Usuario user) throws SQLException{
        String sql = "insert into tbfavoritos (email, filme) values('"
                + user.getEmail() + "', '"
                + filme.getTitulo() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public void inserir(String nomeLista, String email, Filme filme) throws SQLException{
        email = email.replaceAll("@email.com", "dao");
        nomeLista = nomeLista.replaceAll(" ", "_");
        String dbLista = "tb" + email + nomeLista;
        System.out.println(dbLista);
        String sql = "insert into " + dbLista + "(filme) values ('"
                + filme.getTitulo() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public ResultSet consultarFilmes() throws SQLException{
        String sql = "select * from tbfilmes";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.execute();
        ResultSet res = stat.getResultSet();
        return res;
    }
    
    public ResultSet consultarFilmes(String nome) throws SQLException{
        String sql = "select * from tbfilmes where titulo = ?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, nome);
        stat.execute();
        ResultSet res = stat.getResultSet();
        return res;
    }
    
    public ResultSet consultarListas(String email) throws SQLException{
        String sql = "select * from tblistas where email = ?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, email);
        stat.execute();
        ResultSet res = stat.getResultSet();
        return res;
    }
    
    public ResultSet consultarFavoritos(Filme filme, Usuario user) throws SQLException{
        String sql = "select * from tbfavoritos where email = ? and filme = ?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, user.getEmail());
        stat.setString(2, filme.getTitulo());
        stat.execute();
        ResultSet res = stat.getResultSet();
        return res;
    }
    
    public ResultSet consultarListas(Usuario user) throws SQLException{
        String sql = "select * from tblistas where email = ?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, user.getEmail());
        stat.execute();
        ResultSet res = stat.getResultSet();
        return res;
    }
    
    public ResultSet consultarListas(String nomeLista, String email) throws SQLException{
        nomeLista = nomeLista.replaceAll(" ", "_");
        email = email.replaceAll("@email.com", "dao");
        String tbNome = "tb" + email + nomeLista;
        String sql = "select * from " + tbNome;
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.execute();
        ResultSet res = stat.getResultSet();
        return res;
    }
    
    public ResultSet ConsultarFilme(String titulo) throws SQLException {
        String sql = "select * from tbfilmes where titulo = ?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, titulo);
        stat.execute();
        ResultSet res = stat.getResultSet();
        return res;
    }
    
    public void remover (String nomeTabela, String filme) throws SQLException{
        String sql = "delete from " + nomeTabela + " where filme = ?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, filme);
        stat.execute();
        conn.close();
    }
    
    public void remover (String filme, Usuario user) throws SQLException{
        String sql = "delete from tbfavoritos where email = ? and filme = ?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, user.getEmail());
        stat.setString(2, filme);
        stat.execute();
        conn.close();
    }
    
       public void remover (Usuario user, String lista ) throws SQLException{
        String sql = "delete from tblistas where email = ? and nome = ?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, user.getEmail());
        stat.setString(2, lista);
        stat.execute();
        conn.close();
    }
    
    public void remover (String tbNome) throws SQLException{
        String sql = "DROP TABLE IF EXISTS public." + tbNome;
        //System.out.println(sql);
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.execute();
        conn.close();
    }
    
    public void avaliar(String filme, double ava, int nAva) throws SQLException{
        String sql = "update tbfilmes set avaliacoes = ?, " + '"' + "nAvaliacoes" + '"'+ " = ? where titulo = ?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setDouble(1, ava);
        stat.setInt(2, nAva);
        stat.setString(3, filme);
        stat.execute();
        conn.close();
    }
}
