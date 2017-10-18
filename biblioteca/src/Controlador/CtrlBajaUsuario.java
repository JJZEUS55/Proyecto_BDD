/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.baja.BajaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Usuario;

/**
 *
 * @author DDB 3CV3 2017
 */
public class CtrlBajaUsuario implements ActionListener,FocusListener {
    
    private final BajaUsuario vista;
    private Usuario modelo;

    public CtrlBajaUsuario(BajaUsuario vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == vista.getSalir()){
            vista.dispose();
        }
        
        if(ae.getSource() == vista.getBuscar()){
            String correo = vista.getEliminar().getText();
            modelo = new Usuario(correo);
            
            Object consulta[][] = modelo.consultaDatos();
            String auxCorreo = String.valueOf(consulta[0][1]);

            if("null".equals(auxCorreo)){
                JOptionPane.showMessageDialog(null, "No Hay Coincidencias", "ERROR", JOptionPane.ERROR_MESSAGE);
                vista.getEnviar().setEnabled(false);
            }
            else{
            vista.getEnviar().setEnabled(true);
            vista.getCorreo().setText(auxCorreo);
            vista.getContrasenia().setText(String.valueOf(consulta[0][2]));
            vista.getNombre().setText(String.valueOf(consulta[0][3]));
            vista.getAppPaterno().setText(String.valueOf(consulta[0][4]));
            vista.getAppMaterno().setText(String.valueOf(consulta[0][5]));
            vista.getCalle().setText(String.valueOf(consulta[0][6]));
            vista.getExterior().setText(String.valueOf(consulta[0][7]));
            vista.getInterior().setText(String.valueOf(consulta[0][8]));
            }
        }
        
        if(ae.getSource() == vista.getEnviar()){
            String correo = vista.getEliminar().getText();
            modelo = new Usuario(correo);
            modelo.baja();
            vista.getEliminar().setEnabled(false);
        }
    }
    
     @Override
    public void focusLost(FocusEvent fe) {
    }

    @Override
    public void focusGained(FocusEvent fe) {
        Object o = fe.getSource();
        if(o instanceof JTextField){
            JTextField txt = (JTextField) o;
            txt.setSelectionStart(0);
            txt.setSelectionEnd(txt.getText().length());
    }
        
        
        

    
    }
    
    
    
}
