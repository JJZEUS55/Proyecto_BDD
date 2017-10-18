/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.baja;

import Controlador.CtrlBajaUsuario;
import static fuentes.Fuente.arial;
import static fuentes.Fuente.titulo;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author DDB 3CV3 2017
 */
public class BajaUsuario extends JFrame {
    
    private JLabel datosPersonales,domicilio,datosAcceso,mensaje;
    private JTextField correo,nombre, appPaterno,appMaterno, calle, exterior, interior,eliminar;
    private JPasswordField contrasenia;
    private JButton telefono,enviar, salir,buscar;
    private final CtrlBajaUsuario controlador;
    
    public BajaUsuario(){
        controlador = new CtrlBajaUsuario(this);
        configurarVentana(460,550);
        inicializarComponentes();
    }
    
    private void configurarVentana(int ancho, int alto){
        this.setTitle("Eliminar  Usuario");
        this.setSize(ancho,alto);
        this.setLocationRelativeTo(null);  
        this.setLayout(null);  
        this.setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarComponentes(){
        
        mensaje = new JLabel();
        eliminar = new JTextField();
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
        
        
        mensaje.setText("Eliminar Usuario");
        mensaje.setBounds(140, 30, 150, 25);
        mensaje.setFont(arial);
        
        eliminar.setText("Correo@");
        eliminar.setHorizontalAlignment(JTextField.CENTER);
        eliminar.setBounds(115, 80, 180, 20);
        eliminar.addFocusListener(controlador);
        
        buscar.setText("Buscar");
        buscar.setFont(arial);
        buscar.setBounds(305,77,90,25);
        buscar.addActionListener(controlador);
        
        datosPersonales.setText("Datos Personales");
        datosPersonales.setFont(arial);
        datosPersonales.setBounds(30, 150, 130,25);
                
        nombre.setBounds(30, 200, 130, 20);
        nombre.setText("Nombre(s)");
        nombre.setHorizontalAlignment(JTextField.CENTER);
        nombre.setEditable(false);
        
        appPaterno.setBounds(180, 200, 110,20);
        appPaterno.setText("Apellido Paterno");
        appPaterno.setHorizontalAlignment(JTextField.CENTER);
        appPaterno.setEditable(false);
        
        appMaterno.setBounds(310, 200, 110,20);
        appMaterno.setText("Apellido Materno");
        appMaterno.setHorizontalAlignment(JTextField.CENTER);
        appMaterno.setEditable(false);
        
        domicilio.setText("Domicilio");
        domicilio.setFont(titulo);
        domicilio.setBounds(30, 250, 130, 25);
        
        calle.setBounds(30, 300, 130, 20);
        calle.setText("Calle");
        calle.setHorizontalAlignment(JTextField.CENTER);
        calle.setEditable(false);
        
        exterior.setText("Exterior");
        exterior.setHorizontalAlignment(JTextField.CENTER);
        exterior.setBounds(180, 300, 43, 20);
        exterior.setEditable(false);
        
        interior.setText("Interior");
        interior.setHorizontalAlignment(JTextField.CENTER);
        interior.setBounds(248, 300, 43, 20);
        interior.setEditable(false);
        
        datosAcceso.setText("Datos de Acceso");
        datosAcceso.setFont(titulo);
        datosAcceso.setBounds(30, 350, 130, 25);
        
        
        correo.setBounds(30, 400, 190, 20);
        correo.setText("Correo@");
        correo.setHorizontalAlignment(JTextField.CENTER);
        correo.setEditable(false);
        
        contrasenia.setBounds(240,400,160,20);
        contrasenia.setText("Contraseña");
        contrasenia.setHorizontalAlignment(JPasswordField.CENTER);
        contrasenia.setEditable(false);
        
        telefono.setText("+ Telefono");
        telefono.setHorizontalAlignment(JTextField.CENTER);
        telefono.setBounds(320, 295, 90, 27);
        
        salir.setBounds(70, 470, 70, 30);
        salir.setText("Salir");
        salir.addActionListener(controlador);
       
        enviar.setBounds(260, 470, 95, 30);
        enviar.setText("Eliminar");
        enviar.setFont(arial);
        enviar.setEnabled(false);
        enviar.addActionListener(controlador);
        
        this.add(eliminar);
        this.add(mensaje);
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
        this.add(enviar);
        this.add(salir);
        this.add(buscar);
           
    }  

    public JTextField getEliminar() {
        return eliminar;
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
    
    
    
    
    
    
    
    
}
