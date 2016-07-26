/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Portaria;

import Controle.ConectaBanco;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


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
public class Interfone extends javax.swing.JFrame {

    ConectaBanco conex = new ConectaBanco();
    public Interfone() {
        initComponents();
        
        
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
    jButtonSalvar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonSalvar.getActionMap().put("DoClick", action);
    

    
        jTextFieldCodMorador.setEnabled(false);
        jTextFieldNomeProprietario.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBoxBloco = new javax.swing.JComboBox();
        jComboBoxApartamento = new javax.swing.JComboBox();
        jTextFieldCodMorador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNomeProprietario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaSituacaoInterfone = new javax.swing.JTextArea();
        jButtonBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonSalvar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabelIdInterfone = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Condominio-SJ2");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jComboBoxBloco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BLOCO A", "BLOCO B", "BLOCO C", "BLOCO D", "BLOCO F", "BLOCO G", "BLOCO H", "BLOCO I", "BLOCO J", "BLOCO K", " ", " " }));

        jComboBoxApartamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "APARTAMENTO 101", "APARTAMENTO 102", "APARTAMENTO 103", "APARTAMENTO 104", "APARTAMENTO 201", "APARTAMENTO 202", "APARTAMENTO 203", "APARTAMENTO 204", "APARTAMENTO 301", "APARTAMENTO 302", "APARTAMENTO 303", "APARTAMENTO 304", "APARTAMENTO 401", "APARTAMENTO 402", "APARTAMENTO 403", "APARTAMENTO 404", " ", " " }));

        jLabel1.setText("Cod Morador:");

        jLabel2.setText("Proprietario:");

        jTextAreaSituacaoInterfone.setBackground(new java.awt.Color(255, 255, 204));
        jTextAreaSituacaoInterfone.setColumns(20);
        jTextAreaSituacaoInterfone.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jTextAreaSituacaoInterfone.setForeground(new java.awt.Color(51, 51, 255));
        jTextAreaSituacaoInterfone.setRows(5);
        jScrollPane1.setViewportView(jTextAreaSituacaoInterfone);

        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesq.png"))); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Situação do Interfone");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButtonSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/22.png"))); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setToolTipText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldNomeProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldCodMorador, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jComboBoxApartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSalvar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodMorador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonBuscar)
                    .addComponent(jComboBoxApartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxBloco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalvar)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setForeground(new java.awt.Color(0, 204, 204));

        jLabel4.setBackground(new java.awt.Color(51, 102, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cadastrar interfones com defeitos");

        jLabelIdInterfone.setForeground(new java.awt.Color(153, 153, 153));
        jLabelIdInterfone.setText("idInterf");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelIdInterfone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelIdInterfone))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        
        if(jTextFieldCodMorador.getText().equals("")){
          JOptionPane.showMessageDialog(rootPane,"Antenção !Busque um bloco e Apartamento no botão Buscar");
        }else{
            
       
        
        String[] options = {"Sim", "Não"};

        int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja Salvar ?",
                "Confirmar",JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        

        if (resposta == 1) {
        	
        	return;  //Este é o Botao do NAO. Ira retornar para a Calculadora
        }
        
        if(resposta == 0){  try {
            //Este é o Botao do SIM. Ira sair do seu Programa
            
     	
            PreparedStatement inserirInterfone = conex.conn.prepareStatement("call inserir_interfone('"+jTextFieldCodMorador.getText()+"','"+(String)jComboBoxBloco.getSelectedItem()+"','"+(String)jComboBoxApartamento.getSelectedItem()+"','"+jTextFieldNomeProprietario.getText()+"','"+jTextAreaSituacaoInterfone.getText()+"')");
           inserirInterfone.execute();
        JOptionPane.showMessageDialog(rootPane,"Salvo com sucesso");
        
        dispose();
        
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane,"Erro"+ex);
            }
             
        
        
               
           }
       }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        conex.conexao();
        conex.execultasql("select idIterfone from interfone where bloco='"+jComboBoxBloco.getSelectedItem()+"' and numeroApartamento='"+jComboBoxApartamento.getSelectedItem()+"'");
        try {
            conex.rs.first();
            jLabelIdInterfone.setText(String.valueOf(conex.rs.getInt("idIterfone")));
             JOptionPane.showMessageDialog(rootPane,"Esse interfone ja foi cadastrado");
            
             dispose();
             
        } catch (SQLException ex) {
            
            
            
             conex.conexao();
        
        conex.execultasql("select idMorador ,proprietario from condominio where bloco='"+jComboBoxBloco.getSelectedItem()+"' and numeroApartamento='"+jComboBoxApartamento.getSelectedItem()+"'");
           
        
        try {
               
               
               conex.rs.first();
               jTextFieldCodMorador.setText(String.valueOf(conex.rs.getInt("idMorador")));               
               jTextFieldNomeProprietario.setText(conex.rs.getString("proprietario"));
               jTextAreaSituacaoInterfone.requestFocus();
           } catch (SQLException exx) {

           JOptionPane.showMessageDialog(rootPane,"Não foi possível"+exx);
           dispose();

         }  
     
        
        
        

            
            
            
            
        }
        
       
        
        
        
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Interfone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfone().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox jComboBoxApartamento;
    private javax.swing.JComboBox jComboBoxBloco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelIdInterfone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaSituacaoInterfone;
    private javax.swing.JTextField jTextFieldCodMorador;
    private javax.swing.JTextField jTextFieldNomeProprietario;
    // End of variables declaration//GEN-END:variables
}
