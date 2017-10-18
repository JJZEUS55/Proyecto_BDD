/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.alta.AltaAutor;
import Interfaces.alta.AltaEjemplar;
import Interfaces.alta.AltaLibro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Editorial;
import modelo.Genero;
import modelo.Libro;

/**
 *
 * @author DDB 3CV3 2017
 */
public class CtrlAltaLibro implements ActionListener, FocusListener {
    private AltaLibro vista;
    private Libro modelo;
    private int algo=0;
    
    public CtrlAltaLibro(AltaLibro vista){
        this.vista = vista;
    }
    
    private String auxTituloLibro,auxNoPaginas,auxEdicion,auxAnio,auxEditorial,auxGenero;
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == vista.getSalir()){
            vista.dispose();
        }
        
        if(ae.getSource() == vista.getEnviar()){
            String titulo = vista.getTituloLibro().getText();
            String genero = String.valueOf(vista.getGenero().getSelectedItem());
            String editorial = String.valueOf(vista.getEditorial().getSelectedItem());
            String edicion = vista.getEdicion().getText();
            String paginas = vista.getNoPaginas().getText();
            String anio = vista.getAnio().getText();
            
            Genero gen = new Genero(genero);
            Editorial edit = new Editorial(editorial);
            modelo = new Libro(titulo, paginas, edicion, anio);
            boolean correcto = modelo.alta(edit, gen);
            
            if(correcto == true){
                vista.getTituloLibro().setEditable(false);
                vista.getEnviar().setEnabled(false);
                vista.getGenero().setEnabled(false);
                vista.getEditorial().setEnabled(false);
                vista.getEdicion().setEditable(false);
                vista.getNoPaginas().setEditable(false);
                vista.getAnio().setEditable(false);
                vista.getAutor().setEnabled(true);
                
            }
        }
        
        if(ae.getSource() == vista.getBuscar()){
           String titulo = vista.getTituloLibro().getText();
           modelo = new Libro(titulo);
           Object consulta[][] = modelo.consultaDatos();
           
            auxTituloLibro = String.valueOf(consulta[0][1]);
            auxNoPaginas=  String.valueOf(consulta[0][2]);
            auxEdicion =  String.valueOf(consulta[0][3]);
            auxAnio =  String.valueOf(consulta[0][4]);
            auxEditorial =  String.valueOf(consulta[0][5]);
            auxGenero=  String.valueOf(consulta[0][6]);
            
            Genero gen = new Genero("");
            Editorial edit = new Editorial("");
            auxGenero = gen.nombreGenero(auxGenero);
            auxEditorial = edit.nombreEditorial(auxEditorial);
            
            if( "null".equals(auxTituloLibro)){
                JOptionPane.showMessageDialog(null, "No Hay Coincidencias", "ERROR", JOptionPane.ERROR_MESSAGE);
                vista.getEnviar().setVisible(false);
                vista.getActualizar().setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Ingrese los Nuevos Datos", "Correcto", JOptionPane.PLAIN_MESSAGE);
                vista.getTituloLibro().setText(auxTituloLibro);
                vista.getTituloLibro().setEditable(true);
                vista.getNoPaginas().setText(auxNoPaginas);
                vista.getNoPaginas().setEditable(true);
                vista.getEdicion().setText(auxEdicion);
                vista.getEdicion().setEditable(true);
                vista.getAnio().setText(auxAnio);
                vista.getAnio().setEditable(true);
                vista.getEditorial().removeAllItems();
                vista.getEditorial().addItem(auxEditorial);
                vista.getEditorial().setEnabled(true);
                vista.getGenero().removeAllItems();
                vista.getGenero().addItem(auxGenero);
                vista.getGenero().setEnabled(true);
                vista.getBuscar().setVisible(false);
                vista.getActualizar().setVisible(true);
                vista.getEnviar().setVisible(false);     
            }
        }
        
        if(ae.getSource() == vista.getActualizar()){
            String titulo = vista.getTituloLibro().getText();
            String genero = String.valueOf(vista.getGenero().getSelectedItem());
            String editorial = String.valueOf(vista.getEditorial().getSelectedItem());
            String edicion = vista.getEdicion().getText();
            String paginas = vista.getNoPaginas().getText();
            String anio = vista.getAnio().getText();
            
            Genero gen = new Genero("THRILLER");
            Editorial edit = new Editorial("SALAMANDRA");
            modelo = new Libro(auxTituloLibro,titulo, paginas, edicion, anio);
            boolean correcto = modelo.update(edit, gen);
            System.out.println("correcto == " +correcto);
            if(correcto == true){
                vista.getTituloLibro().setEditable(false);
                vista.getEnviar().setVisible(false);
                vista.getBuscar().setVisible(false);
                vista.getActualizar().setEnabled(false);
                vista.getEjemplar().setEnabled(false);
                vista.getGenero().setEnabled(false);
                vista.getEditorial().setEnabled(false);
                vista.getEdicion().setEditable(false);
                vista.getNoPaginas().setEditable(false);
                vista.getAnio().setEditable(false);
                vista.getAutor().setEnabled(false);
                JOptionPane.showMessageDialog(null, "Operación Realizada con Éxito", "Correcto", JOptionPane.PLAIN_MESSAGE);
            }
        }
        
        if(ae.getSource() == vista.getEjemplar()){
            AltaEjemplar nuevo = new AltaEjemplar();
            nuevo.setVisible(true);
            nuevo.getLibro().setText(vista.getTituloLibro().getText());
            nuevo.getLibro().setEditable(false);
        }
        
        if(ae.getSource() == vista.getAutor()){
            AltaAutor nuevo = new AltaAutor();
            nuevo.setVisible(true);
            nuevo.getBuscar().setVisible(false);
            nuevo.getBuscaraux().setBounds(160, 150, 110, 23);
            nuevo.getBuscaraux().setVisible(true);
            nuevo.getEnviar().setBounds(300, 150, 110, 23);
            nuevo.setTituloLibro(vista.getTituloLibro().getText());
        }
        
        if(ae.getSource() == vista.getGenero()){
        Genero genero = new Genero("");
        if(algo!=genero.nodo())
        {
        algo=genero.nodo();
        vista.getGenero().removeAllItems();
        Object[] lista=genero.getNombreGenero();
            for (int i = 0; i < genero.nodo(); i++) {
                vista.getGenero().addItem(lista[i]);
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
