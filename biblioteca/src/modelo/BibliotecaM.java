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
public class BibliotecaM {
    private String nuevoNombre;
    private String nombre;
    private String calle;
    private String exterior;
    private int id;
    
    private Alta alta;
    private Consulta consulta;
    private Baja baja;
    private Update update;
    
    public BibliotecaM(String nombre, String calle, String exterior){
        this.nombre = nombre;
        this.calle = calle;
        this.exterior = exterior;
    }
    
    public BibliotecaM(String nombre){
        this.nombre = nombre;
    }

    public BibliotecaM(int id) {
        this.id = id;
    }
    
    public BibliotecaM(String nombre,String nuevoNombre, String calle, String exterior){
        this.nombre = nombre;
        this.nuevoNombre = nuevoNombre;
        this.calle = calle;
        this.exterior = exterior;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNuevoNombre() {
        return nuevoNombre;
    }
    
    public String getCalle() {
        return calle;
    }

    public String getExterior() {
        return exterior;
    }
    
    public int getID(){
        return id;
    }

    public String getId() {
        String id;
        consulta = new Consulta();
        id = consulta.IDbiblioteca(this);
        return id;
    }
    
    public String getNombreBiblioteca(){
        String nombre;
        consulta = new Consulta();
        nombre = consulta.nombreBiblioteca(this);
        return nombre;
    }
    
    public Object[] getNombreBibliotecas(){
        consulta = new Consulta();
        return consulta.getNombrebibliotecas();
    }
    public int nodo()
    {
        consulta=new Consulta();
        return consulta.contBiblio();
    }
    public boolean alta(){
        alta = new Alta();
        boolean correcto = alta.biblioteca(this);
        return correcto;
    }
    
    public boolean alta(Telefono telefono){
        alta = new Alta();
        boolean correcto = alta.telefonoBiblioteca(this,telefono);
        return correcto;
    }    
    
    public boolean baja(){
        baja = new Baja();
        boolean correcto = baja.biblioteca(this);
        return correcto;
    }
    
    public boolean bajaTelefono(){
        baja = new Baja();
        boolean correcto = baja.telefonoBiblioteca(this);
        return correcto;
    }
    
    public boolean update(){
        update = new Update();
        boolean correcto = update.biblioteca(this);
        return correcto;
    }
    
    public boolean update(Telefono telefono){
        update = new Update();
        boolean correcto = update.telefonoBiblioteca(this,telefono);
        return correcto;
    }  
    
    public String nombreBiblioteca(String idBiblioteca){
        consulta = new Consulta();
        String nombreBiblioteca = consulta.nombreBiblioteca(idBiblioteca);
        return nombreBiblioteca;
    }
    
    public Object[][] consultaDatos(){
        Consulta consulta = new Consulta();
        Object resultado [][] = consulta.getDatosBiblioteca(this);
        return resultado;
    }
    
    public Object[][] consultaDatosTelefono(){
        Consulta consulta = new Consulta();
        Object resultado [][] = consulta.getDatosTelefono(this);
        return resultado;
    }
    
    
    
  
    
}
