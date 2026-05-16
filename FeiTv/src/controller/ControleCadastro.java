/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.Connection;
import java.sql.SQLException;

import dao.Conexao;
import dao.UsuarioDAO;
import dao.VideoDAO;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Cadastro;
import view.Login;
/**
 *
 * @author lucas
 */
public class ControleCadastro {
    private Cadastro cadastro;

    public ControleCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }
    
    public void cadastrarUsuario(){
        String nome = cadastro.getTxt_usuario().getText();
        String email = cadastro.getTxt_email().getText();
        String senha = cadastro.getTxt_senha().getText();
        
        Usuario user = new Usuario(nome, email, senha);
        
        Conexao conexao = new Conexao();
        if (email.contains("@email.com") && senha.length() > 5){
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                dao.inserir(user);
                JOptionPane.showMessageDialog(cadastro, "Usuario Cadastrado", "Aviso",
                        JOptionPane.INFORMATION_MESSAGE);
                Login l = new Login();
                l.setVisible(true);
                cadastro.setVisible(false);
            } catch (SQLException e){
                JOptionPane.showMessageDialog(cadastro, "Usuario nao cadastrado", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }  else if (!email.contains("@email.com")){
            JOptionPane.showMessageDialog(cadastro, "Insira um email valido", "Erro",
                        JOptionPane.ERROR_MESSAGE);
        } else if (senha.length() < 6){
            JOptionPane.showMessageDialog(cadastro, "A senha deve ter 6 digitos!", "Erro",
                        JOptionPane.ERROR_MESSAGE);
        }
    }
}
