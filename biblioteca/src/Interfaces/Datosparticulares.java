/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author DDB 3CV3 2017
 */
public class Datosparticulares extends JFrame {
    fondo fon;
    public Datosparticulares(String name,Object[][] a,String[] columnNames)
    {
        super(name);
        fon=new fondo();
        setLayout(null);
        JTable table = new JTable(new Creartabla(a,columnNames));

        table.setPreferredScrollableViewportSize(new Dimension(430, 300));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(12, 150, 530, 250);
        add(scrollPane);
        add(fon);
        
    }
    
}
