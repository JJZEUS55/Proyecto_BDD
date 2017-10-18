/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author DDB 3CV3 2017
 */
public class procesando extends JFrame{
    ImageIcon ico;
    public procesando()
    {
        super("Espere");
        setLayout(null);
        String path="/imagenes/Cargando.gif/";
        URL url = this.getClass().getResource(path);
        ico=new ImageIcon(url);
        JLabel label = new JLabel();
        label.setBounds(0,0,330,200);
        label.setIcon(ico);
        add(label);
        
        
        
        
    }
    
}
