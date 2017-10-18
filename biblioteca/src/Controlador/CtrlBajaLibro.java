/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.baja.BajaLibro;
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
public class CtrlBajaLibro implements ActionListener , FocusListener{
    private final BajaLibro vista;
    private Libro modelo;

    public CtrlBajaLibro(BajaLibro vista) {
        this.vista = vista;
    }
    
    private String auxTituloLibro,auxNoPaginas,auxEdicion,auxAnio,auxEditorial,auxGenero;
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == vista.getSalir()){
            vista.dispose();
        }
        if(ae.getSource() == vista.getEnviar()){
            String nombre = vista.getEliminar().getText();
            
            modelo = new Libro(nombre);
            modelo.baja();
            vista.getEnviar().setVisible(false);
            vista.getBuscar().setVisible(true);
        }
        
        if(ae.getSource() == vista.getBuscar()){

           String titulo = vista.getEliminar().getText();
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
                vista.getEnviar().setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Se ha Encontrado un resultado", "Correcto", JOptionPane.PLAIN_MESSAGE);
                vista.getTituloLibro().setText(auxTituloLibro);
                vista.getTituloLibro().setEditable(false);
                vista.getNoPaginas().setText(auxNoPaginas);
                vista.getNoPaginas().setEditable(false);
                vista.getEdicion().setText(auxEdicion);
                vista.getEdicion().setEditable(false);
                vista.getAnio().setText(auxAnio);
                vista.getAnio().setEditable(false);
                vista.getEditorial().setText(auxEditorial);
                vista.getEditorial().setEnabled(false);
                vista.getGenero().setText(auxGenero);
                vista.getGenero().setEnabled(false);
                vista.getBuscar().setVisible(false);
                vista.getEnviar().setVisible(true); 
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
