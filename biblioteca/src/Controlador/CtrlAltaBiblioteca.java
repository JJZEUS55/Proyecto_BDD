/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.alta.AltaBiblioteca;
import Interfaces.alta.AltaTelefono;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Autor;
import modelo.BibliotecaM;


/**
 *
 * @author DDB 3CV3 2017
 */
public class CtrlAltaBiblioteca implements ActionListener, FocusListener {
    
    private final AltaBiblioteca vista;
    private BibliotecaM modelo;
    
    public CtrlAltaBiblioteca(AltaBiblioteca vista){
        this.vista = vista;
    }
   
    
    private String auxNombre,auxCalle,auxExterior;
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == vista.getSalir()){
            vista.dispose();
        }
        if(ae.getSource() == vista.getTelefono()){
            AltaTelefono telefono = new AltaTelefono();
            telefono.setVisible(true);
            telefono.getEnviar().setVisible(false);
            telefono.getEnviarAux().setVisible(true);
            String correo = vista.getNombre().getText();
            telefono.setCorreo(correo);
            
        }
        
        if(ae.getSource() == vista.getEnviar()){
            String nombre = vista.getNombre().getText();
            String calle = vista.getCalle().getText();
            String exterior = vista.getExterior().getText();
            
            modelo = new BibliotecaM(nombre, calle, exterior);
            boolean correcto = modelo.alta();
            
            if(correcto == true){
                vista.getNombre().setEditable(false);
                vista.getCalle().setEditable(false);
                vista.getExterior().setEditable(false);
                vista.getEnviar().setEnabled(false);
                vista.getTelefono().setEnabled(true);
            }
            
        }
        
        if(ae.getSource() == vista.getBuscar()){
            String nombre = vista.getNombre().getText();
            modelo = new BibliotecaM(nombre);
            Object consulta[][] = modelo.consultaDatos();
            auxNombre = String.valueOf(consulta[0][1]);
            auxCalle =  String.valueOf(consulta[0][2]);
            auxExterior =  String.valueOf(consulta[0][3]);
          
            if( "null".equals(auxNombre)){
                JOptionPane.showMessageDialog(null, "No Hay Coincidencias", "ERROR", JOptionPane.ERROR_MESSAGE);
                vista.getEnviar().setVisible(false);
                vista.getActualizar().setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Ingrese los Nuevos Datos", "Correcto", JOptionPane.PLAIN_MESSAGE);
                vista.getNombre().setText(auxNombre);
                vista.getNombre().setEditable(true);
                vista.getCalle().setText(auxCalle);
                vista.getCalle().setEditable(true);
                vista.getExterior().setText(auxExterior);
                vista.getExterior().setEditable(true);
                vista.getBuscar().setVisible(false);
                vista.getActualizar().setVisible(true);
                vista.getActualizar().setVisible(true);
                vista.getEnviar().setVisible(false);     
            }
        }
        
        if(ae.getSource() == vista.getActualizar()){
            String nombre = vista.getNombre().getText();
            String calle = vista.getCalle().getText();
            String exterior = vista.getExterior().getText();
            modelo = new BibliotecaM(auxNombre,nombre,calle,exterior);
            boolean correcto = modelo.update();
            if(correcto == true){
                JOptionPane.showMessageDialog(null, "Operación Realizada con Éxito", "Correcto", JOptionPane.PLAIN_MESSAGE);
                vista.getActualizar().setVisible(false);
                vista.getBuscar().setVisible(true);
                vista.getCalle().setEditable(false);
                vista.getCalle().setText("");
                vista.getExterior().setEditable(false);
                vista.getExterior().setText("");
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
