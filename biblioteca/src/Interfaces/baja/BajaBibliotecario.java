/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.baja;

import Controlador.CtrlBajaBibliotecario;
import static fuentes.Fuente.arial;
import static fuentes.Fuente.titulo;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author DDB 3CV3 2017
 */
public class BajaBibliotecario extends JFrame{
    private JLabel datosPersonales,domicilio,datosAcceso,datosTrabajo,mensaje;
    private JTextField correo,nombre, appPaterno,appMaterno, calle, exterior, interior,sueldo,cargo,eliminar;
    private JPasswordField contrasenia;
    private JButton enviar, salir,buscar;
    private JComboBox biblioteca;
    private final CtrlBajaBibliotecario controlador;
    
    public BajaBibliotecario(){
        controlador = new CtrlBajaBibliotecario(this);
        configurarVentana(460,660);
        inicializarComponentes();
    }
    
    private void configurarVentana(int ancho, int alto){
        this.setTitle("Baja de un Bibliotecario");
        this.setSize(ancho,alto);
        this.setLocationRelativeTo(null);  
        this.setLayout(null);  
        this.setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarComponentes(){
        eliminar = new JTextField();
        mensaje = new JLabel();
        datosPersonales = new  JLabel();
        domicilio = new JLabel();
        datosAcceso = new JLabel();
        datosTrabajo = new JLabel();
        correo = new JTextField();
        contrasenia = new JPasswordField();
        nombre = new JTextField();
        appPaterno = new JTextField();
        appMaterno = new JTextField();
        calle = new JTextField();
        exterior = new JTextField();
        interior = new JTextField();
        sueldo = new JTextField();
        cargo = new JTextField();
        biblioteca = new JComboBox();
        enviar = new JButton();
        salir = new JButton();
        buscar = new JButton();
        
        mensaje.setText("Eliminar Bibliotecario");
        mensaje.setBounds(120, 50, 150, 25);
        mensaje.setFont(arial);
        
        eliminar.setText("Correo@");
        eliminar.setHorizontalAlignment(JTextField.CENTER);
        eliminar.setBounds(105, 100, 180, 20);
        eliminar.addFocusListener(controlador);
        
        buscar.setText("Buscar");
        buscar.setFont(arial);
        buscar.setBounds(305,97,90,25);
        buscar.addActionListener(controlador);
        
        datosPersonales.setText("Datos Personales");
        datosPersonales.setFont(titulo);
        datosPersonales.setBounds(30, 170, 130,25);
                
        nombre.setBounds(30, 220, 130, 20);
        nombre.setText("Nombre(s)");
        nombre.setHorizontalAlignment(JTextField.CENTER);
        nombre.setEditable(false);
        
        appPaterno.setBounds(180, 220, 110,20);
        appPaterno.setText("Apellido Paterno");
        appPaterno.setHorizontalAlignment(JTextField.CENTER);
        appPaterno.setEditable(false);
        
        appMaterno.setBounds(310, 220, 110,20);
        appMaterno.setText("Apellido Materno");
        appMaterno.setHorizontalAlignment(JTextField.CENTER);
        appMaterno.setEditable(false);
        
        domicilio.setText("Domicilio");
        domicilio.setFont(titulo);
        domicilio.setBounds(30, 270, 130, 25);
        
        calle.setBounds(30, 320, 130, 20);
        calle.setText("Calle");
        calle.setHorizontalAlignment(JTextField.CENTER);
        calle.setEditable(false);
        
        exterior.setText("Exterior");
        exterior.setHorizontalAlignment(JTextField.CENTER);
        exterior.setBounds(180, 320, 43, 20);
        exterior.setEditable(false);
        
        interior.setText("Interior");
        interior.setHorizontalAlignment(JTextField.CENTER);
        interior.setBounds(248, 320, 43, 20);
        interior.setEditable(false);
        
        datosAcceso.setText("Datos de Acceso");
        datosAcceso.setFont(titulo);
        datosAcceso.setBounds(30, 370, 130, 25);
        
        
        correo.setBounds(30, 420, 190, 20);
        correo.setText("Correo@");
        correo.setHorizontalAlignment(JTextField.CENTER);
        correo.setEditable(false);
        
        contrasenia.setBounds(240,420,160,20);
        contrasenia.setText("Contraseña");
        contrasenia.setHorizontalAlignment(JPasswordField.CENTER);
        contrasenia.setEditable(false);
        
        biblioteca.setBounds(320, 317, 90, 23);
        biblioteca.addItem("BIBLIOTECA");
        biblioteca.setEnabled(true);
        
        datosTrabajo.setText("Datos de Trabajo");
        datosTrabajo.setFont(titulo);
        datosTrabajo.setBounds(30, 470, 130, 25);
        
        sueldo.setText("Sueldo");
        sueldo.setHorizontalAlignment(JTextField.CENTER);
        sueldo.setBounds(30, 520, 100, 20);
        sueldo.setEditable(false);
        
        cargo.setText("Cargo");
        cargo.setHorizontalAlignment(JTextField.CENTER);
        cargo.setBounds(170, 520, 120, 20);
        cargo.setEditable(false);
        
        salir.setBounds(70, 590, 70, 30);
        salir.setText("Salir");
        salir.addActionListener(controlador);
        
        enviar.setBounds(280, 590, 85, 30);
        enviar.setText("Borrar");
        enviar.setFont(arial);
        enviar.setEnabled(false);
        enviar.addActionListener(controlador);
        
        this.add(mensaje);
        this.add(eliminar);
        this.add(domicilio);
        this.add(datosPersonales);
        this.add(datosAcceso);
        this.add(datosTrabajo);
        this.add(correo);
        this.add(contrasenia);
        this.add(nombre);
        this.add(appPaterno);
        this.add(appMaterno);
        this.add(calle);
        this.add(exterior);
        this.add(interior);
        this.add(sueldo);
        this.add(cargo);
        this.add(biblioteca);
        this.add(enviar);
        this.add(salir);
        this.add(buscar);
    }

    public JTextField getCorreo() {
        return correo;
    }

    public JButton getEnviar() {
        return enviar;
    }

    public JButton getSalir() {
        return salir;
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

    public JTextField getSueldo() {
        return sueldo;
    }

    public JTextField getCargo() {
        return cargo;
    }

    public JTextField getEliminar() {
        return eliminar;
    }

    public JPasswordField getContrasenia() {
        return contrasenia;
    }

    public JComboBox getBiblioteca() {
        return biblioteca;
    }

    
    public JButton getBuscar() {
        return buscar;
    }
    
    
    
    
    
    
    
}
