/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.alta;

import Controlador.CtrlAltaLibro;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static fuentes.Fuente.*;

/**
 *
 * @author DDB 3CV3 2017
 */
public class AltaLibro extends JFrame {
    
    private JTextField tituloLibro, noPaginas,edicion,anio;
    private JComboBox editorial,genero;
    private JButton autor,ejemplar,salir,enviar,buscar,actualizar;
    private JLabel datos;
    private final CtrlAltaLibro controlador;
    
    public AltaLibro(){
        controlador = new CtrlAltaLibro(this);
        configurarVentana(460,300);
        inicializarComponentes();   
    }
    
    private void configurarVentana(int ancho, int alto){
        this.setTitle("Nuevo Libro");
        this.setSize(ancho,alto);
        this.setLocationRelativeTo(null);  
        this.setLayout(null);  
        this.setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarComponentes(){
        tituloLibro = new JTextField();
        noPaginas  = new JTextField();
        edicion = new JTextField();
        anio = new JTextField();
        genero = new JComboBox();
        editorial = new JComboBox();
        autor = new JButton();
        ejemplar = new JButton();
        enviar = new JButton();
        salir = new JButton();
        datos = new JLabel();
        buscar = new JButton();
        actualizar = new JButton();
        
        datos.setText("Datos del Libro");
        datos.setFont(arial);
        datos.setBounds(50, 15, 130,25);
        
        tituloLibro.setText("Título");
        tituloLibro.setHorizontalAlignment(JTextField.CENTER);
        tituloLibro.setBounds(100, 50, 250, 20);
        tituloLibro.addFocusListener(controlador);
        
        editorial.setBounds(170, 100, 100, 20);
        editorial.addItem("Añadir Editorial");
        editorial.addItem("DE BOLSILLO");
        
        noPaginas.setText("Páginas");
        noPaginas.setHorizontalAlignment(JTextField.CENTER);
        noPaginas.setBounds(290, 100, 50, 20);
        noPaginas.addFocusListener(controlador);
        
        anio.setText("Año");
        anio.setHorizontalAlignment(JTextField.CENTER);
        anio.setBounds(360, 100, 50, 20);
        anio.addFocusListener(controlador);
        
        genero.setBounds(50, 100, 100, 20);
        genero.addItem("Añadir Genero");
        genero.addItem("THRILLER");
        
        autor.setBounds(58, 145, 80, 22);
        autor.setText("+Autor");
        autor.addActionListener(controlador);
        
        ejemplar.setBounds(180, 145, 82, 22);
        ejemplar.setText("+Ejemplar");
        ejemplar.addActionListener(controlador);
        
        edicion.setBounds(320, 145, 50, 20);
        edicion.setText("Edición");
        edicion.setHorizontalAlignment(JTextField.CENTER);
        edicion.addFocusListener(controlador);
        
        enviar.setText("Enviar");
        enviar.setFont(arial);
        enviar.setBounds(300,220,100,25);
        enviar.addActionListener(controlador);
        
        actualizar.setText("Actualizar");
        actualizar.setFont(arial);
        actualizar.setBounds(290,220,120,25);
        actualizar.addActionListener(controlador);
        actualizar.setVisible(false);
        
        buscar.setText("Buscar");
        buscar.setFont(arial);
        buscar.setBounds(300,220,100,25);
        buscar.addActionListener(controlador);
        buscar.setVisible(false);
        
        salir.setText("Salir");
        salir.setBounds(50, 220, 70, 25);
        salir.addActionListener(controlador);
        
        
        
        this.add(datos);
        this.add(tituloLibro);
        this.add(editorial);
        this.add(genero);
        this.add(noPaginas);
        this.add(edicion);
        this.add(anio);
        this.add(autor);
        this.add(ejemplar);
        this.add(enviar);
        this.add(salir);
        this.add(buscar);
        this.add(actualizar);
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

    public JComboBox getEditorial() {
        return editorial;
    }

    public JComboBox getGenero() {
        return genero;
    }

    public JButton getAutor() {
        return autor;
    }

    public JButton getEjemplar() {
        return ejemplar;
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
