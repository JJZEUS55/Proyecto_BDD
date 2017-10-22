/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dentista;

import BD.Conexion;
import BaseDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class BibliotecarioDent {

    private int idBibliotecario;
    private String usuario;
    private String nombre;
    private String apPaterno;
    private String apMaterno;

    public int getIdBibliotecario() {
        return idBibliotecario;
    }

    public void setIdBibliotecario(int idBibliotecario) {
        this.idBibliotecario = idBibliotecario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public BibliotecarioDent getBibliotecariobyUsuario(String usuario) {

        BibliotecarioDent dentista = new BibliotecarioDent();
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConexion();       
        try {
            String apellidos;
            String[] temp;
            Statement s2 = cn.createStatement();
            ResultSet rs2 = s2.executeQuery("SELECT idbibliotecario, correo, nombre, appPaterno, appMaterno FROM bibliotecario WHERE correo='"+usuario+"'");
            while (rs2.next()) {
                dentista.idBibliotecario = Integer.parseInt(rs2.getObject(1).toString());
                dentista.usuario = rs2.getObject(2).toString();
                dentista.nombre = rs2.getObject(3).toString();
                dentista.apPaterno = rs2.getObject(4).toString();
                dentista.apMaterno = rs2.getObject(5).toString();

//                dentista.setId(Integer.parseInt(rs2.getObject(1).toString()));
//                dentista.setUsuario(rs2.getObject(2).toString());
//                dentista.setNombre(rs2.getObject(3).toString());
//                dentista.setApellidos(rs2.getObject(4).toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No encontro al dentista");
        }
        return dentista;
    }

}


