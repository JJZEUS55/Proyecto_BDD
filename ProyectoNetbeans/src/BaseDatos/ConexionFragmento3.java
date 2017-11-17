package BaseDatos;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionFragmento3 {
//En esta parte donde dice 10.0.0.9 se cambia por el nombre host que tienes en workbench o la ip de la otra computadora es todo lo que tienes de cambiar en java

//Pones el siguiente codigo en mySQL GRANT ALL PRIVILEGES ON *.* TO 'hola'@'%' IDENTIFIED BY 'contraseña';
//cambia 'hola' por tu usuario de mysql y 'contraseña' tu contraseña de mySQL
//ese codigo es importante por que este hace la magia de que permitas a otras computadoras que accedan a tu base de datos
    public String bd = "fragmento3";
    public String url = "jdbc:mysql://localhost:3306/" + bd;
    public String user = "root";
    public String pass = "1234";

    public Connection Conectar() {
        Connection link = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");

            link = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return link;

    }
}
