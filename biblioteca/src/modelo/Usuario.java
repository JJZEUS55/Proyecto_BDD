/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import BD.Alta;
import BD.Baja;
import BD.Consulta;
import BD.Login;
import BD.Update;

/**
 *
 * @author DDB 3CV3 2017
 */
public class Usuario {
    
    private String correo;
    private String contrasenia;
    private String nombre;
    private String appPaterno;
    private String appMaterno;
    private String calle;
    private String exterior;
    private String interior;

    private Baja baja;
    private Login login;
    private Alta alta;
    private Consulta consulta;
    private Update update;
    
    public Usuario(String correo, String contrasenia, String nombre, String appPaterno, String appMaterno, String calle, String exterior, String interior){
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.appPaterno = appPaterno;
        this.appMaterno = appMaterno;
        this.calle = calle;
        this.exterior = exterior;
        this.interior = interior;
    }

    public Usuario(String correo) {
        this.correo = correo;
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

    public String getId() {
        String id;
        consulta = new Consulta();
        id = consulta.IDusuario(this);
        return id;
    }

    
    
    public boolean alta(){
        alta = new Alta();
        boolean correcto = alta.usuario(this);
        return correcto;
    }     
    
    public boolean alta(Telefono telefono){
        alta = new Alta();
        boolean correcto = alta.telefonoUsuario(this,telefono);
        return correcto;
    }

    public boolean baja(){
        baja = new Baja();
        boolean correcto = baja.usuario(this);
        return correcto;
    }
    
    public boolean bajaTelefono(){
        baja = new Baja();
        boolean correcto = baja.telefonoUsuario(this);
        return correcto;
    }
    
    public boolean update(){
        update = new Update();
        boolean correcto = update.usuario(this);
        return correcto;
    }
    
    public boolean update(Telefono telefono){
        update = new Update();
        boolean correcto = update.telefonoUsuario(this,telefono);
        return correcto;
    }
    
    
    public boolean login(){
        login = new Login(this);
        boolean correcto = login.logear();
        return correcto;
    }
    
    public Object[][] consultaDatos(){
        Consulta consulta = new Consulta();
        Object resultado [][] = consulta.usuarios(this);
        return resultado;
    }
    
    public Object[][] consultaDatosTelefono(){
        Consulta consulta = new Consulta();
        Object resultado [][] = consulta.getDatosTelefono(this);
        return resultado;
    }

    
}
