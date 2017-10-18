/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.alta;

import Controlador.CtrlAltaEjemplar;
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
public class AltaEjemplar extends JFrame {
    
    private JTextField libro;
    private JTextArea estadoConservacion;
    private JComboBox  estatus,biblioteca;
    private JButton salir,enviar,buscar,actualizar;
    private JLabel altaEjemplar;
    private final CtrlAltaEjemplar controlador;
    
    public AltaEjemplar(){
        controlador = new CtrlAltaEjemplar(this);
        configurarVentana(390,340);
        inicializarComponentes();   
    }
    
    private void configurarVentana(int ancho, int alto){
        this.setTitle("Alta de Ejemplar");
        this.setSize(ancho,alto);
        this.setLocationRelativeTo(null);  
        this.setLayout(null);  
        this.setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarComponentes(){
        estadoConservacion = new JTextArea();
        libro = new JTextField();
        estatus = new JComboBox();
        salir = new JButton();
        enviar = new JButton();
        altaEjemplar = new JLabel();
        biblioteca = new JComboBox();
        buscar = new JButton();
        actualizar = new JButton();
        
        altaEjemplar.setText("Datos del Ejemplar");
        altaEjemplar.setFont(arial);
        altaEjemplar.setBounds(140, 20, 150,25);
        
        libro.setText("Título del Libro");
        libro.setHorizontalAlignment(JTextField.CENTER);
        libro.setBounds(70, 60, 250, 20);
        libro.addFocusListener(controlador);
        
        biblioteca.setBounds(80, 100, 110, 20);
        biblioteca.addItem("Consultar Bibliotecas");
        biblioteca.addActionListener(controlador);
        
        estatus.setBounds(230, 100, 80, 20);
        estatus.addItem("Disponible");
        estatus.addItem("Prestado");
        
        estadoConservacion.setText("Estado de Conservación");
        estadoConservacion.setBounds(70, 140, 250,80);
        estadoConservacion.addFocusListener(controlador);
        
        enviar.setText("Agregar");
        enviar.setFont(arial);
        enviar.setBounds(210,240,90,25);
        enviar.addActionListener(controlador);
        
        buscar.setText("Buscar");
        buscar.setFont(arial);
        buscar.setBounds(210,240,90,25);
        buscar.addActionListener(controlador);
        buscar.setVisible(false);
        
        actualizar.setText("Actualizar");
        actualizar.setFont(arial);
        actualizar.setBounds(190,240,110,25);
        actualizar.addActionListener(controlador);
        actualizar.setVisible(false);
        
        
        salir.setText("Salir");
        salir.setBounds(70, 240, 60, 25);
        salir.addActionListener(controlador);
        
        this.add(altaEjemplar);
        this.add(libro);
        this.add(estatus);
        this.add(estadoConservacion);
        this.add(enviar);
        this.add(salir);
        this.add(biblioteca);
        this.add(buscar);
        this.add(actualizar);
    }

    public JTextField getLibro() {
        return libro;
    }

    public JTextArea getEstadoConservacion() {
        return estadoConservacion;
    }

    public JComboBox getEstatus() {
        return estatus;
    }

    public JButton getSalir() {
        return salir;
    }

    public JButton getEnviar() {
        return enviar;
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
