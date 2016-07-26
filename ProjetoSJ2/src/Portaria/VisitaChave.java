/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Portaria;

import Controle.AtualizadoHora;
import Controle.ConectaBanco;
import Modelo.ModeloTabela;
import Tabelas.TabelaFuncionario;
import Visao.Principal;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.JButton;

/**
 *
 * @author Eduardo
 */
public class VisitaChave extends javax.swing.JFrame {

    ConectaBanco conex = new ConectaBanco();
    
    String tipo="Devolução confirmada";    
    String e="Entrega de chave confirmada";
    String bloco="CAIXA-DE-ÁGUA";
    String apt="...";
    
    public VisitaChave(String nome, String user ) {
        initComponents();
        jLabelPorteiro.setText(nome);
        jLabelUser.setText(user);
        
        
        AtualizadoHora.start(Hora); // Para colocar a Hora no sistema
        
        this.setExtendedState(getExtendedState()| VisitaChave.MAXIMIZED_BOTH);
        //Pega data do sistema
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        jLabelData.setText(df.format(hoje));
        
        
        

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

    jButtonLimpar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonLimpar.getActionMap().put("DoClick", action);

    jButtonAgendar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonAgendar.getActionMap().put("DoClick", action);

    jButtonBuscaRG.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonBuscaRG.getActionMap().put("DoClick", action);

    jButtonEntregar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonEntregar.getActionMap().put("DoClick", action);

    jButtonBaixa.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonBaixa.getActionMap().put("DoClick", action);

    jButtonDevelucao.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonDevelucao.getActionMap().put("DoClick", action);



    jButtonVoltar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonVoltar.getActionMap().put("DoClick", action);

    jButtonPesData.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonPesData.getActionMap().put("DoClick", action);

    jButtonPesqAgendado.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonPesqAgendado.getActionMap().put("DoClick", action);

    jButtonBaixa.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonBaixa.getActionMap().put("DoClick", action);

    jButtonPesqEntrada.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonPesqEntrada.getActionMap().put("DoClick", action);
    
    jButtonPesqSaida.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonPesqSaida.getActionMap().put("DoClick", action);
    

 
    jButtonPesqBaixa.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
    jButtonPesqBaixa.getActionMap().put("DoClick", action);
    

    
    
    
        jButtonBuscaRG.setEnabled(false);  
        jButtonAgendar.setEnabled(false);
        jButtonEntregar.setEnabled(false);
        jButtonDevelucao.setEnabled(false);
        jButtonBaixa.setEnabled(false);
        jTable1.setEnabled(false);
        
        
       
        
        jForDataVisita.setEnabled(false);
        jFormattedTextFieldHora.setEnabled(false);
        jTextFieldEstadoRG.setEnabled(false);
        jForRG.setEnabled(false);
        jTextFieldTecnico.setEnabled(false);
        jTextFieldEmpresa.setEnabled(false);
        jTextAreaObservacaoSobreServico.setEnabled(false);
        jForTelefone.setEnabled(false);
        jForCelular.setEnabled(false);
        
        jTextFieldDataDevolu.setEnabled(false);
        jTextFieldDataEntrega.setEnabled(false);
        porteiro.setEnabled(false);
        User.setEnabled(false);
        
        
         URL url = this.getClass().getResource("/Imagens/condominio.jpg");  //coloca a imagem no lugar da tigela java
          Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
            this.setIconImage(imagemTitulo);
            
            
        
        
        try {
            MaskFormatter form = new MaskFormatter("##:##");//elemento que cria o formato da mascara  
            jFormattedTextFieldHora.setFormatterFactory(new DefaultFormatterFactory(form));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro!");
        }
        
        
         
        
         
        try {
            MaskFormatter form = new MaskFormatter("##.###.###");
           
            jForRG.setFormatterFactory(new DefaultFormatterFactory(form));
            
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro!");
        }
         
         try {
            MaskFormatter form = new MaskFormatter("(##)####-####");
           
            jForTelefone.setFormatterFactory(new DefaultFormatterFactory(form));
            
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro!");
        }
       
       
        
         try {
            MaskFormatter form = new MaskFormatter("(##)#####-####");
           
             jForCelular.setFormatterFactory(new DefaultFormatterFactory(form));
            
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro!");
        }
        
        try {
            MaskFormatter form = new MaskFormatter("##/##/####");//elemento que cria o formato da mascara  
            jForDataVisita.setFormatterFactory(new DefaultFormatterFactory(form));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro!");
        }
        
        try {
            MaskFormatter form = new MaskFormatter("##/##/####");//elemento que cria o formato da mascara  
            jFormattedTextFieldPesData.setFormatterFactory(new DefaultFormatterFactory(form));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro!");
        }
        
        
        
        // preencherTabelaVisita("select * from visita_chave order by dataVisita");
         
         
         
         
    }

