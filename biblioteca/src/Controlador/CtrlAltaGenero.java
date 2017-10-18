/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.alta.AltaGenero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Genero;

/**
 *
 * @author DDB 3CV3 2017
 */
public class CtrlAltaGenero implements ActionListener, FocusListener {
    
    private Genero modelo;
    private final AltaGenero vista;
    
    public CtrlAltaGenero(AltaGenero vista){
        this.vista = vista;
    }
    private String auxNombre;
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if( ae.getSource() == vista.getSalir()){
            vista.dispose();
        }
        
        if(ae.getSource() == vista.getEnviar()){
            String nombre = vista.getNombre().getText();
            
            modelo  = new Genero(nombre);
            
            boolean correcto = modelo.alta();
            if (correcto == true){
                vista.getNombre().setEditable(false);
                vista.getEnviar().setEnabled(false);
            }
        }
        
        if(ae.getSource() == vista.getBuscar()){
            String nombre = vista.getNombre().getText();

            modelo = new Genero (nombre);
            Object consulta[] = modelo.getNombreGenero();
            auxNombre = String.valueOf(consulta[0]);
            if( "null".equals(auxNombre)){
                JOptionPane.showMessageDialog(null, "No Hay Coincidencias", "ERROR", JOptionPane.ERROR_MESSAGE);
                vista.getEnviar().setVisible(false);
                vista.getActualizar().setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Ingrese los Nuevos Datos", "Correcto", JOptionPane.PLAIN_MESSAGE);
                vista.getBuscar().setVisible(false);
                vista.getActualizar().setVisible(true);
                vista.getEnviar().setVisible(false);     
            }

            }
              
            if(ae.getSource() == vista.getActualizar()){
                String nombre = vista.getNombre().getText();
                
                modelo = new Genero (auxNombre,nombre);
                boolean correcto = modelo.update();
                if(correcto == true){
                    JOptionPane.showMessageDialog(null, "Operación Realizada con Éxito", "Correcto", JOptionPane.PLAIN_MESSAGE);
                    vista.getActualizar().setVisible(false);
                    vista.getBuscar().setVisible(true);
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
