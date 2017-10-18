/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.baja.BajaBibliotecario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.BibliotecaM;
import modelo.Bibliotecario;

/**
 *
 * @author DDB 3CV3 2017
 */
public class CtrlBajaBibliotecario implements ActionListener, FocusListener {
    
    private final BajaBibliotecario vista;
    private Bibliotecario modelo;
    
    public CtrlBajaBibliotecario(BajaBibliotecario vista){
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == vista.getSalir()){
            vista.dispose();
        }
        
        if(ae.getSource() == vista.getEnviar()){
            String correo = vista.getCorreo().getText();
            modelo = new Bibliotecario(correo);
            boolean correcto = modelo.baja();
            
            if(correcto == true){
                vista.getEnviar().setEnabled(false);
            }
        }
        
        if(ae.getSource() == vista.getBuscar()){
            String correo = vista.getEliminar().getText();
            
            modelo = new Bibliotecario(correo);
            modelo.consultaDatos();
     
            Object consulta[][] = modelo.consultaDatos();
            String auxCorreo = String.valueOf(consulta[0][1]);
            
            if("null".equals(auxCorreo)){
                JOptionPane.showMessageDialog(null, "No Hay Coincidencias", "ERROR", JOptionPane.ERROR_MESSAGE);
                vista.getEnviar().setEnabled(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Se encontro un Resultado", "Correcto", JOptionPane.PLAIN_MESSAGE);
                String biblioteca = String.valueOf(consulta[0][11]);
                BibliotecaM biblio = new BibliotecaM(biblioteca);
                String nombreBiblioteca = biblio.getNombreBiblioteca();
                
                vista.getBiblioteca().removeAllItems();
                BibliotecaM bibliote = new BibliotecaM("");
                vista.getBiblioteca().removeAllItems();
                vista.getBiblioteca().addItem(bibliote.nombreBiblioteca(biblioteca));
                vista.getCorreo().setText(String.valueOf(consulta[0][1]));
                vista.getContrasenia().setText(String.valueOf(consulta[0][2]));
                vista.getNombre().setText(String.valueOf(consulta[0][3]));
                vista.getAppPaterno().setText(String.valueOf(consulta[0][4]));
                vista.getAppMaterno().setText(String.valueOf(consulta[0][5]));
                vista.getCalle().setText(String.valueOf(consulta[0][6]));
                vista.getExterior().setText(String.valueOf(consulta[0][7]));
                vista.getInterior().setText(String.valueOf(consulta[0][8]));
                vista.getSueldo().setText(String.valueOf(consulta[0][9]));
                vista.getCargo().setText(String.valueOf(consulta[0][10]));
                vista.getEnviar().setEnabled(true);
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
