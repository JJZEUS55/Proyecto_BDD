/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Autor;
import modelo.BibliotecaM;
import modelo.Bibliotecario;
import modelo.Editorial;
import modelo.Ejemplar;
import modelo.Genero;
import modelo.Libro;
import modelo.Prestamo;
import modelo.Telefono;
import modelo.Usuario;

/**
 *
 * @author DDB 3CV3 2017
 */
public class Update {
    
    private static Conexion conexion;
    private static Statement st;
    boolean correcto = false;
    private String SQL = "";
    
    
    public boolean usuario(Usuario usuario){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            
            SQL = "UPDATE usuario SET  contrasenia = '"+usuario.getContrasenia()+"', nombre = '"+usuario.getNombre()+"',appPaterno = '"+usuario.getAppPaterno()+"', appMaterno = '"+usuario.getAppMaterno()+"', calle = '"+usuario.getCalle()+"', exterior = '"+usuario.getExterior()+"', interior = '"+usuario.getInterior()+"' WHERE correo = '"+usuario.getCorreo()+"'";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
           
            correcto = true;
            con.close();
        }
        catch(SQLException ex){ 
            correcto = false;
        }
        return correcto;
    }
    
    
    public boolean libro(Libro libro, Editorial editorial, Genero genero){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
       
        try{
            SQL = "UPDATE libro SET titulo = '"+libro.getNuevoTitulo()+"', nopaginas = '"+libro.getNoPaginas()+"', edicion = '"+libro.getEdicion()+"',año ='"+libro.getAnio()+"', editorial = '"+editorial.getId()+"', genero = '"+genero.getId()+"' WHERE idlibro = '"+libro.getId()+"'";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            correcto = true;
            con.close();
        }
        catch(SQLException ex){
            System.out.println(ex);
            correcto = false;
        }
        return correcto;
    }
    
    public boolean biblioteca(BibliotecaM biblioteca){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "UPDATE biblioteca SET nombre = '"+biblioteca.getNuevoNombre()+"', calle = '"+biblioteca.getCalle()+"', exterior = '"+biblioteca.getExterior()+"' WHERE idbiblioteca = '"+biblioteca.getId()+"'";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
        }
        return correcto;
    }
    
    public boolean bibliotecario(Bibliotecario bibliotecario, BibliotecaM biblioteca){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "UPDATE bibliotecario SET contrasenia = '"+bibliotecario.getContrasenia()+"', nombre = '"+bibliotecario.getNombre()+"', appPaterno = '"+bibliotecario.getAppPaterno()+"', appMaterno = '"+bibliotecario.getAppMaterno()+"', calle = '"+bibliotecario.getCalle()+"', exterior = '"+bibliotecario.getExterior()+"', interior = '"+bibliotecario.getInterior()+"', sueldo = '"+bibliotecario.getSueldo()+"', cargo = '"+bibliotecario.getCargo()+"', idbiblioteca = '"+biblioteca.getId()+"' WHERE correo = '"+bibliotecario.getCorreo()+"'";
            
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            con.close();
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return correcto;
    }
    
    public boolean ejemplar(Ejemplar ejemplar, BibliotecaM biblioteca){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "UPDATE ejemplar SET estadoConservacion = '"+ejemplar.getEdoConservacion()+"', estatus = '"+ejemplar.getEstatus()+"', idbiblioteca = '"+biblioteca.getId()+"' WHERE idejemplar = '"+ejemplar.getIdEjemplar()+"'";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            System.out.println(correcto);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
        }
        return correcto;
    }
    
    public boolean autor(Autor autor){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "UPDATE autor SET nombre = '"+autor.getNuevoNombre()+"', appPaterno = '"+autor.getNuevoAppPaterno()+"',appMaterno = '"+autor.getNuevoAppMaterno()+"' WHERE idautor = '"+autor.getId()+"'";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            System.out.println(correcto);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
        }
        return correcto;
    }
    
    public boolean genero(Genero genero){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "UPDATE genero SET nombre = '"+genero.getNuevoNombre()+"' WHERE idgenero = '"+genero.getId()+"' ";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            System.out.println(correcto);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
        }
        return correcto;
    }
    
    public boolean editorial(Editorial editorial){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "UPDATE editorial SET nombre = '"+editorial.getNuevoNombre()+"' WHERE ideditorial = '"+editorial.getId()+"'";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            System.out.println(correcto);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
        }
        return correcto;
    }
    
    public boolean telefonoUsuario(Usuario usuario, Telefono telefono){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "UPDATE telefono_usuario SET telefono = '"+telefono.getTelefono()+"' WHERE idusuario = '"+usuario.getId()+"'";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            System.out.println(correcto);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
        }
        return correcto;
    }
    
    public boolean telefonoBiblioteca(BibliotecaM biblioteca, Telefono telefono){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "UPDATE telefono_biblioteca SET telefono = '"+telefono.getTelefono()+"' WHERE idbiblioteca = '"+biblioteca.getId()+"' ";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            System.out.println(correcto);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
        }
        return correcto;
    }
    
    public boolean prestamo(Ejemplar ejemplar, Prestamo prestamo, Bibliotecario bibliotecario){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "UPDATE prestamo SET fechaPrestamo = '"+prestamo.getFechaPrestamo()+"', fechaDevolucion = '"+prestamo.getFechaDevolucion()+"',idbibliotecario = '"+bibliotecario.getId()+"',idbiblioteca = '"+bibliotecario.getBiblioteca()+"' WHERE idprestamo = '"+prestamo.getId(ejemplar.getIdEjemplar())+"'";
                
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            System.out.println(correcto);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
        }
        return correcto;
        
    }
    
    public boolean libroAutor(Libro libro, Autor autor){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "UPDATE autor_libro SET idlibro = '"+libro.getId()+"', idautor = '"+autor.getId()+"'";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
        }
        return correcto;
    }
    
               public void actesatatus(int estado)
        {
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        String esta="OCUPADO";
        try{
            SQL = "UPDATE ejemplar set estatus='"+esta+"' where idejemplar="+estado+"";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            System.out.println("Si se pudo");
            
            con.close();
        }
        catch(SQLException ex){
            System.out.println("No se pudo");
        }
       
    }
        
        public void prestamofin(int estado)
        {
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        String esta="DISPONIBLE";
        try{
            SQL = "UPDATE ejemplar set estatus='"+esta+"' where idejemplar="+estado+"";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            System.out.println("libro dado de baja ");
            
            con.close();
        }
        catch(SQLException ex){
            System.out.println("No se pudo");
        }
       
    }
    
}
