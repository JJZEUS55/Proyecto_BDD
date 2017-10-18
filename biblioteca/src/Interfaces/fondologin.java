/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author DDB 3CV3 2017
 */
public class fondologin extends javax.swing.JPanel{
        public fondologin() {
        initComponents();
        this.setSize(900,550);
    }
    
    @Override
    public void paintComponent(Graphics g){
        Dimension tam = getSize();
        ImageIcon ImagenFondo= new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/login.png")).getImage());
//        ImageIcon ImagenFondo;
//        String path="/imagenes/Servidor.jpeg";
//        URL url = this.getClass().getResource(path); 
//        ImagenFondo=ab(url);
        g.drawImage(ImagenFondo.getImage(), 0, 0, 560,480,null);
        setOpaque(false);
        super.paintComponent(g);
    }
    
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>    


    
}
