/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.baja.BajaBiblioteca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.BibliotecaM;

/**
 *
 * @author DDB 3CV3 2017
 */
public class CtrlBajaBiblioteca implements ActionListener, FocusListener {
    
    private BibliotecaM modelo;
    private final BajaBiblioteca vista;
    
    public CtrlBajaBiblioteca(BajaBiblioteca vista){
        this.vista = vista;
    }
    
    private String auxNombre;
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == vista.getSalir()){
            vista.dispose();
        }
        
        if(ae.getSource() == vista.getEliminar()){
            
            String nombre = vista.getNombre().getText();
            modelo = new BibliotecaM(nombre);
            boolean correcto =  modelo.baja();
            
            if(correcto == true){
                vista.getEliminar().setVisible(false);
                vista.getBuscar().setVisible(true);
                vista.getNombre().setEditable(true);
            }
        }
        
        if(ae.getSource() == vista.getBuscar()){
            String nombre = vista.getNombre().getText();
            modelo = new BibliotecaM(nombre);
            Object consulta[][] = modelo.consultaDatos();
            auxNombre = String.valueOf(consulta[0][1]);
            if( "null".equals(auxNombre)){
                JOptionPane.showMessageDialog(null, "No Hay Coincidencias", "ERROR", JOptionPane.ERROR_MESSAGE);
                vista.getEliminar().setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Se encontro un Resultado", "Correcto", JOptionPane.PLAIN_MESSAGE);
                vista.getNombre().setText(auxNombre);
                vista.getNombre().setEditable(false);
                vista.getBuscar().setVisible(false);
                vista.getEliminar().setVisible(true); 
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
