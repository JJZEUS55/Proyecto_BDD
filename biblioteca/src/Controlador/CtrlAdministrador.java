/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.Administrador;
import Interfaces.alta.*;
import Interfaces.baja.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author DDB 3CV3 2017
 */
public class CtrlAdministrador implements ActionListener,ItemListener {
    private final Administrador vista;
    
    public CtrlAdministrador(Administrador vista){
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == vista.getJBsalir()){
            vista.dispose();
        }
        
        if(ae.getSource() == vista.getJCalta()){
            if("Usuario".equals(vista.getJCalta().getSelectedItem().toString()))
            {
                AltaUsuario abrir = new AltaUsuario();
                abrir.setVisible(true);
            } 
            if("Ejemplar".equals(vista.getJCalta().getSelectedItem().toString()))
            {
                AltaEjemplar abrir = new AltaEjemplar();
                abrir.setVisible(true);
            }     
            if("Libro".equals(vista.getJCalta().getSelectedItem().toString()))
            {
                AltaLibro abrir = new AltaLibro();
                abrir.setVisible(true);
            } 
            if("Bibliotecario".equals(vista.getJCalta().getSelectedItem().toString()))
            {
                AltaBibliotecario abrir = new AltaBibliotecario();
                abrir.setVisible(true);
            } 
            if("Autor".equals(vista.getJCalta().getSelectedItem().toString()))
            {
                AltaAutor abrir = new AltaAutor();
                abrir.setVisible(true);
            } 
            if("Genero".equals(vista.getJCalta().getSelectedItem().toString()))
            {
                AltaGenero abrir = new AltaGenero();
                abrir.setVisible(true);
            }
            if("Editorial".equals(vista.getJCalta().getSelectedItem().toString()))
            {
                AltaEditorial abrir = new AltaEditorial();
                abrir.setVisible(true);
            }
            if("Biblioteca".equals(vista.getJCalta().getSelectedItem().toString()))
            {
                AltaBiblioteca abrir = new AltaBiblioteca();
                abrir.setVisible(true);
            }
            
        }
        
