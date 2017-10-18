/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.baja;

import Controlador.CtrlBajaEditorial;
import static fuentes.Fuente.arial;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author DDB 3CV3 2017
 */
public class BajaEditorial extends JFrame {
    
    private JLabel mensaje;
    private JTextField nombre;
    private JButton salir,eliminar,buscar;
    private final CtrlBajaEditorial controlador;
    
    public BajaEditorial(){
        controlador = new CtrlBajaEditorial(this);
        configurarVentana(200,210);
        inicializarComponentes(); 
    }
    
    private void configurarVentana(int ancho, int alto){
        this.setTitle("Eliminar Editrial");
        this.setSize(ancho,alto);
        this.setLocationRelativeTo(null);  
        this.setLayout(null);  
        this.setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarComponentes(){
        mensaje = new JLabel();
        nombre = new JTextField();
        salir = new JButton();
        eliminar = new JButton();
        buscar = new JButton();
        
        mensaje.setText("Eliminar Editorial");
        mensaje.setFont(arial);
        mensaje.setBounds(35, 20, 150,25);
        
        nombre.setText("Nombre");
        nombre.setHorizontalAlignment(JTextField.CENTER);
        nombre.setBounds(30, 70, 130, 20);
        nombre.addFocusListener(controlador);
        
        eliminar.setText("Eliminar");
        eliminar.setFont(arial);
        eliminar.setBounds(85, 130, 89, 23);
        eliminar.addActionListener(controlador);
        
        buscar.setText("Buscar");
        buscar.setFont(arial);
        buscar.setBounds(85, 130, 89, 23);
        buscar.addActionListener(controlador);

        
        salir.setBounds(10, 130, 70, 23);
        salir.setText("Salir");
        salir.addActionListener(controlador);
        
        this.add(mensaje);
        this.add(nombre);
        this.add(salir);
        this.add(eliminar);
        this.add(buscar);
    }

    public JTextField getNombre() {
        return nombre;
    }

    public JButton getEliminar() {
        return eliminar;
    }

    public JButton getSalir() {
        return salir;
    }

    public JButton getBuscar() {
        return buscar;
    }
    
    
    
}
