/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Interfaces.alta.AltaTelefono;
import Interfaces.alta.AltaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Usuario;

/**
 *
 * @author DDB 3CV3 2017
 */
public class CtrlAltaUsuario implements ActionListener, FocusListener {

    private final AltaUsuario vista;
    private Usuario modelo;
    
    public CtrlAltaUsuario(AltaUsuario vista){
        this.vista = vista;
    }
    
    private String auxCorreo, auxContrasenia,auxNombre,auxappPaterno,auxappMaterno,auxCalle,auxExterior,auxInterior;
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == vista.getSalir()){
            vista.dispose();
        }
        
        if(ae.getSource() == vista.getTelefono()){
            AltaTelefono telefono = new AltaTelefono();
            telefono.setVisible(true);
            String correo = vista.getCorreo().getText();
            telefono.setCorreo(correo);
        }
        
        if(ae.getSource() == vista.getEnviar()){
            
            String correo = vista.getCorreo().getText();
            String contrasenia = String.valueOf(vista.getContrasenia().getPassword());
            String nombre = vista.getNombre().getText();
            String appPaterno = vista.getAppPaterno().getText();
            String appMaterno = vista.getAppMaterno().getText();
            String calle = vista.getCalle().getText();
            String exterior = vista.getExterior().getText();
            String interior = vista.getInterior().getText();

            modelo = new Usuario(correo, contrasenia, nombre, appPaterno, appMaterno, calle, exterior, interior);
            boolean correcto = modelo.alta();
            
            if(correcto == true){
                vista.getTelefono().setEnabled(true);
                vista.getCorreo().setEditable(false);
                vista.getContrasenia().setEditable(false);
                vista.getNombre().setEditable(false);
                vista.getAppPaterno().setEditable(false);
                vista.getAppMaterno().setEditable(false);
                vista.getCalle().setEditable(false);
                vista.getExterior().setEditable(false);
                vista.getInterior().setEditable(false);
                vista.getEnviar().setEnabled(false);
            }
        }
        
        if(ae.getSource() == vista.getBuscar()){
           String correo = vista.getCorreo().getText();
           modelo = new Usuario(correo);
           Object consulta[][] = modelo.consultaDatos();
           
            auxCorreo = String.valueOf(consulta[0][1]);
            auxContrasenia =  String.valueOf(consulta[0][2]);
            auxNombre =  String.valueOf(consulta[0][3]);
            auxappPaterno =  String.valueOf(consulta[0][4]);
            auxappMaterno =  String.valueOf(consulta[0][5]);
            auxCalle =  String.valueOf(consulta[0][6]);
            auxExterior =  String.valueOf(consulta[0][7]);
            auxInterior =  String.valueOf(consulta[0][8]);
            
            if( "null".equals(auxCorreo)){
                JOptionPane.showMessageDialog(null, "No Hay Coincidencias", "ERROR", JOptionPane.ERROR_MESSAGE);
                vista.getEnviar().setVisible(false);
                vista.getActualizar().setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Ingrese los Nuevos Datos", "Correcto", JOptionPane.PLAIN_MESSAGE);
                vista.getCorreo().setText(auxCorreo);
                vista.getCorreo().setEditable(false);
                vista.getContrasenia().setText(auxContrasenia);
                vista.getContrasenia().setEditable(true);
                vista.getNombre().setText(auxNombre);
                vista.getNombre().setEditable(true);
                vista.getAppPaterno().setText(auxappPaterno);
                vista.getAppPaterno().setEditable(true);
                vista.getAppMaterno().setText(auxappMaterno);
                vista.getAppMaterno().setEditable(true);
                vista.getCalle().setText(auxCalle);
                vista.getCalle().setEditable(true);
                vista.getExterior().setText(auxExterior);
                vista.getExterior().setEditable(true);
                vista.getInterior().setText(auxInterior);
                vista.getInterior().setEditable(true);
                vista.getBuscar().setVisible(false);
                vista.getActualizar().setVisible(true);
                vista.getEnviar().setVisible(false);     
            }
        }
        
        if(ae.getSource() == vista.getActualizar()){
            
            String correo = vista.getCorreo().getText();
            String contrasenia = String.valueOf(vista.getContrasenia().getPassword());
            String nombre = vista.getNombre().getText();
            String appPaterno = vista.getAppPaterno().getText();
            String appMaterno = vista.getAppMaterno().getText();
            String calle = vista.getCalle().getText();
            String exterior = vista.getExterior().getText();
            String interior = vista.getInterior().getText();

            modelo = new Usuario(correo, contrasenia, nombre, appPaterno, appMaterno, calle, exterior, interior);
            boolean correcto = modelo.update();
            
            if(correcto == true){
                vista.getCorreo().setEditable(true);
                vista.getContrasenia().setEditable(false);
                vista.getNombre().setEditable(false);
                vista.getAppPaterno().setEditable(false);
                vista.getAppMaterno().setEditable(false);
                vista.getCalle().setEditable(false);
                vista.getExterior().setEditable(false);
                vista.getInterior().setEditable(false);
                vista.getEnviar().setVisible(false);
                vista.getActualizar().setVisible(false);
                vista.getBuscar().setVisible(true);
                JOptionPane.showMessageDialog(null, "Operación Realizada con Éxito", "Correcto", JOptionPane.PLAIN_MESSAGE);
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
