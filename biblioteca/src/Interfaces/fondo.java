/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class fondo extends javax.swing.JPanel {


    public fondo() {
        initComponents();
        this.setSize(900,550);
    }
    
    @Override
    public void paintComponent(Graphics g){
        Dimension tam = getSize();
        ImageIcon ImagenFondo= new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/fondo.jpg")).getImage());
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


    // Variables declaration - do not modify                     
    // End of variables declaration                   

       public ImageIcon ab(URL a)
    {
      ImageIcon b1=new ImageIcon(a);
      Image conversion=b1.getImage();
      Image tam=conversion.getScaledInstance(20,130,Image.SCALE_SMOOTH);
      ImageIcon fin=new ImageIcon(tam);
      return fin;
    }
}