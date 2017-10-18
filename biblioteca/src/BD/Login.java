/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.Usuario;

/**
 *
 * @author DDB 3CV3 2017
 */
public class Login {
    
    private static Conexion conexion;
    private ResultSet rs;
    private static Statement st;
    
    private String usuario;
    private String contrasenia;
    
    public Login(Usuario usuario){
        this.usuario = usuario.getCorreo();
        this.contrasenia = usuario.getContrasenia();
    }
    
    public boolean logear(){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        String aux1 = "";
        String aux2 = "";
        boolean correcto = false;
        
        try{
            PreparedStatement user = con.prepareStatement("SELECT  FROM  WHERE ='"+usuario+"'");
            rs = user.executeQuery();
            rs.next();
            aux1 = rs.getString(1);                       
            user.close();
            PreparedStatement pass = con.prepareStatement("SELECT  FROM  WHERE ='"+contrasenia+"'");
            rs = pass.executeQuery();
            rs.next();
            aux2 = rs.getString(1);
            pass.close(); 
            
            correcto = true;
            con.close();
        }catch(Throwable e ){
            correcto = false;
        }
        
        return correcto;
    }
    
    public void imprimir(){
        System.out.println("Usuario: "+ usuario);
        System.out.println("Contraseña: "+ contrasenia);
    }
    
}
