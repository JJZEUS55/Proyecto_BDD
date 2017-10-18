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
public class Ejemplar {
    private String idEjemplar;
    private String estatus;
    private String edoConservacion;
    private Libro libro;
    
    private Consulta consulta;
    private Alta alta;
    private Baja baja;
    private Update update;

    public Ejemplar(String edoConservacion,String estatus) {
        this.edoConservacion = edoConservacion;
        this.estatus = estatus;
    }

    public Ejemplar(Libro libro) {
        this.libro = libro;
    }
    
    public Ejemplar(String idEjemplar){
      this.idEjemplar = idEjemplar;
    }
    
    public Ejemplar(String idEjemplar,String edoConservacion,String estatus){
        this.idEjemplar = idEjemplar;
        this.edoConservacion = edoConservacion;
        this.estatus = estatus;
    }
    

    public String getEdoConservacion() {
        return edoConservacion;
    }

    public void setEdoConservacion(String edoConservacion) {
        this.edoConservacion = edoConservacion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getEjemplares() {
        int id;
        consulta = new Consulta();
        id = Integer.parseInt(consulta.ejemplares(libro,this));
        return id ;
    }

    public String getIdEjemplar() {
        return idEjemplar;
    }
    
    public String getIdLibro(Libro libro) {
        String id;
        consulta = new Consulta();
        id = consulta.IDlibro(libro);
        return id ;
    }
    
    public String nombreLibro(){
        String nombre;
        consulta = new Consulta();
        nombre = consulta.nombreLibro(this);
        return nombre;
    }
      
    public boolean alta(Libro libro, BibliotecaM biblioteca){
        alta = new Alta();
        boolean correcto = alta.ejemplar(libro,this,biblioteca);
        return correcto;
    }
    
    public boolean update(BibliotecaM biblioteca){
        update = new Update();
        boolean correcto = update.ejemplar(this,biblioteca);
        return correcto;
    }
    
    public boolean baja(){
        baja = new Baja();
        boolean correcto = baja.ejemplar(this);
        return correcto;
    }
    
    public Object[][] consultaDatos(){
        Consulta consulta = new Consulta();
        Object resultado [][] = consulta.getDatosEjemplar(this);
        return resultado;
    }
    
    
    
    
}
