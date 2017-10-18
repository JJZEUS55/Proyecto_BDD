/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Interfaces.alta.AltaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author DDB 3CV3 2017
 */
public class iniciousuario extends JFrame implements ActionListener{
    
    JButton actualizar,prestamo,Devolucion; 
    String us;
    public iniciousuario(String us)
    {
        super("Bienvenido "+us);
        this.us = us;
        this.setLayout(null);
        actualizar = new JButton();
        prestamo=new JButton();
        Devolucion=new JButton();
        
        actualizar.setBounds(60, 80, 200, 30);
        actualizar.setText("Actualizar Información");
        actualizar.addActionListener(this);
        
        prestamo.setBounds(60, 130, 200, 30);
        prestamo.setText("Prestamo");
        prestamo.addActionListener(this);
        
        
        Devolucion.setBounds(60, 180, 200, 30);
        Devolucion.setText("Decolución");
        Devolucion.addActionListener(this);
        
        
        
        
        this.add(actualizar);
        this.add(prestamo);
        this.add(Devolucion);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == actualizar){
            AltaUsuario abrir = new AltaUsuario();
                abrir.setVisible(true);
                abrir.getBuscar().setVisible(true);
                abrir.getActualizar().setVisible(false);
                abrir.getEnviar().setVisible(false);
                abrir.getNombre().setEditable(false);
                abrir.getAppPaterno().setEditable(false);
                abrir.getAppMaterno().setEditable(false);
                abrir.getCalle().setEditable(false);
                abrir.getExterior().setEditable(false);
                abrir.getInterior().setEditable(false);
                abrir.getTelefono().setVisible(false);
                abrir.getContrasenia().setEditable(false);
                abrir.getBuscar().setText("Habilitar Informacion");
                abrir.getBuscar().setBounds(200, 350, 195, 30);
                abrir.getCorreo().setText(us);
                abrir.getCorreo().setEnabled(false);
     
        }
        
        if(ae.getSource()==prestamo)
        {
           try {
		UIManager.setLookAndFeel(
			"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e)
                {
                
                }

        prestamo VER=new prestamo();
        VER.setSize(560,480);
        VER.setVisible(true);
        VER.setLocation(380, 200);
        VER.setResizable(false);
        VER.setEnabled(true); 
        }
        
        if(ae.getSource()==Devolucion)
        {
             try {
		UIManager.setLookAndFeel(
			"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e)
                {
                
                }

        Devolucion VER=new Devolucion();
        VER.setSize(560,480);
        VER.setVisible(true);
        VER.setLocation(380, 200);
        VER.setResizable(false);
        VER.setEnabled(true);
            
        }
    }
    
}
