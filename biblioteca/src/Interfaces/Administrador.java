/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import Controlador.CtrlAdministrador;
import static fuentes.Fuente.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Administrador extends JFrame{

    private JLabel JLalta,JLbaja,JLupdate,JLconsulta,JLnombre;
    private JButton JBsalir;
    private JComboBox JCalta,JCbaja,JCupdate,JCconsulta;
    private final CtrlAdministrador controlador;
    
    public Administrador(){
        controlador = new CtrlAdministrador(this);
        configurarVentana();
        inicializarComponenetes();
        
    }
    
    private void configurarVentana(){
        this.setTitle("Administrador");
        this.setSize(430,300 );
        this.setLocationRelativeTo(null);  
        this.setLayout(null);  
        this.setResizable(false); 
    }
    
    private void inicializarComponenetes(){
        
        JLalta = new JLabel();
        JLbaja = new JLabel();
        JLupdate = new JLabel();
        JLconsulta = new JLabel();
        JLnombre = new JLabel();
        JBsalir = new JButton();
        JCalta = new JComboBox();
        JCbaja = new JComboBox();
        JCupdate = new JComboBox();
        JCconsulta = new JComboBox();
        
        
        
        JLnombre.setText("BIENVENIDO ADMINISTRADOR\n" +
"        JLnombre.setText(\"BIENVENIDO ");
        JLnombre.setFont(titulo);
        JLnombre.setBounds(90, 20, 235, 25);
        
        JLalta.setText("Alta");
        JLalta.setFont(arial);
        JLalta.setBounds(82, 90, 50, 23);
        
        JLbaja.setText("Baja");
        JLbaja.setFont(arial);
        JLbaja.setBounds(182, 90, 50, 23);
        
        JLupdate.setText("Update");
        JLupdate.setFont(arial);
        JLupdate.setBounds(270, 90, 70, 23);
        
        JLconsulta.setText("Consulta");
        JLconsulta.setFont(arial);
        JLconsulta.setBounds(330, 90, 70, 23);
        
        JBsalir.setText("Cerrar Sesión");
        JBsalir.setBounds(150, 200, 120, 30);
        JBsalir.addActionListener(controlador);
        JBsalir.requestFocus();
        
        
        JCalta.setBounds(55, 115, 80, 23);
        JCalta.addActionListener(controlador);
        JCalta.addItem("ALTAS");
        JCalta.addItem("Usuario");
        JCalta.addItem("Bibliotecario");
        JCalta.addItem("Libro");
        JCalta.addItem("Autor");
        JCalta.addItem("Genero");
        JCalta.addItem("Editorial");
        JCalta.addItem("Ejemplar");
        JCalta.addItem("Biblioteca");
        JCalta.setFocusable(false);
      
        
        JCbaja.setBounds(155, 115, 80, 23);
        JCbaja.addActionListener(controlador);
        JCbaja.addItem("ELIMINAR");
        JCbaja.addItem("Usuario");
        JCbaja.addItem("Bibliotecario");
        JCbaja.addItem("Libro");
        JCbaja.addItem("Autor");
        JCbaja.addItem("Genero");
        JCbaja.addItem("Editorial");
        JCbaja.addItem("Ejemplar");
        JCbaja.addItem("Biblioteca");
        JCbaja.setFocusable(false);
        
        JCupdate.setBounds(255, 115, 90, 23);
        JCupdate.addActionListener(controlador);
        JCupdate.addItem("ACTUALIZAR");
        JCupdate.addItem("Usuario");
        JCupdate.addItem("Bibliotecario");
        JCupdate.addItem("Libro");
        JCupdate.addItem("Autor");
        JCupdate.addItem("Genero");
        JCupdate.addItem("Editorial");
        JCupdate.addItem("Ejemplar");
        JCupdate.addItem("Biblioteca");
        JCupdate.setFocusable(false);
        
        JCconsulta.setBounds(315, 115, 90, 23);
        JCconsulta.addActionListener(controlador);
        JCconsulta.addItem("CONSULTAR");
        JCconsulta.addItem("Usuario");
        JCconsulta.addItem("Bibliotecario");
        JCconsulta.addItem("Libro");
        JCconsulta.addItem("Autor");
        JCconsulta.addItem("Genero");
        JCconsulta.addItem("Editorial");
        JCconsulta.addItem("Ejemplar");
        JCconsulta.addItem("Biblioteca");
        JCconsulta.setFocusable(false);
        
        this.add(JBsalir);
        this.add(JLalta);
        this.add(JLbaja);
        this.add(JLupdate);
        //this.add(JLconsulta);
        this.add(JLnombre);
        this.add(JCalta);
        this.add(JCbaja);
        this.add(JCupdate);
        //this.add(JCconsulta);
    } 

    public JButton getJBsalir() {
        return JBsalir;
    }

    public JComboBox getJCalta() {
        return JCalta;
    }

    public JComboBox getJCbaja() {
        return JCbaja;
    }

    public JComboBox getJCupdate() {
        return JCupdate;
    }

    public JComboBox getJCconsulta() {
        return JCconsulta;
    }
    
    
    
    
    
}
