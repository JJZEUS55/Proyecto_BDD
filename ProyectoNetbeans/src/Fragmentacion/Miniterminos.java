package Fragmentacion;

import BaseDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Miniterminos {

   // protected PredicadosSimple[] predicados;
    ArrayList<PredicadosSimple> predicados = new ArrayList<PredicadosSimple>();

    public Miniterminos() {
    }

    public ArrayList<PredicadosSimple> getPredicados() {
        return predicados;
    }

    public void setPredicados(ArrayList<PredicadosSimple> predicados) {
        this.predicados = predicados;
    }

    

    public void checarPredicados() {
        boolean c1, c2, c3, c4;
        c1 = consultarPredicado1(predicados.get(0), predicados.get(1));
        c2 = consultarPredicado2(predicados.get(0), predicados.get(1));
        c3 = consultarPredicado3(predicados.get(0), predicados.get(1));
        c4 = consultarPredicado4(predicados.get(0), predicados.get(1));      
        

    }

    public boolean consultarPredicado1(PredicadosSimple predicado1, PredicadosSimple predicado2) {

        boolean funciona = false;
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        try {
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery("SELECT " + predicado1.getAtributo()
                    + " FROM " + predicado1.getTabla()
                    + " WHERE " + predicado1.getAtributo() + " " + predicado1.getOperador() + " " + predicado1.getValor());
            Statement s1 = cn.createStatement();
            ResultSet rs1 = s1.executeQuery("SELECT " + predicado2.getAtributo()
                    + " FROM " + predicado2.getTabla()
                    + " WHERE " + predicado2.getAtributo() + " " + predicado2.getOperador() + " " + predicado2.getValor());
            if (rs.next() == true && rs1.next() == true) {
                funciona = true;
            }

        } catch (Exception e) {
        }
        return funciona;
    }

    public boolean consultarPredicado2(PredicadosSimple predicado1, PredicadosSimple predicado2) {

        boolean funciona = false;
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        try {
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery("SELECT " + predicado1.getAtributo()
                    + " FROM " + predicado1.getTabla()
                    + " WHERE " + predicado1.getAtributo() + " " + predicado1.getOperador() + " " + predicado1.getValor());
            Statement s1 = cn.createStatement();
            ResultSet rs1 = s1.executeQuery("SELECT " + predicado2.getAtributo()
                    + " FROM " + predicado2.getTabla()
                    + " WHERE NOT(" + predicado2.getAtributo() + " " + predicado2.getOperador() + " " + predicado2.getValor() + ")");
            if (rs.next() == true && rs1.next() == true) {
                funciona = true;
            }

        } catch (Exception e) {
        }
        return funciona;
    }

    public boolean consultarPredicado3(PredicadosSimple predicado1, PredicadosSimple predicado2) {

        boolean funciona = false;
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        try {
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery("SELECT " + predicado1.getAtributo()
                    + " FROM " + predicado1.getTabla()
                    + " WHERE NOT(" + predicado1.getAtributo() + " " + predicado1.getOperador() + " " + predicado1.getValor() + ")");
            Statement s1 = cn.createStatement();
            ResultSet rs1 = s1.executeQuery("SELECT " + predicado2.getAtributo()
                    + " FROM " + predicado2.getTabla()
                    + " WHERE NOT(" + predicado2.getAtributo() + " " + predicado2.getOperador() + " " + predicado2.getValor() + ")");
            if (rs.next() == true && rs1.next() == true) {
                funciona = true;
            }

        } catch (Exception e) {
        }
        return funciona;
    }

    public boolean consultarPredicado4(PredicadosSimple predicado1, PredicadosSimple predicado2) {
        boolean funciona = false;
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        try {
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery("SELECT " + predicado1.getAtributo()
                    + " FROM " + predicado1.getTabla()
                    + " WHERE NOT(" + predicado1.getAtributo() + " " + predicado1.getOperador() + " " + predicado1.getValor()+")");
            Statement s1 = cn.createStatement();
            ResultSet rs1 = s1.executeQuery("SELECT " + predicado2.getAtributo()
                    + " FROM " + predicado2.getTabla()
                    + " WHERE NOT(" + predicado2.getAtributo() + " " + predicado2.getOperador() + " " + predicado2.getValor() + ")");
            if (rs.next() == true && rs1.next() == true) {
                funciona = true;
            }

        } catch (Exception e) {
        }
        return funciona;
    }

}
