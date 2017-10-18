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
public class Autor {
    
    private String nombre;
    private String appPaterno;
    private String appMaterno;
    
    private String nuevoNombre;
    private String nuevoAppPaterno;
    private String nuevoAppMaterno;
    private String id;
    
    private Alta alta;
    private Consulta consulta;
    private Baja baja;
    private Update update;
    
    public Autor(String nombre, String appPaterno, String appMaterno) {
        this.nombre = nombre;
        this.appPaterno = appPaterno;
        this.appMaterno = appMaterno;
    }
    
    public Autor(String nombre, String appPaterno, String appMaterno,String nuevoNombre,String nuevoAppPaterno, String nuevoAppMaterno) {
        this.nombre = nombre;
        this.appPaterno = appPaterno;
        this.appMaterno = appMaterno;
        this.nuevoNombre = nuevoNombre;
        this.nuevoAppPaterno = nuevoAppPaterno;
        this.nuevoAppMaterno = nuevoAppMaterno;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppPaterno() {
        return appPaterno;
    }

    public void setAppPaterno(String appPaterno) {
        this.appPaterno = appPaterno;
    }

    public String getAppMaterno() {
        return appMaterno;
    }

    public void setAppMaterno(String appMaterno) {
        this.appMaterno = appMaterno;
    }

    public String getNuevoNombre() {
        return nuevoNombre;
    }

    public String getNuevoAppPaterno() {
        return nuevoAppPaterno;
    }

    public String getNuevoAppMaterno() {
        return nuevoAppMaterno;
    }
    
    public String getId(){
        String id;
        consulta = new Consulta();
        id = consulta.IDautor(this);
        return id;
    }
    
   
    public boolean alta(){
        alta = new Alta();
        boolean correcto = alta.autor(this);
        return correcto;
    }
    
    public boolean baja(){
        baja = new Baja();
        boolean correcto = baja.autor(this);
        return correcto;
    }
    
    public boolean update(){
        update = new Update();
        boolean correcto = update.autor(this);
        return correcto;
    }
    
    public Object[][] consultaDatos(){
        Consulta consulta = new Consulta();
        Object resultado [][] = consulta.getDatosautor(this);
        return resultado;
    }
 
    
    
}
