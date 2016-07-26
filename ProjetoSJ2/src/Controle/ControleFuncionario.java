/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.ModeloFuncionario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Delfino
 */
public class ControleFuncionario {
    
    ConectaBanco conex = new ConectaBanco();
     ConectaBanco c = new ConectaBanco();
     ModeloFuncionario mod = new ModeloFuncionario();
    
     
      
      public ModeloFuncionario Primeiro(){
        conex.conexao();
          
          conex.execultasql("select * from funcionario"); 
          
          
        try {
            conex.rs.first();
            
            mod.setCodigo(conex.rs.getInt("idFuncionario"));
            mod.setNome(conex.rs.getString("nome"));
            mod.setRg(conex.rs.getString("rg"));
            mod.setEstadoRg(conex.rs.getString("estadoRg"));
            mod.setCpf(conex.rs.getString("cpf"));
            mod.setTefoneProprio(conex.rs.getString("telefoneProprio"));
            mod.setTelefoneRecado(conex.rs.getString("telefoneRecado"));
            mod.setNomeContato(conex.rs.getString("nomeContato"));
            mod.setEmail(conex.rs.getString("email"));
            mod.setCidade(conex.rs.getString("cidade"));
            mod.setEstadoCidade(conex.rs.getString("estadoCidade"));         
                    
            mod.setRua(conex.rs.getString("rua"));
            mod.setNumero(conex.rs.getString("numero"));
            mod.setBairro(conex.rs.getString("bairro"));
            mod.setComplemento(conex.rs.getString("complemento"));
            
            
          
            
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Clique no botão proximo !");
        }
      // conex.desconecta();
       
          return mod;
      }
      
      
       public ModeloFuncionario Proximo() {
                  
         
        
          
         //conex.execultasql("select * from funcionario"); 
        try {        
          conex.rs.next();
                
                 
                
                mod.setCodigo(conex.rs.getInt("idFuncionario"));
                mod.setNome(conex.rs.getString("nome"));
                mod.setRg(conex.rs.getString("rg"));
                mod.setEstadoRg(conex.rs.getString("estadoRg"));
                mod.setCpf(conex.rs.getString("cpf"));
                mod.setTefoneProprio(conex.rs.getString("telefoneProprio"));
                mod.setTelefoneRecado(conex.rs.getString("telefoneRecado"));
                mod.setNomeContato(conex.rs.getString("nomeContato"));
                mod.setEmail(conex.rs.getString("email"));
                mod.setCidade(conex.rs.getString("cidade"));
                mod.setEstadoCidade(conex.rs.getString("estadoCidade"));
                
                mod.setRua(conex.rs.getString("rua"));
                mod.setNumero(conex.rs.getString("numero"));
                mod.setBairro(conex.rs.getString("bairro"));
                mod.setComplemento(conex.rs.getString("complemento"));
               
              
                
               // conex.desconecta();
                
           } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "De um duplo clique no botão Anterior  para voltar ou va para o botão primeiro ou botão ultimo!");
            
        }
       
        return mod;
       }  
       
       
      
      
      
      public ModeloFuncionario Anterior() {
      
        try {     
            
           
           conex.rs.previous();
           
            
            
            mod.setCodigo(conex.rs.getInt("idFuncionario"));
            mod.setNome(conex.rs.getString("nome"));
            mod.setRg(conex.rs.getString("rg"));
            mod.setEstadoRg(conex.rs.getString("estadoRg"));
            mod.setCpf(conex.rs.getString("cpf"));
            mod.setTefoneProprio(conex.rs.getString("telefoneProprio"));
            mod.setTelefoneRecado(conex.rs.getString("telefoneRecado"));
            mod.setNomeContato(conex.rs.getString("nomeContato"));
            mod.setEmail(conex.rs.getString("email"));
            mod.setCidade(conex.rs.getString("cidade"));
            mod.setEstadoCidade(conex.rs.getString("estadoCidade"));         
                    
            mod.setRua(conex.rs.getString("rua"));
            mod.setNumero(conex.rs.getString("numero"));
            mod.setBairro(conex.rs.getString("bairro"));
            mod.setComplemento(conex.rs.getString("complemento"));
            
              
           } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "De um duplo clique no botão proximo ou va para o botão primeiro ou botão ultimo!");
        }
            
        return mod; 
       
        
      }
      
      
      
      
      public ModeloFuncionario Ultimo(){
         
       
        try {
            conex.rs.last();
             
             
             
           mod.setCodigo(conex.rs.getInt("idFuncionario"));
            mod.setNome(conex.rs.getString("nome"));
            mod.setRg(conex.rs.getString("rg"));
            mod.setEstadoRg(conex.rs.getString("estadoRg"));
            mod.setCpf(conex.rs.getString("cpf"));
            mod.setTefoneProprio(conex.rs.getString("telefoneProprio"));
            mod.setTelefoneRecado(conex.rs.getString("telefoneRecado"));
            mod.setNomeContato(conex.rs.getString("nomeContato"));
            mod.setEmail(conex.rs.getString("email"));
            mod.setCidade(conex.rs.getString("cidade"));
            mod.setEstadoCidade(conex.rs.getString("estadoCidade"));         
                    
            mod.setRua(conex.rs.getString("rua"));
            mod.setNumero(conex.rs.getString("numero"));
            mod.setBairro(conex.rs.getString("bairro"));
            mod.setComplemento(conex.rs.getString("complemento"));
            
            
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "De um duplo clique no botão anterior ou um clique botão primeiro !");
        }
        
          return mod;
      }
      
      
      
      
     
} 

