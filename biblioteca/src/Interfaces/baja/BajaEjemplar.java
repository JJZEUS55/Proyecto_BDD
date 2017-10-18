/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.baja;

import Controlador.CtrlBajaEjemplar;
import static fuentes.Fuente.arial;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author DDB 3CV3 2017
 */
public class BajaEjemplar extends JFrame {
    
    private JLabel mensaje;
    private JTextField libro,ejemplar;
    private JButton salir,eliminar,buscar;
    private final CtrlBajaEjemplar controlador;
    
    public BajaEjemplar(){
        controlador = new CtrlBajaEjemplar(this);
        configurarVentana(200,300);
        inicializarComponentes(); 
    }
    
    private void configurarVentana(int ancho, int alto){
        this.setTitle("Eliminar Ejemplar");
        this.setSize(ancho,alto);
        this.setLocationRelativeTo(null);  
        this.setLayout(null);  
        this.setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarComponentes(){
        mensaje = new JLabel();
        libro = new JTextField();
        salir = new JButton();
        eliminar = new JButton();
        ejemplar = new JTextField();
        buscar = new JButton();
        
        mensaje.setText("Eliminar Ejemplar");
        mensaje.setFont(arial);
        mensaje.setBounds(35, 20, 150,25);
        
        libro.setText("Libro");
        libro.setHorizontalAlignment(JTextField.CENTER);
        libro.setBounds(30, 160, 130, 20);
        libro.setEditable(false);
        
        buscar.setText("Buscar");
        buscar.setFont(arial);
        buscar.setBounds(55, 110, 90, 23);
        buscar.addActionListener(controlador);
        
        ejemplar.setText("ID Ejemplar");
        ejemplar.setHorizontalAlignment(JTextField.CENTER);
        ejemplar.setBounds(30, 60, 130, 20);
        ejemplar.addFocusListener(controlador);
        
        eliminar.setEnabled(false);
        eliminar.setText("Eliminar");
        eliminar.setFont(arial);
        eliminar.setBounds(85,220, 89, 23);
        eliminar.addActionListener(controlador);
        
        salir.setBounds(10, 220, 70, 23);
        salir.setText("Salir");
        salir.addActionListener(controlador);
        
        this.add(ejemplar);
        this.add(mensaje);
        this.add(libro);
        this.add(salir);
        this.add(eliminar);
        this.add(buscar);
    }


    public JTextField getEjemplar() {
        return ejemplar;
    }

    public JButton getSalir() {
        return salir;
    }

    public JButton getEliminar() {
        return eliminar;
    }

    public JTextField getLibro() {
        return libro;
    }

    public JButton getBuscar() {
        return buscar;
    }
    
    
    
    
    
}
