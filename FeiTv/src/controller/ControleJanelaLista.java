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
import model.Lista;
import model.Usuario;
import view.Home;
import view.JanelaLista;

/**
 *
 * @author lucas
 */
public class ControleJanelaLista {
    private Usuario user;
    private Lista fav;
    private ArrayList<Lista> listas;
    private ArrayList<Filme> filmes;
    private JanelaLista jl;

    public ControleJanelaLista() {
    }

    public ControleJanelaLista(Usuario user, Lista fav, ArrayList<Lista> listas, ArrayList<Filme> filmes, JanelaLista jl) {
        this.user = user;
        this.fav = fav;
        this.listas = listas;
        this.filmes = filmes;
        this.jl = jl;
    }


    public Lista setFav(){
        Lista fav = new Lista();
        ArrayList<Filme> a = new ArrayList();
        Conexao conexao = new Conexao();
        fav.setNome("Favoritos");
        
        for (int i = 0; i < filmes.size(); i++){
            Filme filme = filmes.get(i);
            try{
                Connection conn = conexao.getConnection();
                VideoDAO dao = new VideoDAO(conn);
                ResultSet res = dao.consultarFavoritos(filme, user);
                if(res.next()){
                    String email = res.getString("email");
                    String titulo = res.getString("filme");
                    if (email.compareToIgnoreCase(email) >= 0 && titulo.compareToIgnoreCase(titulo) >= 0){
                        a.add(filme);
                    }
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(jl, "Erro de conexao!", "Erro",
                            JOptionPane.INFORMATION_MESSAGE);
            }
        }
        fav.setLista(a);
        return fav;
    }
    
    public ArrayList<String> setNomesListas(String email){
        ArrayList<String> nomesListas = new ArrayList();
        
        Conexao conexao = new Conexao();
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
            JOptionPane.showMessageDialog(jl, "Erro de conexao com listas!", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
        }
        
        return nomesListas;
    }
    
    public ArrayList<Lista> setListas(ArrayList<String> nomesListas, String email){
        ArrayList<Lista> listas = new ArrayList();
        ArrayList<Filme> filmes;
        Conexao conexao = new Conexao();
        String nomeLista;
        for (int i = 0; i < nomesListas.size(); i++){
            nomeLista = nomesListas.get(i);
            try{
                Connection conn = conexao.getConnection();
                VideoDAO dao = new VideoDAO(conn);
                ResultSet res = dao.consultarListas(nomeLista, email);
                while (res.next()){
                    String titulo = res.getString("filme");
                    filmes = new ArrayList();
                    try{
                        Connection conn2 = conexao.getConnection();
                        VideoDAO dao2 = new VideoDAO(conn2);
                        ResultSet res2 = dao2.consultarFilmes(titulo);
                        while (res2.next()){
                            titulo = res2.getString("titulo");
                            String descricao = res2.getString("descricao");
                            String genero = res2.getString("genero");
                            int horas = res2.getInt("horas");
                            int minutos = res2.getInt("minutos");
                            int segundos = res2.getInt("segundos");
                            double avaliacoes = res2.getDouble("avaliacoes");
                            int nAvaliacoes = res2.getInt("nAvaliacoes");
                            filmes.add(new Filme(titulo, descricao, genero, horas, minutos, segundos, avaliacoes, nAvaliacoes));
                        }
                        listas.add(new Lista(nomeLista, filmes));
                    }catch(SQLException e){
                        System.out.println(e);
                        JOptionPane.showMessageDialog(jl, "Erro de conexao com filmes!", "Erro",
                                    JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }catch(SQLException e){
                System.out.println(e);
                JOptionPane.showMessageDialog(jl, "Erro de conexao com a lista!", "Erro",
                            JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        return listas;
    }
}
