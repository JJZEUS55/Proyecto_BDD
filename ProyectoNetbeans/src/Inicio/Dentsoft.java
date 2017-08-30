/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import Inicio.Inicio;
import java.io.File;

/**
 *
 * @author Tom
 */
public class Dentsoft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File folder = new File("src/ImagenesPaciente");
        folder.mkdirs();
        Inicio ventana= new Inicio();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    
}