    private VisitaChave() {
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxSetor = new javax.swing.JComboBox();
        jComboBoxApartamento = new javax.swing.JComboBox();
        jButtonBuscar = new javax.swing.JButton();
        jLabelIdVisita = new javax.swing.JLabel();
        jButtonLimpar = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButtonAgendar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jForDataVisita = new javax.swing.JFormattedTextField();
        jForRG = new javax.swing.JFormattedTextField();
        jTextFieldTecnico = new javax.swing.JTextField();
        jTextFieldEmpresa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObservacaoSobreServico = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldEstadoRG = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jForTelefone = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jForCelular = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldDataEntrega = new javax.swing.JTextField();
        jFormattedTextFieldHora = new javax.swing.JFormattedTextField();
        jButtonEntregar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButtonBaixa = new javax.swing.JButton();
        jButtonBuscaRG = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldAutorizacao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabelHoraEntrada = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        porteiro = new javax.swing.JTextField();
        User = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldDataDevolu = new javax.swing.JTextField();
        jButtonDevelucao = new javax.swing.JButton();
        jLabelPorteiro = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabelHoraSaida = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelData = new javax.swing.JLabel();
        Hora = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabelIdFuncionario = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButtonPesqAgendado = new javax.swing.JButton();
        jButtonPesqEntrada = new javax.swing.JButton();
        jButtonPesqSaida = new javax.swing.JButton();
        jButtonPesqBaixa = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jFormattedTextFieldPesData = new javax.swing.JFormattedTextField();
        jButtonPesData = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        confirmarcao = new javax.swing.JLabel();
        jLabelImg = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Condominio-SJ2");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jComboBoxSetor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxSetor.setForeground(new java.awt.Color(102, 102, 0));
        jComboBoxSetor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CAIXA-DE-ÁGUA", "VÁRIAS-VISITAS", "BLOCO A", "BLOCO B", "BLOCO C", "BLOCO D", "BLOCO F", "BLOCO G", "BLOCO H", "BLOCO I", "BLOCO J", "BLOCO K", " ", " " }));
        jComboBoxSetor.setToolTipText("Setores");

        jComboBoxApartamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxApartamento.setForeground(new java.awt.Color(102, 102, 0));
        jComboBoxApartamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...", "APARTAMENTO 101", "APARTAMENTO 102", "APARTAMENTO 103", "APARTAMENTO 104", "APARTAMENTO 201", "APARTAMENTO 202", "APARTAMENTO 203", "APARTAMENTO 204", "APARTAMENTO 301", "APARTAMENTO 302", "APARTAMENTO 303", "APARTAMENTO 304", "APARTAMENTO 401", "APARTAMENTO 402", "APARTAMENTO 403", "APARTAMENTO 404", " ", " " }));
        jComboBoxApartamento.setToolTipText("Um campo vazio e os Apartamentos");

        jButtonBuscar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(51, 51, 0));
        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesq.png"))); // NOI18N
        jButtonBuscar.setText("Setor e Apartamento");
        jButtonBuscar.setToolTipText("Escolha o setor e o apartamento");
        jButtonBuscar.setBorder(null);
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabelIdVisita.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelIdVisita.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIdVisita.setText("IdVisita");

