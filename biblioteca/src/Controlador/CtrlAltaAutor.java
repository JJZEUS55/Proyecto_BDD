/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.alta.AltaAutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Autor;
import modelo.AutorLibro;
import modelo.Libro;

/**
 *
 * @author DDB 3CV3 2017
 */
public class CtrlAltaAutor implements ActionListener,FocusListener {
    
    private final AltaAutor vista;
    private Autor modelo;
    
    public CtrlAltaAutor(AltaAutor vista){
        this.vista = vista;
    }
    
    
    private String auxNombre = "";
    private String auxappPaterno = "";
    private String auxappMaterno = "";
    @Override
    public void actionPerformed(ActionEvent ae) {
   
        if(ae.getSource() == vista.getSalir()){
            vista.dispose();
        }
        if(ae.getSource() == vista.getEnviar()){
            String nombre = vista.getNombre().getText();
            String appPaterno = vista.getAppPaterno().getText();
            String appMaterno = vista.getAppMaterno().getText();
            
            modelo = new Autor(nombre, appPaterno, appMaterno);
            boolean correcto = modelo.alta();
            
            if(correcto == true){
                vista.getNombre().setEditable(false);
                vista.getAppPaterno().setEditable(false);
                vista.getAppMaterno().setEditable(false);
                vista.getEnviar().setEnabled(false);
                
            }
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
        
        if(ae.getSource() == vista.getBuscaraux()){
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
            }
            else{
                JOptionPane.showMessageDialog(null, "Se encontro un Resultado", "Correcto", JOptionPane.PLAIN_MESSAGE);
                vista.getBuscar().setVisible(false);
                vista.getBuscaraux().setVisible(false);
                vista.getLibroAutor().setVisible(true);
                vista.getEnviar().setEnabled(false);
                vista.getNombre().setEditable(false);
                vista.getAppPaterno().setEditable(false);
                vista.getAppMaterno().setEditable(false);
            }

            }
        
        if(ae.getSource() == vista.getLibroAutor()){
            String tituloLibro = vista.getTituloLibro();
            String nombre = vista.getNombre().getText();
            String appPaterno = vista.getAppPaterno().getText();
            String appMaterno = vista.getAppMaterno().getText();
            Autor autor = new Autor(nombre, appPaterno, appMaterno);
            Libro libro = new Libro(tituloLibro);
            boolean correcto = libro.autorlibro(autor);
            
            if(correcto == true){
                vista.getLibroAutor().setEnabled(false);
            }
            }
              
        if(ae.getSource() == vista.getActualizar()){
                String nombre = vista.getNombre().getText();
                String appPaterno = vista.getAppPaterno().getText();
                String appMaterno = vista.getAppMaterno().getText();
                
                Autor aux = new Autor (auxNombre,auxappPaterno,auxappMaterno,nombre,appPaterno,appMaterno);
                boolean correcto = aux.update();
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
