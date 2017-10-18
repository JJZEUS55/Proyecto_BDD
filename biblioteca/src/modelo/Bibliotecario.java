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
public class Bibliotecario {
   
   private String correo;
   private String contrasenia;
   private String nombre;
   private String appPaterno;
   private String appMaterno;
   private String calle;
   private String exterior;
   private String interior;
   private String sueldo;
   private String cargo;

   private Baja baja;
   private Alta alta;
   private Consulta consulta;
   private Update update;

    public Bibliotecario(String correo,String contrasenia,String nombre, String appPaterno, String appMaterno, String calle, String exterior, String interior, String sueldo, String cargo){
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.appPaterno = appPaterno;
        this.appMaterno = appMaterno;
        this.calle = calle;
        this.exterior = exterior;
        this.interior = interior;
        this.sueldo = sueldo;
        this.cargo = cargo;
    }
    
    public Bibliotecario(String correo){
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getExterior() {
        return exterior;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getBiblioteca() {
        String biblioteca;
        consulta = new Consulta();
        biblioteca = consulta.IDbiblioteca(this);
        return biblioteca;
    }


    public String getId() {
        String id;
        consulta = new Consulta();
        id = consulta.IDbibliotecario(this);
        return id;
    }

    public boolean alta(BibliotecaM biblioteca){
        alta = new Alta();
        boolean correcto = alta.bibliotecario(this,biblioteca);
        System.out.println(correcto);
        return correcto;
    }
    
    public boolean baja(){
        baja = new Baja();
        boolean correcto = baja.bibliotecario(this);
        return correcto;
    }
    
    public boolean update(BibliotecaM biblioteca){
        update = new Update();
        boolean correcto = update.bibliotecario(this,biblioteca);
        System.out.println(correcto);
        return correcto;
    }
    
    public Object[][] consultaDatos(){
        Consulta consulta = new Consulta();
        Object resultado [][] = consulta.bibliotecarios(this);
        return resultado;
    }
   
    
    
}
