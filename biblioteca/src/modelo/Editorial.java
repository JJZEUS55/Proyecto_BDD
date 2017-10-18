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
public class Editorial {
    
    private String nombre;
    private String nuevoNombre;
    
    private Alta alta;
    private Consulta consulta;
    private Baja baja;
    private Update update;
    
    public Editorial(String nombre) {
        this.nombre = nombre;
    }

    public Editorial(String nombre, String nuevoNombre) {
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
        id = consulta.IDeditorial(this);
        return id;
    }
    
    public boolean alta(){
        alta = new Alta();
        boolean correcto = alta.editorial(this);
        return correcto;
    }
    
    public boolean baja(){
        baja = new Baja();
        boolean correcto = baja.editorial(this);
        return correcto;
    }
    
    public boolean update(){
        update = new Update();
        boolean correcto = update.editorial(this);
        return correcto;
    }
    
    public String nombreEditorial(String idEditorial){
        consulta = new Consulta();
        String nombreEditorial = consulta.nombreEditorial(idEditorial);
        return nombreEditorial;
    }
    
    public Object[][] consultaDatos(){
        Consulta consulta = new Consulta();
        Object resultado [][] = consulta.getDatosEditorial(this);
        return resultado;
    }
}
