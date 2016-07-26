/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Portaria;

import Controle.ConectaBanco;
import Controle.ControleFuncionario;
import Modelo.ModeloFuncionario;
import Visao.Principal;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Eduardo
 */
public class Funcionario extends javax.swing.JFrame {
    ControleFuncionario control = new ControleFuncionario();
    ModeloFuncionario mod = new ModeloFuncionario();
    ConectaBanco conex = new ConectaBanco();
    FileInputStream fis ;
    int longitudBytes;  
   
    private BufferedImage img;
    
    
    public Funcionario() {
        initComponents();
        
         URL url = this.getClass().getResource("/Imagens/condominio.jpg");  //coloca a imagem no lugar da tigela java
          Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
            this.setIconImage(imagemTitulo);
        
        this.setExtendedState(getExtendedState()| Funcionario .MAXIMIZED_BOTH);
        

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
    
    jButtonP.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonP.getActionMap().put("DoClick", action);
   
   
        
        
        
        
        try {
            MaskFormatter form = new MaskFormatter("(##)#####-####");//elemento que cria o formato da mascara  
            jFormattedTextFieldCelularProprio.setFormatterFactory(new DefaultFormatterFactory(form));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro!");
        }
        
        
         try {
            MaskFormatter form = new MaskFormatter("(##)####-####");//elemento que cria o formato da mascara  
            jFormattedTextFieldTelefoneRecado.setFormatterFactory(new DefaultFormatterFactory(form));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro!");
        }
        
         
        try {
            MaskFormatter form = new MaskFormatter("##.###.###");
           
            jFormattedTextFieldRG.setFormatterFactory(new DefaultFormatterFactory(form));
            
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro!");
        }
         
         try {
            MaskFormatter form = new MaskFormatter("###.###.###-##");
           
            jFormattedTextFieldCPF.setFormatterFactory(new DefaultFormatterFactory(form));
            
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro!");
        }
       
        
        
     
         jTextFieldPesquisa.requestFocus();
                 
         jTextFieldMatricula.setEnabled(false);
         
         jButtonAtualizaFoto.setEnabled(false);
         jButtonAtualizarDados.setEnabled(false);
         jButtonBuscarFotos.setEnabled(!false);
         jButtonSalvar.setEnabled(!false);
         jButtonSalvarSomenteDados.setEnabled(!false);
         
         
         // jLabelImg.setIcon(null);
        
         FileNameExtensionFilter filtro=new FileNameExtensionFilter("Formatos de Arquivos JPEG(*.JPG;*.JPEG)","jpg","jpeg");    
          
         
         
             JFileChooser j= new JFileChooser();
             j.setFileSelectionMode(JFileChooser.FILES_ONLY);
             
            
             
             j.addChoosableFileFilter(filtro);
             j.setDialogTitle("Escolha a foto desejada para cadastrar !S");
            File ruta = new File("C:/ImgTeste");
             j.setCurrentDirectory(ruta);
             
             
             
             int estado=j.showOpenDialog(null);
             
             
             if(estado==JFileChooser.APPROVE_OPTION){
                 
                 try{
                 
                 fis=new FileInputStream(j.getSelectedFile());
                 this.longitudBytes=(int)j.getSelectedFile().length();
                 
                 try{
                     
                    Image icono=ImageIO.read(j.getSelectedFile()).getScaledInstance
        (jLabelImg.getWidth(),jLabelImg.getHeight(), Image.SCALE_DEFAULT);
                    jLabelImg.setIcon(new ImageIcon(icono));
                    jLabelImg.updateUI();
                    
                    
                   if(jTextFieldMatricula.getText().equals("")){
                      jButtonAtualizaFoto.setEnabled(false);  
                       jButtonSalvarSomenteDados.setEnabled(false);
                       jButtonSalvar.setEnabled(!false);
                    }else{
                     jButtonAtualizaFoto.setEnabled(!false);  
                   
                    }
                    
                     
             }catch(IOException ex){
                     
                     
             JOptionPane.showMessageDialog(rootPane,"imagem"+ex);
             
             
             
           }
                 
         } catch(FileNotFoundException ex){
                 
                 ex.printStackTrace();
                 
                 
       }   
                 
      }else{
                 jButtonSalvar.setEnabled(false);
             }
             
        
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
        jLabel1 = new javax.swing.JLabel();
        jButtonP = new javax.swing.JButton();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jFormattedTextFieldRG = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCelularProprio = new javax.swing.JFormattedTextField();
        jFormattedTextFieldTelefoneRecado = new javax.swing.JFormattedTextField();
        jTextFieldContato = new javax.swing.JTextField();
        jFormattedTextFieldEmail = new javax.swing.JFormattedTextField();
        jTextFieldRua = new javax.swing.JTextField();
        jTextFieldNumero = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jTextFieldComplemento = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jTextFieldEstadoRG = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldEstadoCidade = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabelImg = new javax.swing.JLabel();
        jButtonBuscarFotos = new javax.swing.JButton();
        jTextFieldMatricula = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonAtualizaFoto = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButtonAtualizarDados = new javax.swing.JButton();
        jButtonSalvarSomenteDados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Condominio-SJ2");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de pessoas");