        jButtonLimpar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/back.png"))); // NOI18N
        jButtonLimpar.setText("Limpar");
        jButtonLimpar.setToolTipText("Limpar");
        jButtonLimpar.setBorder(null);
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setText("Setor");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 51));
        jLabel22.setText("Apartamento");

        jButtonAgendar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonAgendar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAgendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/accept.png"))); // NOI18N
        jButtonAgendar.setText("Agendar");
        jButtonAgendar.setToolTipText("Agendar");
        jButtonAgendar.setBorder(null);
        jButtonAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgendarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(jComboBoxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxApartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(jLabel21)
                .addGap(127, 127, 127)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelIdVisita)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdVisita)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxApartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jButtonLimpar)
                    .addComponent(jComboBoxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAgendar))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 0));
        jLabel2.setText("Data visita:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 0));
        jLabel3.setText("Hora:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 0));
        jLabel4.setText("RG:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 0));
        jLabel5.setText("Técnico");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 0));
        jLabel6.setText("Empresa:");

        jForDataVisita.setBackground(new java.awt.Color(255, 255, 204));
        jForDataVisita.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jForDataVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jForDataVisitaActionPerformed(evt);
            }
        });

        jForRG.setBackground(new java.awt.Color(255, 255, 204));
        jForRG.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTextFieldTecnico.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldTecnico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTextFieldEmpresa.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 0));
        jLabel7.setText("Descrição sobre o serviço");

        jTextAreaObservacaoSobreServico.setBackground(new java.awt.Color(255, 255, 204));
        jTextAreaObservacaoSobreServico.setColumns(20);
        jTextAreaObservacaoSobreServico.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jTextAreaObservacaoSobreServico.setRows(5);
        jScrollPane1.setViewportView(jTextAreaObservacaoSobreServico);

        jLabel15.setBackground(new java.awt.Color(51, 51, 0));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 0));
        jLabel15.setText("Estado:");

        jTextFieldEstadoRG.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldEstadoRG.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 0));
        jLabel8.setText("Telefone:");

        jForTelefone.setBackground(new java.awt.Color(255, 255, 204));
        jForTelefone.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jForTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jForTelefoneActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 0));
        jLabel9.setText("Celular:");

        jForCelular.setBackground(new java.awt.Color(255, 255, 204));
        jForCelular.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jForCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jForCelularActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 0));
        jLabel10.setText("Data Entrega:");

        jTextFieldDataEntrega.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldDataEntrega.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldDataEntrega.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jFormattedTextFieldHora.setBackground(new java.awt.Color(255, 255, 204));
        jFormattedTextFieldHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jButtonEntregar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonEntregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonEntregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/accept.png"))); // NOI18N
        jButtonEntregar.setText("Entregar");
        jButtonEntregar.setToolTipText("Entregar Chave");
        jButtonEntregar.setBorder(null);
        jButtonEntregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntregarActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Entregar as chaves agendadas para os visitantes ");

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Agendar chave para os visitantes");

        jButtonBaixa.setBackground(new java.awt.Color(204, 204, 204));
        jButtonBaixa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonBaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete.png"))); // NOI18N
        jButtonBaixa.setText("Baixa");
        jButtonBaixa.setToolTipText("Dar Baixa no agendamento");
        jButtonBaixa.setBorder(null);
        jButtonBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBaixaActionPerformed(evt);
            }
        });

        jButtonBuscaRG.setBackground(new java.awt.Color(204, 204, 204));
        jButtonBuscaRG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesq.png"))); // NOI18N
        jButtonBuscaRG.setToolTipText("Pesquise uma RG Cadastrada");
        jButtonBuscaRG.setBorder(null);
        jButtonBuscaRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscaRGActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 0));
        jLabel24.setText("Autorizado pelo:");

        jTextFieldAutorizacao.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldAutorizacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldAutorizacao.setToolTipText("Autorização pelo morador ou pelo síndico");
        jTextFieldAutorizacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Hora de Entrada:");

        jLabelHoraEntrada.setText(":");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel5))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel8))
                            .addComponent(jLabel4))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jForRG, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonBuscaRG, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15))
                                    .addComponent(jForCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldEstadoRG, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelHoraEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jForTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonEntregar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(183, 183, 183))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(42, 42, 42)
                                .addComponent(jTextFieldAutorizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(177, 177, 177)
                                    .addComponent(jLabel7)
                                    .addGap(124, 124, 124))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jFormattedTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jForDataVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jForDataVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jFormattedTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAutorizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jForRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButtonBuscaRG, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextFieldEstadoRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBaixa))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextFieldTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jForCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel1)
                            .addComponent(jLabelHoraEntrada))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jForTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEntregar))))
                .addGap(38, 38, 38)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 0));
        jLabel11.setText("Data Devolução:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 0));
        jLabel12.setText("Porteiro:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 0));
        jLabel13.setText("Usuario:");

        porteiro.setBackground(new java.awt.Color(255, 255, 204));
        porteiro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        porteiro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        User.setBackground(new java.awt.Color(255, 255, 204));
        User.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        User.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Devolução de chaves para a portaria");

        jTextFieldDataDevolu.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldDataDevolu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldDataDevolu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonDevelucao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonDevelucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/accept.png"))); // NOI18N
        jButtonDevelucao.setText("Devolução");
        jButtonDevelucao.setToolTipText("Devolução de chave");
        jButtonDevelucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDevelucaoActionPerformed(evt);
            }
        });

        jLabelPorteiro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelPorteiro.setForeground(new java.awt.Color(204, 204, 204));
        jLabelPorteiro.setText("Porteiro");

        jLabelUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelUser.setForeground(new java.awt.Color(204, 204, 204));
        jLabelUser.setText("User");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Hora Saida:");

        jLabelHoraSaida.setText(":");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(porteiro, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13))
                                    .addComponent(jTextFieldDataDevolu, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDevelucao, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelHoraSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUser)
                    .addComponent(jLabelPorteiro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldDataDevolu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(porteiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jButtonDevelucao)
                    .addComponent(jLabelUser))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabelPorteiro)
                    .addComponent(jLabel25)
                    .addComponent(jLabelHoraSaida))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("Agendamento de visitas para entrega de chaves");

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setForeground(new java.awt.Color(51, 153, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabelData.setBackground(new java.awt.Color(102, 102, 255));
        jLabelData.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelData.setForeground(new java.awt.Color(102, 102, 255));
        jLabelData.setText("              /  /");

        Hora.setBackground(new java.awt.Color(102, 102, 255));
        Hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Hora.setForeground(new java.awt.Color(102, 102, 255));
        Hora.setText(":");

        jLabelIdFuncionario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelIdFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIdFuncionario.setText("idFuncio");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jButtonPesqAgendado.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPesqAgendado.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonPesqAgendado.setForeground(new java.awt.Color(51, 153, 0));
        jButtonPesqAgendado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesq.png"))); // NOI18N
        jButtonPesqAgendado.setText("Agendados");
        jButtonPesqAgendado.setToolTipText("Agendado");
        jButtonPesqAgendado.setBorder(null);
        jButtonPesqAgendado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesqAgendadoActionPerformed(evt);
            }
        });

        jButtonPesqEntrada.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPesqEntrada.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonPesqEntrada.setForeground(new java.awt.Color(51, 153, 0));
        jButtonPesqEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesq.png"))); // NOI18N
        jButtonPesqEntrada.setText("Entrada");
        jButtonPesqEntrada.setToolTipText("Entrada");
        jButtonPesqEntrada.setBorder(null);
        jButtonPesqEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesqEntradaActionPerformed(evt);
            }
        });

        jButtonPesqSaida.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPesqSaida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPesqSaida.setForeground(new java.awt.Color(51, 153, 0));
        jButtonPesqSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesq.png"))); // NOI18N
        jButtonPesqSaida.setText("Devolução");
        jButtonPesqSaida.setToolTipText("Devolução de chaves");
        jButtonPesqSaida.setBorder(null);
        jButtonPesqSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesqSaidaActionPerformed(evt);
            }
        });

        jButtonPesqBaixa.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPesqBaixa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonPesqBaixa.setForeground(new java.awt.Color(51, 153, 0));
        jButtonPesqBaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesq.png"))); // NOI18N
        jButtonPesqBaixa.setText("Baixas");
        jButtonPesqBaixa.setToolTipText("Para agendados que não compareceram.");
        jButtonPesqBaixa.setBorder(null);
        jButtonPesqBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesqBaixaActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Data Visita:");

        jButtonPesData.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPesData.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonPesData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesq.png"))); // NOI18N
        jButtonPesData.setToolTipText("Digiete uma data de Agendamento");
        jButtonPesData.setBorder(null);
        jButtonPesData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesDataActionPerformed(evt);
            }
        });

        jButtonVoltar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/back.png"))); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setToolTipText("Voltar os dados da tabela");
        jButtonVoltar.setBorder(null);
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        confirmarcao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        confirmarcao.setForeground(new java.awt.Color(255, 153, 51));
        confirmarcao.setText("Confirmação");

        jLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Foto.png"))); // NOI18N
        jLabelImg.setText("jLabel1");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonPesqAgendado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jFormattedTextFieldPesData, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonPesData, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel20))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonPesqBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonPesqSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jButtonPesqEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmarcao))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(confirmarcao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonPesqAgendado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPesqEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jButtonPesqSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPesqBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonPesData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(11, 11, 11)
                                .addComponent(jFormattedTextFieldPesData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setForeground(new java.awt.Color(51, 51, 255));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/add.png"))); // NOI18N
        jMenu1.setText("Tabela");

        jMenuItem2.setForeground(new java.awt.Color(51, 153, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesq.png"))); // NOI18N
        jMenuItem2.setText("Visitantes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator5)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelIdFuncionario)
                        .addGap(214, 214, 214)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175)
                        .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIdFuncionario)
                    .addComponent(jLabelData)
                    .addComponent(Hora))
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jForDataVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jForDataVisitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jForDataVisitaActionPerformed

    private void jForCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jForCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jForCelularActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
       jForDataVisita.requestFocus();
        jTextFieldAutorizacao.setText("");
        
        jForDataVisita.setText("");
        jFormattedTextFieldHora.setText("");
        jTextFieldEstadoRG.setText("");
        jForRG.setText("");
        jTextFieldTecnico.setText("");
        jTextFieldEmpresa.setText("");
        jTextAreaObservacaoSobreServico.setText("");
        jForTelefone.setText("");
        jForCelular.setText("");
        jTextFieldDataEntrega.setText("");
        jTextFieldDataDevolu.setText("");
        porteiro.setText("");
        User.setText("");
        jFormattedTextFieldPesData.setText("");
        
         jTable1.setEnabled(false);
         jButtonBuscaRG.setEnabled(false);          
        jButtonAgendar.setEnabled(!false);
        jButtonEntregar.setEnabled(false);
        jButtonDevelucao.setEnabled(false);
        jButtonBaixa.setEnabled(false);
        jForDataVisita.setEnabled(!false);
        jFormattedTextFieldHora.setEnabled(!false);
        jForRG.setEnabled(false);
        jTextFieldEstadoRG.setEnabled(false);
        jTextFieldTecnico.setEnabled(false);
        jTextFieldEmpresa.setEnabled(!false);
        jTextAreaObservacaoSobreServico.setEnabled(!false);
        jForTelefone.setEnabled(false);
        jForCelular.setEnabled(false);
        jLabelData.setEnabled(false);
          jTextFieldAutorizacao.setEnabled(!false);  
          
       jTextFieldDataEntrega.setEnabled(false);      
        User.setEnabled(false);   
        
        
        jButtonPesqAgendado.setEnabled(false);
jButtonPesqEntrada.setEnabled(false);
jButtonPesqSaida.setEnabled(false);
jButtonPesqBaixa.setEnabled(false);
jButtonPesData.setEnabled(false);
jButtonVoltar.setEnabled(false); 



        
        
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgendarActionPerformed
        
       
        String[] options = {"Sim", "Não"};

        int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja Agendar o visitante ?",
                "Confirmar",JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        

        if (resposta == 1) {
        	
        	return;  //Este é o Botao do NAO. Ira retornar para a Calculadora
        }
        
        if(resposta == 0){  //Este é o Botao do SIM. Ira sair do seu Programa          
            
     	
            conex.conexao();
        try {
            PreparedStatement inserirVisitaChave = conex.conn.prepareStatement("call inserir_visita_chave( '"+(String)jComboBoxSetor.getSelectedItem()+"' ,'"+(String)jComboBoxApartamento.getSelectedItem()+"' , '"+jForDataVisita.getText()+"','"+jFormattedTextFieldHora.getText()+"' ,'"+jTextFieldEmpresa.getText()+"','"+jTextAreaObservacaoSobreServico.getText()+"' ,'"+jLabelPorteiro.getText()+"','"+jLabelUser.getText()+"','"+jTextFieldAutorizacao.getText()+"')");
            inserirVisitaChave.execute();
            
            
        JOptionPane.showMessageDialog(rootPane,"Agendado!");
        
         //preencherTabelaVisita("select * from visita_chave");
         jButtonAgendar.setEnabled(false);
         jButtonEntregar.setEnabled(!false);
         jButtonBaixa.setEnabled(!false);
         jButtonDevelucao.setEnabled(false);
         
         jButtonPesqAgendado.setEnabled(!false);
jButtonPesqEntrada.setEnabled(!false);
jButtonPesqSaida.setEnabled(!false);
jButtonPesqBaixa.setEnabled(!false);
jButtonPesData.setEnabled(!false);
jButtonVoltar.setEnabled(!false);  


         preencherTabelaVisita("select * from visita_chave order by dataVisita");
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao Salvar"+ ex);
        }
             
        
         
               
     }
        
        
        
        
        
        
    }//GEN-LAST:event_jButtonAgendarActionPerformed

    private void jForTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jForTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jForTelefoneActionPerformed

    private void jButtonDevelucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDevelucaoActionPerformed
        // TODO add your handling code here:
        
        
        if(jTextFieldDataEntrega.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane,"É preciso agendar uma data de entrega" );
            
        }else if(!jTextFieldDataDevolu.getText().equals("")){
          
        JOptionPane.showMessageDialog(rootPane,"A Devolução da chave já foi confirmada");
        
        }else{
            
        String[] options = {"Sim", "Não"};

        int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja Devolver a chave ?",
                "Confirmar",JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        

        if (resposta == 1) {
        	
        	return;  //Este é o Botao do NAO. Ira retornar para a Calculadora
        }
        
        if(resposta == 0){  //Este é o Botao do SIM. Ira sair do seu Programa          
            
     	
            conex.conexao();
        try {
            PreparedStatement inserirVisitaChave = conex.conn.prepareStatement("call devolucao_visita_chave('"+jLabelIdVisita.getText()+"' , '"+jLabelData.getText()+"','"+Hora.getText()+"' )");
            inserirVisitaChave.execute();
            
            
        JOptionPane.showMessageDialog(rootPane,"Devolução de chave realizada.");
        
        jButtonDevelucao.setEnabled(false);
        jTable1.setEnabled(false);
        
        preencherTabelaVisita("select * from visita_chave order by dataVisita");
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao Salvar"+ ex);
        }
             
        } 
      }
     
        
    }//GEN-LAST:event_jButtonDevelucaoActionPerformed

    private void jButtonPesDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesDataActionPerformed
        // TODO add your handling code here:
        jComboBoxSetor.setSelectedItem(bloco);
        jComboBoxApartamento.setSelectedItem(apt);
        jTextFieldAutorizacao.setText("");
        
        jForDataVisita.setText("");
        jFormattedTextFieldHora.setText("");
        jTextFieldEstadoRG.setText("");
        jForRG.setText("");
        jTextFieldTecnico.setText("");
        jTextFieldEmpresa.setText("");
        jTextAreaObservacaoSobreServico.setText("");
        jForTelefone.setText("");
        jForCelular.setText("");
        jTextFieldDataEntrega.setText("");
        jTextFieldDataDevolu.setText("");
        porteiro.setText("");
        User.setText("");
        jFormattedTextFieldPesData.setText("");
        preencherTabelaVisita("select * from visita_chave where dataVisita like'%"+jFormattedTextFieldPesData.getText()+"%'");
        jFormattedTextFieldPesData.setText("");
    }//GEN-LAST:event_jButtonPesDataActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        
        jForRG.requestFocus();
        jTextFieldAutorizacao.setText("");
        
        jForDataVisita.setText("");
        jFormattedTextFieldHora.setText("");
        jTextFieldEstadoRG.setText("");
        jForRG.setText("");
        jTextFieldTecnico.setText("");
        jTextFieldEmpresa.setText("");
        jTextAreaObservacaoSobreServico.setText("");
        jForTelefone.setText("");
        jForCelular.setText("");
        jTextFieldDataEntrega.setText("");
        jTextFieldDataDevolu.setText("");
        porteiro.setText("");
        User.setText("");
        jFormattedTextFieldPesData.setText("");
        
        
         String id = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        jLabelIdVisita.setText(id);
        
        String data = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 1);
        jForDataVisita.setText(data);
        
        String obs = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 2);
        confirmarcao.setText(obs);
        
        String hora = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 3);
        jFormattedTextFieldHora.setText(hora);
        
        String bloco = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 4);
        jComboBoxSetor.setSelectedItem(bloco);
        
        String apt = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 5);
        jComboBoxApartamento.setSelectedItem(apt);
        
        String descricao = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 6);
        jTextAreaObservacaoSobreServico.setText(descricao);
        
        String horaEntrada = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 7);
        jLabelHoraEntrada.setText(horaEntrada);
        
        String horaSaida = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 8);
        jLabelHoraSaida.setText(horaSaida);
        
        String origem = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 9);
        jTextFieldEmpresa.setText(origem);
        
        String autorizacao = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 10);
        jTextFieldAutorizacao.setText(autorizacao);
        
        String rg = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 11);
        jForRG.setText(rg);
        
        String est = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 12);
       jTextFieldEstadoRG.setText(est);
        
        String visit= ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 13);
        jTextFieldTecnico.setText(visit);
        
        String celu = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 14);
        jForCelular.setText(celu);
        
        String tele = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 15);
        jForTelefone.setText(tele);
        
        String dataEnt = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 16);
        jTextFieldDataEntrega.setText(dataEnt);
        
        String dataS = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 17);
        jTextFieldDataDevolu.setText(dataS);
        
        String port = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 18);
        porteiro.setText(port);
        
        String us = ""+ jTable1.getValueAt(jTable1.getSelectedRow(), 19);
        User.setText(us);
        
        
        
        conex.conexao();
         try{ 
        
            
            conex.execultasql("select img from funcionario where rg='"+jForRG.getText()+"'");
         
            
        ImageIcon foto;
        InputStream is ;
        

         
            

            while(conex.rs.next()){

                is=conex.rs.getBinaryStream(1);
               
                BufferedImage bi = ImageIO.read(is);

                foto= new ImageIcon(bi);

                Image img=foto.getImage();
               
                Image newimg=img.getScaledInstance(210,210,java.awt.Image.SCALE_SMOOTH);

                ImageIcon newicon=new ImageIcon(newimg);

                jLabelImg.setIcon(newicon);
                

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao buscar a imagem!"+ex);
        }     
        
        
        
        
        jForDataVisita.setEnabled(!false);
        jFormattedTextFieldHora.setEnabled(!false);
        jForRG.setEnabled(!false);
        jTextFieldEstadoRG.setEnabled(!false);
        jTextFieldTecnico.setEnabled(!false);
        jTextFieldEmpresa.setEnabled(!false);
        jTextAreaObservacaoSobreServico.setEnabled(!false);
        jForTelefone.setEnabled(!false);
        jForCelular.setEnabled(!false);
        jLabelData.setEnabled(!false);
        jTextFieldAutorizacao.setEnabled(!false);
        jTextFieldDataEntrega.setEnabled(true);
        jTextFieldDataDevolu.setEnabled(true);
        
        
        jButtonBuscaRG.setEnabled(!false);  
        jButtonAgendar.setEnabled(false);
        jButtonEntregar.setEnabled(!false);
        jButtonBaixa.setEnabled(!false);
        jButtonDevelucao.setEnabled(!false);
        
        
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonEntregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntregarActionPerformed
        // TODO add your handling code here:
        
        
        if(jTextFieldTecnico.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane,"É preciso cadastrar" );
        }else if(!jTextFieldDataEntrega.getText().equals("")){
            
         JOptionPane.showMessageDialog(rootPane,"A entrega de chave já foi confirmada");
        } else{
              
                
                String[] options = {"Sim", "Não"};

        int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja Entregar a chave ?",
                "Confirmar",JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        

        if (resposta == 1) {
        	
        	return;  //Este é o Botao do NAO. Ira retornar para a Calculadora
        }
        
        if(resposta == 0){  //Este é o Botao do SIM. Ira sair do seu Programa          
            
     	
            conex.conexao();
        try {
            PreparedStatement inserirVisitaChave = conex.conn.prepareStatement("call entrada_visita_chave('"+jLabelIdVisita.getText()+"' ,'"+jForRG.getText()+"','"+jTextFieldEstadoRG.getText()+"','"+jTextFieldTecnico.getText()+"','"+jTextAreaObservacaoSobreServico.getText()+"','"+jForTelefone.getText()+"','"+jForCelular.getText()+"', '"+jLabelData.getText()+"','"+Hora.getText()+"' )");
            inserirVisitaChave.execute();
            
            
        JOptionPane.showMessageDialog(rootPane,"Entrega de chave realizada.");
        preencherTabelaVisita("select * from visita_chave order by dataVisita");
        
       jButtonEntregar.setEnabled(false);
       jButtonBaixa.setEnabled(false);
       jTable1.setEnabled(false);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao Salvar"+ ex);
        }
             
        } 
        }
     
    }//GEN-LAST:event_jButtonEntregarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        // TODO add your handling code here:
         jLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Foto.png")));
        jTable1.setEnabled(false);
         jButtonAgendar.setEnabled(false);
        jComboBoxSetor.setSelectedItem(bloco);
        jComboBoxApartamento.setSelectedItem(apt);
        
        jTextFieldAutorizacao.setText("");
                
        jLabelHoraEntrada.setText("");
        jForDataVisita.setText("");
        jFormattedTextFieldHora.setText("");
        jTextFieldEstadoRG.setText("");
        jForRG.setText("");
        jTextFieldTecnico.setText("");
        jTextFieldEmpresa.setText("");
        jTextAreaObservacaoSobreServico.setText("");
        jForTelefone.setText("");
        jForCelular.setText("");
        jTextFieldDataEntrega.setText("");
        jTextFieldDataDevolu.setText("");
        porteiro.setText("");
        User.setText("");
        jFormattedTextFieldPesData.setText("");
         
        
        jTextFieldDataDevolu.setEnabled(false);
        jTextFieldDataEntrega.setEnabled(false);
        
        
        
        
        jForDataVisita.setEnabled(false);
        jFormattedTextFieldHora.setEnabled(false);
        jTextFieldEstadoRG.setEnabled(false);
        jForRG.setEnabled(false);
        jTextFieldTecnico.setEnabled(false);
        jTextFieldEmpresa.setEnabled(false);
        jTextAreaObservacaoSobreServico.setEnabled(false);
        jForTelefone.setEnabled(false);
        jForCelular.setEnabled(false);
        
        jTextFieldDataDevolu.setEnabled(false);
        jTextFieldDataEntrega.setEnabled(false);
        porteiro.setEnabled(false);
        User.setEnabled(false);
        
        jButtonBuscaRG.setEnabled(false);  
        jButtonAgendar.setEnabled(false);
        jButtonEntregar.setEnabled(false);
        jButtonDevelucao.setEnabled(false);
        jButtonBaixa.setEnabled(false);
        
        
        jButtonPesqAgendado.setEnabled(!false);
