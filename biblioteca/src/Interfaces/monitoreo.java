/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Timer;

/**
 *
 * @author DDB 3CV3 2017
 */
public class monitoreo implements ItemListener,ActionListener{
    Timer t = null; 
    procesando a;
    Object[] obj;
    public monitoreo(procesando ver,Object[] ob)
    {
     
    this.obj=ob;
    this.a=ver;
    t = new Timer(5000, this); 
    t.start(); 
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==t)
    {
        a.dispose();
        descripcionbook VER=new descripcionbook(obj);
        VER.setSize(400,450);
        VER.setVisible(true);
        VER.setLocation(450, 200);
        VER.setResizable(false);
        VER.setEnabled(true);
        t.stop();
        
        
    }
    }
    
}
