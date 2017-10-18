/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.baja;

import Controlador.CtrlBajaAutor;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static fuentes.Fuente.arial;

/**
 *
 * @author DDB 3CV3 2017
 */
public class BajaAutor extends JFrame {
    
    private JLabel mensaje;
    private JTextField nombre,appPaterno,appMaterno;
    private JButton salir,eliminar,buscar;
    private final CtrlBajaAutor controlador;
    
    public BajaAutor(){
        controlador = new CtrlBajaAutor(this);
        configurarVentana(455,210);
        inicializarComponentes(); 
    }
    
    private void configurarVentana(int ancho, int alto){
        this.setTitle("Eliminar Autor");
        this.setSize(ancho,alto);
        this.setLocationRelativeTo(null);  
        this.setLayout(null);  
        this.setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarComponentes(){
        mensaje = new JLabel();
        nombre = new JTextField();
        appPaterno = new JTextField();
        appMaterno = new JTextField();
        salir = new JButton();
        eliminar = new JButton();
        buscar = new JButton();
        
        mensaje.setText("Eliminar Autor");
        mensaje.setFont(arial);
        mensaje.setBounds(185, 20, 150,25);
        
        nombre.setText("Nombre(s)");
        nombre.setHorizontalAlignment(JTextField.CENTER);
        nombre.setBounds(30, 70, 130, 20);
        nombre.addFocusListener(controlador);
        
        appPaterno.setBounds(180, 70, 110, 20);
        appPaterno.setHorizontalAlignment(JTextField.CENTER);
        appPaterno.setText("Apellido Paterno");
        appPaterno.addFocusListener(controlador);
        
        appMaterno.setBounds(310, 70, 110, 20);
        appMaterno.setHorizontalAlignment(JTextField.CENTER);
        appMaterno.setText("Apellido Materno");
        appMaterno.addFocusListener(controlador);
        
        eliminar.setText("Eliminar");
        eliminar.setFont(arial);
        eliminar.setBounds(270, 130, 90, 23);
        eliminar.addActionListener(controlador);
        
        salir.setBounds(70, 130, 70, 23);
        salir.setText("Salir");
        salir.addActionListener(controlador);
        
        buscar.setText("Buscar");
        buscar.setFont(arial);
        buscar.setBounds(270, 130, 90, 23);
        buscar.addActionListener(controlador);
        
        this.add(mensaje);
        this.add(nombre);
        this.add(appPaterno);
        this.add(appMaterno);
        this.add(salir);
        this.add(eliminar);
        this.add(buscar);
    }

    public JTextField getNombre() {
        return nombre;
    }

    public JTextField getAppPaterno() {
        return appPaterno;
    }

    public JTextField getAppMaterno() {
        return appMaterno;
    }

    public JButton getSalir() {
        return salir;
    }

    public JButton getEliminar() {
        return eliminar;
    }

    public JButton getBuscar() {
        return buscar;
    }
    
    
    
}
