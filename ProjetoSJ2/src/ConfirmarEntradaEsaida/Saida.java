/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ConfirmarEntradaEsaida;

import ConfirmarEntradaEsaida.ConfirmarSaidaVeiculoMudanca;
import Controle.AtualizadoHora;
import Controle.ConectaBanco;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class Saida extends javax.swing.JFrame {

    ConectaBanco conex = new ConectaBanco();
    public Saida() {
        initComponents();
        AtualizadoHora.start(Hora); // Para colocar a Hora no sistema
        
        
        //Pega data do sistema
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        Data.setText(df.format(hoje));
        
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
    jButtonConfirmar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonConfirmar.getActionMap().put("DoClick", action);
    
    
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Data = new javax.swing.JLabel();
        Hora = new javax.swing.JLabel();
        jLabelCodigoMorador = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxBloco = new javax.swing.JComboBox();
        jComboBoxApartamento = new javax.swing.JComboBox();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaMoradores = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabelSaida = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Condominio-SJ2");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Confirmar Saida de Moradores");

        Data.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Data.setForeground(new java.awt.Color(255, 255, 255));
        Data.setText("Data:");

        Hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Hora.setForeground(new java.awt.Color(255, 255, 255));
        Hora.setText("Hora:");

        jLabelCodigoMorador.setForeground(new java.awt.Color(204, 204, 204));
        jLabelCodigoMorador.setText("Cod Morador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelCodigoMorador)
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Data)
                        .addGap(122, 122, 122)))
                .addComponent(Hora)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelCodigoMorador))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Data)
                    .addComponent(Hora))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(204, 204, 255));

        jComboBoxBloco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxBloco.setForeground(new java.awt.Color(0, 153, 0));
        jComboBoxBloco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BLOCO A", "BLOCO B", "BLOCO C", "BLOCO D", "BLOCO F", "BLOCO G", "BLOCO H", "BLOCO I", "BLOCO J", "BLOCO K", " ", " " }));

        jComboBoxApartamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxApartamento.setForeground(new java.awt.Color(0, 153, 0));
        jComboBoxApartamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "APARTAMENTO 101", "APARTAMENTO 102", "APARTAMENTO 103", "APARTAMENTO 104", "APARTAMENTO 201", "APARTAMENTO 202", "APARTAMENTO 203", "APARTAMENTO 204", "APARTAMENTO 301", "APARTAMENTO 302", "APARTAMENTO 303", "APARTAMENTO 304", "APARTAMENTO 401", "APARTAMENTO 402", "APARTAMENTO 403", "APARTAMENTO 404", " ", " " }));

        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(0, 153, 0));
        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesq.png"))); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTextAreaMoradores.setBackground(new java.awt.Color(0, 0, 0));
        jTextAreaMoradores.setColumns(20);
        jTextAreaMoradores.setForeground(new java.awt.Color(51, 204, 0));
        jTextAreaMoradores.setRows(5);
        jScrollPane2.setViewportView(jTextAreaMoradores);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Moradores");

        jButtonConfirmar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonConfirmar.setForeground(new java.awt.Color(0, 153, 0));
        jButtonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/accept.png"))); // NOI18N
        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Situação:");

        jLabelSaida.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSaida.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSaida.setText("saida");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jComboBoxBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxApartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSaida)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(177, 177, 177)))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxBloco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxApartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabelSaida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
       conex.conexao();
        
        conex.execultasql("select idMorador ,nomeMorador,situacaoImovel from condominio where bloco='"+jComboBoxBloco.getSelectedItem()+"' and numeroApartamento='"+jComboBoxApartamento.getSelectedItem()+"'");
           
        
        try {
               
               
               conex.rs.first();
               jLabelCodigoMorador.setText(String.valueOf(conex.rs.getInt("idMorador")));               
               jTextAreaMoradores.setText(conex.rs.getString("nomeMorador"));
               jLabelSaida.setText(conex.rs.getString("situacaoImovel"));
           } catch (SQLException ex) {

           JOptionPane.showMessageDialog(rootPane,"Não foi possível");
           dispose();

}  
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
         
        conex.conexao();
        
        String saida="Vazio";  
        conex.execultasql("select idMorador,situacaoImovel from condominio where idMorador='"+jLabelCodigoMorador.getText()+"' and situacaoImovel='"+saida+"'");
         try {              
              conex.rs.first(); 
               jLabelCodigoMorador.setText(String.valueOf(conex.rs.getInt("idMorador")));   
                jLabelSaida.setText(conex.rs.getString("situacaoImovel"));  
               JOptionPane.showMessageDialog(rootPane,"Impossível!!");
                JOptionPane.showMessageDialog(rootPane,"A saída já foi realizada!!");
                dispose();
                
           } catch (SQLException ex1) {
        
        
        
        
        
        
      ///////////////////////////////////////  
        
        
        String[] options = {"Sim", "Não"};

        int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja Salvar ?",
                "Confirmar",JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        

        if (resposta == 1) {
        	
        	return;  //Este é o Botao do NAO. Ira retornar para a Calculadora
        }
        
        if(resposta == 0){  try {
            //Este é o Botao do SIM. Ira sair do seu Programa
            
     	
            PreparedStatement confirmar = conex.conn.prepareStatement("call saidaMudanca('"+jLabelCodigoMorador.getText()+"','"+(String)jComboBoxBloco.getSelectedItem()+"','"+(String)jComboBoxApartamento.getSelectedItem()+"')");
            confirmar.execute();
            //JOptionPane.showMessageDialog(rootPane,"Mudança realizada com sucesso");
            dispose();
            
            new ConfirmarSaidaVeiculoMudanca(String.valueOf(jComboBoxBloco.getSelectedItem()),String.valueOf(jComboBoxApartamento.getSelectedItem())).setVisible(true);
        
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane,"Erro"+ex);
            }
            
             
        
        
               
           }
        
        ///////////////////////////////////////////////////
      }
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
            java.util.logging.Logger.getLogger(Saida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Saida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Saida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Saida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Saida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Data;
    private javax.swing.JLabel Hora;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox jComboBoxApartamento;
    private javax.swing.JComboBox jComboBoxBloco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCodigoMorador;
    private javax.swing.JLabel jLabelSaida;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaMoradores;
    // End of variables declaration//GEN-END:variables
}
