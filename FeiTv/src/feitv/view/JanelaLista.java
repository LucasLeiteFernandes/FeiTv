/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControleJanelaLista;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import model.Filme;
import model.Lista;
import model.Usuario;
import view.RemoverDeLista;
/**
 *
 * @author lucas
 */
public class JanelaLista extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JanelaLista.class.getName());

    /**
     * Creates new form JanelaLista
     */
    public JanelaLista(Usuario user, ArrayList<Filme> filmes) {
        
        this.user = user;
        this.filmes = filmes;
        initComponents();
        cjl = new ControleJanelaLista(user, fav, listas, filmes, this);
        this.nomesListas =  cjl.setNomesListas(user.getEmail());
        this.listas = cjl.setListas(nomesListas, user.getEmail());
//        System.out.println();
//        System.out.println("Print das listas");
//        for (int k = 0; k < listas.size(); k++){
//            System.out.println(listas.get(k).getNome());
//            for (int j = 0; j < listas.get(k).getLista().size(); j++){
//                System.out.println(listas.get(k).getLista().get(j).toString());
//            }
//        }
        this.fav = cjl.setFav();
        iniciar();
    }

    private void iniciar(){
        int qtFilmes = 0, qtTeste = 0, qtTerror = 0;
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        String str;     
        
        for (int i = 0; i < nomesListas.size(); i++){
            lbl_nomeLista = new javax.swing.JLabel();
            str = nomesListas.get(i);
            
            criarLabelNomeLista(str, 320, lbl_nomeLista, layout, i);
        }
        
        for (int i = 0; i < fav.getLista().size(); i++){
            lbl_poster = new javax.swing.JLabel();
            Filme filme = fav.getLista().get(i);
            //System.out.println(fav.getLista().get(i).toString());
            str = fav.getLista().get(i).getGenero();
            if (str.compareToIgnoreCase("terror") >= 0){
                criarPoster(filme, 146, Color.red,Color.BLACK, lbl_poster, layout, i, 0, "Old English Text MT", "tbfavoritos");       
            } else if (str.equalsIgnoreCase("ficcao")) {
                    criarPoster(filme, 146, Color.GREEN, Color.BLACK, lbl_poster, layout, i, 0, "Lucida Console", "tbfavoritos");
            } else if (str.equalsIgnoreCase("romance")) {
                    criarPoster(filme, 146, Color.PINK, Color.BLACK, lbl_poster, layout, i, 0, "SimSun", "tbfavoritos");
            } else if (str.equalsIgnoreCase("musical")) {
                    criarPoster(filme, 146, Color.BLUE, Color.WHITE, lbl_poster, layout, i, 0, "SimSun", "tbfavoritos");
            } 
            qtFilmes++;
        }
        
        if(listas.isEmpty() == false){
            qtFilmes = 0;
            int k = 0, qtListaAtual = 0;
            String listaAtual = listas.get(0).getNome();
            int gap = 165;
            for (int i = 0; i < listas.size(); i++){
                qtFilmes++;
                if (listaAtual.compareToIgnoreCase(listas.get(i).getNome()) > 0){
                    k++;
                    listaAtual = listas.get(i).getNome();
                    qtListaAtual = 1;
                } else {
                    qtListaAtual++;
                }
                for (int j = 0; j < listas.get(i).getLista().size(); j++){
                    lbl_poster = new javax.swing.JLabel();
                    Filme filme = listas.get(i).getLista().get(j);
                    str = filme.getGenero();
                    System.out.println(filmes.get(i).getTitulo() + " " + str);

                     if ((str.equalsIgnoreCase("terror"))){
                        criarPoster(filme, 160 + gap * (j + 1) + gap * k, Color.red,Color.BLACK, lbl_poster, layout, i, qtFilmes - qtListaAtual,"Old English Text MT", listaAtual);
                    }else if (str.equalsIgnoreCase("ficcao")) {
                        criarPoster(filme, 160 + gap * (j + 1) + gap * k, Color.GREEN, Color.BLACK, lbl_poster, layout, i, qtFilmes - qtListaAtual, "Lucida Console", listaAtual);
                    } else if (str.equalsIgnoreCase("romance")) {
                        criarPoster(filme, 160 + gap * (j + 1) + gap * k, Color.PINK, Color.BLACK, lbl_poster, layout, i, qtFilmes - qtListaAtual, "SimSun", listaAtual);
                    } else if (str.equalsIgnoreCase("musical")) {
                        criarPoster(filme, 160 + gap * (j + 1) + gap * k, Color.BLUE, Color.WHITE, lbl_poster, layout, i, qtFilmes - qtListaAtual, "SimSun", listaAtual);
                    } 

                }
            }
        } else {
            System.out.println("listas vazias");
        }
    }
    
    
    private void criarLabelNomeLista(String nomeLista, int gap, JLabel lbl_nomeLista, javax.swing.GroupLayout layout, int i){
        lbl_nomeLista.setFont(new java.awt.Font("Segoe UI", 1, 24));
        lbl_nomeLista.setText("<html>" + nomeLista + "<br>");
        lbl_nomeLista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nomeLista.setPreferredSize(new java.awt.Dimension(60, 100));
        //lbl_nomeLista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        
        lbl_nomeLista.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_nomeListaMouseClicked(evt, nomeLista);
            }
        });

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_nomeLista, 140, 140, 140))
        );
        layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(gap + 170 * i, gap + 170 * i, gap + 170 * i)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbl_nomeLista, 150, 150, 150))
            .addContainerGap(0, Short.MAX_VALUE))
        );
        pack();          
    }
    
    private void criarPoster(Filme filme, int gap, Color cor, Color backgroundColor , JLabel lbl_poster, javax.swing.GroupLayout layout, int i, int j, String font, String tbNome){
        lbl_poster.setFont(new java.awt.Font(font, 1, 24));
        lbl_poster.setText("<html>" + filme.getTitulo() + "<br>");
        lbl_poster.setOpaque(true);
        lbl_poster.setBackground(backgroundColor);
        lbl_poster.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_poster.setPreferredSize(new java.awt.Dimension(60, 100));
        lbl_poster.setForeground(cor);
        lbl_poster.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        
        lbl_poster.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_posterMouseClicked(evt, filme, tbNome);
            }
        });

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(160 + (i - j) * 150 , 160 + (i - j) * 150, 160 + (i - j) * 150)
                .addComponent(lbl_poster, 140, 140, 140))
        );
        layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(gap, gap , gap)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbl_poster, 150, 150, 150))
            .addContainerGap(0, Short.MAX_VALUE))
        );
        pack();          
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_nomeUser = new javax.swing.JLabel();
        lbl_logo = new javax.swing.JLabel();
        lbl_teste = new javax.swing.JLabel();
        lbl_terror = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txt_pesquisar = new javax.swing.JTextField();
        bt_criarLista = new javax.swing.JButton();
        bt_verListas = new javax.swing.JButton();
        lbl_nomeUser1 = new javax.swing.JLabel();
        lbl_logo1 = new javax.swing.JLabel();
        lbl_favoritos = new javax.swing.JLabel();
        txt_pesquisar1 = new javax.swing.JTextField();
        bt_criarLista1 = new javax.swing.JButton();
        bt_verListas1 = new javax.swing.JButton();
        bt_voltar = new javax.swing.JButton();

        lbl_nomeUser.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_nomeUser.setText("Nome");
        lbl_nomeUser.setPreferredSize(new java.awt.Dimension(118, 32));

        lbl_logo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbl_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo.setText("FeiTv");

        lbl_teste.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_teste.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_teste.setText("teste:");
        lbl_teste.setInheritsPopupMenu(false);
        lbl_teste.setMaximumSize(new java.awt.Dimension(140, 150));
        lbl_teste.setPreferredSize(new java.awt.Dimension(140, 150));

        lbl_terror.setFont(new java.awt.Font("Old English Text MT", 1, 24)); // NOI18N
        lbl_terror.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_terror.setText("Terror:");
        lbl_terror.setInheritsPopupMenu(false);
        lbl_terror.setOpaque(true);
        lbl_terror.setPreferredSize(new java.awt.Dimension(118, 32));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setMinimumSize(new java.awt.Dimension(50, 3));
        jSeparator1.setOpaque(true);
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 3));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setMinimumSize(new java.awt.Dimension(50, 3));
        jSeparator2.setOpaque(true);
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 3));

        txt_pesquisar.setText("Pesquisar");
        txt_pesquisar.addActionListener(this::txt_pesquisarActionPerformed);

        bt_criarLista.setText("Criar lista");
        bt_criarLista.addActionListener(this::bt_criarListaActionPerformed);

        bt_verListas.setText("Ver listas");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1800, 1800));
        setMinimumSize(new java.awt.Dimension(1000, 700));

        lbl_nomeUser1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_nomeUser1.setText("Nome");
        lbl_nomeUser1.setPreferredSize(new java.awt.Dimension(118, 32));

        lbl_logo1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbl_logo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo1.setText("FeiTv");

        lbl_favoritos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_favoritos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_favoritos.setText("Favoritos");
        lbl_favoritos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lbl_favoritos.setInheritsPopupMenu(false);
        lbl_favoritos.setMaximumSize(new java.awt.Dimension(140, 150));
        lbl_favoritos.setPreferredSize(new java.awt.Dimension(140, 150));
        lbl_favoritos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_favoritosKeyPressed(evt);
            }
        });

        txt_pesquisar1.setText("Pesquisar");
        txt_pesquisar1.addActionListener(this::txt_pesquisar1ActionPerformed);

        bt_criarLista1.setText("Criar lista");
        bt_criarLista1.addActionListener(this::bt_criarLista1ActionPerformed);

        bt_verListas1.setText("Ver listas");

        bt_voltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_voltar.setText("VOLTAR");
        bt_voltar.addActionListener(this::bt_voltarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(bt_voltar)
                .addGap(18, 18, 18)
                .addComponent(lbl_logo1)
                .addGap(18, 18, 18)
                .addComponent(txt_pesquisar1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_criarLista1)
                        .addGap(18, 18, 18)
                        .addComponent(bt_verListas1))
                    .addComponent(lbl_nomeUser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_favoritos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_logo1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_nomeUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bt_criarLista1)
                                    .addComponent(bt_verListas1)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(txt_pesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addComponent(lbl_favoritos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(437, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesquisarActionPerformed

    private void bt_criarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_criarListaActionPerformed
        // TODO add your handling code here:
        CriarLista cl = new CriarLista(user);
        cl.setVisible(true);
    }//GEN-LAST:event_bt_criarListaActionPerformed

    private void txt_pesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesquisar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesquisar1ActionPerformed

    private void bt_criarLista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_criarLista1ActionPerformed
        // TODO add your handling code here:
        CriarLista cl = new CriarLista(user);
        cl.setVisible(true);
    }//GEN-LAST:event_bt_criarLista1ActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        // TODO add your handling code here:
        Home h = new Home(user, filmes);
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void lbl_favoritosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_favoritosKeyPressed
        // TODO add your handling code here:
        System.out.println(evt.getKeyCode());
    }//GEN-LAST:event_lbl_favoritosKeyPressed

    private void lbl_nomeListaMouseClicked(java.awt.event.MouseEvent evt, String nomeLista) {                                            
        // TODO add your handling code here:
        RemoverDeLista rl = new RemoverDeLista(nomeLista, user);
        rl.setVisible(true);
    }  
    
    private void lbl_posterMouseClicked(java.awt.event.MouseEvent evt, Filme filme, String tbNome) {                                            
        // TODO add your handling code here:
        Reproducao r;
        r = new Reproducao(filme, user, filmes);
        if(evt.getButton() == 1){
            r.setVisible(true);
            this.setVisible(false);
        }

        if(evt.getButton() == 3){
            if (tbNome.compareToIgnoreCase("tbfavoritos") == 0){
                RemoverDeLista rl = new RemoverDeLista(tbNome, filme.getTitulo(), user);
                rl.setVisible(true);
            } else {
                String email = user.getEmail().replaceAll("@email.com", "dao");
                tbNome = tbNome.replaceAll(" ", "_");
                String tb = "tb" + email + tbNome;
                RemoverDeLista rl = new RemoverDeLista(tb, filme.getTitulo(), user);
                rl.setVisible(true);
            }
            System.out.println("botao direito");
        }
    }  
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
//            logger.log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> new JanelaLista().setVisible(true));
//    }

    private javax.swing.JLabel lbl_poster;
    private Lista fav;
    private ArrayList<Lista> listas;
    private Usuario user; 
    private ControleJanelaLista cjl;
    private ArrayList<Filme> filmes;
    private ArrayList<String> nomesListas;
    private javax.swing.JLabel lbl_nomeLista;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_criarLista;
    private javax.swing.JButton bt_criarLista1;
    private javax.swing.JButton bt_verListas;
    private javax.swing.JButton bt_verListas1;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_favoritos;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_logo1;
    private javax.swing.JLabel lbl_nomeUser;
    private javax.swing.JLabel lbl_nomeUser1;
    private javax.swing.JLabel lbl_terror;
    private javax.swing.JLabel lbl_teste;
    private javax.swing.JTextField txt_pesquisar;
    private javax.swing.JTextField txt_pesquisar1;
    // End of variables declaration//GEN-END:variables
}
