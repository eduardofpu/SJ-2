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
public class TabelaVeiculos extends javax.swing.JFrame {
    
    ConectaBanco connn = new ConectaBanco();
    public TabelaVeiculos() {
        initComponents();
        this.setExtendedState(getExtendedState()| TabelaVeiculos.MAXIMIZED_BOTH);
        
        
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

    jButtonBuscarNome.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonBuscarNome.getActionMap().put("DoClick", action);
    
        preencherTabelaVeiculos("select * from veiculo order by bloco");
        
        
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
        jComboBoxBlocos = new javax.swing.JComboBox();
        jComboBoxApts = new javax.swing.JComboBox();
        jButtonBuscar = new javax.swing.JButton();
        jButtonAtualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonBuscarNome = new javax.swing.JButton();
        jTextFieldNome = new javax.swing.JTextField();
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
        jLabel1.setText("Tabela de veículos");

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

        jComboBoxBlocos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BLOCO A", "BLOCO B", "BLOCO C", "BLOCO D", "BLOCO F", "BLOCO G", "BLOCO H", "BLOCO I", "BLOCO J", "BLOCO K", " ", " " }));

        jComboBoxApts.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "APARTAMENTO 101", "APARTAMENTO 102", "APARTAMENTO 103", "APARTAMENTO 104", "APARTAMENTO 201", "APARTAMENTO 202", "APARTAMENTO 203", "APARTAMENTO 204", "APARTAMENTO 301", "APARTAMENTO 302", "APARTAMENTO 303", "APARTAMENTO 304", "APARTAMENTO 401", "APARTAMENTO 402", "APARTAMENTO 403", "APARTAMENTO 404", " ", " " }));

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/back.png"))); // NOI18N
        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar : modelo,motorista,bicicleta ou placa");

        jButtonBuscarNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesq.png"))); // NOI18N
        jButtonBuscarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarNomeActionPerformed(evt);
            }
        });

        jTextFieldNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldNome.setForeground(new java.awt.Color(0, 0, 204));
        jTextFieldNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(jComboBoxBlocos, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxApts, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAtualizar)
                        .addGap(66, 66, 66))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonBuscarNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxBlocos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxApts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonBuscar)
                        .addComponent(jButtonAtualizar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        preencherTabelaVeiculos("select * from veiculo where bloco='"+jComboBoxBlocos.getSelectedItem()+"' and numeroApartamento='"+jComboBoxApts.getSelectedItem()+"'");
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        // TODO add your handling code here:
         preencherTabelaVeiculos("select * from veiculo order by bloco");
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jButtonBuscarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarNomeActionPerformed
        // TODO add your handling code here:
        
        
        preencherTabelaVeiculos("select * from veiculo where modelo_carroAdesivado like'%"+jTextFieldNome.getText()+"%' or modelo_carroNaoAdesivado like'%"+jTextFieldNome.getText()+"%' or modelo_moto1 like'%"+jTextFieldNome.getText()+"%' or modelo_moto2 like'%"+jTextFieldNome.getText()+"%' or  motorista_carroAdesivado like'%"+jTextFieldNome.getText()+"%' or motorista_carroNaoAdesivado like'%"+jTextFieldNome.getText()+"%' or motorista_moto1 like'%"+jTextFieldNome.getText()+"%' or motorista_moto2 like'%"+jTextFieldNome.getText()+"%' or  placa_carroAdesivado like'%"+jTextFieldNome.getText()+"%' or placa_carroNaoAdesivado like'%"+jTextFieldNome.getText()+"%' or placa_moto1 like'%"+jTextFieldNome.getText()+"%' or placa_moto2 like'%"+jTextFieldNome.getText()+"%' or bicicleta like'%"+jTextFieldNome.getText()+"%' or garagem like'%"+jTextFieldNome.getText()+"%' or descricao like'%"+jTextFieldNome.getText()+"%' ");
        
    }//GEN-LAST:event_jButtonBuscarNomeActionPerformed

    
    
    public void preencherTabelaVeiculos(String sql){
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Garagem","Bloco","Apartamento","Modelo-carro-Adesivado","Cor-carro-Adesivado","Motorista-carro-adesivado","CNH-Carro-Adesivado","Placa-carro-Adesivado","Modelo-carro-Não-Adesivado","Cor-carro-Não-Adesivado","Motorista-carro-Não-adesivado","CNH-Carro-Não-Adesivado","Placa-carro-Não-Adesivado","modelo-moto1", "cor-moto1","motorista-moto1","cnh-motorista-moto1","placa-moto1","modelo-moto2", "cor-moto2","motorista-moto2","cnh-motorista-moto2","placa-moto2","Bicicletas","Descrição" };
       
     
        
        connn.conexao();
        connn.execultasql(sql);                
            try {
                connn.rs.first();
                do {
                  
                    dados.add(new Object[]{
       
connn.rs.getString("garagem"),connn.rs.getString("bloco"),connn.rs.getString("numeroApartamento"),connn.rs.getString("modelo_carroAdesivado"),connn.rs.getString("cor_carroAdesivado"),connn.rs.getString("motorista_carroAdesivado"),connn.rs.getString("cnh_motorista_carroAdesivado"),connn.rs.getString("placa_carroAdesivado"),connn.rs.getString("modelo_carroNaoAdesivado"),connn.rs.getString("cor_carroNaoAdesivado"),connn.rs.getString("motorista_carroNaoAdesivado"),connn.rs.getString("cnh_motorista_carroNaoAdesivado"),connn.rs.getString("placa_carroNaoAdesivado"),connn.rs.getString("modelo_moto1"),connn.rs.getString("cor_moto1"),connn.rs.getString("motorista_moto1"),connn.rs.getString("cnh_motorista_moto1"),connn.rs.getString("placa_moto1"),connn.rs.getString("modelo_moto2"),connn.rs.getString("cor_moto2"),connn.rs.getString("motorista_moto2"),connn.rs.getString("cnh_motorista_moto2"),connn.rs.getString("placa_moto2"),connn.rs.getString("bicicleta"),connn.rs.getString("descricao")});
                    
                  
                   
                   
                }while(connn.rs.next());
            } catch (SQLException ex) {
               // JOptionPane.showMessageDialog(rootPane,"Erro ao preencher o ArrayList!\nErro:"+ex);
                JOptionPane.showMessageDialog(rootPane,"Bloco e Apartamento não cadastrado:");
            }
       
            
           
            
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
          jTable1.setModel(modelo);
          jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(0).setResizable(false);
          jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(1).setResizable(false);  
          jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(2).setResizable(false);  
          jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(3).setResizable(false);  
          jTable1.getColumnModel().getColumn(4).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(4).setResizable(false); 
          jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(5).setResizable(false); 
          jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(6).setResizable(false); 
          jTable1.getColumnModel().getColumn(7).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(7).setResizable(false);          
          jTable1.getColumnModel().getColumn(8).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(8).setResizable(false);          
          jTable1.getColumnModel().getColumn(9).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(9).setResizable(false);          
          jTable1.getColumnModel().getColumn(10).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(10).setResizable(false);
          jTable1.getColumnModel().getColumn(11).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(11).setResizable(false);
          jTable1.getColumnModel().getColumn(12).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(12).setResizable(false);
          jTable1.getColumnModel().getColumn(13).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(13).setResizable(false);
          jTable1.getColumnModel().getColumn(14).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(14).setResizable(false);
          jTable1.getColumnModel().getColumn(15).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(15).setResizable(false);
          jTable1.getColumnModel().getColumn(16).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(16).setResizable(false);
          jTable1.getColumnModel().getColumn(17).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(17).setResizable(false);
          jTable1.getColumnModel().getColumn(18).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(18).setResizable(false);
          jTable1.getColumnModel().getColumn(19).setPreferredWidth(250);
          jTable1.getColumnModel().getColumn(19).setResizable(false);
          jTable1.getColumnModel().getColumn(20).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(20).setResizable(false);
          jTable1.getColumnModel().getColumn(21).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(21).setResizable(false);
          jTable1.getColumnModel().getColumn(22).setPreferredWidth(300);
          jTable1.getColumnModel().getColumn(22).setResizable(false);
          jTable1.getColumnModel().getColumn(23).setPreferredWidth(300);
          jTable1.getColumnModel().getColumn(23).setResizable(false);
          jTable1.getColumnModel().getColumn(24).setPreferredWidth(300);
          jTable1.getColumnModel().getColumn(24).setResizable(false);
          
          
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
            java.util.logging.Logger.getLogger(TabelaVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelaVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelaVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelaVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabelaVeiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonBuscarNome;
    private javax.swing.JComboBox jComboBoxApts;
    private javax.swing.JComboBox jComboBoxBlocos;
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
