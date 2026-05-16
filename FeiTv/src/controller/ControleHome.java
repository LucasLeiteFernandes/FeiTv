/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import dao.VideoDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Filme;
import model.Usuario;
import view.Home;
import view.Reproducao;

/**
 *
 * @author lucas
 */
public class ControleHome {
    private Home home;
    private Usuario user;

    public ControleHome(Home home, Usuario user) {
        this.home = home;
        this.user = user;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public void pesquisar(Usuario user, ArrayList<Filme> filmes){
        String pesquisa = home.getTxt_pesquisar().getText();
        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            ResultSet res = dao.ConsultarFilme(pesquisa);
            if(res.next()){
                String titulo = res.getString("titulo");
                String descricao = res.getString("descricao");
                String genero = res.getString("genero");
                int horas = res.getInt("horas");
                int minutos = res.getInt("minutos");
                int segundos = res.getInt("segundos");
                double avaliacoes = res.getDouble("avaliacoes");
                int nAvaliacoes = res.getInt("nAvaliacoes");
                Filme filme = new Filme(titulo, descricao, genero, horas, minutos, segundos, avaliacoes, nAvaliacoes);
                Reproducao r = new Reproducao(filme, user , filmes);
                r.setVisible(true);
                home.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(home, "Filme nao encontrado!", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(home, "Erro de conexao!", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
