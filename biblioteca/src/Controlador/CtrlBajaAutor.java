/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.baja.BajaAutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Autor;

/**
 *
 * @author DDB 3CV3 2017
 */
public class CtrlBajaAutor implements ActionListener, FocusListener {
    private final BajaAutor vista;
    private Autor modelo;
    
    public CtrlBajaAutor(BajaAutor vista){
        this.vista = vista;
    }
    
    private String auxNombre,auxappPaterno,auxappMaterno;

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == vista.getEliminar()){ 
            String nombre = vista.getNombre().getText();
            String appPaterno = vista.getAppPaterno().getText();
            String appMaterno = vista.getAppMaterno().getText();
            
            modelo = new Autor(nombre, appPaterno, appMaterno);
            boolean correcto = modelo.baja();
            
            if(correcto == true){
                vista.getEliminar().setVisible(false);
                vista.getBuscar().setVisible(true);
                vista.getNombre().setEditable(true);
                vista.getAppPaterno().setEditable(true);
                vista.getAppMaterno().setEditable(true);
            }
       }
       
       if(ae.getSource() == vista.getSalir()){
           vista.dispose();
       }
       
       
       if(ae.getSource() == vista.getBuscar()){
            String nombre = vista.getNombre().getText();
            String appPaterno = vista.getAppPaterno().getText();
            String appMaterno = vista.getAppMaterno().getText();
            modelo = new Autor (nombre,appPaterno,appMaterno);
            Object consulta[][] = modelo.consultaDatos();
            auxNombre = String.valueOf(consulta[0][1]);
            auxappPaterno = String.valueOf(consulta[0][2]);
            auxappMaterno = String.valueOf(consulta[0][3]);
            System.err.println(auxNombre+auxappPaterno+auxappMaterno);
            if("null".equals(auxappMaterno) || "null".equals(auxNombre) || "null".equals(auxappPaterno)){
                JOptionPane.showMessageDialog(null, "No Hay Coincidencias", "ERROR", JOptionPane.ERROR_MESSAGE);
                vista.getEliminar().setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Se encontro un Resultado", "Correcto", JOptionPane.PLAIN_MESSAGE);
                vista.getNombre().setEditable(false);
                vista.getAppPaterno().setEditable(false);
                vista.getAppMaterno().setEditable(false);
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
