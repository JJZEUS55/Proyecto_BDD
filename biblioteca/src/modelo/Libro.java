/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import BD.Alta;
import BD.Baja;
import BD.Consulta;
import BD.Update;


/**
 *
 * @author DDB 3CV3 2017
 */
public class Libro {
    private String nuevoTitulo;
    private String titulo;
    private String noPaginas;
    private String edicion;
    private String anio;
    
    private Alta alta;
    private Consulta consulta; 
    private Baja baja;
    private Update update;
    
    
    public Libro(String titulo, String noPaginas, String edicion, String anio){
        this.titulo = titulo;
        this.noPaginas = noPaginas;
        this.edicion = edicion;
        this.anio = anio;
    }

    public Libro(String titulo) {
        this.titulo = titulo;
    }
    
    public Libro(String titulo, String nuevoTitulo, String noPaginas, String edicion, String anio){
        this.titulo = titulo;
        this.nuevoTitulo = nuevoTitulo;
        this.noPaginas = noPaginas;
        this.edicion = edicion;
        this.anio = anio;
    }
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNuevoTitulo() {
        return nuevoTitulo;
    }
   

    public String getNoPaginas() {
        return noPaginas;
    }

    public void setNoPaginas(String noPaginas) {
        this.noPaginas = noPaginas;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getId() {
        String id;
        consulta = new Consulta();
        id = consulta.IDlibro(this);
        return id;
    }

    
    public boolean alta(Editorial editorial, Genero genero){
        alta = new Alta();
        boolean correcto = alta.libro(this,editorial,genero);
        return correcto;
    }
    
    public boolean alta(Autor autor){
        alta = new Alta();
        boolean correcto = alta.libroAutor(this, autor);
        return correcto;
    }
    
    public boolean update(Editorial editorial, Genero genero){
        update = new Update();
        boolean correcto = update.libro(this, editorial, genero);
        return correcto;
    }
    
    public boolean baja(){
        baja = new Baja();
        boolean correcto = baja.libro(this);
        return correcto;
    }
    
    public boolean autorlibro(Autor autor){
       alta = new Alta();
       boolean correcto= alta.libroAutor(this, autor);
       return correcto;
    }
    
    public Object[][] consultaDatos(){
        Consulta consulta = new Consulta();
        Object resultado [][] = consulta.getDatosLibro(this);
        return resultado;
    }
        
    
    
    
}
