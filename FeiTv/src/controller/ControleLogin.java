/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import dao.VideoDAO;
import model.Usuario;
import view.Login;
import view.Home;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Filme;
import view.Cadastro;

/**
 *
 * @author lucas
 */
public class ControleLogin {
    private Login tela1;
    
    public ControleLogin(Login tela1) {
        this.tela1 = tela1;
    }
    
    public ArrayList setFilmes(){
        Conexao conexao = new Conexao();
        ArrayList<Filme> filmes = new ArrayList();
        try{
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            ResultSet res = dao.consultarFilmes();
            while (res.next()){
                String titulo = res.getString("titulo");
                String descricao = res.getString("descricao");
                String genero = res.getString("genero");
                int horas = res.getInt("horas");
                int minutos = res.getInt("minutos");
                int segundos = res.getInt("segundos");
                double avaliacoes = res.getDouble("avaliacoes");
                int nAvaliacoes = res.getInt("nAvaliacoes");
                filmes.add(new Filme(titulo, descricao, genero, horas, minutos, segundos, avaliacoes, nAvaliacoes));
                //System.out.println(filmes.get(0).toString());
            }
            return filmes;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(tela1, "Erro de conexao com filmes!", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
        }
        return filmes;
    }
    
    public void loginUsuario(){
        Usuario user = new Usuario(null, tela1.getTxt_usuario().getText(), tela1.getTxt_senha().getText());
        Conexao conexao = new Conexao();
        ArrayList<Filme> filmes;
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(user);
            if(res.next()){
                
                String nome = res.getString("nome");
                String email = res.getString("email");
                String senha = res.getString("senha");
                filmes = setFilmes();
                Home home = new Home(new Usuario(nome, email, senha), filmes);
                home.setVisible(true);
                tela1.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(tela1, "Login nao efetuado!", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(tela1, "Erro de conexao!", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void cadastrar(){
        Cadastro cad = new Cadastro();
        cad.setVisible(true);
        tela1.setVisible(false);
    }
} 