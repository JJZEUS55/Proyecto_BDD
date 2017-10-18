/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import biblioteca.Biblioteca;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.*;


/**
 *
 * @author DDB 3CV3 2017
 */
public class Baja {
    
    private static Conexion conexion;
    private static Statement st;
    boolean correcto = false;
    private String SQL = "";
    
    public boolean usuario(Usuario usuario){
        conexion = new Conexion();
        Connection con = conexion.getConexion();

        try{
            
            SQL = "DELETE FROM usuario WHERE idusuario = '"+usuario.getId()+"' ";
            System.out.println(SQL);
            st = con.createStatement();
            st.execute(SQL);
           
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Se borro satisfactoriamente", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){ 
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Borrar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        return correcto;
    }
        
    public boolean libro(Libro libro){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
   
        try{
            SQL = "DELETE FROM libro WHERE idlibro = '"+libro.getId()+"' ";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Se borro satisfactoriamente", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Borrar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean biblioteca(BibliotecaM biblioteca){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
   
        try{
            SQL = "DELETE FROM biblioteca WHERE idbiblioteca = '"+biblioteca.getId()+"' ";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Se borro satisfactoriamente", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Borrar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean bibliotecario(Bibliotecario bibliotecario){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
   
        try{
            SQL = "DELETE FROM bibliotecario WHERE idbibliotecario = '"+bibliotecario.getId()+"' ";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Se borro satisfactoriamente", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Borrar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean ejemplar(Ejemplar ejemplar){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
   
        try{
            SQL = "DELETE FROM ejemplar WHERE idejemplar = '"+ejemplar.getIdEjemplar()+"' ";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Se borro satisfactoriamente", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Borrar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean autor(Autor autor){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
   
        try{
            SQL = "DELETE FROM autor WHERE idautor = '"+autor.getId()+"' ";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Se borro satisfactoriamente", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Borrar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean genero(Genero genero){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
   
        try{
            SQL = "DELETE FROM genero WHERE idgenero = '"+genero.getId()+"' ";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Se borro satisfactoriamente", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Borrar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean editorial(Editorial editorial){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
   
        try{
            SQL = "DELETE FROM editorial WHERE ideditorial = '"+editorial.getId()+"' ";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Se borro satisfactoriamente", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Borrar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean telefonoUsuario(Usuario usuario){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
   
        try{
            SQL = "DELETE FROM telefono_usuario WHERE idusuario = '"+usuario.getId()+"' ";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Se borro satisfactoriamente", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Borrar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean telefonoBiblioteca(BibliotecaM biblioteca){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
   
        try{
            SQL = "DELETE FROM telefono_biblioteca WHERE idbiblioteca = '"+biblioteca.getId()+"' ";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Se borro satisfactoriamente", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Borrar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean prestamo(String idPrestamo){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
   
        try{
            SQL = "DELETE FROM prestamo WHERE idprestamo = '"+idPrestamo+"' ";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Se borro satisfactoriamente", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Borrar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
}
