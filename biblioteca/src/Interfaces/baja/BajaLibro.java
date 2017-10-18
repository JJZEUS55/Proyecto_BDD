/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.baja;

import Controlador.CtrlBajaLibro;
import static fuentes.Fuente.arial;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author DDB 3CV3 2017
 */
public class BajaLibro extends JFrame {
    
    private JTextField tituloLibro, noPaginas,edicion,anio,editorial,genero,eliminar;
    private JButton salir,enviar,buscar;
    private JLabel datos,mensaje;
    private final CtrlBajaLibro controlador;
    
    public BajaLibro(){
        controlador = new CtrlBajaLibro(this);
        configurarVentana(460,400);
        inicializarComponentes();   
    }
    
    private void configurarVentana(int ancho, int alto){
        this.setTitle("Eliminar Libro");
        this.setSize(ancho,alto);
        this.setLocationRelativeTo(null);  
        this.setLayout(null);  
        this.setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarComponentes(){
        mensaje = new JLabel();
        eliminar = new JTextField();
        tituloLibro = new JTextField();
        noPaginas  = new JTextField();
        edicion = new JTextField();
        anio = new JTextField();
        genero = new JTextField();
        editorial = new JTextField();
        enviar = new JButton();
        salir = new JButton();
        buscar = new JButton();
        datos = new JLabel();
        
        mensaje.setText("Eliminar Libro");
        mensaje.setBounds(180, 30, 150, 25);
        mensaje.setFont(arial);
        
        eliminar.setText("Título");
        eliminar.setHorizontalAlignment(JTextField.CENTER);
        eliminar.setBounds(155, 70, 180, 20);
        eliminar.addFocusListener(controlador);
        
        datos.setText("Datos del Libro");
        datos.setFont(arial);
        datos.setBounds(50, 135, 130,25);
        
        tituloLibro.setText("Título");
        tituloLibro.setHorizontalAlignment(JTextField.CENTER);
        tituloLibro.setBounds(100, 190, 250, 20);
        tituloLibro.setEditable(false);
        
        editorial.setBounds(170, 240, 100, 20);
        editorial.setText("Editorial");
        editorial.setHorizontalAlignment(JTextField.CENTER);
        editorial.setEditable(false);
        
        noPaginas.setText("Páginas");
        noPaginas.setHorizontalAlignment(JTextField.CENTER);
        noPaginas.setBounds(290, 240, 50, 20);
        noPaginas.setEditable(false);
        
        anio.setText("Año");
        anio.setHorizontalAlignment(JTextField.CENTER);
        anio.setBounds(360, 240, 50, 20);
        anio.setEditable(false);
        
        genero.setBounds(50, 240, 100, 20);
        genero.setText("Genero");
        genero.setHorizontalAlignment(JTextField.CENTER);
        genero.setEditable(false);
        
        enviar.setText("Eliminar");
        enviar.setFont(arial);
        enviar.setVisible(false);
        enviar.setBounds(300,300,100,25);
        enviar.addActionListener(controlador);
        
        buscar.setText("Buscar");
        buscar.setFont(arial);
        buscar.setBounds(300,300,100,25);
        buscar.addActionListener(controlador);
        
        salir.setText("Salir");
        salir.setBounds(50, 300, 70, 25);
        salir.addActionListener(controlador);
        
        this.add(mensaje);
        this.add(eliminar);
        this.add(datos);
        this.add(tituloLibro);
        this.add(editorial);
        this.add(genero);
        this.add(noPaginas);
        this.add(edicion);
        this.add(anio);
        this.add(enviar);
        this.add(salir);
        this.add(buscar);
    }

    public JTextField getEliminar() {
        return eliminar;
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

    public JTextField getTituloLibro() {
        return tituloLibro;
    }

    public JTextField getNoPaginas() {
        return noPaginas;
    }

    public JTextField getEdicion() {
        return edicion;
    }

    public JTextField getAnio() {
        return anio;
    }

    public JTextField getEditorial() {
        return editorial;
    }

    public JTextField getGenero() {
        return genero;
    }
    
    
    
}
