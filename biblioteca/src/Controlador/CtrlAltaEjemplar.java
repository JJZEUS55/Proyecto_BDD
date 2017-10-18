/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.alta.AltaEjemplar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.BibliotecaM;
import modelo.Ejemplar;
import modelo.Libro;

/**
 *
 * @author DDB 3CV3 2017
 */
public class CtrlAltaEjemplar implements ActionListener, FocusListener {
    private final AltaEjemplar vista;
    private Ejemplar modelo;

    public CtrlAltaEjemplar(AltaEjemplar vista){
        this.vista = vista;
    }
    private String auxLibro, auxEstadoConservacion,auxEstatus,auxBiblioteca,idEjemplar;
    private int algo;
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == vista.getSalir()){
            vista.dispose();
        }
        if(ae.getSource() == vista.getEnviar()){
            
            String titulo = vista.getLibro().getText();
            String estatus = String.valueOf(vista.getEstatus().getSelectedItem());
            String estado = vista.getEstadoConservacion().getText();
            String biblioteca = String.valueOf(vista.getBiblioteca().getSelectedItem());
            
            Libro libro = new Libro(titulo);
            
            BibliotecaM biblio = new BibliotecaM(biblioteca);
            modelo = new Ejemplar(estado, estatus);
            boolean correcto =modelo.alta(libro, biblio);
            if(correcto == true){
            vista.getLibro().setEditable(false);
            vista.getEstatus().setEnabled(false);
            vista.getEstadoConservacion().setEditable(false);
            vista.getBiblioteca().setEnabled(false);
            vista.getEnviar().setEnabled(false);
                } 
        }
        
        if(ae.getSource() == vista.getBuscar()){
            idEjemplar = vista.getLibro().getText();
            modelo = new Ejemplar(idEjemplar);
            Object consulta[][] = modelo.consultaDatos();
            auxLibro = String.valueOf(consulta[0][1]);
            auxEstadoConservacion =  String.valueOf(consulta[0][2]);
            auxEstatus =  String.valueOf(consulta[0][3]);
            auxBiblioteca =  String.valueOf(consulta[0][4]);
            BibliotecaM biblio = new BibliotecaM("");
            auxBiblioteca = biblio.nombreBiblioteca(auxBiblioteca);
            if( "null".equals(auxLibro)){
                JOptionPane.showMessageDialog(null, "No Hay Coincidencias", "ERROR", JOptionPane.ERROR_MESSAGE);
                vista.getEnviar().setVisible(false);
                vista.getActualizar().setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Ingrese los Nuevos Datos", "Correcto", JOptionPane.PLAIN_MESSAGE);
                String nombre = modelo.nombreLibro();
                if("".equals(nombre)){
                JOptionPane.showMessageDialog(null, "No existe Libro", "ERROR", JOptionPane.ERROR_MESSAGE);
         
                }else{
                vista.getLibro().setText(nombre);
  
            }
                vista.getLibro().setText(nombre);
                vista.getLibro().setEditable(true);
                vista.getEstadoConservacion().setText(auxEstadoConservacion);
                vista.getEstadoConservacion().setEditable(true);
                vista.getEstatus().removeAllItems();
                vista.getEstatus().addItem(auxEstatus);
                if("DISPONIBLE".equals(auxEstatus) || "Disponible".equals(auxEstatus)){
                    vista.getEstatus().addItem("OCUPADO");
                }
                if("OCUPADO".equals(auxEstatus) || "Ocupado".equals(auxEstatus)){
                    vista.getEstatus().addItem("DISPONIBLE");
                }
                vista.getEstatus().setEnabled(true);
                vista.getBiblioteca().removeAllItems();
                vista.getBiblioteca().addItem(auxBiblioteca);
                vista.getBiblioteca().setEnabled(true);
                vista.getBuscar().setVisible(false);
                vista.getActualizar().setVisible(true);
                vista.getActualizar().setVisible(true);
                vista.getEnviar().setVisible(false);     
            }
        }
        
        if(ae.getSource() == vista.getActualizar()){
            String estatus = String.valueOf(vista.getEstatus().getSelectedItem());
            String estado = vista.getEstadoConservacion().getText();
            String biblioteca = String.valueOf(vista.getBiblioteca().getSelectedItem());
 
            
            BibliotecaM biblio = new BibliotecaM(biblioteca);
            modelo = new Ejemplar(idEjemplar,estado, estatus);
            boolean correcto =modelo.update(biblio);
            if(correcto == true){
            JOptionPane.showMessageDialog(null, "Operación Realizada con Éxito", "Correcto", JOptionPane.PLAIN_MESSAGE);
            vista.getLibro().setEditable(false);
            vista.getEstatus().setEnabled(false);
            vista.getEstadoConservacion().setEditable(false);
            vista.getBiblioteca().setEnabled(false);
            vista.getEnviar().setVisible(false);
            vista.getBuscar().setVisible(false);
            vista.getActualizar().setEnabled(false);
                } 
        }
        
        if(ae.getSource() == vista.getBiblioteca()){
                BibliotecaM bibliotecaM = new BibliotecaM("");
                if(algo!=bibliotecaM.nodo())
                {
                algo=bibliotecaM.nodo();
                vista.getBiblioteca().removeAllItems();
                Object[] lista=bibliotecaM.getNombreBibliotecas();
                
                for (int i = 0; i < bibliotecaM.nodo(); i++) {
                vista.getBiblioteca().addItem(lista[i]);
                System.out.println("i'm here");
                }
        
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
