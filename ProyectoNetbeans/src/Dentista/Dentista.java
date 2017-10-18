/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dentista;

import BaseDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Dentista {

    private int id;
    private String usuario;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

  

    public Dentista getDentistaporID(int id) {
        Dentista dentista = new Dentista();
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        try {
            String apellidos;
            String[] temp;
            Statement s2 = cn.createStatement();
            ResultSet rs2 = s2.executeQuery("SELECT idDentista, user, nombres, apellidos FROM dentista WHERE idDentista='"+ id +"'");
            while (rs2.next()) {
                dentista.id = Integer.parseInt(rs2.getObject(1).toString());
                dentista.usuario = rs2.getObject(2).toString();
                dentista.nombre = rs2.getObject(3).toString();
                
                apellidos = rs2.getObject(4).toString();
                //Dividir los apellidos en materno y paterno
                temp = apellidos.split(" ");
                dentista.apellidoPat = temp[0];
                dentista.apellidoMat = temp[1];
                
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
