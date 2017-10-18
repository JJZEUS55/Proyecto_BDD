/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.alta.AltaTelefono;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import modelo.BibliotecaM;
import modelo.Telefono;
import modelo.Usuario;

/**
 *
 * @author DDB 3CV3 2017
 */
public class CtrlAltaTelefono implements ActionListener, FocusListener {
    private final AltaTelefono vista;
    private Telefono modelo;
    
    public CtrlAltaTelefono(AltaTelefono vista){
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == vista.getSalir()){
            vista.dispose();
        }
        if(ae.getSource() == vista.getEnviar()){
            String telefono = vista.getTelefono().getText();
            
            modelo = new Telefono(telefono);
            String correo = vista.getCorreo();
            Usuario usuario = new Usuario(correo);
            boolean correcto = usuario.alta(modelo);
            if(correcto == true){
                vista.getTelefono().setEditable(false);
                vista.getEnviar().setEnabled(false);
                vista.getAgregar().setEnabled(true);
            }  
        }
        
        if(ae.getSource() == vista.getAgregar()){
            vista.getTelefono().setEditable(true);
            vista.getTelefono().setText("");
            vista.getEnviar().setEnabled(true);
            vista.getAgregar().setEnabled(false);
        }
        
        if(ae.getSource() == vista.getEnviarAux()){
            String telefono = vista.getTelefono().getText();
            modelo = new Telefono(telefono);
            String correo = vista.getCorreo();
            BibliotecaM biblioteca = new BibliotecaM(correo);
            boolean correcto = biblioteca.alta(modelo);
            if(correcto == true){
                vista.getTelefono().setEditable(false);
                vista.getEnviar().setEnabled(false);
                vista.getAgregar().setEnabled(true);
            }  
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
