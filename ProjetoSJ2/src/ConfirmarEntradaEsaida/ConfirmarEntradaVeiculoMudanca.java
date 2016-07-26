/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ConfirmarEntradaEsaida;

import Controle.ConectaBanco;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
public class ConfirmarEntradaVeiculoMudanca extends javax.swing.JFrame {

    ConectaBanco conex = new ConectaBanco();
    int idVeiculoMudanca;
    int idMudanca;
    int idVeiculo;
    int idMorador;
    
    public ConfirmarEntradaVeiculoMudanca(String idMuda,String bloco, String apt) {
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
    
    jButtonConfirmar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonConfirmar.getActionMap().put("DoClick", action);


    
    
    
        /////////////////////////////////////
        
        conex.conexao();
      
      conex.execultasql("select  max(idVeiculoMudanca) as idVeiculoMudanca  from  veiculo_mudanca  where idMuda='"+idMuda+"' and bloco = '"+bloco+"' and numeroApartamento ='"+apt+"'");
        try {
            conex.rs.first();
            idVeiculoMudanca=conex.rs.getInt("idVeiculoMudanca");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro");
            
            
            
            
        }
        
        
        /////////////////////////////////////////
        
        
        
       
        // Para buscar o bloco e o numero do apartamento cadastrado no condominio
        conex.conexao();
      
          conex.execultasql("select  idMuda,idMorador ,idVeiculo,bloco, numeroApartamento  from veiculo_mudanca  where idMuda='"+idMuda+"' and bloco = '"+bloco+"' and numeroApartamento ='"+apt+"' and idVeiculoMudanca='"+idVeiculoMudanca+"'");
       
        
      
      try {
            conex.rs.first();
            idMudanca=conex.rs.getInt("idMuda");
            idMorador=conex.rs.getInt("idMorador");
            idVeiculo=conex.rs.getInt("idveiculo");
            jLabelBloco.setText(conex.rs.getString("bloco"));
            jLabelApt.setText(conex.rs.getString("numeroApartamento"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro");
            
            
            
            
        }
    }

    private ConfirmarEntradaVeiculoMudanca() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jButtonConfirmar = new javax.swing.JButton();
        jLabelBloco = new javax.swing.JLabel();
        jLabelApt = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CondominioSJ2");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonConfirmar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/accept.png"))); // NOI18N
        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.setToolTipText("Salvar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jLabelBloco.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabelBloco.setText("BLOCO");

        jLabelApt.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabelApt.setText("APARTAMENTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabelBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelApt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBloco)
                    .addComponent(jLabelApt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jButtonConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Confirmar Entrada  Veiculo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        
        
       try {
            //Este é o Botao do SIM. Ira sair do seu Programa
            
            PreparedStatement inserirVeiculo = conex.conn.prepareStatement("call atualizaVeiculoMudanca('"+idVeiculoMudanca+"','"+idVeiculo+"','"+idMorador+"','"+idMudanca+"','"+jLabelBloco.getText()+"','"+jLabelApt.getText()+"')");
            
            inserirVeiculo.execute();
            
             //JOptionPane.showMessageDialog(rootPane,"Ok");
             dispose();
             
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane,"Erro ao Alterar"+ex);
            }
        
        
        
        dispose();
        //System.exit(1);
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(ConfirmarEntradaVeiculoMudanca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmarEntradaVeiculoMudanca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmarEntradaVeiculoMudanca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmarEntradaVeiculoMudanca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfirmarEntradaVeiculoMudanca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabelApt;
    private javax.swing.JLabel jLabelBloco;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    // End of variables declaration//GEN-END:variables
}