/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.VideoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Filme;
import model.Usuario;
import view.Avaliar;

/**
 *
 * @author lucas
 */
public class ControleAvaliar {
    private Avaliar a;
    private Filme filme;

    public ControleAvaliar(Avaliar a, Filme filme) {
        this.a = a;
        this.filme = filme;
    }
    
    public void avaliar(){
        String notaString = a.getTxt_nota().getText();
        Double nota = Double.parseDouble(notaString);
        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            dao.avaliar(filme.getTitulo(), filme.getAvaliacoes() + nota, filme.getnAvaliacoes() + 1);
            
            JOptionPane.showMessageDialog(a, "Filme avaliado!", "Aviso",
                        JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(a, "Filme nao avaliado!", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
