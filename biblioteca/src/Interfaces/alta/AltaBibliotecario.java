/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.alta;

import Controlador.CtrlAltaBibliotecario;
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
public class AltaBibliotecario extends JFrame{
    
    private JLabel datosPersonales,domicilio,datosAcceso,datosTrabajo;
    private JTextField correo,nombre, appPaterno,appMaterno, calle, exterior, interior,sueldo,cargo;
    private JPasswordField contrasenia;
    private JButton enviar, salir,buscar,actualizar;
    private JComboBox biblioteca;
    private final CtrlAltaBibliotecario controlador;
    
    public AltaBibliotecario(){
        controlador = new CtrlAltaBibliotecario(this);
        configurarVentana(460,540);
        inicializarComponentes();
    }
    
    private void configurarVentana(int ancho, int alto){
        this.setTitle("Alta de un Bibliotecario");
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
        actualizar = new JButton();
        
        datosPersonales.setText("Datos Personales");
        datosPersonales.setFont(titulo);
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
        domicilio.addFocusListener(controlador);
        
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
        
        biblioteca.setBounds(305, 177, 120, 23);
        biblioteca.addItem("Consultar Biblioteca");
        biblioteca.addActionListener(controlador);
        
        datosTrabajo.setText("Datos de Trabajo");
        datosTrabajo.setFont(titulo);
        datosTrabajo.setBounds(30, 330, 130, 25);
        
        sueldo.setText("Sueldo");
        sueldo.setHorizontalAlignment(JTextField.CENTER);
        sueldo.setBounds(30, 380, 100, 20);
        sueldo.addFocusListener(controlador);
        
        cargo.setText("Cargo");
        cargo.setHorizontalAlignment(JTextField.CENTER);
        cargo.setBounds(170, 380, 120, 20);
        cargo.addFocusListener(controlador);
        
        salir.setBounds(70, 450, 70, 30);
        salir.setText("Salir");
        salir.addActionListener(controlador);
       
        enviar.setBounds(280, 450, 85, 30);
        enviar.setText("Enviar");
        enviar.setFont(arial);
        enviar.addActionListener(controlador);
        
        buscar.setBounds(280, 450, 85, 30);
        buscar.setText("Buscar");
        buscar.setFont(arial);
        buscar.addActionListener(controlador);
        buscar.setVisible(false);
        
        actualizar.setBounds(270, 450, 105, 30);
        actualizar.setText("Actualizar");
        actualizar.setFont(arial);
        actualizar.addActionListener(controlador);
        actualizar.setVisible(false);
        
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
        this.add(actualizar);
           
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

    public JTextField getSueldo() {
        return sueldo;
    }

    public JTextField getCargo() {
        return cargo;
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

    public JButton getActualizar() {
        return actualizar;
    }
    
    
    
}
