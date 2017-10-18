/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author DDB 3CV3 2017
 */
public class descripcionbook extends JFrame {
    Object[] obj;
    public descripcionbook(Object[] a)
    {
        super("Descripcion ");
        setLayout(null);
        this.obj=a;
        JLabel jl=new JLabel();
        
        jl=new JLabel("Nombre del libro:");
        jl.setBounds(20, 30, 150, 30);
        add(jl);
        
        jl=new JLabel((String) a[1]);
        jl.setBounds(80, 60, 150, 30);
        add(jl);
        
        jl=new JLabel("Número de páginas:");
        jl.setBounds(20, 90, 150, 30);
        add(jl);
        
        jl=new JLabel(String.valueOf (a[2]));
        jl.setBounds(80, 120, 150, 30);
        add(jl);
        
        jl=new JLabel("Numero de edición:");
        jl.setBounds(20, 150, 150, 30);
        add(jl);
        
        jl=new JLabel(String.valueOf (a[3]));
        jl.setBounds(80, 180, 150, 30);
        add(jl);
        
        jl=new JLabel("Año:");
        jl.setBounds(20, 210, 150, 30);
        add(jl);
        
         jl=new JLabel(String.valueOf (a[4]));
        jl.setBounds(80, 240, 150, 30);
        add(jl);
        
        jl=new JLabel("Editorial:");
        jl.setBounds(20, 270, 150, 30);
        add(jl);
        
         jl=new JLabel(String.valueOf (a[5]));
        jl.setBounds(80, 300, 150, 30);
        add(jl);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