        if(ae.getSource() == vista.getJCbaja()){
            if("Usuario".equals(vista.getJCbaja().getSelectedItem().toString()))
            {
                BajaUsuario abrir = new BajaUsuario();
                abrir.setVisible(true);
            } 
            if("Ejemplar".equals(vista.getJCbaja().getSelectedItem().toString()))
            {
                BajaEjemplar abrir = new BajaEjemplar();
                abrir.setVisible(true);
            }     
            if("Libro".equals(vista.getJCbaja().getSelectedItem().toString()))
            {
                BajaLibro abrir = new BajaLibro();
                abrir.setVisible(true);
            } 
            if("Bibliotecario".equals(vista.getJCbaja().getSelectedItem().toString()))
            {
                BajaBibliotecario abrir = new BajaBibliotecario();
                abrir.setVisible(true);
            } 
            if("Autor".equals(vista.getJCbaja().getSelectedItem().toString()))
            {
                BajaAutor abrir = new BajaAutor();
                abrir.setVisible(true);
                abrir.getEliminar().setVisible(false);
                abrir.getBuscar().setVisible(true);
            } 
            if("Genero".equals(vista.getJCbaja().getSelectedItem().toString()))
            {
                BajaGenero abrir = new BajaGenero();
                abrir.setVisible(true);
                abrir.getEliminar().setVisible(false);
                abrir.getBuscar().setVisible(true);
            }
            if("Editorial".equals(vista.getJCbaja().getSelectedItem().toString()))
            {
                BajaEditorial abrir = new BajaEditorial();
                abrir.setVisible(true);
                abrir.getEliminar().setVisible(false);
                abrir.getBuscar().setVisible(true);
            }
            if("Biblioteca".equals(vista.getJCbaja().getSelectedItem().toString()))
            {
                BajaBiblioteca abrir = new BajaBiblioteca();
                abrir.setVisible(true);
                abrir.getEliminar().setVisible(false);
                abrir.getBuscar().setVisible(true);
            }   
        }
        if(ae.getSource() == vista.getJCupdate()){
            if("Usuario".equals(vista.getJCupdate().getSelectedItem().toString()))
            {
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
     
            } 
            if("Ejemplar".equals(vista.getJCupdate().getSelectedItem().toString()))
            {
                AltaEjemplar abrir = new AltaEjemplar();
                abrir.setVisible(true);
                abrir.getBuscar().setVisible(true);
                abrir.getActualizar().setVisible(false);
                abrir.getEnviar().setVisible(false);
                abrir.getLibro().setText("ID EJEMPLAR");
                abrir.getEstatus().setEnabled(false);
                abrir.getEstadoConservacion().setEditable(false);
                abrir.getBiblioteca().setEnabled(false);
                
            }     
            if("Libro".equals(vista.getJCupdate().getSelectedItem().toString()))
            {
                AltaLibro abrir = new AltaLibro();
                abrir.setVisible(true);
                abrir.getBuscar().setVisible(true);
                abrir.getActualizar().setVisible(false);
                abrir.getEnviar().setVisible(false);
                abrir.getEjemplar().setEnabled(false);
                abrir.getGenero().setEnabled(false);
                abrir.getEditorial().setEnabled(false);
                abrir.getEdicion().setEditable(false);
                abrir.getNoPaginas().setEditable(false);
                abrir.getAnio().setEditable(false);
                abrir.getAutor().setEnabled(false);
            } 
            if("Bibliotecario".equals(vista.getJCupdate().getSelectedItem().toString()))
            {
                AltaBibliotecario abrir = new AltaBibliotecario();
                abrir.setVisible(true);
                abrir.getEnviar().setVisible(false);
                abrir.getBuscar().setVisible(true);
                abrir.getNombre().setEditable(false);
                abrir.getAppPaterno().setEditable(false);
                abrir.getAppMaterno().setEditable(false);
                abrir.getCalle().setEditable(false);
                abrir.getExterior().setEditable(false);
                abrir.getInterior().setEditable(false);
                abrir.getBiblioteca().setEnabled(false);
                abrir.getContrasenia().setEditable(false);
                abrir.getSueldo().setEditable(false);
                abrir.getCargo().setEditable(false);
            } 
            if("Autor".equals(vista.getJCupdate().getSelectedItem().toString()))
            {
                AltaAutor abrir = new AltaAutor();
                abrir.setVisible(true);
                abrir.getBuscar().setVisible(true);
                abrir.getActualizar().setVisible(false);
                abrir.getEnviar().setVisible(false);
            } 
            if("Genero".equals(vista.getJCupdate().getSelectedItem().toString()))
            {
                AltaGenero abrir = new AltaGenero();
                abrir.setVisible(true);
                abrir.getBuscar().setVisible(true);
                abrir.getActualizar().setVisible(false);
                abrir.getEnviar().setVisible(false);
            }
            if("Editorial".equals(vista.getJCupdate().getSelectedItem().toString()))
            {
                AltaEditorial abrir = new AltaEditorial();
                abrir.setVisible(true);
                abrir.getBuscar().setVisible(true);
                abrir.getActualizar().setVisible(false);
                abrir.getEnviar().setVisible(false);
            }
            if("Biblioteca".equals(vista.getJCupdate().getSelectedItem().toString()))
            {
                AltaBiblioteca abrir = new AltaBiblioteca();
                abrir.setVisible(true);
                abrir.getBuscar().setVisible(true);
                abrir.getActualizar().setVisible(false);
                abrir.getEnviar().setVisible(false);
                abrir.getCalle().setEditable(false);
                abrir.getExterior().setEditable(false);
                abrir.getTelefono().setVisible(false);
            }
            
        }
        
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
       
        
  
    }
    
}
