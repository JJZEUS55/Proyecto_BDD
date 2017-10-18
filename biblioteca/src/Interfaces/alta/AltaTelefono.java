/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.alta;

import Controlador.CtrlAltaTelefono;
import static fuentes.Fuente.arial;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author DDB 3CV3 2017
 */
public class AltaTelefono extends JFrame{
    
    private JTextField telefono;
    private JButton salir,enviar,agregar,enviarAux;
    private JLabel datos;
    private String correo;
    private final CtrlAltaTelefono controlador;
    
    public AltaTelefono(){
        controlador = new CtrlAltaTelefono(this);
        configurarVentana(370,200);
        inicializarComponentes();   
    }
    
    private void configurarVentana(int ancho, int alto){
        this.setTitle("Alta de Telefono");
        this.setSize(ancho,alto);
        this.setLocationRelativeTo(null);  
        this.setLayout(null);  
        this.setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarComponentes(){
        
        telefono = new JTextField();
        salir = new JButton();
        enviar = new JButton();
        enviarAux = new JButton();
        agregar = new JButton();
        datos = new JLabel();
        
        datos.setText("Número Telefónico");
        datos.setFont(arial);
        datos.setBounds(125, 20, 150,25);
        
        telefono.setText("Telefono");
        telefono.setHorizontalAlignment(JTextField.CENTER);
        telefono.setBounds(70, 60, 250, 20);
        telefono.addFocusListener(controlador);
       
        agregar.setText("+Agregar");
        agregar.setBounds(130, 110, 80, 25);
        agregar.setEnabled(false);
        agregar.addActionListener(controlador);
        
        enviar.setText("Aceptar");
        enviar.setFont(arial);
        enviar.setBounds(230,110,90,25);
        enviar.addActionListener(controlador);
        
        enviarAux.setText("Aceptar");
        enviarAux.setFont(arial);
        enviarAux.setBounds(230,110,90,25);
        enviarAux.addActionListener(controlador);
        enviarAux.setVisible(false);
        
        salir.setText("Salir");
        salir.setBounds(20, 110, 60, 25);
        salir.addActionListener(controlador);
        
        this.add(agregar);
        this.add(datos);
        this.add(telefono);
        this.add(enviar);
        this.add(enviarAux);
        this.add(salir);
    }

    public JTextField getTelefono() {
        return telefono;
    }

    public JButton getSalir() {
        return salir;
    }

    public JButton getEnviar() {
        return enviar;
    }

    public JButton getEnviarAux() {
        return enviarAux;
    }
   
    public JButton getAgregar() {
        return agregar;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    } 
    
    public String getCorreo(){
        return correo;
    }
    
    
    
}
