/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author DDB 3CV3 2017
 */
public class inicio {
    Icon alfa=new ImageIcon("src/imagenes/adios.png");
    Icon   alfa1=new ImageIcon("src/imagenes/Connecting.gif");
    public inicio()
    {
        allbook a=new allbook();
        a.setSize(560,480);
        a.setVisible(true);
        a.setLocation(380, 200);
        a.setResizable(false);
        a.setEnabled(true);
        a.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
        a.addWindowListener(new WindowAdapter() {
     
    @Override
    public void windowClosing(WindowEvent e)
    {
        cerrar();
    }


});
            
        
        
}
private static void Sleep(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void cerrar()
    {
        String botones[]={"Cerrar","Cancelar"};
        int eleccion=JOptionPane.showOptionDialog(null,"¿Desea salir de la aplicacion?", "Cerrar", 0, 0, null, botones,2);
        
        if(eleccion==JOptionPane.YES_OPTION)
        {
            JOptionPane.showMessageDialog(null, "Gracias por la visita","Gracias",JOptionPane.WARNING_MESSAGE,alfa);
            System.exit(0);
        }
        else if(eleccion==JOptionPane.NO_OPTION)
        {
            JOptionPane.showMessageDialog(null, "Cancelo operacion","Cancelar",JOptionPane.WARNING_MESSAGE,alfa1);
        }
                
    }

    private void addWindowListener() {
    
    
    
    
    }
    
}
