/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.VideoDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Filme;
import view.AdicionarLista;

/**
 *
 * @author lucas
 */
public class ControleAdicionarLista {
    private String email;
    private AdicionarLista al;
    private Filme filme;
    private String nomeLista;

    public ControleAdicionarLista(String email, AdicionarLista al, Filme filme, String nomeLista) {
        this.email = email;
        this.al = al;
        this.filme = filme;
        this.nomeLista = nomeLista;
    }
    

    
    public ControleAdicionarLista(String email, AdicionarLista al) {
        this.email = email;
        this.al = al;
    }
    
    public ArrayList setNomesListas(){
        Conexao conexao = new Conexao();
        ArrayList<String> nomesListas = new ArrayList();
        
        try{
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            ResultSet res = dao.consultarListas(email);
            while (res.next()){
                String nome = res.getString("nome");
                nomesListas.add(nome);
            }
            return nomesListas;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(al, "Erro de conexao com listas!", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
        }
        
        return nomesListas;
    }
    
    public void inserir(String nomeLista, Filme filme){
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            dao.inserir(nomeLista, email, filme);
            JOptionPane.showMessageDialog(al, "Filme adicionado a lista: " + nomeLista, "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(al, "Erro de conexao com listas!", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
