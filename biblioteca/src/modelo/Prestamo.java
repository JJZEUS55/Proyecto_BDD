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
public class Prestamo {
    private String fechaPrestamo;
    private String fechaDevolucion;
    
    private Alta alta;
    private Consulta consulta;
    private Baja baja;
    private Update update;

    public Prestamo(String fechaPrestamo, String fechaDevolucion) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }   
    
    public Prestamo(){}

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getId(String idEjemplar) {
        String id;
        consulta = new Consulta();
        id =consulta.IDprestamo(idEjemplar);
        return id;
    }
    
    public void alta(Usuario usuario,String idEjemplar, Bibliotecario bibliotecario){
        alta = new Alta();
        alta.prestamo(usuario, idEjemplar, this, bibliotecario);
    }     
    
    public void update(Ejemplar ejemplar, Bibliotecario bibliotecario){
        update = new Update();
        update.prestamo(ejemplar, this, bibliotecario);
    }   
    
    public void baja(String idPrestamo){
        baja = new Baja();
        baja.prestamo(idPrestamo);
    }
            public void Pres(int ejemplar,int usu,int biblo,String pres,String dev,int bibli )       
    {
        alta=new Alta();
        alta.prestamo(ejemplar, usu, biblo, pres, dev,bibli);
        //(int ejemplar,int usu,int biblo,String pres,String dev,int bibli)
 
    }
    
    
    
    
    
    
}
