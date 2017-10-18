/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.alta;

import Controlador.CtrlAltaUsuario;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static fuentes.Fuente.*;
import javax.swing.JPasswordField;

/**
 *
 * @author DDB 3CV3 2017
 */
public class AltaUsuario extends JFrame {
    
    private JLabel datosPersonales,domicilio,datosAcceso;
    private JTextField correo,nombre, appPaterno,appMaterno, calle, exterior, interior;
    private JPasswordField contrasenia;
    private JButton telefono,enviar, salir,buscar,actualizar;
    
    private final CtrlAltaUsuario controlador;
    
    public AltaUsuario(){
        controlador = new CtrlAltaUsuario(this);
        configurarVentana(460,440);
        inicializarComponentes();
    }
    
    private void configurarVentana(int ancho, int alto){
        this.setTitle("Usuario");
        this.setSize(ancho,alto);
        this.setLocationRelativeTo(null);  
        this.setLayout(null);  
        this.setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarComponentes(){
        datosPersonales = new  JLabel();
        domicilio = new JLabel();
        datosAcceso = new JLabel();
        correo = new JTextField();
        contrasenia = new JPasswordField();
        nombre = new JTextField();
        appPaterno = new JTextField();
        appMaterno = new JTextField();
        calle = new JTextField();
        exterior = new JTextField();
        interior = new JTextField();
        telefono = new JButton();
        enviar = new JButton();
        salir = new JButton();
        buscar = new JButton();
        actualizar = new JButton();
        
        
        datosPersonales.setText("Datos Personales");
        datosPersonales.setFont(arial);
        datosPersonales.setBounds(30, 30, 130,25);
                
        nombre.setBounds(30, 80, 130, 20);
        nombre.setText("Nombre(s)");
        nombre.setHorizontalAlignment(JTextField.CENTER);
        nombre.addFocusListener(controlador);
        
        appPaterno.setBounds(180, 80, 110,20);
        appPaterno.setText("Apellido Paterno");
        appPaterno.setHorizontalAlignment(JTextField.CENTER);
        appPaterno.addFocusListener(controlador);
        
        appMaterno.setBounds(310, 80, 110,20);
        appMaterno.setText("Apellido Materno");
        appMaterno.setHorizontalAlignment(JTextField.CENTER);
        appMaterno.addFocusListener(controlador);
        
        domicilio.setText("Domicilio");
        domicilio.setFont(titulo);
        domicilio.setBounds(30, 130, 130, 25);
        
        calle.setBounds(30, 180, 130, 20);
        calle.setText("Calle");
        calle.setHorizontalAlignment(JTextField.CENTER);
        calle.addFocusListener(controlador);
        
        exterior.setText("Exterior");
        exterior.setHorizontalAlignment(JTextField.CENTER);
        exterior.setBounds(180, 180, 43, 20);
        exterior.addFocusListener(controlador);
        
        interior.setText("Interior");
        interior.setHorizontalAlignment(JTextField.CENTER);
        interior.setBounds(248, 180, 43, 20);
        interior.addFocusListener(controlador);
        
        datosAcceso.setText("Datos de Acceso");
        datosAcceso.setFont(titulo);
        datosAcceso.setBounds(30, 230, 130, 25);
        
        
        correo.setBounds(30, 280, 190, 20);
        correo.setText("Correo@");
        correo.setHorizontalAlignment(JTextField.CENTER);
        correo.addFocusListener(controlador);
        
        contrasenia.setBounds(240,280,160,20);
        contrasenia.setText("Contraseña");
        contrasenia.setHorizontalAlignment(JPasswordField.CENTER);
        contrasenia.addFocusListener(controlador);
        
        telefono.setText("+ Telefono");
        telefono.setHorizontalAlignment(JTextField.CENTER);
        telefono.setBounds(320, 175, 90, 27);
        telefono.setEnabled(false);
        telefono.addActionListener(controlador);
        
        salir.setBounds(70, 350, 70, 30);
        salir.setText("Salir");
        salir.addActionListener(controlador);
       
        enviar.setBounds(280, 350, 85, 30);
        enviar.setText("Enviar");
        enviar.setFont(arial);
        enviar.addActionListener(controlador);
        
        buscar.setBounds(280, 350, 85, 30);
        buscar.setText("Buscar");
        buscar.setFont(arial);
        buscar.addActionListener(controlador);
        buscar.setVisible(false);
        
        actualizar.setBounds(270, 350, 105, 30);
        actualizar.setText("Actualizar");
        actualizar.setFont(arial);
        actualizar.addActionListener(controlador);
        actualizar.setVisible(false);
        
        this.add(domicilio);
        this.add(datosPersonales);
        this.add(datosAcceso);
        this.add(correo);
        this.add(contrasenia);
        this.add(nombre);
        this.add(appPaterno);
        this.add(appMaterno);
        this.add(calle);
        this.add(exterior);
        this.add(interior);
        this.add(telefono);
        this.add(enviar);
        this.add(salir);
        this.add(buscar);
        this.add(actualizar);
    }  

    public JButton getTelefono() {
        return telefono;
    }

    public JButton getEnviar() {
        return enviar;
    }

    public JButton getSalir() {
        return salir;
    }

    public JTextField getCorreo() {
        return correo;
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

    public JTextField getCalle() {
        return calle;
    }

    public JTextField getExterior() {
        return exterior;
    }

    public JTextField getInterior() {
        return interior;
    }

    public JPasswordField getContrasenia() {
        return contrasenia;
    }
    
    public JButton getBuscar() {
        return buscar;
    }

    public JButton getActualizar() {
        return actualizar;
    }
    
    
}
