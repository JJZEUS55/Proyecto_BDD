/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.alta;

import Controlador.CtrlAltaEditorial;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static fuentes.Fuente.*;

/**
 *
 * @author DDB 3CV3 2017
 */
public class AltaEditorial extends JFrame {
    private JLabel altaEditorial;
    private JTextField nombre;
    private JButton salir,enviar,buscar,actualizar;
    private final CtrlAltaEditorial controlador;
    
    public AltaEditorial(){
        controlador = new CtrlAltaEditorial(this);
        configurarVentana(230,230);
        inicializarComponentes();
    }
    
    private void configurarVentana(int ancho, int alto){
        this.setTitle("Alta de Editorial");
        this.setSize(ancho,alto);
        this.setLocationRelativeTo(null);  
        this.setLayout(null);  
        this.setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarComponentes(){ 
        
        altaEditorial = new JLabel();
        nombre = new JTextField();
        salir = new JButton();
        enviar = new JButton();
        buscar = new JButton();
        actualizar = new JButton();
        
        altaEditorial.setBounds(80, 30, 130, 20);
        nombre.setBounds(50, 80, 130, 20);
        salir.setBounds(15, 150, 70, 23);
        buscar.setBounds(115, 150, 100, 23);
        actualizar.setBounds(105, 150, 110, 23);
        enviar.setBounds(115, 150, 100, 23);
        
        altaEditorial.setText("Editorial");
        altaEditorial.setFont(arial);
        
        nombre.setText("Nombre");
        nombre.setHorizontalAlignment(JTextField.CENTER);
        nombre.addFocusListener(controlador);
        
        enviar.setText("Aceptar");
        enviar.setFont(arial);
        enviar.addActionListener(controlador);
        
        buscar.setText("Buscar");
        buscar.setFont(arial);
        buscar.addActionListener(controlador);
        buscar.setVisible(false);
        
        actualizar.setText("Actualizar");
        actualizar.setFont(arial);
        actualizar.addActionListener(controlador);
        actualizar.setVisible(false);
        
        salir.setText("Salir");
        salir.addActionListener(controlador);
        
        this.add(altaEditorial);
        this.add(nombre);
        this.add(salir);
        this.add(enviar);
        this.add(actualizar);
        this.add(buscar);
        
    }

    public JTextField getNombre() {
        return nombre;
    }

    public JButton getSalir() {
        return salir;
    }

    public JButton getEnviar() {
        return enviar;
    }

    public JButton getBuscar() {
        return buscar;
    }

    public JButton getActualizar() {
        return actualizar;
    }
    
    
    
    
}
