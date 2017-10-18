/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DDB 3CV3 2017
 */
public class Conexion {
    
    private static String servidor="jdbc:mysql://localhost/biblio";
    private static String user="root"; //Ubuntu es caos caos
    private static String psw="1234";
    private static String driver="com.mysql.jdbc.Driver";
    private static Connection cnx;
    
    public Conexion(){
        
        try{
            Class.forName(driver);
            cnx=DriverManager.getConnection(servidor, user, psw);
            
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Conexion Fallida");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
    
    public Connection getConexion(){
    return cnx;
    }
}
