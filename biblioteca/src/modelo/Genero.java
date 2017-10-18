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
public class Genero {
  
    private String nombre;
    
    private String nuevoNombre;
    
    private Alta alta;
    private Consulta consulta;
    private Baja baja;
    private Update update;
    
    public Genero(String nombre) {
        this.nombre = nombre;
    }
    
    public Genero(String nombre,String nuevoNombre) {
        this.nombre = nombre;
        this.nuevoNombre = nuevoNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNuevoNombre() {
        return nuevoNombre;
    }
    
    

    public String getId() {
        String id;
        consulta = new Consulta();
        id = consulta.IDgenero(this);
        return id;
    }

    
    public boolean alta(){
        alta = new Alta();
        boolean correcto = alta.genero(this);
        return correcto;
    }
    
    public boolean baja(){
        baja = new Baja();
        boolean correcto = baja.genero(this);
        return correcto;
    }
    
    public boolean update(){
        update = new Update();
        boolean correcto = update.genero(this);
        return correcto;
    }
    
    public String nombreGenero(String idGenero){
        consulta = new Consulta();
        String nombreGenero = consulta.nombreGenero(idGenero);
        return nombreGenero;
    }
    
    public Object[] getNombreGenero(){
        consulta = new Consulta();
        return consulta.getNombreGenero(this);
    }
    public int nodo()
    {
        consulta=new Consulta();
        return consulta.contGen();
    }
    

    
}
