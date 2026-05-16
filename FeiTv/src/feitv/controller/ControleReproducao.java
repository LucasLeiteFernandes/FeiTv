/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.VideoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Filme;
import model.Usuario;
import view.Reproducao;

/**
 *
 * @author lucas
 */
public class ControleReproducao {
    private Reproducao rep;
    private Filme filme;
    private Usuario user;
    private ArrayList<Filme> filmes;

    public ControleReproducao(Reproducao rep, Filme filme, Usuario user, ArrayList<Filme> filmes) {
        this.rep = rep;
        this.filme = filme;
        this.user = user;
        this.filmes = filmes;
    }
    
    Conexao conexao = new Conexao();
    public void Adicionar(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            dao.inserir(filme, user);
            JOptionPane.showMessageDialog(rep, "Filme adicionado aos favoritos", "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(rep, "Nao foi possivel favoritar o filme", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
