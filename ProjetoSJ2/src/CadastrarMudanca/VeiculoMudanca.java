/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CadastrarMudanca;

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
public class VeiculoMudanca extends javax.swing.JFrame {

    ConectaBanco conex = new ConectaBanco();
    int idMudanca;
    int idMorador;
    int idVeiculo;
    public VeiculoMudanca(String bloco, String apt) {
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
    
    jButtonSalvar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonSalvar.getActionMap().put("DoClick", action);


    
    
            
        
       
        // Para buscar o bloco e o numero do apartamento cadastrado no condominio
        conex.conexao();
      
      conex.execultasql("select idMorador , idVeiculo,bloco, numeroApartamento  from veiculo  where bloco = '"+bloco+"' and numeroApartamento ='"+apt+"'");
        try {
            conex.rs.first();
            
            idMorador=conex.rs.getInt("idMorador");
            idVeiculo=conex.rs.getInt("idveiculo");
            
            jLabelBloco.setText(conex.rs.getString("bloco"));
            jLabelApt.setText(conex.rs.getString("numeroApartamento"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Bloco e numero do apartamento não cadastrado");
            JOptionPane.showMessageDialog(rootPane,"Volte ao menu Cadastrar Moradores e cadastre");
            
            
            
            
        }
        
        
        ////////////////////////////////
        
        conex.conexao();
        conex.execultasql("select max(idMudanca) as idMudanca  from mudanca  where bloco = '"+bloco+"' and numeroApartamento ='"+apt+"'");
        try {
            conex.rs.first();
            
            
           
            idMudanca=conex.rs.getInt("idMudanca");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro");
           
            
            
            
            
        }
        
        
        
     jTextFieldDescricao.setEnabled(false);   
        
        jTextFieldModeloCarroAdesivado.setEnabled(false);   
       jTextFieldCorCarroAdesivado.setEnabled(false);  
       jTextFieldMotoristaCarroAdesivado.setEnabled(false);  
       jTextFieldCnhCarroAdesivado.setEnabled(false);  
       jTextFieldPlacaCarroAdesivado.setEnabled(false);  
       
       
      
       jTextFieldModeloCarroNaoAdesivado.setEnabled(false);  
       jTextFieldCorCarroNaoAdesivado.setEnabled(false);  
       jTextFieldMotoristaCarroNaoAdesivado.setEnabled(false);  
       jTextFieldCnhCarroNaoAdesivado.setEnabled(false);  
       jTextFieldPlacaCarroNaoAdesivado.setEnabled(false);  
       
       
       jTextFieldModeloMoto1.setEnabled(false);  
       jTextFieldCorMoto1.setEnabled(false);  
       jTextFieldMotoristaMoto1.setEnabled(false);  
       jTextFieldCnhMoto1.setEnabled(false);  
       jTextFieldPlacaMoto1.setEnabled(false);  
       
       
       jTextFieldModeloMoto2.setEnabled(false);  
       jTextFieldCorMoto2.setEnabled(false);  
       jTextFieldMotoristaMoto2.setEnabled(false);  
       jTextFieldCnhMoto2.setEnabled(false);  
       jTextFieldPlacaMoto2.setEnabled(false);  
       jTextAreaBicicleta.setEnabled(false);

    jButtonSalvar.setEnabled(false);
        
        
    }

    private VeiculoMudanca() {
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
        jPanel2 = new javax.swing.JPanel();
        jTextFieldModeloCarroAdesivado = new javax.swing.JTextField();
        jTextFieldCorCarroAdesivado = new javax.swing.JTextField();
        jTextFieldMotoristaCarroAdesivado = new javax.swing.JTextField();
        jTextFieldCnhCarroAdesivado = new javax.swing.JTextField();
        jTextFieldPlacaCarroAdesivado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldPlacaCarroNaoAdesivado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldCorCarroNaoAdesivado = new javax.swing.JTextField();
        jTextFieldMotoristaCarroNaoAdesivado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCnhCarroNaoAdesivado = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldModeloCarroNaoAdesivado = new javax.swing.JTextField();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldModeloMoto1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldCorMoto1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldMotoristaMoto1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldCnhMoto1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldPlacaMoto1 = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jButtonSalvar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldModeloMoto2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldCorMoto2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldMotoristaMoto2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldCnhMoto2 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldPlacaMoto2 = new javax.swing.JTextField();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaBicicleta = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabeGaragem = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabelBloco = new javax.swing.JLabel();
        jLabelApt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jCheckBoxOculpada = new javax.swing.JCheckBox();
        jCheckBoxAlugada = new javax.swing.JCheckBox();
        jCheckBoxVazia = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CondominioSJ2");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jTextFieldModeloCarroAdesivado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldModeloCarroAdesivadoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Modelo ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Cor ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Motorista");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("CNH ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Placa ");

        jRadioButton1.setBackground(new java.awt.Color(204, 204, 204));
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(102, 102, 102));
        jRadioButton1.setText("Vazio");
        jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jRadioButton1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldCorCarroAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldModeloCarroAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldCnhCarroAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldMotoristaCarroAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPlacaCarroAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(28, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldModeloCarroAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldCorCarroAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldMotoristaCarroAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCnhCarroAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldPlacaCarroAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jRadioButton1))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Modelo ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Cor ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Motorista ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("CNH ");

