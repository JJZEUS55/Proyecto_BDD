/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentarLibro.validaciones;

import BD.Conexion;
import BaseDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author usuario
 */
public class ValidacionesIngreso {

    //Ingreso a base de datos LIBRERIA
    Conexion conexion = new Conexion();
    Connection Bcon = conexion.getConexion();
    ResultSet rs;

    //Ingreso a base de datos DENTISTA
    ConexionMySQL mysql = new ConexionMySQL();
    Connection Dcn = mysql.Conectar();

    public boolean saltarPublicidad(String usuario) {
       
        System.out.println("Recibi " + usuario);
        try {      
             boolean sn = true;
           //PreparedStatement ps = Bcon.prepareStatement("SELECT correo FROM bibliotecario WHERE correo = '" + usuario + "'");
            Statement s = Bcon.createStatement();
            rs = s.executeQuery("SELECT correo FROM bibliotecario WHERE correo like '"+usuario+"' ");
            while(rs.next()){
                String usuBiblioteca = rs.getString("correo");
                if(usuario.equals(usuBiblioteca)){
                    System.out.println("encontre al prro usuario");
                    sn = false;                   
                } else{
                    System.out.println("no lo encontre alv :'v");
                    sn = true;
                }                
            }
            s.close();
            Bcon.close();
            System.out.println("Valor sn " + sn);
            return sn;
        } catch (Throwable e) {
             return false;            
        }
        
    }

}
