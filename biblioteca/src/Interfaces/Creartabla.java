/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DDB 3CV3 2017
 */
public class Creartabla extends DefaultTableModel{

    boolean[] canEdit = new boolean [] {
                false, false, false, false,false,false
            };
    
    
    
    public Creartabla(Object[][] datos,String[] columnNames)
    {
        super(datos,columnNames);
    }
//    @Override
//    public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
          return canEdit [columnIndex];
    }
    
}