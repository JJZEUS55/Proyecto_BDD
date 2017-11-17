package Fragmentacion;

import BaseDatos.ConexionFragmento1;
import BaseDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Miniterminos {

    protected ArrayList<PredicadosSimple> predicados = new ArrayList<PredicadosSimple>();

    public Miniterminos() {
    }

    public ArrayList<PredicadosSimple> getPredicados() {
        return predicados;
    }

    public void setPredicados(ArrayList<PredicadosSimple> predicados) {
        this.predicados = predicados;
    }

    public String checarPredicados() {
        boolean c1, c2, c3, c4;
        String resultados = "";
        c1 = consultarPredicado1(predicados.get(0), predicados.get(1));
        c2 = consultarPredicado2(predicados.get(0), predicados.get(1));
        c3 = consultarPredicado3(predicados.get(0), predicados.get(1));
        c4 = consultarPredicado4(predicados.get(0), predicados.get(1));
        if (c1 == true) {
            resultados = "m1: " + predicados.get(0).getAtributo() + " " + predicados.get(0).getOperador() + " " + predicados.get(0).getValor()
                    + " ^ " + predicados.get(1).getAtributo() + " " + predicados.get(1).getOperador() + " " + predicados.get(1).getValor();
        }
        if (c2 == true) {
            resultados = resultados + "\n" + "m2: ~(" + predicados.get(0).getAtributo() + " " + predicados.get(0).getOperador() + " " + predicados.get(0).getValor()
                    + ") ^ " + predicados.get(1).getAtributo() + " " + predicados.get(1).getOperador() + " " + predicados.get(1).getValor();
        }
        if (c3 == true) {
            resultados = resultados + "\n" + "m3: " + predicados.get(0).getAtributo() + " " + predicados.get(0).getOperador() + " " + predicados.get(0).getValor()
                    + " ^ ~(" + predicados.get(1).getAtributo() + " " + predicados.get(1).getOperador() + " " + predicados.get(1).getValor() + ")";
        }
        if (c4 == true) {
            resultados = resultados + "\n" + "m4: ~(" + predicados.get(0).getAtributo() + " " + predicados.get(0).getOperador() + " " + predicados.get(0).getValor()
                    + ") ^ ~(" + predicados.get(1).getAtributo() + " " + predicados.get(1).getOperador() + " " + predicados.get(1).getValor() + ")";
        }
        return resultados;
    }

    public void insertarPredicados(int fragmento, PredicadosSimple predicado1, PredicadosSimple predicado2) {

        switch (fragmento) {
            case 1:
                ConexionMySQL mysql = new ConexionMySQL();
                Connection cn = mysql.Conectar();
                try {
                    Statement s = cn.createStatement();
                    ResultSet rs = s.executeQuery("SELECT t1." + predicado1.getAtributo() + ", t2." + predicado2.getAtributo()
                            + " FROM " + predicado1.getTabla() + " t1, " + predicado2.getTabla() + " t2"
                            + " WHERE t1." + predicado1.getAtributo() + " " + predicado1.getOperador() + " '" + predicado1.getValor() + "'"
                            + " AND t2." + predicado2.getAtributo() + " " + predicado2.getOperador() + " '" + predicado2.getValor() + "'");

                } catch (Exception e) {
                }

                break;

            default:
                JOptionPane.showMessageDialog(null, "No se pudo insertar en fragmento!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean consultarPredicado1(PredicadosSimple predicado1, PredicadosSimple predicado2) {

        boolean funciona = false;
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        try {
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * \n"
                    + " FROM " + predicado1.getTabla() +"\n"
                    + " WHERE (" + predicado1.getAtributo() + " " + predicado1.getOperador() + " '" + predicado1.getValor() + "' \n"
                    + " AND " + predicado2.getAtributo() + " " + predicado2.getOperador() + " '" + predicado2.getValor() + "')");
            if (rs.next() == true) {
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
            ResultSet rs = s.executeQuery("SELECT * \n" 
                    + " FROM " + predicado1.getTabla() + " \n"
                    + " WHERE (NOT(" + predicado1.getAtributo() + " " + predicado1.getOperador() + " '" + predicado1.getValor() + "') \n"
                    + " AND " + predicado2.getAtributo() + " " + predicado2.getOperador() + " '" + predicado2.getValor() + "')");

            if (rs.next() == true) {
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
            ResultSet rs = s.executeQuery("SELECT *" + " \n"
                    + " FROM " + predicado1.getTabla() + " \n"
                    + " WHERE (" + predicado1.getAtributo() + " " + predicado1.getOperador() + " '" + predicado1.getValor() + "' \n"
                    + " AND NOT(" + predicado2.getAtributo() + " " + predicado2.getOperador() + " '" + predicado2.getValor() + "'))");

            if (rs.next() == true) {
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
            ResultSet rs = s.executeQuery("SELECT *" + " \n"
                    + " FROM " + predicado1.getTabla() + " \n"
                    + " WHERE (NOT(" + predicado1.getAtributo() + " " + predicado1.getOperador() + " '" + predicado1.getValor() + "')"
                    + " AND NOT(" + predicado2.getAtributo() + " " + predicado2.getOperador() + " '" + predicado2.getValor() + "'))");
            if (rs.next() == true) {
                funciona = true;
            }

        } catch (Exception e) {
        }
        return funciona;
    }

    public void checarTabla1(PredicadosSimple predicado1, PredicadosSimple predicado2) {
        ConexionFragmento1 mysql = new ConexionFragmento1();
        Connection cn1 = mysql.Conectar();

        String sqlCrearTabla = "create table if not exists fragmento1." + predicado1.getTabla() + "f1  \n"
                + "as\n"
                + "select *\n"
                + "from dentsoft2." + predicado1.getTabla() + "\n"
                + "where (dentsoft2." + predicado1.getTabla() + "." + predicado1.getAtributo() + " " + predicado1.getOperador() + " '" + predicado1.getValor() + "'\n"
                + "and dentsoft2." + predicado2.getTabla() + "." + predicado2.getAtributo() + " " + predicado2.getOperador() + " '" + predicado2.getValor() + "')";
        String sqlInsertar = "insert into fragmento1." + predicado1.getTabla() + "f1  \n"                
                + "select *\n"
                + "from dentsoft2." + predicado1.getTabla() + "\n"
                + "where (dentsoft2." + predicado1.getTabla() + "." + predicado1.getAtributo() + " " + predicado1.getOperador() + " '" + predicado1.getValor() + "'\n"
                + "and dentsoft2." + predicado2.getTabla() + "." + predicado2.getAtributo() + " " + predicado2.getOperador() + " '" + predicado2.getValor() + "')";
        Statement s;
        try {
//            s = cn1.createStatement();
//            s.execute(sqlCrearTabla);
            DatabaseMetaData dbms = cn1.getMetaData();
            ResultSet tablas = dbms.getTables(null, null, "fragmento1." + predicado1.getTabla()+"f1", null);
            if (tablas.next()) {
                s = cn1.createStatement();
                s.execute(sqlInsertar);
            } else {
                s = cn1.createStatement();
                s.execute(sqlCrearTabla);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Miniterminos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void checarTabla2(PredicadosSimple predicado1, PredicadosSimple predicado2) {
        ConexionFragmento1 mysql = new ConexionFragmento1();
        Connection cn1 = mysql.Conectar();

        String sqlCrearTabla = "create table if not exists fragmento1." + predicado1.getTabla() + "f1  \n"
                + "as\n"
                + "select *\n"
                + "from dentsoft2." + predicado1.getTabla() + "\n"
                + "where (dentsoft2." + predicado1.getTabla() + "." + predicado1.getAtributo() + " " + predicado1.getOperador() + " '" + predicado1.getValor() + "'\n"
                + "and dentsoft2." + predicado2.getTabla() + "." + predicado2.getAtributo() + " " + predicado2.getOperador() + " '" + predicado2.getValor() + "')";
        String sqlInsertar = "insert into fragmento1." + predicado1.getTabla() + "f1  \n"                
                + "select *\n"
                + "from dentsoft2." + predicado1.getTabla() + "\n"
                + "where (dentsoft2." + predicado1.getTabla() + "." + predicado1.getAtributo() + " " + predicado1.getOperador() + " '" + predicado1.getValor() + "'\n"
                + "and dentsoft2." + predicado2.getTabla() + "." + predicado2.getAtributo() + " " + predicado2.getOperador() + " '" + predicado2.getValor() + "')";
        Statement s;
        try {
//            s = cn1.createStatement();
//            s.execute(sqlCrearTabla);
            DatabaseMetaData dbms = cn1.getMetaData();
            ResultSet tablas = dbms.getTables(null, null, "fragmento1." + predicado1.getTabla()+"f1", null);
            if (tablas.next()) {
                s = cn1.createStatement();
                s.execute(sqlInsertar);
            } else {
                s = cn1.createStatement();
                s.execute(sqlCrearTabla);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Miniterminos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
