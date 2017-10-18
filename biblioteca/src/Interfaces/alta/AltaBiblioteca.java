/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.alta;

import Controlador.CtrlAltaBiblioteca;
import static fuentes.Fuente.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author DDB 3CV3 2017
 */
public class AltaBiblioteca extends JFrame {
    
    private JLabel datosBiblioteca;
    private JTextField nombre,calle,exterior;
    private JButton enviar,salir,telefono,buscar,actualizar;
    private final CtrlAltaBiblioteca controlador;
    
    public AltaBiblioteca(){
        
        controlador = new CtrlAltaBiblioteca(this);
        configurarVentana(420,270);
        inicializarComponentes();
    }
    
    private void configurarVentana(int ancho, int alto){
        this.setTitle("Alta de Biblioteca");
        this.setSize(ancho,alto);
        this.setLocationRelativeTo(null);  
        this.setLayout(null);  
        this.setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarComponentes(){ 
        datosBiblioteca = new JLabel();
        nombre = new JTextField();
        calle = new JTextField();
        exterior = new JTextField();
        telefono = new JButton();
        enviar = new JButton();
        salir = new JButton();
        buscar = new JButton();
        actualizar = new JButton();
        
        datosBiblioteca.setText("Datos de la Biblioteca");
        datosBiblioteca.setFont(arial);
        datosBiblioteca.setHorizontalAlignment(JTextField.CENTER);
        datosBiblioteca.setBounds(28, 30, 170,25);
        
        nombre.setBounds(30, 80, 130, 20);
        nombre.setText("Nombre");
        nombre.setHorizontalAlignment(JTextField.CENTER);
        nombre.addFocusListener(controlador);
        
        calle.setBounds(180, 80, 130, 20);
        calle.setText("Calle");
        calle.setHorizontalAlignment(JTextField.CENTER);
        calle.addFocusListener(controlador);
        
        exterior.setBounds(330, 80, 43, 20);
        exterior.setText("Exterior");
        exterior.setHorizontalAlignment(JTextField.CENTER);
        exterior.addFocusListener(controlador);
        
        telefono.setBounds(45, 130, 90, 22);
        telefono.setText("+ Telefono");
        telefono.setEnabled(false);
        telefono.addActionListener(controlador);
        
        salir.setBounds(40,190,70,23);
        salir.setText("Salir");
        salir.addActionListener(controlador);
        
        enviar.setBounds(230,155,110,25);
        enviar.setText("Aceptar");
        enviar.setFont(arial);
        enviar.addActionListener(controlador);
        
        buscar.setBounds(230,155,110,25);
        buscar.setText("Buscar");
        buscar.setFont(arial);
        buscar.addActionListener(controlador);
        buscar.setVisible(false);
        
        actualizar.setBounds(230,155,110,25);
        actualizar.setText("Actualizar");
        actualizar.setFont(arial);
        actualizar.addActionListener(controlador);
        actualizar.setVisible(false);
        
        
        this.add(nombre);
        this.add(datosBiblioteca);
        this.add(calle);
        this.add(exterior);
        this.add(telefono);
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

    public JButton getTelefono() {
        return telefono;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public JTextField getCalle() {
        return calle;
    }

    public JTextField getExterior() {
        return exterior;
    }

    public JButton getBuscar() {
        return buscar;
    }

    public JButton getActualizar() {
        return actualizar;
    }
    
    
    
}
