/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaces.alta.AltaBibliotecario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.BibliotecaM;
import modelo.Bibliotecario;

/**
 *
 * @author DDB 3CV3 2017
 */
public class CtrlAltaBibliotecario implements ActionListener, FocusListener,ItemListener{

    private final  AltaBibliotecario vista;
    private Bibliotecario modelo;
    int algo;
    
    public CtrlAltaBibliotecario(AltaBibliotecario vista){
        this.vista = vista;
        
    }
    
    private String auxCorreo,auxContrasenia,auxNombre,auxappPaterno,auxappMaterno,auxCalle,auxExterior,auxInterior,auxSueldo,auxCargo,auxBiblioteca;
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == vista.getSalir()){
            vista.dispose();
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
            String sueldo = vista.getSueldo().getText();
            String cargo = vista.getCargo().getText();
            String biblioteca = String.valueOf(vista.getBiblioteca().getSelectedItem());
            
            modelo = new Bibliotecario(correo, contrasenia, nombre, appPaterno, appMaterno, calle, exterior, interior, sueldo, cargo);
            
            BibliotecaM bibliotecaM = new BibliotecaM(biblioteca);
            boolean correcto = modelo.alta(bibliotecaM);
            
            if(correcto == true){
                vista.getEnviar().setEnabled(false);
                vista.getCorreo().setEditable(false);
                vista.getContrasenia().setEditable(false);
                vista.getNombre().setEditable(false);
                vista.getAppPaterno().setEditable(false);
                vista.getAppMaterno().setEditable(false);
                vista.getCalle().setEditable(false);
                vista.getExterior().setEditable(false);
                vista.getInterior().setEditable(false);
                vista.getSueldo().setEditable(false);
                vista.getCargo().setEditable(false);
                vista.getBiblioteca().setEnabled(false);
            }
        }
        
         if(ae.getSource() == vista.getBuscar()){
            String correo = vista.getCorreo().getText();
            modelo = new Bibliotecario (correo);
            Object consulta[][] = modelo.consultaDatos();
            auxCorreo = String.valueOf(consulta[0][1]);
            auxContrasenia = String.valueOf(consulta[0][2]);
            auxNombre = String.valueOf(consulta[0][3]);
            auxappPaterno = String.valueOf(consulta[0][4]);
            auxappMaterno = String.valueOf(consulta[0][5]);
            auxCalle = String.valueOf(consulta[0][6]);
            auxExterior = String.valueOf(consulta[0][7]);
            auxInterior = String.valueOf(consulta[0][8]);
            auxSueldo = String.valueOf(consulta[0][9]);
            auxCargo = String.valueOf(consulta[0][10]);
            auxBiblioteca = String.valueOf(consulta[0][11]);
            if("null".equals(auxCorreo)){
                JOptionPane.showMessageDialog(null, "No Hay Coincidencias", "ERROR", JOptionPane.ERROR_MESSAGE);
                vista.getEnviar().setVisible(false);
                vista.getActualizar().setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Ingrese los Nuevos Datos", "Correcto", JOptionPane.PLAIN_MESSAGE);
                
                vista.getBuscar().setVisible(false);
                vista.getActualizar().setVisible(true);
                vista.getEnviar().setVisible(false);   
                vista.getCorreo().setEditable(false);
                vista.getCorreo().setText(auxCorreo);
                vista.getNombre().setEditable(true);
                vista.getNombre().setText(auxNombre);
                vista.getAppPaterno().setEditable(true);
                vista.getAppPaterno().setText(auxappPaterno);
                vista.getAppMaterno().setEditable(true);
                vista.getAppMaterno().setText(auxappMaterno);
                vista.getCalle().setEditable(true);
                vista.getCalle().setText(auxCalle);
                vista.getExterior().setEditable(true);
                vista.getExterior().setText(auxExterior);
                vista.getInterior().setEditable(true);
                vista.getInterior().setText(auxInterior);
                vista.getSueldo().setEditable(true);
                vista.getSueldo().setText(auxSueldo);
                vista.getCargo().setEditable(true);
                vista.getCargo().setText(auxCargo);
                vista.getContrasenia().setText(auxContrasenia);
                vista.getBiblioteca().setEnabled(true);
                BibliotecaM bibliote = new BibliotecaM("");
                vista.getBiblioteca().removeAllItems();
                vista.getBiblioteca().addItem(bibliote.nombreBiblioteca(auxBiblioteca));
               
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
                String sueldo = vista.getSueldo().getText();
                String cargo = vista.getCargo().getText();
                String biblioteca = String.valueOf(vista.getBiblioteca().getSelectedItem());
                
                modelo = new Bibliotecario(correo, contrasenia, nombre, appPaterno, appMaterno, calle, exterior, interior, sueldo, cargo);
            
                BibliotecaM bibliotecaM = new BibliotecaM(biblioteca);
                boolean correcto = modelo.update(bibliotecaM);
     
                if(correcto == true){
                    JOptionPane.showMessageDialog(null, "Operación Realizada con Éxito", "Correcto", JOptionPane.PLAIN_MESSAGE);
                    vista.getEnviar().setVisible(false);
                    vista.getActualizar().setVisible(false);
                    vista.getBuscar().setVisible(true);
                    vista.getCorreo().setEditable(true);
                    vista.getContrasenia().setEditable(false);
                    vista.getNombre().setEditable(false);
                    vista.getAppPaterno().setEditable(false);
                    vista.getAppMaterno().setEditable(false);
                    vista.getCalle().setEditable(false);
                    vista.getExterior().setEditable(false);
                    vista.getInterior().setEditable(false);
                    vista.getSueldo().setEditable(false);
                    vista.getCargo().setEditable(false);
                    vista.getBiblioteca().setEnabled(false);
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

    @Override
    public void itemStateChanged(ItemEvent ie) {
//        if(ie.getItemSelectable() == vista.getBiblioteca()){
//        BibliotecaM bibliotecaM = new BibliotecaM("");
//        ResultSet rs =bibliotecaM.getNombreBibliotecas();
//        //vista.getBiblioteca().getSelectedIndex();
//        System.out.println("i'm here");
//        }
        
//        
        
    }
}
