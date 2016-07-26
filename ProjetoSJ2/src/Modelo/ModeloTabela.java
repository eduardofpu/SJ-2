/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Eduardo
 */
public class ModeloTabela extends AbstractTableModel{
    private ArrayList linhas = null;
    private String[] colunas = null;
     
    /**
     *
     * @param lin
     * @param col
     */
    public ModeloTabela (ArrayList lin,String[]col){
        setLinhas(lin);
        setColunas(col);
        
    }

    /**
     *
     * @return
     */
    public ArrayList getLinhas(){
        return linhas;
    }

    /**
     *
     * @param dados
     */
    public void setLinhas(ArrayList dados){
        linhas = dados;
    }

    /**
     *
     * @return
     */
    public String[] getColunas(){
        return colunas;
    }

    /**
     *
     * @param nomes
     */
    public void setColunas(String[] nomes){
        colunas = nomes;
        
    }
    public int getColumnCount(){
        return colunas.length;
    }
    public int getRowCount(){
        return linhas.size();
    }
    public String getColumnName(int numCol){
        return colunas[numCol];
    }
    public Object getValueAt(int numLin, int numCol){
        Object[] linha = (Object[])getLinhas().get(numLin);
        return linha[numCol];
    }
    
}
