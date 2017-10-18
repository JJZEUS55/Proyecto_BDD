/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import BD.Alta;



/**
 *
 * @author DDB 3CV3 2017
 */
public class Telefono {
    private String telefono;
    Alta alta;
    
    public Telefono(String telefono){
        this.telefono = telefono;
        
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    


}
