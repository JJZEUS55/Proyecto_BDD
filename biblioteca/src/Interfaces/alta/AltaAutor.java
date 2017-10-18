/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.alta;

import Controlador.CtrlAltaAutor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static fuentes.Fuente.*;

/**
 *
 * @author DDB 3CV3 2017
 */
public class AltaAutor extends JFrame{
    
    private JLabel datosPersonales;
    private JTextField nombre,appPaterno,appMaterno;
    private JButton salir,enviar,actualizar,buscar,buscaraux,libroAutor;
    private String tituloLibro;
    private final CtrlAltaAutor controlador;
    
    public AltaAutor(){
        controlador = new CtrlAltaAutor(this);
        configurarVentana(450,230);
        inicializarComponentes();
    }
    
    private void configurarVentana(int ancho, int alto){
        this.setTitle("Agregar Autor");
        this.setSize(ancho,alto);
        this.setLocationRelativeTo(null);  
        this.setLayout(null);  
        this.setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarComponentes(){ 
        datosPersonales = new JLabel();
        nombre = new JTextField();
        appPaterno  = new JTextField();
        appMaterno = new JTextField();
        enviar = new JButton();
        actualizar = new JButton();
        buscar = new JButton();
        buscaraux = new JButton();
        salir = new JButton();
        libroAutor = new JButton();
        
        datosPersonales.setBounds(30, 30 , 170, 25);
        nombre.setBounds(30, 80, 130, 20);
        appPaterno.setBounds(180, 80, 110, 20);
        appMaterno.setBounds(310, 80, 110, 20);
        enviar.setBounds(250, 150, 110, 23);
        actualizar.setBounds(250, 150, 120, 23);
        buscar.setBounds(250, 150, 110, 23);
        libroAutor.setBounds(160, 150, 110, 23);
        buscaraux.setBounds(250, 150, 110, 23);
        salir.setBounds(60, 150, 70, 23);
        
        datosPersonales.setText("Datos del Autor");
        datosPersonales.setFont(arial);

        nombre.setText("Nombre(s)");
        nombre.setHorizontalAlignment(JTextField.CENTER);
        nombre.addFocusListener(controlador);
        
        appPaterno.setText("Apellido Paterno");
        appPaterno.setHorizontalAlignment(JTextField.CENTER);
        appPaterno.addFocusListener(controlador);
        
        appMaterno.setText("Apellido Materno");
        appMaterno.setHorizontalAlignment(JTextField.CENTER);
        appMaterno.addFocusListener(controlador);
        
        enviar.setText("Añadir");
        enviar.setFont(arial);
        enviar.addActionListener(controlador);
        
        actualizar.setText("Actualizar");
        actualizar.setFont(arial);
        actualizar.addActionListener(controlador);
        actualizar.setVisible(false);
                
        buscar.setText("Buscar");
        buscar.setFont(arial);
        buscar.addActionListener(controlador);
        buscar.setVisible(false);
        
        buscaraux.setText("Buscar");
        buscaraux.setFont(arial);
        buscaraux.addActionListener(controlador);
        buscaraux.setVisible(false);
        
        libroAutor.setText("Aceptar");
        libroAutor.setFont(arial);
        libroAutor.addActionListener(controlador);
        libroAutor.setVisible(false);
        
        salir.setText("Salir");
        salir.addActionListener(controlador);
        
        this.add(datosPersonales);
        this.add(nombre);
        this.add(appPaterno);
        this.add(appMaterno);
        this.add(enviar);
        this.add(buscar);
        this.add(buscaraux);
        this.add(actualizar);
        this.add(salir);
        this.add(libroAutor);
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

    public JButton getEnviar() {
        return enviar;
    }

    public JButton getActualizar() {
        return actualizar;
    }

    public JButton getBuscar() {
        return buscar;
    }

    public JButton getBuscaraux() {
        return buscaraux;
    }

    public JButton getLibroAutor() {
        return libroAutor;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }
    
    
        
}
