

package Controle;



import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Eduardo
 */
public class ConectaBanco {

    /**
     *
     */
    public Statement stm;  
   
    public ResultSet rs;
    
    private String driver = "com.mysql.jdbc.Driver"; 
    //private String driver = "org.mysql.Driver";
    
    private String  caminho = "jdbc:mysql://127.0.0.1:3306/projetosj2";   //nome database minusculo no banco de dados 
            
    private String usuario = "root";
    
    private String senha = "1234";
    
   
    public Connection conn;
    
    
    public void conexao () {
          System.setProperty("jdbc.Drivers", driver);
          try {
           conn = DriverManager.getConnection(caminho, usuario, senha);
              //JOptionPane.showMessageDialog(null, "Conectado com sucesso!"); 
              
              
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,  "Erro de conexão!\n Erro:" + ex.getMessage());     
            
        }
    }

    /**
     *
     * @param SQL
     */
    public void execultasql (String SQL){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);   
          
            rs = stm.executeQuery(SQL); 
        
        } catch (SQLException ex) {
           // JOptionPane.showMessageDialog(null,  "Erro no execultasql!\n Erro:" + ex.getMessage());
        }
        
    }

    /**
     *
     */
    public void desconecta() {
        try {
            conn.close();
            // JOptionPane.showMessageDialog(null," Desconectado com sucesso!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\n Erro:" + ex.getMessage());
        }
    }
}
    