jButtonPesqEntrada.setEnabled(!false);
jButtonPesqSaida.setEnabled(!false);
jButtonPesqBaixa.setEnabled(!false);
jButtonPesData.setEnabled(!false);
jButtonVoltar.setEnabled(!false); 
        
         String limpa="limpaDados";
        //preencherTabelaVisita("select * from visita where tipo like'%"+jTextFieldTipo.getText()+"%'");
        preencherTabelaVisita("select * from visita where tipo ='"+limpa+"'");
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBaixaActionPerformed
        // TODO add your handling code here:
        
        
        if(jTextAreaObservacaoSobreServico.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane,"Não é necessário dar baixa" );
        }else if(!jTextFieldDataEntrega.getText().equals("")){
            
         JOptionPane.showMessageDialog(rootPane,"Não é necessário dar baixa");
        } else{
              
                
                String[] options = {"Sim", "Não"};

        int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja dar Baixa no agendamento ?",
                "Confirmar",JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        

        if (resposta == 1) {
        	
        	return;  //Este é o Botao do NAO. Ira retornar para a Calculadora
        }
        
        if(resposta == 0){  //Este é o Botao do SIM. Ira sair do seu Programa          
            
     	
            conex.conexao();
        try {
            PreparedStatement inserirVisitaChave = conex.conn.prepareStatement("call baixa_visita_chave('"+jLabelIdVisita.getText()+"' , '"+jLabelData.getText()+"','"+jLabelData.getText()+"','"+Hora.getText()+"' )");
            inserirVisitaChave.execute();
            
            
        JOptionPane.showMessageDialog(rootPane,"Baixa de chave realizada.");
        
       jButtonEntregar.setEnabled(false);
       jTable1.setEnabled(false);
        preencherTabelaVisita("select * from visita_chave order by dataVisita");
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao Salvar"+ ex);
        }
             
        } 
        }
    }//GEN-LAST:event_jButtonBaixaActionPerformed

    private void jButtonBuscaRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscaRGActionPerformed
        // TODO add your handling code here:
        conex.conexao();
        conex.execultasql("select * from funcionario where rg='"+jForRG.getText()+"'");
        try {
            conex.rs.first();
            jLabelIdFuncionario.setText(String.valueOf(conex.rs.getInt("idFuncionario")));
            jTextFieldEstadoRG.setText(conex.rs.getString("estadoRg"));
            jTextFieldTecnico.setText(conex.rs.getString("nome"));
            
            jForCelular.setText(conex.rs.getString("telefoneProprio"));
            jForTelefone.setText(conex.rs.getString("telefoneRecado"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Faça o cadastro deste visitante");
            new Funcionario().setVisible(true);
        }
        
        
        conex.conexao();
         try{ 
        
            
            conex.execultasql("select img from funcionario where rg='"+jForRG.getText()+"'");
         
            
        ImageIcon foto;
        InputStream is ;
        

         
            

            while(conex.rs.next()){

                is=conex.rs.getBinaryStream(1);
               
                BufferedImage bi = ImageIO.read(is);

                foto= new ImageIcon(bi);

                Image img=foto.getImage();
               
                Image newimg=img.getScaledInstance(210,210,java.awt.Image.SCALE_SMOOTH);

                ImageIcon newicon=new ImageIcon(newimg);

                jLabelImg.setIcon(newicon);
                

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao buscar a imagem!"+ex);
        }     
    }//GEN-LAST:event_jButtonBuscaRGActionPerformed

    private void jButtonPesqAgendadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesqAgendadoActionPerformed
        // TODO add your handling code here:
       
        jComboBoxSetor.setSelectedItem(bloco);
        jComboBoxApartamento.setSelectedItem(apt);
        jTable1.setEnabled(!false);
        jTextFieldAutorizacao.setText("");
        
        jForDataVisita.setText("");
        jFormattedTextFieldHora.setText("");
        jTextFieldEstadoRG.setText("");
        jForRG.setText("");
        jTextFieldTecnico.setText("");
        jTextFieldEmpresa.setText("");
        jTextAreaObservacaoSobreServico.setText("");
        jForTelefone.setText("");
        jForCelular.setText("");
        jTextFieldDataEntrega.setText("");
        jTextFieldDataDevolu.setText("");
        porteiro.setText("");
        User.setText("");
        jFormattedTextFieldPesData.setText("");
        
        String a="Agendado";
        //preencherTabelaVisita("select * from visita where tipo like'%"+jTextFieldTipo.getText()+"%'");
        preencherTabelaVisita("select * from visita_chave where tipo ='"+a+"'");
    }//GEN-LAST:event_jButtonPesqAgendadoActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        
        jComboBoxSetor.setSelectedItem(bloco);
        jComboBoxApartamento.setSelectedItem(apt);
         jTable1.setEnabled(false);
        jTextFieldAutorizacao.setText("");
        
        jForDataVisita.setText("");
        jFormattedTextFieldHora.setText("");
        jTextFieldEstadoRG.setText("");
        jForRG.setText("");
        jTextFieldTecnico.setText("");
        jTextFieldEmpresa.setText("");
        jTextAreaObservacaoSobreServico.setText("");
        jForTelefone.setText("");
        jForCelular.setText("");
        jTextFieldDataEntrega.setText("");
        jTextFieldDataDevolu.setText("");
        porteiro.setText("");
        User.setText("");
        jFormattedTextFieldPesData.setText("");
         preencherTabelaVisita("select * from visita_chave order by dataVisita");
         jFormattedTextFieldPesData.setText("");
         
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        new TabelaFuncionario().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButtonPesqEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesqEntradaActionPerformed
        // TODO add your handling code here:
        jComboBoxSetor.setSelectedItem(bloco);
        jComboBoxApartamento.setSelectedItem(apt);
        jTable1.setEnabled(!false);
        jTextFieldAutorizacao.setText("");
        
        jForDataVisita.setText("");
        jFormattedTextFieldHora.setText("");
        jTextFieldEstadoRG.setText("");
        jForRG.setText("");
        jTextFieldTecnico.setText("");
        jTextFieldEmpresa.setText("");
        jTextAreaObservacaoSobreServico.setText("");
        jForTelefone.setText("");
        jForCelular.setText("");
        jTextFieldDataEntrega.setText("");
        jTextFieldDataDevolu.setText("");
        porteiro.setText("");
        User.setText("");
        jFormattedTextFieldPesData.setText("");
        
        
        
        //preencherTabelaVisita("select * from visita where tipo like'%"+jTextFieldTipo.getText()+"%'");
        preencherTabelaVisita("select * from visita_chave where tipo ='"+e+"'");
    }//GEN-LAST:event_jButtonPesqEntradaActionPerformed

    private void jButtonPesqSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesqSaidaActionPerformed
        // TODO add your handling code here:
        
        jComboBoxSetor.setSelectedItem(bloco);
        jComboBoxApartamento.setSelectedItem(apt);
        jTable1.setEnabled(!false);
        jTextFieldAutorizacao.setText("");
        
        jForDataVisita.setText("");
        jFormattedTextFieldHora.setText("");
        jTextFieldEstadoRG.setText("");
        jForRG.setText("");
        jTextFieldTecnico.setText("");
        jTextFieldEmpresa.setText("");
        jTextAreaObservacaoSobreServico.setText("");
        jForTelefone.setText("");
        jForCelular.setText("");
        jTextFieldDataEntrega.setText("");
        jTextFieldDataDevolu.setText("");
        porteiro.setText("");
        User.setText("");
        jFormattedTextFieldPesData.setText("");
        
        
        String d="Devolução confirmada";
        //preencherTabelaVisita("select * from visita where tipo like'%"+jTextFieldTipo.getText()+"%'");
        preencherTabelaVisita("select * from visita_chave where tipo ='"+d+"'");
    }//GEN-LAST:event_jButtonPesqSaidaActionPerformed

    private void jButtonPesqBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesqBaixaActionPerformed
        // TODO add your handling code here:
        jComboBoxSetor.setSelectedItem(bloco);
        jComboBoxApartamento.setSelectedItem(apt);
        jTable1.setEnabled(!false);
        jTextFieldAutorizacao.setText("");
        
        jForDataVisita.setText("");
        jFormattedTextFieldHora.setText("");
        jTextFieldEstadoRG.setText("");
        jForRG.setText("");
        jTextFieldTecnico.setText("");
        jTextFieldEmpresa.setText("");
        jTextAreaObservacaoSobreServico.setText("");
        jForTelefone.setText("");
        jForCelular.setText("");
        jTextFieldDataEntrega.setText("");
        jTextFieldDataDevolu.setText("");
        porteiro.setText("");
        User.setText("");
        jFormattedTextFieldPesData.setText("");
        
        
        String b="Baixa confirmada";
        //preencherTabelaVisita("select * from visita where tipo like'%"+jTextFieldTipo.getText()+"%'");
        preencherTabelaVisita("select * from visita_chave where tipo ='"+b+"'");
    }//GEN-LAST:event_jButtonPesqBaixaActionPerformed

    
    public void preencherTabelaVisita(String sql){
          ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"idVisita","Data","Observação","Hora","Bloco","Apartamento","Descrição","Hora Entrada","Hora Saida","Origem","Autorização","Rg","Estado","visitante","Celular","Telefone","Data Entrada","Data Saida","Porteiro","Usuario"};
       
     
        
        conex.conexao();
        conex.execultasql(sql);                
            try {
                conex.rs.first();
                do {
                  
                    dados.add(new Object[]{conex.rs.getString("idVisita"),conex.rs.getString("dataVisita"),conex.rs.getString("tipo"),conex.rs.getString("horaVisita"),conex.rs.getString("bloco"),conex.rs.getString("numeroApartamento"),conex.rs.getString("observacaoSobreServico"),conex.rs.getString("horaEntrada"),conex.rs.getString("horaSaida"),conex.rs.getString("empresa"),conex.rs.getString("autorizacao"),conex.rs.getString("rg"),conex.rs.getString("estado"),conex.rs.getString("tecnico"),conex.rs.getString("celular"),conex.rs.getString("telefone"),conex.rs.getString("dataEntrega"),conex.rs.getString("dataDevolucao"),conex.rs.getString("nomePorteiro"),conex.rs.getString("usuario")});
                    
                    
                   
                   
                }while(conex.rs.next());
            } catch (SQLException ex) {
               // JOptionPane.showMessageDialog(rootPane,"Erro ao preencher o ArrayList!\nErro:"+ex);
               // JOptionPane.showMessageDialog(rootPane,"Não encontrado");
                jComboBoxSetor.setSelectedItem(bloco);
                jComboBoxApartamento.setSelectedItem(apt);
            }
       
            
           
            
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
          jTable1.setModel(modelo);
          jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
          jTable1.getColumnModel().getColumn(0).setResizable(false);
          jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
          jTable1.getColumnModel().getColumn(1).setResizable(false);
          jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
          jTable1.getColumnModel().getColumn(2).setResizable(false);
          jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
          jTable1.getColumnModel().getColumn(3).setResizable(false);
          jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
          jTable1.getColumnModel().getColumn(4).setResizable(false);
          jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
          jTable1.getColumnModel().getColumn(5).setResizable(false);
          
          jTable1.getColumnModel().getColumn(6).setPreferredWidth(550);
          jTable1.getColumnModel().getColumn(6).setResizable(false);
          jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
          jTable1.getColumnModel().getColumn(7).setResizable(false);
          
          jTable1.getColumnModel().getColumn(8).setPreferredWidth(100);
          jTable1.getColumnModel().getColumn(8).setResizable(false);
          jTable1.getColumnModel().getColumn(9).setPreferredWidth(100);
          jTable1.getColumnModel().getColumn(9).setResizable(false);
          
          jTable1.getColumnModel().getColumn(10).setPreferredWidth(100);
          jTable1.getColumnModel().getColumn(10).setResizable(false);
          
          jTable1.getColumnModel().getColumn(11).setPreferredWidth(100);
          jTable1.getColumnModel().getColumn(11).setResizable(false);
          jTable1.getColumnModel().getColumn(12).setPreferredWidth(100);
          jTable1.getColumnModel().getColumn(12).setResizable(false);
          jTable1.getColumnModel().getColumn(13).setPreferredWidth(100);
          jTable1.getColumnModel().getColumn(13).setResizable(false);
          jTable1.getColumnModel().getColumn(14).setPreferredWidth(100);
          jTable1.getColumnModel().getColumn(14).setResizable(false);
          jTable1.getColumnModel().getColumn(15).setPreferredWidth(100);
          jTable1.getColumnModel().getColumn(15).setResizable(false);
          jTable1.getColumnModel().getColumn(16).setPreferredWidth(100);
          jTable1.getColumnModel().getColumn(16).setResizable(false);
          jTable1.getColumnModel().getColumn(17).setPreferredWidth(100);
          jTable1.getColumnModel().getColumn(17).setResizable(false);
          jTable1.getColumnModel().getColumn(18).setPreferredWidth(100);
          jTable1.getColumnModel().getColumn(18).setResizable(false);
          jTable1.getColumnModel().getColumn(19).setPreferredWidth(100);
          jTable1.getColumnModel().getColumn(19).setResizable(false);
          
          
          jTable1.getTableHeader().setReorderingAllowed(false);
          jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
          jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);                                  
    
       }
    
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
            java.util.logging.Logger.getLogger(VisitaChave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisitaChave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisitaChave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisitaChave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisitaChave().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Hora;
    private javax.swing.JTextField User;
    private javax.swing.JLabel confirmarcao;
    private javax.swing.JButton jButtonAgendar;
    private javax.swing.JButton jButtonBaixa;
    private javax.swing.JButton jButtonBuscaRG;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonDevelucao;
    private javax.swing.JButton jButtonEntregar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonPesData;
    private javax.swing.JButton jButtonPesqAgendado;
    private javax.swing.JButton jButtonPesqBaixa;
    private javax.swing.JButton jButtonPesqEntrada;
    private javax.swing.JButton jButtonPesqSaida;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox jComboBoxApartamento;
    private javax.swing.JComboBox jComboBoxSetor;
    private javax.swing.JFormattedTextField jForCelular;
    private javax.swing.JFormattedTextField jForDataVisita;
    private javax.swing.JFormattedTextField jForRG;
    private javax.swing.JFormattedTextField jForTelefone;
    private javax.swing.JFormattedTextField jFormattedTextFieldHora;
    private javax.swing.JFormattedTextField jFormattedTextFieldPesData;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelHoraEntrada;
    private javax.swing.JLabel jLabelHoraSaida;
    private javax.swing.JLabel jLabelIdFuncionario;
    private javax.swing.JLabel jLabelIdVisita;
    private javax.swing.JLabel jLabelImg;
    private javax.swing.JLabel jLabelPorteiro;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaObservacaoSobreServico;
    private javax.swing.JTextField jTextFieldAutorizacao;
    private javax.swing.JTextField jTextFieldDataDevolu;
    private javax.swing.JTextField jTextFieldDataEntrega;
    private javax.swing.JTextField jTextFieldEmpresa;
    private javax.swing.JTextField jTextFieldEstadoRG;
    private javax.swing.JTextField jTextFieldTecnico;
    private javax.swing.JTextField porteiro;
    // End of variables declaration//GEN-END:variables
}