        jButtonP.setBackground(new java.awt.Color(255, 255, 255));
        jButtonP.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButtonP.setForeground(new java.awt.Color(51, 153, 0));
        jButtonP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesq.png"))); // NOI18N
        jButtonP.setText("Pesquisa e aciona o botão Buscar foto");
        jButtonP.setToolTipText("Pesquisar pessoas cadastradas");
        jButtonP.setBorder(null);
        jButtonP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPActionPerformed(evt);
            }
        });

        jTextFieldPesquisa.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonP, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setText("Nome:");

        jLabel3.setText("RG:");

        jLabel4.setText("CPF:");

        jLabel5.setText("Celular:");

        jLabel6.setText("Telefone recado:");

        jLabel7.setText("Contato:");

        jLabel8.setText("Email:");

        jLabel9.setText("Rua:");

        jLabel10.setText("Número:");

        jLabel11.setText("Bairro:");

        jLabel12.setText("Complemento:");

        jTextFieldNome.setForeground(new java.awt.Color(0, 51, 255));
        jTextFieldNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jFormattedTextFieldRG.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jFormattedTextFieldRG.setForeground(new java.awt.Color(51, 153, 0));

        jFormattedTextFieldCPF.setForeground(new java.awt.Color(255, 153, 0));

        jTextFieldEstadoRG.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setText("Estado:");

        jLabel16.setText("Cidade:");

        jLabel17.setText("Estado");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Foto.png"))); // NOI18N
        jLabelImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonBuscarFotos.setBackground(new java.awt.Color(255, 255, 255));
        jButtonBuscarFotos.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jButtonBuscarFotos.setForeground(new java.awt.Color(51, 153, 0));
        jButtonBuscarFotos.setText("Buscar Foto");
        jButtonBuscarFotos.setBorder(null);
        jButtonBuscarFotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarFotosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonBuscarFotos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelImg, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButtonBuscarFotos)
                .addContainerGap())
        );

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Matrícula:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 51, 204));
        jLabel18.setText("Digite aqui a matrícula , ou o nome , ou o rg  , ou o cpf  para pesquisar.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel15))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jFormattedTextFieldRG, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                                    .addComponent(jFormattedTextFieldCelularProprio, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jFormattedTextFieldTelefoneRecado, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addGap(126, 126, 126)
                                                .addComponent(jLabel14)
                                                .addGap(32, 32, 32)
                                                .addComponent(jTextFieldEstadoRG, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTextFieldContato, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldComplemento)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jFormattedTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(49, 49, 49)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel17)
                                                                .addGap(25, 25, 25)
                                                                .addComponent(jTextFieldEstadoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel10)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jTextFieldNumero)))))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(191, 191, 191))))
                            .addComponent(jSeparator5)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldEstadoRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldCelularProprio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldTelefoneRecado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldEstadoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/portaria.jpg"))); // NOI18N
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 102, 0));
        jButton1.setText("Primeiro");
        jButton1.setToolTipText("Primeiro");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 102, 51));
        jButton2.setText("Próximo");
        jButton2.setToolTipText("Próximo");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 102, 51));
        jButton3.setText("Anterior");
        jButton3.setToolTipText("Anterior");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setForeground(new java.awt.Color(255, 102, 51));
        jButton4.setText("Último");
        jButton4.setToolTipText("Último");
        jButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButtonSalvar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSalvar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(51, 153, 0));
        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/22.png"))); // NOI18N
        jButtonSalvar.setText("Cadastrar dados e gravar Fotos");
        jButtonSalvar.setToolTipText("Salva os dados e grava a foto");
        jButtonSalvar.setBorder(null);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonAtualizaFoto.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAtualizaFoto.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jButtonAtualizaFoto.setForeground(new java.awt.Color(51, 153, 0));
        jButtonAtualizaFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/accept.png"))); // NOI18N
        jButtonAtualizaFoto.setText("Editar dados e Fotos");
        jButtonAtualizaFoto.setToolTipText("Para atualizar a foto jundo com os dados");
        jButtonAtualizaFoto.setBorder(null);
        jButtonAtualizaFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizaFotoActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jButton7.setForeground(new java.awt.Color(51, 153, 0));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/vassoura.jpg"))); // NOI18N
        jButton7.setText("Limpar");
        jButton7.setToolTipText("Clique aui para limpar os dados.");
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButtonAtualizarDados.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAtualizarDados.setForeground(new java.awt.Color(0, 51, 255));
        jButtonAtualizarDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/accept.png"))); // NOI18N
        jButtonAtualizarDados.setText("Editar dados");
        jButtonAtualizarDados.setToolTipText("Para atualizar somente os dados");
        jButtonAtualizarDados.setBorder(null);
        jButtonAtualizarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarDadosActionPerformed(evt);
            }
        });

        jButtonSalvarSomenteDados.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSalvarSomenteDados.setForeground(new java.awt.Color(0, 51, 255));
        jButtonSalvarSomenteDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/accept.png"))); // NOI18N
        jButtonSalvarSomenteDados.setText("Cadastrar dados");
        jButtonSalvarSomenteDados.setToolTipText("Salva os dados sem precisar salvar as fotos");
        jButtonSalvarSomenteDados.setBorder(null);
        jButtonSalvarSomenteDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarSomenteDadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(jButtonSalvarSomenteDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAtualizarDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAtualizaFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButtonAtualizaFoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAtualizarDados)
                .addGap(10, 10, 10)
                .addComponent(jButtonSalvarSomenteDados)
                .addGap(18, 18, 18)
                .addComponent(jButtonSalvar)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
     
        
        if(!jTextFieldMatricula.getText().equals("")){
            
             JOptionPane.showMessageDialog(rootPane,"Não sera possível gravar esses dados , porque ele ja foi cadastrado , mas você pode altera-los se for necessário.");
            
            
            
        }else if(jTextFieldNome.getText().equals("") || jFormattedTextFieldRG.getText().equals("")|| jTextFieldEstadoRG.getText().equals("")||jTextFieldCidade.getText().equals("")|| jTextFieldEstadoCidade.getText().equals("")|| jTextFieldRua.getText().equals("")|| jTextFieldNumero.getText().equals("")|| jTextFieldBairro.getText().equals("")|| jTextFieldComplemento.getText().equals("")){
            
            
             JOptionPane.showMessageDialog(rootPane," Atenção para cadastrar é preciso cadastrar os dados citados  !");
            
             JOptionPane.showMessageDialog(rootPane,"É obrigatório cadastrar , nome , rg , estodo do rg ,cidade , estado da cidade , rua , numero , bairro e complemento !");
            
            
        }else{
        jTextFieldPesquisa.setText("");
        jTextFieldPesquisa.requestFocus();
        
        String[] options = {"Sim", "Não"};

        int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja Salvar ?",
                "Confirmar",JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        

        if (resposta == 1) {
        	
        	return;  //Este é o Botao do NAO. Ira retornar para a Calculadora
        }
        
        if(resposta == 0){ 
            
            
            
            
            conex.conexao();
            
            try {
           
           
            
            PreparedStatement pst=conex.conn.prepareStatement("insert into funcionario(nome,rg,estadoRg,cpf,telefoneProprio,telefoneRecado,nomeContato,email,cidade,estadoCidade,rua,numero,bairro,complemento,img)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
     	   
              pst.setString(1,jTextFieldNome.getText() );
              pst.setString(2,jFormattedTextFieldRG.getText() );
              pst.setString(3,jTextFieldEstadoRG.getText() );        
              pst.setString(4,jFormattedTextFieldCPF.getText() );
              pst.setString(5,jFormattedTextFieldCelularProprio.getText() );
              pst.setString(6,jFormattedTextFieldTelefoneRecado.getText() );
              pst.setString(7,jTextFieldContato.getText() );
              pst.setString(8,jFormattedTextFieldEmail.getText() );
              pst.setString(9,jTextFieldCidade.getText() );
              pst.setString(10,jTextFieldEstadoCidade.getText() );
              pst.setString(11,jTextFieldRua.getText() );
              pst.setString(12,jTextFieldNumero.getText() );
              pst.setString(13,jTextFieldBairro.getText() );
              pst.setString(14,jTextFieldComplemento.getText()); 
              pst.setBinaryStream(15, fis, longitudBytes);
              pst.execute();           
              pst.close();
              
              jTextFieldMatricula.setText(""); 
             jTextFieldNome.setText(""); 
             jFormattedTextFieldRG.setText(""); 
             jTextFieldEstadoRG.setText("");     
             jFormattedTextFieldCPF.setText(""); 
             jFormattedTextFieldCelularProprio.setText(""); 
             jFormattedTextFieldTelefoneRecado.setText(""); 
             jTextFieldContato.setText(""); 
             jFormattedTextFieldEmail.setText(""); 
             jTextFieldCidade.setText(""); 
             jTextFieldEstadoCidade.setText(""); 
             jTextFieldRua.setText(""); 
             jTextFieldNumero.setText(""); 
             jTextFieldBairro.setText(""); 
             jTextFieldComplemento.setText(""); 
              jLabelImg.setIcon(null);      
            
            
           // PreparedStatement inserirFuncionario=conex.conn.prepareStatement("call inserir_funcionario('"+jTextFieldNome.getText()+"','"+jFormattedTextFieldRG.getText()+"','"+jTextFieldEstadoRG.getText()+"','"+jFormattedTextFieldCPF.getText()+"','"+jFormattedTextFieldCelularProprio.getText()+"','"+jFormattedTextFieldTelefoneRecado.getText()+"','"+jTextFieldContato.getText()+"','"+jFormattedTextFieldEmail.getText()+"','"+jTextFieldCidade.getText()+"','"+jTextFieldEstadoCidade.getText()+"','"+jTextFieldRua.getText()+"','"+jTextFieldNumero.getText()+"','"+jTextFieldBairro.getText()+"','"+jTextFieldComplemento.getText()+"')");
            
            
            //inserirFuncionario.execute();
            
            
              
            JOptionPane.showMessageDialog(rootPane,"Salvo com sucesso");
            // dispose();
             
            
             } catch (SQLException |NumberFormatException |HeadlessException ex) {
            JOptionPane.showMessageDialog(rootPane,"Falha ao gravar a imagem!/Erro"+ex);
        
        }
             
        }       
               
        }
      
        
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonBuscarFotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarFotosActionPerformed
        // TODO add your handling code here:
        
        jTextFieldPesquisa.setText("");
        jTextFieldPesquisa.requestFocus();
        
         jLabelImg.setIcon(null);
        
         FileNameExtensionFilter filtro=new FileNameExtensionFilter("Formatos de Arquivos JPEG(*.JPG;*.JPEG)","jpg","jpeg");    
          
         
         
             JFileChooser j= new JFileChooser();
             j.setFileSelectionMode(JFileChooser.FILES_ONLY);
             
            
             
             j.addChoosableFileFilter(filtro);
             j.setDialogTitle("Escolha a foto para cadastrar !");
             File ruta = new File("C:/ImgTeste");
             j.setCurrentDirectory(ruta);
             
             
             
             int estado=j.showOpenDialog(null);
             
             
             if(estado==JFileChooser.APPROVE_OPTION){
                 
                 try{
                 
                 fis=new FileInputStream(j.getSelectedFile());
                 this.longitudBytes=(int)j.getSelectedFile().length();
                 
                 try{
                     
                    Image icono=ImageIO.read(j.getSelectedFile()).getScaledInstance
        (jLabelImg.getWidth(),jLabelImg.getHeight(), Image.SCALE_DEFAULT);
                    jLabelImg.setIcon(new ImageIcon(icono));
                    jLabelImg.updateUI();
                    if(jTextFieldMatricula.getText().equals("")){
                      jButtonAtualizaFoto.setEnabled(false);  
                       jButtonSalvarSomenteDados.setEnabled(false);
                       jButtonSalvar.setEnabled(!false);
                    }else{
                     jButtonAtualizaFoto.setEnabled(!false);  
                    
                    }
                    
                   
                     
             }catch(IOException ex){
                     
                     
             JOptionPane.showMessageDialog(rootPane,"imagem"+ex);
           }
                 
         } catch(FileNotFoundException ex){
                 
                 ex.printStackTrace();
                 
       }     
      }
       
               
               jButtonAtualizarDados.setEnabled(false);
               
    }//GEN-LAST:event_jButtonBuscarFotosActionPerformed

    private void jButtonAtualizaFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizaFotoActionPerformed
        // TODO add your handling code here:
        
        if(jTextFieldMatricula.getText().equals("")){
            
             JOptionPane.showMessageDialog(rootPane,"Você não escolheu nenhum cadastro! Para Editar escolha um cadastro existente .");
            
            
            
        }else{
        
            
            jTextFieldPesquisa.setText("");
        jTextFieldPesquisa.requestFocus();
        
        
        String[] options = {"Sim", "Não"};

        int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja Editar ?",
                "Confirmar",JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        

        if (resposta == 1) {
        	
        	return;  //Este é o Botao do NAO. Ira retornar para a Calculadora
        }
        
        if(resposta == 0){ 
            
            conex.conexao();
        try { 
       
            
     	          
        String sql="update funcionario set nome=?,rg=?,estadoRg=?,cpf=?,telefoneProprio=?,telefoneRecado=?,nomeContato=?,email=?,cidade=?,estadoCidade=?,rua=?,numero=?,bairro=?,complemento=?,img=? where idFuncionario='"+jTextFieldMatricula.getText()+"'";
        
        
        
        PreparedStatement pst=conex.conn.prepareStatement(sql);
        
              
        
        
              pst.setString(1,jTextFieldNome.getText() );
              pst.setString(2,jFormattedTextFieldRG.getText() );
              pst.setString(3,jTextFieldEstadoRG.getText() );        
              pst.setString(4,jFormattedTextFieldCPF.getText() );
              pst.setString(5,jFormattedTextFieldCelularProprio.getText() );
              pst.setString(6,jFormattedTextFieldTelefoneRecado.getText() );
              pst.setString(7,jTextFieldContato.getText() );
              pst.setString(8,jFormattedTextFieldEmail.getText() );
              pst.setString(9,jTextFieldCidade.getText() );
              pst.setString(10,jTextFieldEstadoCidade.getText() );
              pst.setString(11,jTextFieldRua.getText() );
              pst.setString(12,jTextFieldNumero.getText() );
              pst.setString(13,jTextFieldBairro.getText() );
              pst.setString(14,jTextFieldComplemento.getText()); 
              pst.setBinaryStream(15, fis, longitudBytes);
              pst.execute();           
              pst.close();
              jLabelImg.setIcon(null);      
             
             
              
              
              jTextFieldPesquisa.setText("");
              jTextFieldPesquisa.requestFocus();
        
             jTextFieldMatricula.setText(""); 
             jTextFieldNome.setText(""); 
             jFormattedTextFieldRG.setText(""); 
             jTextFieldEstadoRG.setText("");     
             jFormattedTextFieldCPF.setText(""); 
             jFormattedTextFieldCelularProprio.setText(""); 
             jFormattedTextFieldTelefoneRecado.setText(""); 
             jTextFieldContato.setText(""); 
             jFormattedTextFieldEmail.setText(""); 
             jTextFieldCidade.setText(""); 
             jTextFieldEstadoCidade.setText(""); 
             jTextFieldRua.setText(""); 
             jTextFieldNumero.setText(""); 
             jTextFieldBairro.setText(""); 
             jTextFieldComplemento.setText(""); 
             
          
              JOptionPane.showMessageDialog(rootPane,"Atualização concluida");
            
      
        } catch (SQLException |NumberFormatException |HeadlessException ex) {
            JOptionPane.showMessageDialog(rootPane,"Falha ao Atualizar a imagem!/Erro"+ex);
        
        }
            
        }    
           
             
        }       
        
    
        
        
               
              
               jButtonAtualizarDados.setEnabled(false);
        
        
    }//GEN-LAST:event_jButtonAtualizaFotoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextFieldPesquisa.setText("");
        jTextFieldPesquisa.requestFocus();
        jButtonAtualizaFoto.setEnabled(false);
        jButtonAtualizarDados.setEnabled(!false);
         jButtonBuscarFotos.setEnabled(!false);
         jButtonSalvar.setEnabled(false);
        jButtonSalvarSomenteDados.setEnabled(false);
        jButtonBuscarFotos.setEnabled(false);
        
             jTextFieldMatricula.setText(""); 
             jTextFieldNome.setText(""); 
             jFormattedTextFieldRG.setText(""); 
             jTextFieldEstadoRG.setText("");     
             jFormattedTextFieldCPF.setText(""); 
             jFormattedTextFieldCelularProprio.setText(""); 
             jFormattedTextFieldTelefoneRecado.setText(""); 
             jTextFieldContato.setText(""); 
             jFormattedTextFieldEmail.setText(""); 
             jTextFieldCidade.setText(""); 
             jTextFieldEstadoCidade.setText(""); 
             jTextFieldRua.setText(""); 
             jTextFieldNumero.setText(""); 
             jTextFieldBairro.setText(""); 
             jTextFieldComplemento.setText(""); 
      
              mod=control.Primeiro();     
        
              jTextFieldMatricula.setText(String.valueOf(mod.getCodigo()));
              jTextFieldNome.setText(mod.getNome());
              jFormattedTextFieldRG.setText(mod.getRg());   
              jTextFieldEstadoRG.setText(mod.getEstadoRg()); 
              
              jFormattedTextFieldCPF.setText(mod.getCpf());
              jFormattedTextFieldCelularProprio.setText(mod.getTefoneProprio());
              jFormattedTextFieldTelefoneRecado.setText(mod.getTelefoneRecado());
              jTextFieldContato.setText(mod.getNomeContato());
              jFormattedTextFieldEmail.setText(mod.getEmail());
              jTextFieldCidade.setText(mod.getCidade());
              jTextFieldEstadoCidade.setText(mod.getEstadoCidade());
              jTextFieldRua.setText(mod.getRua());
              jTextFieldNumero.setText(mod.getNumero());
              jTextFieldBairro.setText(mod.getBairro());
              jTextFieldComplemento.setText(mod.getComplemento());
             
              
        
        conex.conexao();
         

         try{ 
        
            
            conex.execultasql("select img from funcionario where idFuncionario='"+jTextFieldMatricula.getText()+"'");
         
            
        ImageIcon foto;
        InputStream is ;
        

         
            

            while(conex.rs.next()){

                is=conex.rs.getBinaryStream(1);
               
                BufferedImage bi = ImageIO.read(is);

                foto= new ImageIcon(bi);

                Image img=foto.getImage();
               
                Image newimg=img.getScaledInstance(310,310,java.awt.Image.SCALE_SMOOTH);

                ImageIcon newicon=new ImageIcon(newimg);

                jLabelImg.setIcon(newicon);
                

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"Essa cadastro ainda não possui imagem!"+ex);
            jLabelImg.setIcon(null);
        }
              
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jTextFieldPesquisa.setText("");
        jTextFieldPesquisa.requestFocus();
          jButtonAtualizaFoto.setEnabled(false);
        jButtonAtualizarDados.setEnabled(!false);
         jButtonBuscarFotos.setEnabled(!false);
         jButtonSalvar.setEnabled(false);
          jButtonSalvarSomenteDados.setEnabled(false);
           jButtonBuscarFotos.setEnabled(false);
           
          
        jTextFieldMatricula.setText(""); 
             jTextFieldNome.setText(""); 
             jFormattedTextFieldRG.setText(""); 
             jTextFieldEstadoRG.setText("");     
             jFormattedTextFieldCPF.setText(""); 
             jFormattedTextFieldCelularProprio.setText(""); 
             jFormattedTextFieldTelefoneRecado.setText(""); 
             jTextFieldContato.setText(""); 
             jFormattedTextFieldEmail.setText(""); 
             jTextFieldCidade.setText(""); 
             jTextFieldEstadoCidade.setText(""); 
             jTextFieldRua.setText(""); 
             jTextFieldNumero.setText(""); 
             jTextFieldBairro.setText(""); 
             jTextFieldComplemento.setText(""); 
             
        mod=control.Ultimo();
        
              jTextFieldMatricula.setText(String.valueOf(mod.getCodigo()));
              jTextFieldNome.setText(mod.getNome());
              jFormattedTextFieldRG.setText(mod.getRg());   
              jTextFieldEstadoRG.setText(mod.getEstadoRg()); 
              
              jFormattedTextFieldCPF.setText(mod.getCpf());
              jFormattedTextFieldCelularProprio.setText(mod.getTefoneProprio());
              jFormattedTextFieldTelefoneRecado.setText(mod.getTelefoneRecado());
              jTextFieldContato.setText(mod.getNomeContato());
              jFormattedTextFieldEmail.setText(mod.getEmail());
              jTextFieldCidade.setText(mod.getCidade());
              jTextFieldEstadoCidade.setText(mod.getEstadoCidade());
              jTextFieldRua.setText(mod.getRua());
              jTextFieldNumero.setText(mod.getNumero());
              jTextFieldBairro.setText(mod.getBairro());
              jTextFieldComplemento.setText(mod.getComplemento());
             
              
        
        conex.conexao();
         

         try{ 
        
            
            conex.execultasql("select img from funcionario where idFuncionario='"+jTextFieldMatricula.getText()+"'");
         
            
        ImageIcon foto;
        InputStream is ;
        

         
            

            while(conex.rs.next()){

                is=conex.rs.getBinaryStream(1);
               
                BufferedImage bi = ImageIO.read(is);

                foto= new ImageIcon(bi);

                Image img=foto.getImage();
               
                Image newimg=img.getScaledInstance(310,310,java.awt.Image.SCALE_SMOOTH);

                ImageIcon newicon=new ImageIcon(newimg);

                jLabelImg.setIcon(newicon);
                

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"Essa cadastro ainda não possui imagem!"+ex);
            jLabelImg.setIcon(null);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       jTextFieldPesquisa.setText("");
        jTextFieldPesquisa.requestFocus();
         jButtonAtualizaFoto.setEnabled(false);
        jButtonAtualizarDados.setEnabled(!false);
         jButtonBuscarFotos.setEnabled(!false);
        jButtonSalvar.setEnabled(false);
         jButtonSalvarSomenteDados.setEnabled(false);
          jButtonBuscarFotos.setEnabled(false);
          
        jTextFieldMatricula.setText(""); 
             jTextFieldNome.setText(""); 
             jFormattedTextFieldRG.setText(""); 
             jTextFieldEstadoRG.setText("");     
             jFormattedTextFieldCPF.setText(""); 
             jFormattedTextFieldCelularProprio.setText(""); 
             jFormattedTextFieldTelefoneRecado.setText(""); 
             jTextFieldContato.setText(""); 
             jFormattedTextFieldEmail.setText(""); 
             jTextFieldCidade.setText(""); 
             jTextFieldEstadoCidade.setText(""); 
             jTextFieldRua.setText(""); 
             jTextFieldNumero.setText(""); 
             jTextFieldBairro.setText(""); 
             jTextFieldComplemento.setText(""); 
             
        mod=control.Proximo();
        
              jTextFieldMatricula.setText(String.valueOf(mod.getCodigo()));
              jTextFieldNome.setText(mod.getNome());
              jFormattedTextFieldRG.setText(mod.getRg());   
              jTextFieldEstadoRG.setText(mod.getEstadoRg()); 
              
              jFormattedTextFieldCPF.setText(mod.getCpf());
              jFormattedTextFieldCelularProprio.setText(mod.getTefoneProprio());
              jFormattedTextFieldTelefoneRecado.setText(mod.getTelefoneRecado());
              jTextFieldContato.setText(mod.getNomeContato());
              jFormattedTextFieldEmail.setText(mod.getEmail());
              jTextFieldCidade.setText(mod.getCidade());
              jTextFieldEstadoCidade.setText(mod.getEstadoCidade());
              jTextFieldRua.setText(mod.getRua());
              jTextFieldNumero.setText(mod.getNumero());
              jTextFieldBairro.setText(mod.getBairro());
              jTextFieldComplemento.setText(mod.getComplemento());
             
       
        
        conex.conexao();
         

         try{ 
        
            
            conex.execultasql("select img from funcionario where idFuncionario='"+jTextFieldMatricula.getText()+"'");
         
            
        ImageIcon foto;
        InputStream is ;
        

         
            

            while(conex.rs.next()){

                is=conex.rs.getBinaryStream(1);
               
                BufferedImage bi = ImageIO.read(is);

                foto= new ImageIcon(bi);

                Image img=foto.getImage();
               
                Image newimg=img.getScaledInstance(310,310,java.awt.Image.SCALE_SMOOTH);

                ImageIcon newicon=new ImageIcon(newimg);

                jLabelImg.setIcon(newicon);
                

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"Essa cadastro ainda não possui imagem!"+ex);
            jLabelImg.setIcon(null);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
      
        jTextFieldPesquisa.setText("");
        jTextFieldPesquisa.requestFocus();
         jButtonAtualizaFoto.setEnabled(false);
        jButtonAtualizarDados.setEnabled(!false);
         jButtonBuscarFotos.setEnabled(!false);
         jButtonSalvar.setEnabled(false);
          jButtonSalvarSomenteDados.setEnabled(false);
           jButtonBuscarFotos.setEnabled(false);
           
        jTextFieldMatricula.setText(""); 
             jTextFieldNome.setText(""); 
             jFormattedTextFieldRG.setText(""); 
             jTextFieldEstadoRG.setText("");     
             jFormattedTextFieldCPF.setText(""); 
             jFormattedTextFieldCelularProprio.setText(""); 
             jFormattedTextFieldTelefoneRecado.setText(""); 
             jTextFieldContato.setText(""); 
             jFormattedTextFieldEmail.setText(""); 
             jTextFieldCidade.setText(""); 
             jTextFieldEstadoCidade.setText(""); 
             jTextFieldRua.setText(""); 
             jTextFieldNumero.setText(""); 
             jTextFieldBairro.setText(""); 
             jTextFieldComplemento.setText(""); 
             
        mod=control.Anterior();
        
              jTextFieldMatricula.setText(String.valueOf(mod.getCodigo()));
              jTextFieldNome.setText(mod.getNome());
              jFormattedTextFieldRG.setText(mod.getRg());   
              jTextFieldEstadoRG.setText(mod.getEstadoRg()); 
              
              jFormattedTextFieldCPF.setText(mod.getCpf());
              jFormattedTextFieldCelularProprio.setText(mod.getTefoneProprio());
              jFormattedTextFieldTelefoneRecado.setText(mod.getTelefoneRecado());
              jTextFieldContato.setText(mod.getNomeContato());
              jFormattedTextFieldEmail.setText(mod.getEmail());
              jTextFieldCidade.setText(mod.getCidade());
              jTextFieldEstadoCidade.setText(mod.getEstadoCidade());
              jTextFieldRua.setText(mod.getRua());
              jTextFieldNumero.setText(mod.getNumero());
              jTextFieldBairro.setText(mod.getBairro());
              jTextFieldComplemento.setText(mod.getComplemento());
             
         
        
        conex.conexao();
         

         try{ 
        
            
            conex.execultasql("select img from funcionario where idFuncionario='"+jTextFieldMatricula.getText()+"'");
         
            
        ImageIcon foto;
        InputStream is ;
        

         
            

            while(conex.rs.next()){

                is=conex.rs.getBinaryStream(1);
               
                BufferedImage bi = ImageIO.read(is);

                foto= new ImageIcon(bi);

                Image img=foto.getImage();
               
                Image newimg=img.getScaledInstance(310,310,java.awt.Image.SCALE_SMOOTH);

                ImageIcon newicon=new ImageIcon(newimg);

                jLabelImg.setIcon(newicon);
                

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"Essa cadastro ainda não possui imagem!"+ex);
            jLabelImg.setIcon(null);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPActionPerformed
        // TODO add your handling code here:
         jButtonAtualizaFoto.setEnabled(false);
         jButtonAtualizarDados.setEnabled(false);
         jButtonBuscarFotos.setEnabled(!false);
         jButtonSalvar.setEnabled(false);
         jButtonSalvarSomenteDados.setEnabled(false);
         
             jTextFieldMatricula.setText(""); 
             jTextFieldNome.setText(""); 
             jFormattedTextFieldRG.setText(""); 
             jTextFieldEstadoRG.setText("");     
             jFormattedTextFieldCPF.setText(""); 
             jFormattedTextFieldCelularProprio.setText(""); 
             jFormattedTextFieldTelefoneRecado.setText(""); 
             jTextFieldContato.setText(""); 
             jFormattedTextFieldEmail.setText(""); 
             jTextFieldCidade.setText(""); 
             jTextFieldEstadoCidade.setText(""); 
             jTextFieldRua.setText(""); 
             jTextFieldNumero.setText(""); 
             jTextFieldBairro.setText(""); 
             jTextFieldComplemento.setText(""); 
             
        
        String pesquisa = jTextFieldPesquisa.getText();
        
            conex.conexao();
            conex.execultasql("select * from funcionario where idFuncionario = '"+pesquisa+"' or nome ='"+pesquisa+"'  or rg  ='"+pesquisa+"'  or cpf = '"+pesquisa+"' ");
            try {
                conex.rs.first();
                
             jTextFieldMatricula.setText(String.valueOf(conex.rs.getInt("idFuncionario")));  
             jTextFieldNome.setText(conex.rs.getString("nome")); 
             jFormattedTextFieldRG.setText(conex.rs.getString("rg")); 
             jTextFieldEstadoRG.setText(conex.rs.getString("estadoRg"));     
             jFormattedTextFieldCPF.setText(conex.rs.getString("cpf")); 
             jFormattedTextFieldCelularProprio.setText(conex.rs.getString("telefoneProprio")); 
             jFormattedTextFieldTelefoneRecado.setText(conex.rs.getString("telefoneRecado")); 
             jTextFieldContato.setText(conex.rs.getString("nomeContato")); 
             jFormattedTextFieldEmail.setText(conex.rs.getString("email")); 
             jTextFieldCidade.setText(conex.rs.getString("cidade")); 
             jTextFieldEstadoCidade.setText(conex.rs.getString("estadoCidade")); 
             jTextFieldRua.setText(conex.rs.getString("rua")); 
             jTextFieldNumero.setText(conex.rs.getString("numero")); 
             jTextFieldBairro.setText(conex.rs.getString("bairro")); 
             jTextFieldComplemento.setText(conex.rs.getString("complemento")); 
             
             jTextFieldPesquisa.setText("");
             jTextFieldPesquisa.requestFocus();
               
            } catch (SQLException ex) {
                Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane,"Erro!"+ ex);
             
            
        }
            
       conex.conexao();
         

         try{ 
        
            
            conex.execultasql("select img from funcionario where idFuncionario='"+jTextFieldMatricula.getText()+"'");
         
            
        ImageIcon foto;
        InputStream is ;
        

         
            

            while(conex.rs.next()){

                is=conex.rs.getBinaryStream(1);
               
                BufferedImage bi = ImageIO.read(is);

                foto= new ImageIcon(bi);

                Image img=foto.getImage();
               
                Image newimg=img.getScaledInstance(310,310,java.awt.Image.SCALE_SMOOTH);

                ImageIcon newicon=new ImageIcon(newimg);

                jLabelImg.setIcon(newicon);
                

            }

        } catch (Exception ex) {
           JOptionPane.showMessageDialog(rootPane,"Essa cadastro ainda não possui imagem!"+ex);
            jLabelImg.setIcon(null);
        }     
            
            
    }//GEN-LAST:event_jButtonPActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        jTextFieldPesquisa.setText("");
        jTextFieldPesquisa.requestFocus();
        jButtonAtualizaFoto.setEnabled(false);
        jButtonAtualizarDados.setEnabled(false);
         jButtonBuscarFotos.setEnabled(!false);
          jButtonSalvarSomenteDados.setEnabled(!false);
        jButtonSalvar.setEnabled(false);
         jButtonBuscarFotos.setEnabled(!false);
        
        
        //jLabelImg.setIcon(null);
        jLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Foto.png")));
             jTextFieldMatricula.setText(""); 
             jTextFieldNome.setText(""); 
             jFormattedTextFieldRG.setText(""); 
             jTextFieldEstadoRG.setText("");     
             jFormattedTextFieldCPF.setText(""); 
             jFormattedTextFieldCelularProprio.setText(""); 
             jFormattedTextFieldTelefoneRecado.setText(""); 
             jTextFieldContato.setText(""); 
             jFormattedTextFieldEmail.setText(""); 
             jTextFieldCidade.setText(""); 
             jTextFieldEstadoCidade.setText(""); 
             jTextFieldRua.setText(""); 
             jTextFieldNumero.setText(""); 
             jTextFieldBairro.setText(""); 
             jTextFieldComplemento.setText(""); 
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButtonAtualizarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarDadosActionPerformed
        // TODO add your handling code here:
        if(jTextFieldMatricula.getText().equals("")){
            
             JOptionPane.showMessageDialog(rootPane,"Você não escolheu nenhum cadastro! Para Editar escolha um cadastro existente .");
            
            
            
        }else{
           
            
            jTextFieldPesquisa.setText("");
        jTextFieldPesquisa.requestFocus();
        
        
        String[] options = {"Sim", "Não"};

        int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja Editar ?",
                "Confirmar",JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        

        if (resposta == 1) {
        	
        	return;  //Este é o Botao do NAO. Ira retornar para a Calculadora
        }
        
        if(resposta == 0){ 
            
            conex.conexao();
        try { 
       
            
            PreparedStatement editarFuncionario=conex.conn.prepareStatement("call update_funcionario('"+jTextFieldMatricula.getText()+"','"+jTextFieldNome.getText()+"','"+jFormattedTextFieldRG.getText()+"','"+jTextFieldEstadoRG.getText()+"','"+jFormattedTextFieldCPF.getText()+"','"+jFormattedTextFieldCelularProprio.getText()+"','"+jFormattedTextFieldTelefoneRecado.getText()+"','"+jTextFieldContato.getText()+"','"+jFormattedTextFieldEmail.getText()+"','"+jTextFieldCidade.getText()+"','"+jTextFieldEstadoCidade.getText()+"','"+jTextFieldRua.getText()+"','"+jTextFieldNumero.getText()+"','"+jTextFieldBairro.getText()+"','"+jTextFieldComplemento.getText()+"')");
            
            
            editarFuncionario.execute();
            
            
              
            JOptionPane.showMessageDialog(rootPane,"Atualizado com sucesso");
            jTextFieldPesquisa.setText("");
              jTextFieldPesquisa.requestFocus();
        
             jTextFieldMatricula.setText(""); 
             jTextFieldNome.setText(""); 
             jFormattedTextFieldRG.setText(""); 
             jTextFieldEstadoRG.setText("");     
             jFormattedTextFieldCPF.setText(""); 
             jFormattedTextFieldCelularProprio.setText(""); 
             jFormattedTextFieldTelefoneRecado.setText(""); 
             jTextFieldContato.setText(""); 
             jFormattedTextFieldEmail.setText(""); 
             jTextFieldCidade.setText(""); 
             jTextFieldEstadoCidade.setText(""); 
             jTextFieldRua.setText(""); 
             jTextFieldNumero.setText(""); 
             jTextFieldBairro.setText(""); 
             jTextFieldComplemento.setText(""); 
             
     	
          
              JOptionPane.showMessageDialog(rootPane,"Atualização concluida");
            
      
        } catch (SQLException |NumberFormatException |HeadlessException ex) {
            JOptionPane.showMessageDialog(rootPane,"Falha ao Atualizar a imagem!/Erro"+ex);
        
        }
            
            
           
             
        }       
               
            
            
        }
        
        
        
        
    }//GEN-LAST:event_jButtonAtualizarDadosActionPerformed

    private void jButtonSalvarSomenteDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarSomenteDadosActionPerformed
        // TODO add your handling code here:
        
        if(!jTextFieldMatricula.getText().equals("")){
            
             JOptionPane.showMessageDialog(rootPane,"Não sera possível gravar esses dados , porque ele ja foi cadastrado , mas você pode altera-los se for necessário.");
            
            
            
        }else if(jTextFieldNome.getText().equals("") || jFormattedTextFieldRG.getText().equals("")|| jTextFieldEstadoRG.getText().equals("")||jTextFieldCidade.getText().equals("")|| jTextFieldEstadoCidade.getText().equals("")|| jTextFieldRua.getText().equals("")|| jTextFieldNumero.getText().equals("")|| jTextFieldBairro.getText().equals("")|| jTextFieldComplemento.getText().equals("")){
            
            
             JOptionPane.showMessageDialog(rootPane," Atenção para cadastrar é preciso cadastrar os dados citados  !");
            
             JOptionPane.showMessageDialog(rootPane,"É obrigatório cadastrar , nome , rg , estodo do rg ,cidade , estado da cidade , rua , numero , bairro e complemento !");
            
            
        }else{
        jTextFieldPesquisa.setText("");
        jTextFieldPesquisa.requestFocus();
        
        String[] options = {"Sim", "Não"};

        int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja Salvar ?",
                "Confirmar",JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        

        if (resposta == 1) {
        	
        	return;  //Este é o Botao do NAO. Ira retornar para a Calculadora
        }
        
        if(resposta == 0){ 
            
            
            
            
            conex.conexao();
            
            try {
           
           
            
           /* PreparedStatement pst=conex.conn.prepareStatement("insert into funcionario(nome,rg,estadoRg,cpf,telefoneProprio,telefoneRecado,nomeContato,email,cidade,estadoCidade,rua,numero,bairro,complemento)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           pst.setString(1,jTextFieldNome.getText() );
              pst.setString(2,jFormattedTextFieldRG.getText() );
              pst.setString(3,jTextFieldEstadoRG.getText() );        
              pst.setString(4,jFormattedTextFieldCPF.getText() );
              pst.setString(5,jFormattedTextFieldCelularProprio.getText() );
              pst.setString(6,jFormattedTextFieldTelefoneRecado.getText() );
              pst.setString(7,jTextFieldContato.getText() );
              pst.setString(8,jFormattedTextFieldEmail.getText() );
              pst.setString(9,jTextFieldCidade.getText() );
              pst.setString(10,jTextFieldEstadoCidade.getText() );
              pst.setString(11,jTextFieldRua.getText() );
              pst.setString(12,jTextFieldNumero.getText() );
              pst.setString(13,jTextFieldBairro.getText() );
              pst.setString(14,jTextFieldComplemento.getText()); 
             */   
                 
            
            
            PreparedStatement inserirFuncionario=conex.conn.prepareStatement("call inserir_funcionario('"+jTextFieldNome.getText()+"','"+jFormattedTextFieldRG.getText()+"','"+jTextFieldEstadoRG.getText()+"','"+jFormattedTextFieldCPF.getText()+"','"+jFormattedTextFieldCelularProprio.getText()+"','"+jFormattedTextFieldTelefoneRecado.getText()+"','"+jTextFieldContato.getText()+"','"+jFormattedTextFieldEmail.getText()+"','"+jTextFieldCidade.getText()+"','"+jTextFieldEstadoCidade.getText()+"','"+jTextFieldRua.getText()+"','"+jTextFieldNumero.getText()+"','"+jTextFieldBairro.getText()+"','"+jTextFieldComplemento.getText()+"')");
            
            
            inserirFuncionario.execute();
            
            
              
            JOptionPane.showMessageDialog(rootPane,"Salvo com sucesso");
            jTextFieldPesquisa.setText("");
              jTextFieldPesquisa.requestFocus();
        
             jTextFieldMatricula.setText(""); 
             jTextFieldNome.setText(""); 
             jFormattedTextFieldRG.setText(""); 
             jTextFieldEstadoRG.setText("");     
             jFormattedTextFieldCPF.setText(""); 
             jFormattedTextFieldCelularProprio.setText(""); 
             jFormattedTextFieldTelefoneRecado.setText(""); 
             jTextFieldContato.setText(""); 
             jFormattedTextFieldEmail.setText(""); 
             jTextFieldCidade.setText(""); 
             jTextFieldEstadoCidade.setText(""); 
             jTextFieldRua.setText(""); 
             jTextFieldNumero.setText(""); 
             jTextFieldBairro.setText(""); 
             jTextFieldComplemento.setText(""); 
             
            
             } catch (SQLException |NumberFormatException |HeadlessException ex) {
            JOptionPane.showMessageDialog(rootPane,"Falha ao gravar a imagem!/Erro"+ex);
        
        }
             
        }       
        }        
         
      
    }//GEN-LAST:event_jButtonSalvarSomenteDadosActionPerformed

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
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Funcionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonAtualizaFoto;
    private javax.swing.JButton jButtonAtualizarDados;
    private javax.swing.JButton jButtonBuscarFotos;
    private javax.swing.JButton jButtonP;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSalvarSomenteDados;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldCelularProprio;
    private javax.swing.JFormattedTextField jFormattedTextFieldEmail;
    private javax.swing.JFormattedTextField jFormattedTextFieldRG;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefoneRecado;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelImg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldContato;
    private javax.swing.JTextField jTextFieldEstadoCidade;
    private javax.swing.JTextField jTextFieldEstadoRG;
    private javax.swing.JTextField jTextFieldMatricula;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JTextField jTextFieldRua;
    // End of variables declaration//GEN-END:variables
}
