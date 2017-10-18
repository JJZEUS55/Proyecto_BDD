/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
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
public class Alta {
    
    private static Conexion conexion;
    private static Statement st;
    boolean correcto = false;
    private String SQL = "";
    
    
    public boolean usuario(Usuario usuario){
        conexion = new Conexion();
        Connection con = conexion.getConexion();

        try{
            
            SQL = "INSERT INTO usuario VALUES(null,'"+usuario.getCorreo()+"','"+usuario.getContrasenia()+"','"+usuario.getNombre()+"','"+usuario.getAppPaterno()+"','"+usuario.getAppMaterno()+"','"+usuario.getCalle()+"','"+usuario.getExterior()+"','"+usuario.getInterior()+"')";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
           
            correcto = true;
            JOptionPane.showMessageDialog(null, "Exito al Registrar", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){ 
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Insertar los Datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean usuario(String usuario, String password, String nombre, String apellidoPaterno, String apellidoMaterno, String calle, int numInterior, int numExterior){
        conexion = new Conexion();
        Connection con = conexion.getConexion();

        try{
            
            SQL = "INSERT INTO usuario VALUES(null,'"+usuario+"','"+password+"','"+nombre+"','"+apellidoPaterno+"','"+apellidoMaterno+"','"+calle+"','"+numExterior+"','"+numInterior+"')";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
           
            correcto = true;
            JOptionPane.showMessageDialog(null, "Exito al Registrar", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){ 
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Insertar los Datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    
    public boolean libro(Libro libro, Editorial editorial, Genero genero){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
   
        try{
            SQL = "INSERT INTO libro VALUES(null, '"+libro.getTitulo()+"','"+libro.getNoPaginas()+"', '"+libro.getEdicion()+"','"+libro.getAnio()+"','"+editorial.getId()+"','"+genero.getId()+"')";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Exito al Registrar", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Insertar los Datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean biblioteca(BibliotecaM biblioteca){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "INSERT INTO biblioteca VALUES(null,'"+biblioteca.getNombre()+"','"+biblioteca.getCalle()+"','"+biblioteca.getExterior()+"')";
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Exito al Registrar", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Insertar los Datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean bibliotecario(Bibliotecario bibliotecario, BibliotecaM biblioteca){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "INSERT INTO bibliotecario VALUES(null,'"+bibliotecario.getCorreo()+"','"+bibliotecario.getContrasenia()+"','"+bibliotecario.getNombre()+"','"+bibliotecario.getAppPaterno()+"','"+bibliotecario.getAppMaterno()+"','"+bibliotecario.getCalle()+"','"+bibliotecario.getExterior()+"','"+bibliotecario.getInterior()+"','"+bibliotecario.getSueldo()+"','"+bibliotecario.getCargo()+"','"+biblioteca.getId()+"')";
            
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Exito al Registrar", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Insertar los Datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean ejemplar(Libro libro,Ejemplar ejemplar, BibliotecaM biblioteca){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "INSERT INTO ejemplar VALUES(null,'"+ejemplar.getIdLibro(libro)+"','"+ejemplar.getEdoConservacion()+"','"+ejemplar.getEstatus()+"','"+biblioteca.getId()+"')";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Exito al Registrar", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            if("".equals(biblioteca.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una Biblioteca", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else{
            JOptionPane.showMessageDialog(null, "El libro no existe, Registre previamente el libro", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return correcto;
    }
    
    public boolean autor(Autor autor){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "INSERT INTO autor VALUES(null,'"+autor.getNombre()+"','"+autor.getAppPaterno()+"','"+autor.getAppMaterno()+"')";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Exito al Registrar", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Insertar los Datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean genero(Genero genero){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "INSERT INTO genero VALUES(null,'"+genero.getNombre()+"')";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Exito al Registrar", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Insertar los Datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean editorial(Editorial editorial){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "INSERT INTO editorial VALUES(null,'"+editorial.getNombre()+"')";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Exito al Registrar", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Insertar los Datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean telefonoUsuario(Usuario usuario, Telefono telefono){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "INSERT INTO telefono_usuario VALUES('"+usuario.getId()+"','"+telefono.getTelefono()+"')";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Exito al Registrar", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Insertar los Datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean telefonoBiblioteca(BibliotecaM biblioteca, Telefono telefono){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "INSERT INTO telefono_biblioteca VALUES('"+biblioteca.getId()+"','"+telefono.getTelefono()+"')";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Exito al Registrar", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Insertar los Datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }
    
    public boolean prestamo(Usuario usuario, String idejemplar, Prestamo prestamo, Bibliotecario bibliotecario){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "INSERT INTO prestamo VALUES(null,'"+usuario.getId()+"','"+idejemplar+"','"+prestamo.getFechaPrestamo()+"','"+prestamo.getFechaDevolucion()+"','"+bibliotecario.getId()+"','"+bibliotecario.getBiblioteca()+"')";
                
            System.out.println(SQL);
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Exito al Registrar", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al Insertar los Datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
        
    }
    
    public boolean libroAutor(Libro libro, Autor autor){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            SQL = "INSERT INTO autor_libro VALUES('"+libro.getId()+"','"+autor.getId()+"')";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            
            correcto = true;
            JOptionPane.showMessageDialog(null, "Exito al Registrar", "", JOptionPane.PLAIN_MESSAGE);
            con.close();
        }
        catch(SQLException ex){
            correcto = false;
            if("".equals(libro.getId())){
                JOptionPane.showMessageDialog(null, "El libro no existe, Registre previamente el libro", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else{
            JOptionPane.showMessageDialog(null, "Error al Insertar los Datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return correcto;
    }
    
      public void prestamo(int ejemplar,int usu,int biblo,String pres,String dev,int bibli)
    {
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        Consulta consulta=new Consulta();
        boolean verificar=consulta.ejemplar1(ejemplar);
        if(verificar==true)
        {
        try{
            SQL = "INSERT INTO prestamo VALUES(null,"+usu+","+ejemplar+","+pres+","+dev+","+bibli+","+biblo+")";
            System.out.println(SQL);    
            st = con.createStatement();
            st.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null,"Prestamo realizado con exito","prestamo",JOptionPane.OK_OPTION);
            correcto = true;
            
            con.close();
            
        }
        catch(SQLException ex){
            correcto = false;
            System.out.println("o habito aqui");
        }
        }
     
        
    } 
    

}
