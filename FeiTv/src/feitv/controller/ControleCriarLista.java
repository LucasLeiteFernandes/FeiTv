/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.Connection;
import java.sql.SQLException;

import dao.Conexao;
import dao.VideoDAO;
import javax.swing.JOptionPane;
import model.Usuario;
import view.CriarLista;
/**
 *
 * @author lucas
 */
public class ControleCriarLista {
    private Usuario user;
    private CriarLista l;

    public ControleCriarLista(Usuario user, CriarLista l) {
        this.user = user;
        this.l = l;
    }
    
    public void CriarLista(){
        String nomeLista = l.getTxt_nomeLista().getText().replaceAll(" ", "_");
        String email = user.getEmail().replaceAll("@email.com", "dao");
        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            dao.criarLista(nomeLista, email);
            JOptionPane.showMessageDialog(l, "Lista Criada", "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(l, "Lista nao criada", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        conexao = new Conexao();
        nomeLista = nomeLista.replaceAll("_", " ");
        email = email.replaceAll("dao", "@email.com");
        try{
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            dao.inserir(nomeLista, email);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(l, "Lista nao criada", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