        jLabel21.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Placa");

        jRadioButton2.setBackground(new java.awt.Color(204, 204, 204));
        jRadioButton2.setForeground(new java.awt.Color(102, 102, 102));
        jRadioButton2.setText("Vazio");
        jRadioButton2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCnhCarroNaoAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPlacaCarroNaoAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldMotoristaCarroNaoAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCorCarroNaoAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldModeloCarroNaoAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jRadioButton2)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldModeloCarroNaoAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCorCarroNaoAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMotoristaCarroNaoAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldCnhCarroNaoAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextFieldPlacaCarroNaoAdesivado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2))
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Modelo");

        jLabel12.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Cor");

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Motorista");

        jLabel14.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("CNH");

        jLabel15.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Placa");

        jRadioButton3.setBackground(new java.awt.Color(204, 204, 204));
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(102, 102, 102));
        jRadioButton3.setText("Vazio");
        jRadioButton3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton3ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldCnhMoto1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jTextFieldMotoristaMoto1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCorMoto1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldModeloMoto1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPlacaMoto1)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButton3)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldModeloMoto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldCorMoto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldMotoristaMoto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldCnhMoto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldPlacaMoto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton3))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jButtonSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/22.png"))); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setToolTipText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(1154, Short.MAX_VALUE)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel16.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Modelo");

        jLabel17.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Cor");

        jLabel18.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Motorista");

        jLabel19.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("CNH");

        jLabel20.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Placa");

        jRadioButton4.setBackground(new java.awt.Color(204, 204, 204));
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(102, 102, 102));
        jRadioButton4.setText("Vazio");
        jRadioButton4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton4ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jRadioButton4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldModeloMoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldCorMoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldMotoristaMoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldCnhMoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldPlacaMoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(21, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldModeloMoto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldCorMoto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextFieldMotoristaMoto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextFieldCnhMoto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextFieldPlacaMoto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton4))
        );

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("CARRO  ADESIVADO");

        jLabel22.setBackground(new java.awt.Color(204, 204, 204));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("CARRO NÃO ADESIVADO");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("MOTO 1");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("MOTO 2");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 153, 51));
        jLabel28.setText("Bicicletas");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel23)
                .addGap(102, 102, 102)
                .addComponent(jLabel22)
                .addGap(173, 173, 173)
                .addComponent(jLabel24)
                .addGap(224, 224, 224)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addGap(127, 127, 127))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addComponent(jLabel28))
                .addContainerGap())
        );

        jTextAreaBicicleta.setColumns(20);
        jTextAreaBicicleta.setRows(5);
        jScrollPane1.setViewportView(jTextAreaBicicleta);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 1304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 1339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setForeground(new java.awt.Color(51, 102, 255));
        jLabel27.setText("Garagem");

        jLabeGaragem.setForeground(new java.awt.Color(255, 153, 51));
        jLabeGaragem.setText("Estado");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel27)
                .addGap(70, 70, 70)
                .addComponent(jLabeGaragem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabeGaragem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel26.setText("Cadastrar veiculos  Mudanças");

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        jLabelBloco.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabelBloco.setForeground(new java.awt.Color(0, 153, 0));
        jLabelBloco.setText("BLOCO");

        jLabelApt.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabelApt.setForeground(new java.awt.Color(51, 153, 0));
        jLabelApt.setText("APARTAMENTO");

        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Alugada para:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabelBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelApt, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(424, 424, 424))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApt)
                    .addComponent(jLabelBloco))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jCheckBoxOculpada.setForeground(new java.awt.Color(51, 102, 255));
        jCheckBoxOculpada.setText("Ocupada");
        jCheckBoxOculpada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxOculpadaItemStateChanged(evt);
            }
        });

        jCheckBoxAlugada.setForeground(new java.awt.Color(51, 102, 255));
        jCheckBoxAlugada.setText("Alugada");
        jCheckBoxAlugada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxAlugadaItemStateChanged(evt);
            }
        });

        jCheckBoxVazia.setForeground(new java.awt.Color(51, 102, 255));
        jCheckBoxVazia.setText("vazio");
        jCheckBoxVazia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxVaziaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxOculpada)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBoxAlugada)
                        .addGap(38, 38, 38)
                        .addComponent(jCheckBoxVazia)
                        .addGap(203, 203, 203)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1315, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 28, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBoxOculpada)
                            .addComponent(jCheckBoxAlugada)
                            .addComponent(jCheckBoxVazia))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldModeloCarroAdesivadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldModeloCarroAdesivadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldModeloCarroAdesivadoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        
        
        String[] options = {"Sim", "Não"};

        int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja Salvar ?",
                "Confirmar",JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        

        if (resposta == 1) {
        	
        	return;  //Este é o Botao do NAO. Ira retornar para a Calculadora
        }
        
        if(resposta == 0){  try {
            //Este é o Botao do SIM. Ira sair do seu Programa
            
            PreparedStatement inserirVeiculo = conex.conn.prepareStatement("call inserirVeiculoMudanca('"+idVeiculo+"','"+idMorador+"','"+idMudanca+"','"+jLabelBloco.getText()+"','"+jLabelApt.getText()+"','"+jTextFieldModeloCarroAdesivado.getText()+"','"+jTextFieldCorCarroAdesivado.getText()+"','"+jTextFieldMotoristaCarroAdesivado.getText()+"','"+jTextFieldCnhCarroAdesivado.getText()+"','"+jTextFieldPlacaCarroAdesivado.getText()+"'   ,'"+jTextFieldModeloCarroNaoAdesivado.getText()+"','"+jTextFieldCorCarroNaoAdesivado.getText()+"','"+jTextFieldMotoristaCarroNaoAdesivado.getText()+"','"+jTextFieldCnhCarroNaoAdesivado.getText()+"','"+jTextFieldPlacaCarroNaoAdesivado.getText()+"'    ,'"+jTextFieldModeloMoto1.getText()+"','"+jTextFieldCorMoto1.getText()+"','"+jTextFieldMotoristaMoto1.getText()+"','"+jTextFieldCnhMoto1.getText()+"','"+jTextFieldPlacaMoto1.getText()+"'   ,'"+jTextFieldModeloMoto2.getText()+"','"+jTextFieldCorMoto2.getText()+"','"+jTextFieldMotoristaMoto2.getText()+"','"+jTextFieldCnhMoto2.getText()+"','"+jTextFieldPlacaMoto2.getText()+"','"+jLabeGaragem.getText()+"','"+jTextFieldDescricao.getText()+"','"+jTextAreaBicicleta.getText()+"')");
            
            inserirVeiculo.execute();
            
             JOptionPane.showMessageDialog(rootPane,"Salvo com sucesso");
             dispose();
             
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane,"Erro ao Salvar"+ex);
            }
                
        }
        
        
        
        dispose();
        //System.exit(1);
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton1ItemStateChanged
        String a = (String)jRadioButton1.getText();
         
           jTextFieldModeloCarroAdesivado.setText(a);
           jTextFieldCorCarroAdesivado.setText(a);
           jTextFieldMotoristaCarroAdesivado.setText(a);
           jTextFieldCnhCarroAdesivado.setText(a);
           jTextFieldPlacaCarroAdesivado.setText(a);
    }//GEN-LAST:event_jRadioButton1ItemStateChanged

    private void jRadioButton2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton2ItemStateChanged
       String a = (String)jRadioButton2.getText();
         
           jTextFieldModeloCarroNaoAdesivado.setText(a);
           jTextFieldCorCarroNaoAdesivado.setText(a);
           jTextFieldMotoristaCarroNaoAdesivado.setText(a);
           jTextFieldCnhCarroNaoAdesivado.setText(a);
           jTextFieldPlacaCarroNaoAdesivado.setText(a);
    }//GEN-LAST:event_jRadioButton2ItemStateChanged

    private void jRadioButton3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton3ItemStateChanged
         String a = (String)jRadioButton3.getText();
         
           jTextFieldModeloMoto1.setText(a);
           jTextFieldCorMoto1.setText(a);
           jTextFieldMotoristaMoto1.setText(a);
           jTextFieldCnhMoto1.setText(a);
           jTextFieldPlacaMoto1.setText(a);
    }//GEN-LAST:event_jRadioButton3ItemStateChanged

    private void jRadioButton4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton4ItemStateChanged
        String a = (String)jRadioButton4.getText();
         
           jTextFieldModeloMoto2.setText(a);
           jTextFieldCorMoto2.setText(a);
           jTextFieldMotoristaMoto2.setText(a);
           jTextFieldCnhMoto2.setText(a);
           jTextFieldPlacaMoto2.setText(a);
    }//GEN-LAST:event_jRadioButton4ItemStateChanged

    private void jCheckBoxOculpadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxOculpadaItemStateChanged
        // TODO add your handling code here:
        
        String a = (String)jCheckBoxOculpada.getText();
           jLabeGaragem.setText(a);
           jCheckBoxAlugada.setSelected(false);
           jCheckBoxVazia.setSelected(false);
           
           jTextFieldModeloCarroAdesivado.setText("");
           jTextFieldCorCarroAdesivado.setText("");
           jTextFieldMotoristaCarroAdesivado.setText("");
           jTextFieldCnhCarroAdesivado.setText("");
           jTextFieldPlacaCarroAdesivado.setText("");
           jTextFieldModeloCarroNaoAdesivado.setText("");
           jTextFieldCorCarroNaoAdesivado.setText("");
           jTextFieldMotoristaCarroNaoAdesivado.setText("");
           jTextFieldCnhCarroNaoAdesivado.setText("");
           jTextFieldPlacaCarroNaoAdesivado.setText("");
           jTextFieldModeloMoto1.setText("");
           jTextFieldCorMoto1.setText("");
           jTextFieldMotoristaMoto1.setText("");
           jTextFieldCnhMoto1.setText("");
           jTextFieldPlacaMoto1.setText("");
           jTextFieldModeloMoto2.setText("");
           jTextFieldCorMoto2.setText("");
           jTextFieldMotoristaMoto2.setText("");
           jTextFieldCnhMoto2.setText("");
           jTextFieldPlacaMoto2.setText("");
           jTextAreaBicicleta.setText("");
           
           jTextFieldDescricao.setEnabled(false);
           
           
           
           jTextFieldModeloCarroAdesivado.setEnabled(!false);
           jTextFieldCorCarroAdesivado.setEnabled(!false);
           jTextFieldMotoristaCarroAdesivado.setEnabled(!false);
           jTextFieldCnhCarroAdesivado.setEnabled(!false);
           jTextFieldPlacaCarroAdesivado.setEnabled(!false);
           jTextFieldModeloCarroNaoAdesivado.setEnabled(!false);
           jTextFieldCorCarroNaoAdesivado.setEnabled(!false);
           jTextFieldMotoristaCarroNaoAdesivado.setEnabled(!false);
           jTextFieldCnhCarroNaoAdesivado.setEnabled(!false);
           jTextFieldPlacaCarroNaoAdesivado.setEnabled(!false);
           jTextFieldModeloMoto1.setEnabled(!false);
           jTextFieldCorMoto1.setEnabled(!false);
           jTextFieldMotoristaMoto1.setEnabled(!false);
           jTextFieldCnhMoto1.setEnabled(!false);
           jTextFieldPlacaMoto1.setEnabled(!false);
           jTextFieldModeloMoto2.setEnabled(!false);
           jTextFieldCorMoto2.setEnabled(!false);
           jTextFieldMotoristaMoto2.setEnabled(!false);
           jTextFieldCnhMoto2.setEnabled(!false);
           jTextFieldPlacaMoto2.setEnabled(!false);
           jTextAreaBicicleta.setEnabled(!false); 
            jButtonSalvar.setEnabled(!false);
    }//GEN-LAST:event_jCheckBoxOculpadaItemStateChanged

    private void jCheckBoxAlugadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxAlugadaItemStateChanged
        // TODO add your handling code here:
        
         String a = (String)jCheckBoxAlugada.getText();
           jLabeGaragem.setText(a);
           
           jCheckBoxOculpada.setSelected(false);
           jCheckBoxVazia.setSelected(false);
           
           jTextFieldModeloCarroAdesivado.setText("");
           jTextFieldCorCarroAdesivado.setText("");
           jTextFieldMotoristaCarroAdesivado.setText("");
           jTextFieldCnhCarroAdesivado.setText("");
           jTextFieldPlacaCarroAdesivado.setText("");
           jTextFieldModeloCarroNaoAdesivado.setText("");
           jTextFieldCorCarroNaoAdesivado.setText("");
           jTextFieldMotoristaCarroNaoAdesivado.setText("");
           jTextFieldCnhCarroNaoAdesivado.setText("");
           jTextFieldPlacaCarroNaoAdesivado.setText("");
           jTextFieldModeloMoto1.setText("");
           jTextFieldCorMoto1.setText("");
           jTextFieldMotoristaMoto1.setText("");
           jTextFieldCnhMoto1.setText("");
           jTextFieldPlacaMoto1.setText("");
           jTextFieldModeloMoto2.setText("");
           jTextFieldCorMoto2.setText("");
           jTextFieldMotoristaMoto2.setText("");
           jTextFieldCnhMoto2.setText("");
           jTextFieldPlacaMoto2.setText("");
           jTextAreaBicicleta.setText("");
           
           
            jTextFieldDescricao.setEnabled(!false);
            
            jTextFieldModeloCarroAdesivado.setEnabled(!false);
           jTextFieldCorCarroAdesivado.setEnabled(!false);
           jTextFieldMotoristaCarroAdesivado.setEnabled(!false);
           jTextFieldCnhCarroAdesivado.setEnabled(!false);
           jTextFieldPlacaCarroAdesivado.setEnabled(!false);
           jTextFieldModeloCarroNaoAdesivado.setEnabled(!false);
           jTextFieldCorCarroNaoAdesivado.setEnabled(!false);
           jTextFieldMotoristaCarroNaoAdesivado.setEnabled(!false);
           jTextFieldCnhCarroNaoAdesivado.setEnabled(!false);
           jTextFieldPlacaCarroNaoAdesivado.setEnabled(!false);
           jTextFieldModeloMoto1.setEnabled(!false);
           jTextFieldCorMoto1.setEnabled(!false);
           jTextFieldMotoristaMoto1.setEnabled(!false);
           jTextFieldCnhMoto1.setEnabled(!false);
           jTextFieldPlacaMoto1.setEnabled(!false);
           jTextFieldModeloMoto2.setEnabled(!false);
           jTextFieldCorMoto2.setEnabled(!false);
           jTextFieldMotoristaMoto2.setEnabled(!false);
           jTextFieldCnhMoto2.setEnabled(!false);
           jTextFieldPlacaMoto2.setEnabled(!false);
           jTextAreaBicicleta.setEnabled(!false);
            jButtonSalvar.setEnabled(!false);
    }//GEN-LAST:event_jCheckBoxAlugadaItemStateChanged

    private void jCheckBoxVaziaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxVaziaItemStateChanged
        // TODO add your handling code here:
        
         String a = (String)jCheckBoxVazia.getText();
           jLabeGaragem.setText(a);
           
           jCheckBoxAlugada.setSelected(false);
           jCheckBoxOculpada.setSelected(false);
           
           jTextFieldModeloCarroAdesivado.setText("");
           jTextFieldCorCarroAdesivado.setText("");
           jTextFieldMotoristaCarroAdesivado.setText("");
           jTextFieldCnhCarroAdesivado.setText("");
           jTextFieldPlacaCarroAdesivado.setText("");
           jTextFieldModeloCarroNaoAdesivado.setText("");
           jTextFieldCorCarroNaoAdesivado.setText("");
           jTextFieldMotoristaCarroNaoAdesivado.setText("");
           jTextFieldCnhCarroNaoAdesivado.setText("");
           jTextFieldPlacaCarroNaoAdesivado.setText("");
           jTextFieldModeloMoto1.setText("");
           jTextFieldCorMoto1.setText("");
           jTextFieldMotoristaMoto1.setText("");
           jTextFieldCnhMoto1.setText("");
           jTextFieldPlacaMoto1.setText("");
           jTextFieldModeloMoto2.setText("");
           jTextFieldCorMoto2.setText("");
           jTextFieldMotoristaMoto2.setText("");
           jTextFieldCnhMoto2.setText("");
           jTextFieldPlacaMoto2.setText("");
           jTextAreaBicicleta.setText("");
             
           jTextFieldModeloCarroAdesivado.setText(a);
           jTextFieldCorCarroAdesivado.setText(a);
           jTextFieldMotoristaCarroAdesivado.setText(a);
           jTextFieldCnhCarroAdesivado.setText(a);
           jTextFieldPlacaCarroAdesivado.setText(a);
           jTextFieldModeloCarroNaoAdesivado.setText(a);
           jTextFieldCorCarroNaoAdesivado.setText(a);
           jTextFieldMotoristaCarroNaoAdesivado.setText(a);
           jTextFieldCnhCarroNaoAdesivado.setText(a);
           jTextFieldPlacaCarroNaoAdesivado.setText(a);
           jTextFieldModeloMoto1.setText(a);
           jTextFieldCorMoto1.setText(a);
           jTextFieldMotoristaMoto1.setText(a);
           jTextFieldCnhMoto1.setText(a);
           jTextFieldPlacaMoto1.setText(a);
           jTextFieldModeloMoto2.setText(a);
           jTextFieldCorMoto2.setText(a);
           jTextFieldMotoristaMoto2.setText(a);
           jTextFieldCnhMoto2.setText(a);
           jTextFieldPlacaMoto2.setText(a);
           
            jTextFieldDescricao.setEnabled(false);
            jButtonSalvar.setEnabled(!false);
    }//GEN-LAST:event_jCheckBoxVaziaItemStateChanged

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
            java.util.logging.Logger.getLogger(VeiculoMudanca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VeiculoMudanca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VeiculoMudanca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VeiculoMudanca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VeiculoMudanca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JCheckBox jCheckBoxAlugada;
    private javax.swing.JCheckBox jCheckBoxOculpada;
    private javax.swing.JCheckBox jCheckBoxVazia;
    private javax.swing.JLabel jLabeGaragem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelApt;
    private javax.swing.JLabel jLabelBloco;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextArea jTextAreaBicicleta;
    private javax.swing.JTextField jTextFieldCnhCarroAdesivado;
    private javax.swing.JTextField jTextFieldCnhCarroNaoAdesivado;
    private javax.swing.JTextField jTextFieldCnhMoto1;
    private javax.swing.JTextField jTextFieldCnhMoto2;
    private javax.swing.JTextField jTextFieldCorCarroAdesivado;
    private javax.swing.JTextField jTextFieldCorCarroNaoAdesivado;
    private javax.swing.JTextField jTextFieldCorMoto1;
    private javax.swing.JTextField jTextFieldCorMoto2;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldModeloCarroAdesivado;
    private javax.swing.JTextField jTextFieldModeloCarroNaoAdesivado;
    private javax.swing.JTextField jTextFieldModeloMoto1;
    private javax.swing.JTextField jTextFieldModeloMoto2;
    private javax.swing.JTextField jTextFieldMotoristaCarroAdesivado;
    private javax.swing.JTextField jTextFieldMotoristaCarroNaoAdesivado;
    private javax.swing.JTextField jTextFieldMotoristaMoto1;
    private javax.swing.JTextField jTextFieldMotoristaMoto2;
    private javax.swing.JTextField jTextFieldPlacaCarroAdesivado;
    private javax.swing.JTextField jTextFieldPlacaCarroNaoAdesivado;
    private javax.swing.JTextField jTextFieldPlacaMoto1;
    private javax.swing.JTextField jTextFieldPlacaMoto2;
    // End of variables declaration//GEN-END:variables
}
