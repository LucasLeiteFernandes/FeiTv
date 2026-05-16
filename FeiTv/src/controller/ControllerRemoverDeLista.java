/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import dao.Conexao;
import dao.VideoDAO;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Usuario;
import view.RemoverDeLista;

/**
 *
 * @author lucas
 */
public class ControllerRemoverDeLista {
    private String nomeTabela, filme, nomeLista;
    private RemoverDeLista rl;
    private Usuario user;

    public ControllerRemoverDeLista(String nomeTabela, String filme, RemoverDeLista rl, Usuario user) {
        this.nomeTabela = nomeTabela;
        this.filme = filme;
        this.rl = rl;
        this.user = user;
    }
    
    public ControllerRemoverDeLista(String nomeLista, RemoverDeLista rl, Usuario user) {
        this.rl = rl;
        this.user = user;
        this.nomeLista = nomeLista;
    }
    
    public void remover(){
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            if (nomeTabela.equalsIgnoreCase("tbfavoritos")){
                //System.out.println(nomeTabela);
                dao.remover(filme, user);
            } else {
                //System.out.println(nomeTabela);
                dao.remover(nomeTabela, filme);
            }
            
            JOptionPane.showMessageDialog(rl, "Filme removido!", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(rl, "Filme nao removido!", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void remover(String lista, Usuario user){
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            dao.remover(user, lista);
            
            conn = conexao.getConnection();
            dao = new VideoDAO(conn);
            
            
            String email = user.getEmail().replaceAll("@email.com", "dao");
            lista = lista.replaceAll(" ", "_");
            String tb = "tb" + email + lista;
            
            dao.remover(tb);
            JOptionPane.showMessageDialog(rl, "Lista removida!", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(rl, "Lista nao removido!", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
        }        
    }
}
