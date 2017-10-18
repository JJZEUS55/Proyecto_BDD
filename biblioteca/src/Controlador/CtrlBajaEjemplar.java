/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.baja.BajaEjemplar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Ejemplar;

/**
 *
 * @author DDB 3CV3 2017
 */
public class CtrlBajaEjemplar implements ActionListener, FocusListener {
    private final BajaEjemplar vista;
    private Ejemplar modelo;

    public CtrlBajaEjemplar(BajaEjemplar vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == vista.getSalir()){
            vista.dispose();
        }
        if(ae.getSource() == vista.getEliminar()){
            String idEjemplar = vista.getEjemplar().getText();
            
            modelo = new Ejemplar(idEjemplar);
            boolean correcto = modelo.baja();
            if(correcto = true){
                vista.getBuscar().setVisible(true);
                vista.getEliminar().setVisible(false);
                vista.getEjemplar().setEditable(true);
            }
        }
        
        if(ae.getSource() == vista.getBuscar()){
            String idEjemplar = vista.getEjemplar().getText();
            
            modelo = new Ejemplar(idEjemplar);
            String nombre = modelo.nombreLibro();
            if("".equals(nombre)){
                JOptionPane.showMessageDialog(null, "No existe Libro", "ERROR", JOptionPane.ERROR_MESSAGE);
                vista.getEliminar().setEnabled(false);
            }else{
            vista.getLibro().setText(nombre);
            vista.getEliminar().setEnabled(true);
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
