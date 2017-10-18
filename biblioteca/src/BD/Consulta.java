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
import javax.swing.JOptionPane;
import modelo.Autor;
import modelo.BibliotecaM;
import modelo.Bibliotecario;
import modelo.Editorial;
import modelo.Ejemplar;
import modelo.Genero;
import modelo.Libro;
import modelo.Usuario;

/**
 *
 * @author DDB 3CV3 2017
 */
public class Consulta {
    
    private static Conexion conexion;
    private static Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private String cadena = "";
    

    
    public String IDusuario(Usuario usuario){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT idusuario FROM usuario WHERE correo = '"+usuario.getCorreo()+"'");
            rs = ps.executeQuery();
            rs.next();
            cadena = rs.getString(1);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return cadena;
    }
    
    public String ejemplares(Libro libro, Ejemplar ejemplar){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        cadena = libro.getTitulo();
        try{
            System.out.println(libro.getId() + " Y " + libro.getTitulo());
            PreparedStatement ps = con.prepareStatement("SELECT ejemplar.idejemplar FROM ejemplar,libro WHERE ejemplar.libro ='"+libro.getId()+"' AND ejemplar.libro = '"+ejemplar.getIdLibro(libro)+"'" );
            rs = ps.executeQuery();                      
            rs.next();
            cadena = rs.getString(1);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return cadena;
    }
    
    
     public String IDlibro(Libro libro){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT idlibro FROM libro WHERE titulo = '"+libro.getTitulo()+"'");
            rs = ps.executeQuery();
            rs.next();
            cadena = rs.getString(1);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return cadena;
    }
     
     public String IDbibliotecario(Bibliotecario bibliotecario){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT idbibliotecario FROM bibliotecario WHERE correo = '"+bibliotecario.getCorreo()+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            cadena = rs.getString(1);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return cadena;
    }
     
     public String IDbiblioteca(Bibliotecario bibliotecario){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT idbiblioteca FROM bibliotecario WHERE correo = '"+bibliotecario.getCorreo()+"'");                                             
            rs = ps.executeQuery();
            rs.next();
            cadena = rs.getString(1);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return cadena;
    }
    
    public String IDbiblioteca(BibliotecaM biblioteca){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT idbiblioteca FROM biblioteca WHERE nombre = '"+biblioteca.getNombre()+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            cadena = rs.getString(1);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return cadena;
    }
    
    public String IDgenero(Genero genero){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT idgenero FROM genero WHERE nombre = '"+genero.getNombre()+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            cadena = rs.getString(1);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return cadena;
    }
    
    public String IDeditorial(Editorial editorial){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT ideditorial FROM editorial WHERE nombre = '"+editorial.getNombre()+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            cadena = rs.getString(1);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return cadena;
    }
    
    public String nombreEditorial(String editorial){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT nombre FROM editorial WHERE ideditorial = '"+editorial+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            cadena = rs.getString(1);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return cadena;
    }
    
    public String nombreGenero(String genero){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT nombre FROM genero WHERE idgenero = '"+genero+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            cadena = rs.getString(1);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return cadena;
    }
    
    public String nombreBiblioteca(String biblioteca){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT nombre FROM biblioteca WHERE idbiblioteca = '"+biblioteca+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            cadena = rs.getString(1);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return cadena;
    }
    
    public String IDautor(Autor autor){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            System.out.println("Estoy Consultando el Autor :" +autor.getNombre()+autor.getAppPaterno()+autor.getAppMaterno());
            PreparedStatement ps = con.prepareStatement("SELECT idautor FROM autor WHERE nombre = '"+autor.getNombre()+"' AND appPaterno = '"+autor.getAppPaterno()+"' AND appMaterno = '"+autor.getAppMaterno()+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            cadena = rs.getString(1);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return cadena;
    }
    
    public String IDprestamo(String idPrestamo){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT prestamo.idprestamo FROM prestamo,ejemplar WHERE prestamo.ejemplar = ejemplar.idejemplar AND ejemplar.idejemplar = '"+idPrestamo+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            cadena = rs.getString(1);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return cadena;
    }
    
    public String nombreBiblioteca(BibliotecaM biblioteca){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT nombre FROM biblioteca WHERE idbiblioteca = '"+biblioteca.getID()+"'  ");                                          
            rs = ps.executeQuery();
            rs.next();
            cadena = rs.getString(1);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return cadena;
    }
    
    
        public Object idlibro(int numero){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        Object[] lista=new Object[6];
        try{
            PreparedStatement ps = con.prepareStatement("select libro.idlibro,libro.titulo,libro.nopaginas,libro.edicion,libro.año,editorial.nombre from libro,editorial where libro.editorial=editorial.ideditorial and libro.idlibro='"+numero+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            //cadena = rs.getString(1);
            
            System.out.println("---->"+rs.getInt (1) + "     " + rs.getString (2)+ "    " + rs.getInt(3)+"    "+rs.getInt(4)+"    "+rs.getInt(5)+"    "+rs.getString(6));
            lista[0]=rs.getInt (1);
            lista[1]=rs.getString (2);
            lista[2]=rs.getInt(3);
            lista[3]=rs.getInt(4);
            lista[4]=rs.getInt(5);
            lista[5]=rs.getString(6);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return lista;
        }
        
        
        public boolean acceso(String usu,String contr){
            boolean bol=false;
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT*FROM usuario WHERE correo='"+usu+"'and contrasenia='"+contr+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            //cadena = rs.getString(1);
            System.out.println("--->---"+rs.getRow());
            bol=(rs.getRow()==1)?true:false;
                
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return bol;
    }
        
    public boolean accesoBibliotecario(String usu,String contr){
            boolean bol=false;
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT*FROM bibliotecario WHERE correo='"+usu+"'and contrasenia='"+contr+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            //cadena = rs.getString(1);
            System.out.println("--->---"+rs.getRow());
            bol=(rs.getRow()==1)?true:false;
                
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return bol;
    }
        
    public Object[][] Edi(String Edi){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        int i=0;
        try{
            PreparedStatement ps = con.prepareStatement("select editorial.nombre,libro.titulo from editorial,libro where editorial.ideditorial=libro.editorial and  editorial.nombre='"+Edi+"'");                                          
            rs = ps.executeQuery();
            while (rs.next())
               {
                   
                  i++;
                   
               }
            ps.close();
            
        }catch(Throwable e){  
        }
        Object[][] a=new Object[i][2];
        i=0;
        try{
            PreparedStatement ps = con.prepareStatement("select editorial.nombre,libro.titulo from editorial,libro where editorial.ideditorial=libro.editorial and  editorial.nombre='"+Edi+"'");                                          
            rs = ps.executeQuery();
            while (rs.next())
               {
                   
                  a[i][0]=rs.getString(1);
                  a[i][1]=rs.getString(2);
                  i++;
                  
               }
            rs.close();
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        
        
        return a;
    }
           
           
      public Object[][] Aut(String Edi){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        int i=0;
        try{
            PreparedStatement ps = con.prepareStatement("select libro.titulo, autor.nombre from autor_libro, libro ,autor where autor_libro.idlibro=libro.idlibro and autor_libro.idautor=autor.idautor and autor.nombre='"+Edi+"'");                                          
            rs = ps.executeQuery();
            while (rs.next())
               {
                   
                  i++;
                   
               }
            ps.close();
            
        }catch(Throwable e){  
        }
        Object[][] a=new Object[i][2];
        i=0;
        try{
            PreparedStatement ps = con.prepareStatement("select libro.titulo, autor.nombre from autor_libro, libro ,autor where autor_libro.idlibro=libro.idlibro and autor_libro.idautor=autor.idautor and autor.nombre='"+Edi+"'");                                          
            rs = ps.executeQuery();
            while (rs.next())
               {
                   
                  a[i][0]=rs.getString(1);
                  a[i][1]=rs.getString(2);
                  i++;
                  
               }
            rs.close();
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        
        
        return a;
    }
      
         public Object[][] Gen(String Edi){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        int i=0;
        try{
            PreparedStatement ps = con.prepareStatement("select libro.titulo, genero.nombre from libro,genero where libro.genero=genero.idgenero and genero.nombre='"+Edi+"'");                                          
            rs = ps.executeQuery();
            while (rs.next())
               {
                   
                  i++;
                   
               }
            ps.close();
            
        }catch(Throwable e){  
        }
        Object[][] a=new Object[i][2];
        i=0;
        try{
            PreparedStatement ps = con.prepareStatement("select libro.titulo, genero.nombre from libro,genero where libro.genero=genero.idgenero and genero.nombre='"+Edi+"'");                                          
            rs = ps.executeQuery();
            while (rs.next())
               {
                   
                  a[i][0]=rs.getString(1);
                  a[i][1]=rs.getString(2);
                  i++;
                  
               }
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        
        
        return a;
    }
         
         
    public int con()
    {
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        int i=0;
        try{
            PreparedStatement ps = con.prepareStatement("select*from libro");                                          
            rs = ps.executeQuery();
            while (rs.next())
               {
                   
                  i++;
                   
               }
            ps.close();
            rs.close();
            con.close();
        }catch(Throwable e){  
        }
        return i;
    }
    
    
    public Object[][] constr()
    {
        
        conexion = new Conexion();
        Connection cone = conexion.getConexion();
        Consulta s=new Consulta();
        int i=0,in=0;
        Object[][] datos=new Object[i=s.con()][6];   
        try {
                //PreparedStatement user = cone.prepareStatement("select*from libro");
                PreparedStatement user = cone.prepareStatement("select libro.idlibro,libro.titulo,libro.nopaginas,libro.edicion,libro.año,editorial.nombre from libro,editorial where libro.editorial=editorial.ideditorial");
                rs = user.executeQuery();
                
                while (rs.next()) 
                    { 
                        
                          
                           datos[in][0]=rs.getInt(1);
                           datos[in][1]=rs.getString(2);
                           datos[in][2]=rs.getInt(3);
                           datos[in][3]=rs.getInt(4);
                           datos[in][4]=rs.getInt(5);
                           datos[in][5]=rs.getString(6);
                           
                           
                           in++;
                           
                    }
                    rs.close();
                    user.close();
             } catch (Exception e) {
            }
     return datos;   
    }
    
    
    public Object[][] usuarios(Usuario usuario){
        
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        Consulta s=new Consulta();
        int i=0,in=0;
        Object[][] datos=new Object[i=s.con()][9]; 
        
        try {
            String SQL = "SELECT * FROM usuario WHERE correo = '"+usuario.getCorreo()+"'";
            PreparedStatement user = con.prepareStatement(SQL);
            rs = user.executeQuery();
                
            while (rs.next()) 
                { 
                datos[in][0]=rs.getString(1);
                datos[in][1]=rs.getString(2);
                datos[in][2]=rs.getString(3);
                datos[in][3]=rs.getString(4);
                datos[in][4]=rs.getString(5);
                datos[in][5]=rs.getString(6);
                datos[in][6]=rs.getString(7);
                datos[in][7]=rs.getString(8);
                datos[in][8]=rs.getString(9);
                in++;    
                    }
            rs.close();
            user.close();
            } catch (Exception e) {
            }
     return datos;   
    }
    
    public Object[][] bibliotecarios(Bibliotecario bibliotecario){
        
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        Consulta s=new Consulta();
        int i=0,in=0;
        Object[][] datos=new Object[i=s.con()][12]; 
        try {
            String SQL = "SELECT * FROM bibliotecario WHERE correo = '"+bibliotecario.getCorreo()+"'";
            PreparedStatement user = con.prepareStatement(SQL);
            rs = user.executeQuery();
                
            while (rs.next()) 
                { 
                datos[in][0]=rs.getString(1);
                datos[in][1]=rs.getString(2);
                datos[in][2]=rs.getString(3);
                datos[in][3]=rs.getString(4);
                datos[in][4]=rs.getString(5);
                datos[in][5]=rs.getString(6);
                datos[in][6]=rs.getString(7);
                datos[in][7]=rs.getString(8);
                datos[in][8]=rs.getString(9);
                datos[in][9]=rs.getString(10);
                datos[in][10]=rs.getString(11);
                datos[in][11]=rs.getString(12);
                in++;    
                    }
            rs.close();
            user.close();
            } catch (Exception e) {
            }
     return datos;   
    }
    
    public Object[][] getDatosautor(Autor autor){
        
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        Consulta s=new Consulta();
        int i=0,in=0;
        Object[][] datos=new Object[i=s.con()][4]; 
        try {
            String SQL = "SELECT * FROM autor WHERE nombre = '"+autor.getNombre()+"' AND appPaterno = '"+autor.getAppPaterno()+"' AND appMaterno = '"+autor.getAppMaterno()+"'";
            PreparedStatement user = con.prepareStatement(SQL);
            rs = user.executeQuery();
                
            while (rs.next()) 
                { 
                datos[in][0]=rs.getString(1);
                datos[in][1]=rs.getString(2);
                datos[in][2]=rs.getString(3);
                datos[in][3]=rs.getString(4);
                in++;    
                    }
            rs.close();
            user.close();
            } catch (Exception e) {
            }
     return datos;   
    }
    
    public Object[][] getDatosBiblioteca(BibliotecaM biblioteca){
        
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        Consulta s=new Consulta();
        int i=0,in=0;
        Object[][] datos=new Object[i=s.con()][4]; 
        try {
            String SQL = "SELECT * FROM biblioteca WHERE nombre = '"+biblioteca.getNombre()+"'";
            PreparedStatement user = con.prepareStatement(SQL);
            rs = user.executeQuery();
                
            while (rs.next()) 
                { 
                datos[in][0]=rs.getString(1);
                datos[in][1]=rs.getString(2);
                datos[in][2]=rs.getString(3);
                datos[in][3]=rs.getString(4);
                in++;    
                    }
            rs.close();
            user.close();
            } catch (Exception e) {
            }
     return datos;   
    }
    
    public Object[][] getDatosEjemplar(Ejemplar ejemplar){
        
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        Consulta s=new Consulta();
        int i=0,in=0;
        Object[][] datos=new Object[i=s.con()][5]; 
        try {
            String SQL = "SELECT * FROM ejemplar WHERE idejemplar = '"+ejemplar.getIdEjemplar()+"'";
            PreparedStatement user = con.prepareStatement(SQL);
            rs = user.executeQuery();
                
            while (rs.next()) 
                { 
                datos[in][0]=rs.getString(1);
                datos[in][1]=rs.getString(2);
                datos[in][2]=rs.getString(3);
                datos[in][3]=rs.getString(4);
                datos[in][4]=rs.getString(5);
                in++;    
                    }
            rs.close();
            user.close();
            } catch (Exception e) {
            }
     return datos;   
    }
    
    public Object[][] getDatosEditorial(Editorial editorial){  
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        Consulta s=new Consulta();
        int i=0,in=0;
        Object[][] datos=new Object[i=s.con()][2]; 
        try {
            String SQL = "SELECT * FROM editorial WHERE nombre = '"+editorial.getNombre()+"'";
            PreparedStatement user = con.prepareStatement(SQL);
            rs = user.executeQuery();
                
            while (rs.next()) 
                { 
                datos[in][0]=rs.getString(1);
                datos[in][1]=rs.getString(2);
                in++;    
                    }
            rs.close();
            user.close();
            } catch (Exception e) {
            }
     return datos;   
    }
    

    
    public Object[][] getDatosTelefono(Usuario usuario){  
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        Consulta s=new Consulta();
        int i=0,in=0;
        Object[][] datos=new Object[i=s.con()][2]; 
        try {
            String SQL = "SELECT * FROM telefono_usuario WHERE idusuario = '"+usuario.getId()+"'";
            PreparedStatement user = con.prepareStatement(SQL);
            rs = user.executeQuery();
                
            while (rs.next()) 
                { 
                datos[in][0]=rs.getString(1);
                datos[in][1]=rs.getString(2);
                in++;    
                    }
            rs.close();
            user.close();
            } catch (Exception e) {
            }
     return datos;   
    }
    
    public Object[][] getDatosTelefono(BibliotecaM biblioteca){  
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        Consulta s=new Consulta();
        int i=0,in=0;
        Object[][] datos=new Object[i=s.con()][5]; 
        try {
            String SQL = "SELECT * FROM telefono_biblioteca WHERE idusuario = '"+biblioteca.getId()+"'";
            PreparedStatement user = con.prepareStatement(SQL);
            rs = user.executeQuery();
                
            while (rs.next()) 
                { 
                datos[in][0]=rs.getString(1);
                datos[in][1]=rs.getString(2);
                in++;    
                    }
            rs.close();
            user.close();
            } catch (Exception e) {
            }
     return datos;   
    }
    
    public Object[][] getDatosLibro(Libro libro){  
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        Consulta s=new Consulta();
        int i=0,in=0;
        Object[][] datos=new Object[i=s.con()][7]; 
        try {
            String SQL = "SELECT * FROM libro WHERE titulo = '"+libro.getTitulo()+"'";
            PreparedStatement user = con.prepareStatement(SQL);
            rs = user.executeQuery();
                
            while (rs.next()) 
                { 
                datos[in][0]=rs.getString(1);
                datos[in][1]=rs.getString(2);
                datos[in][2]=rs.getString(3);
                datos[in][3]=rs.getString(4);
                datos[in][4]=rs.getString(5);
                datos[in][5]=rs.getString(6);
                datos[in][6]=rs.getString(7);
                in++;    
                    }
            rs.close();
            user.close();
            } catch (Exception e) {
            }
     return datos;   
    }
    
    public int contBiblio()
    {
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        int i=0;
        try{
            PreparedStatement ps = con.prepareStatement("SELECT nombre FROM biblioteca ORDER BY nombre asc");                                          
            rs = ps.executeQuery();
            while(rs.next())
            {
                i++;
            }
            rs.close();
            con.close();
        }catch(Throwable e){  
        }
        return i;
    }
    public int contGen()
    {
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        int i=0;
        try{
            PreparedStatement ps = con.prepareStatement("SELECT nombre FROM genero ORDER BY nombre asc");                                          
            rs = ps.executeQuery();
            while(rs.next())
            {
                i++;
            }
            rs.close();
            con.close();
        }catch(Throwable e){  
        }
        return i;
    }
    public Object[] getNombrebibliotecas(){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        Consulta consulta=new Consulta();
        Object[] resultado=new Object[consulta.contBiblio()];
        int i=0;
        try{
            PreparedStatement ps = con.prepareStatement("SELECT nombre FROM biblioteca");                                          
            rs = ps.executeQuery();
            while(rs.next())
            {
                resultado[i]=rs.getString(1);
                i++;
            }
            
            
            rs.close();
                    
            con.close();
        }catch(Throwable e){  
        }
        return resultado;
    }
    
    
    public String nombreLibro(Ejemplar ejemplar){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT libro.titulo FROM libro,ejemplar WHERE libro.idlibro = ejemplar.libro AND ejemplar.idejemplar = '"+ejemplar.getIdEjemplar()+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            cadena = rs.getString(1);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return cadena;
    }
    
    public Object[] getNombreGenero(Genero genero){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        Consulta consulta=new Consulta();
        Object[] resultado=new Object[consulta.contBiblio()];
        int i=0;
        try{
            PreparedStatement ps = con.prepareStatement("SELECT nombre FROM genero WHERE nombre = '"+genero.getNombre()+"'");                                          
            rs = ps.executeQuery();
            while(rs.next())
            {
                resultado[i]=rs.getString(1);
                i++;
            }
            
            
            rs.close();
                    
            con.close();
        }catch(Throwable e){  
        }
        return resultado;
    }
    
          public boolean biblio(String usu,String contr)
     {
         conexion = new Conexion();
        Connection con = conexion.getConexion();
        boolean i=false;
        try{
            PreparedStatement ps = con.prepareStatement("SELECT*FROM bibliotecario WHERE correo='"+usu+"'and contrasenia='"+contr+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            //cadena = rs.getString(1);
            System.out.println("--->---"+rs.getRow());
            i=(rs.getRow()==1)?true:false;
                
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return i;
     }
     
     public int idbliotecario(String biblio)
     {
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        int a=0;
        try{
            PreparedStatement ps = con.prepareStatement("Select idbibliotecario from bibliotecario where correo='"+biblio+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            //cadena = rs.getString(1);
            System.out.println("--->---"+rs.getRow());
            
            
            a=rs.getInt(1);
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
        return a;
     }
     
     
     public int idprestamo(String srt)
     {
         conexion = new Conexion();
        Connection con = conexion.getConexion();
        int i=0;
        try{
            PreparedStatement ps = con.prepareStatement("select idbiblioteca from bibliotecario where correo='"+srt+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            //cadena = rs.getString(1);
            System.out.println("--->---"+rs.getRow());
            i=rs.getInt(1);
                
            ps.close();
            con.close();
        }catch(Throwable e){  
        }
         
         return i;
     }
     
     
     public boolean ejemplar1(int busqueda)
     {
         conexion = new Conexion();
        Connection con = conexion.getConexion();
        String bus="";
        try{
            PreparedStatement ps = con.prepareStatement("select estatus from ejemplar where idejemplar='"+busqueda+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            //cadena = rs.getString(1);
            System.out.println("--->---"+rs.getRow());
            bus=rs.getString(1);
                
            ps.close();
            con.close();
        }catch(Throwable e){  
        }   
        
        if(bus.equals("DISPONIBLE"))
        {
           Update up=new Update();
           up.actesatatus(busqueda);
           return true; 
        }
        else 
        {
            JOptionPane.showMessageDialog(null,"ERROR LIBRO OCUPADO","LIBRO OCUPADO", busqueda);
            return false;
        }
        
     }
     
     public int idusuario1(String name)
     {
          conexion = new Conexion();
        Connection con = conexion.getConexion();
        
        int i=0;
        try{
            PreparedStatement ps = con.prepareStatement("select usuario.idusuario from prestamo,usuario where prestamo.idusuario=usuario.idusuario and usuario.nombre='"+name+"'");                                          
            rs = ps.executeQuery();
            rs.next();
            //cadena = rs.getString(1);
            System.out.println("--->---"+rs.getRow());
            i=rs.getInt(1);
                
            ps.close();
            con.close();
        }catch(Throwable e){  
        }   
         return i;
     }
     
     public int prueba(String nombre,String apellidoP,String apellidoM,String libro)
     {
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        String date="2017-03-01";
        int idusuari=0;
        int resultado=0;
         try {
             PreparedStatement ps = con.prepareStatement("select idusuario from usuario where nombre='"+nombre+"' and appPaterno='"+apellidoP+"' and appMaterno='"+apellidoM+"'");
             rs = ps.executeQuery();
             rs.next();
             idusuari=rs.getInt(1);
             System.out.println("--->usuario id"+idusuari);
             
         } catch (Exception e) {
         }
         try {
             PreparedStatement ps = con.prepareStatement("select prestamo.fechadevolucion from prestamo,usuario where prestamo.idusuario=usuario.idusuario and usuario.idusuario='"+idusuari+"'");
             rs = ps.executeQuery();
             rs.next();
             
             System.out.println("si entro o nel---------<-<-<"+rs.getRow());
             date=rs.getString(1);
             System.out.println("Fecha -----"+date);
         } catch (Exception e) {
             System.out.println("ya no pude perdon 1");
         }
        try{
            PreparedStatement ps = con.prepareStatement("select DATEDIFF('"+date+"',curdate())");                                          
            rs = ps.executeQuery();
            rs.next();
            //cadena = rs.getString(1);
            System.out.println("--->---"+rs.getRow()+"  ----  "+rs.getString(1)); 
            resultado=Integer.parseInt(rs.getString(1));
            ps.close();
            con.close();
        }catch(Throwable e){  
            System.out.println(" ya no pude perdon 2");
        }
         
        return resultado;
         
     }
     
public int nodoautor()
{
    conexion = new Conexion();
        Connection con = conexion.getConexion();
        int i=0;
        try{
            PreparedStatement ps = con.prepareStatement("SELECT nombre FROM autor ORDER BY nombre asc");                                          
            rs = ps.executeQuery();
            while(rs.next())
            {
                i++;
            }
            rs.close();
            con.close();
        }catch(Throwable e){  
        }
        return i;
}

public Object[] autor(){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        Consulta consulta=new Consulta();
        Object[] resultado=new Object[consulta.nodoautor()];
        int i=0;
        try{
            PreparedStatement ps = con.prepareStatement("SELECT nombre from autor order by nombre asc");                                          
            rs = ps.executeQuery();
            while(rs.next())
            {
                resultado[i]=rs.getString(1);
                i++;
            }
            
            
            rs.close();
                    
            con.close();
        }catch(Throwable e){  
        }
        return resultado;
    }     
     
     

public int nodoeditorial()
{
    conexion = new Conexion();
        Connection con = conexion.getConexion();
        int i=0;
        try{
            PreparedStatement ps = con.prepareStatement("SELECT nombre FROM editorial ORDER BY nombre asc");                                          
            rs = ps.executeQuery();
            while(rs.next())
            {
                i++;
            }
            rs.close();
            con.close();
        }catch(Throwable e){  
        }
        return i;
}

public Object[] editorial(){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        Consulta consulta=new Consulta();
        Object[] resultado=new Object[consulta.nodoeditorial()];
        int i=0;
        try{
            PreparedStatement ps = con.prepareStatement("SELECT nombre from editorial order by nombre asc");                                          
            rs = ps.executeQuery();
            while(rs.next())
            {
                resultado[i]=rs.getString(1);
                i++;
            }
            
            
            rs.close();
                    
            con.close();
        }catch(Throwable e){  
        }
        return resultado;
    } 


public int nodogenero()
{
    conexion = new Conexion();
        Connection con = conexion.getConexion();
        int i=0;
        try{
            PreparedStatement ps = con.prepareStatement("SELECT nombre FROM genero ORDER BY nombre asc");                                          
            rs = ps.executeQuery();
            while(rs.next())
            {
                i++;
            }
            rs.close();
            con.close();
        }catch(Throwable e){  
        }
        return i;
}

public Object[] generogenero(){
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        Consulta consulta=new Consulta();
        Object[] resultado=new Object[consulta.nodogenero()];
        int i=0;
        try{
            PreparedStatement ps = con.prepareStatement("SELECT nombre from genero order by nombre asc");                                          
            rs = ps.executeQuery();
            while(rs.next())
            {
                resultado[i]=rs.getString(1);
                i++;
            }
            
            
            rs.close();
                    
            con.close();
        }catch(Throwable e){  
        }
        return resultado;
    } 
}
      


    
    
     
    

