/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tabelas;

import Controle.ConectaBanco;
import Modelo.ModeloTabela;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.JButton;

/**
 *
 * @author Eduardo
 */
public class TabelaeTodosEXmoradores extends javax.swing.JFrame {
    
    ConectaBanco connn = new ConectaBanco();
    public TabelaeTodosEXmoradores() {
        initComponents();
        this.setExtendedState(getExtendedState()| TabelaeTodosEXmoradores.MAXIMIZED_BOTH);
        
        
         URL url = this.getClass().getResource("/Imagens/condominio.jpg");  //coloca a imagem no lugar da tigela java
          Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
            this.setIconImage(imagemTitulo);
            
            

//faz os botões serem acionados com a tecla enter
    AbstractAction action = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton){
        JButton button = (JButton) e.getSource();
        button.doClick();        
        } else if(e.getSource() instanceof JComponent){
            JComponent component = (JComponent) e.getSource();
            component.transferFocus();
        }
    }
    };


    jButtonBuscar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonBuscar.getActionMap().put("DoClick", action);

    jButtonAtualizar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonAtualizar.getActionMap().put("DoClick", action);
    
            
              
         
           //////////////////////////////////////////////////////// 
           
            
            String nome="Vazio";
          
            preencherTabelaTodosEx("select * from exmorador where  nomeMorador not like'%"+nome+"%'order by nomeMorador");
           
             
             
            
        
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonAtualizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Condominio-SJ2");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(51, 153, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setRowHeight(51);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Tabela de EX-Moradores");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(461, 461, 461))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesq.png"))); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        jButtonAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/back.png"))); // NOI18N
        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(440, 440, 440)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButtonBuscar)
                .addGap(18, 18, 18)
                .addComponent(jButtonAtualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jLabel2)
                    .addComponent(jButtonAtualizar))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1332, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        preencherTabelaTodosEx("select * from exmorador where nomeMorador like '%"+jTextFieldNome.getText()+"%'");
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        // TODO add your handling code here:
         preencherTabelaTodosEx("select * from exmorador ");
         jTextFieldNome.setText("");
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    
    
    public void preencherTabelaTodosEx(String sql){
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Bloco","Apartamento","Proprietario","Telefone Proprietario","Email Proprietario","Nome Morador","Telefone1","Contato1","Telefone2","Contato2","Telefone3","Contato3","emailMorador","Telefone Urgência","Contato Telefone Urgencia","Celular Urgência","Contato Celular Urgência","Data de saída"};
       
     
        
        connn.conexao();
        connn.execultasql(sql);                
            try {
                connn.rs.first();
                do {
                  
                    dados.add(new Object[]{connn.rs.getString("bloco"),connn.rs.getString("numeroApartamento"),connn.rs.getString("proprietario"),connn.rs.getString("telefoneProprietario"),connn.rs.getString("emailProprietario"),connn.rs.getString("nomeMorador"),connn.rs.getString("telefoneContato1"),connn.rs.getString("nomeContato1"),connn.rs.getString("telefoneContato2"),connn.rs.getString("nomeContato2"),connn.rs.getString("telefoneContato3"),connn.rs.getString("nomeContato3"),connn.rs.getString("emailMorador"),connn.rs.getString("telefoneUrgencia"),connn.rs.getString("contatoUrgencia"),connn.rs.getString("celularUrgencia"),connn.rs.getString("contatoCelularUrgencia"),connn.rs.getString("dataSaida")});
                    
                    
                   
                   
                }while(connn.rs.next());
            } catch (SQLException ex) {
               // JOptionPane.showMessageDialog(rootPane,"Erro ao preencher o ArrayList!\nErro:"+ex);
                JOptionPane.showMessageDialog(rootPane,"Não encontrado");
            }
       
            
           
            
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
          jTable1.setModel(modelo);
          jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
          jTable1.getColumnModel().getColumn(0).setResizable(false);
          jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
          jTable1.getColumnModel().getColumn(1).setResizable(false);  
          jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(2).setResizable(false);  
          jTable1.getColumnModel().getColumn(3).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(3).setResizable(false);  
          jTable1.getColumnModel().getColumn(4).setPreferredWidth(400);
          jTable1.getColumnModel().getColumn(4).setResizable(false); 
          jTable1.getColumnModel().getColumn(5).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(5).setResizable(false); 
          jTable1.getColumnModel().getColumn(6).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(6).setResizable(false); 
          jTable1.getColumnModel().getColumn(7).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(7).setResizable(false); 
          jTable1.getColumnModel().getColumn(8).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(8).setResizable(false); 
          jTable1.getColumnModel().getColumn(9).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(9).setResizable(false); 
          jTable1.getColumnModel().getColumn(10).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(10).setResizable(false); 
          jTable1.getColumnModel().getColumn(11).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(11).setResizable(false); 
          
          jTable1.getColumnModel().getColumn(12).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(12).setResizable(false); 
          
          jTable1.getColumnModel().getColumn(13).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(13).setResizable(false); 
          
          jTable1.getColumnModel().getColumn(14).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(14).setResizable(false); 
          
          jTable1.getColumnModel().getColumn(15).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(15).setResizable(false); 
          
          jTable1.getColumnModel().getColumn(16).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(16).setResizable(false); 
          
          jTable1.getColumnModel().getColumn(17).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(17).setResizable(false); 
          
          
          jTable1.getTableHeader().setReorderingAllowed(false);
          jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
          jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);                                   
    
       
       }
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TabelaeTodosEXmoradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelaeTodosEXmoradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelaeTodosEXmoradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelaeTodosEXmoradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabelaeTodosEXmoradores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
