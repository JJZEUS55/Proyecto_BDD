/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import BD.Consulta;
import BD.Update;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author DDB 3CV3 2017
 */
public class Devolucion extends JFrame implements ItemListener,ActionListener{
    public JLabel usuario,con,nombre;
    public JLabel apellidoP,apellidoM,retraso,nomlibro;
    public JTextField usu,nombre1,apellido1,apellido2,nomlibro1,retra;
    
    public JPasswordField contra;
    public JButton aceptar,procesar,cerrar,amonestar;
    public Devolucion()
    {
        super("Devolucion");
        setLayout(null);
        usuario=new JLabel("Usuario");
        usuario.setBounds(120,40,100,30);
        add(usuario);
       
       usu=new JTextField();
       usu.setBounds(200,40,100,30);
       add(usu);
       
       con=new JLabel("Contraseña");
       con.setBounds(120,80,100,30);
       add(con);
       
       contra=new JPasswordField("");
       contra.setBounds(200,80,100,30);
       add(contra);
       
       aceptar=new JButton("Iniciar sesion");
       aceptar.setBounds(190,120,100, 35);
       add(aceptar);
       aceptar.addActionListener(this);
       
       cerrar=new JButton("Cerar sesion");
       cerrar.setBounds(190,120,100, 35);
       cerrar.setVisible(false);
       add(cerrar);
       cerrar.addActionListener(this);
       
       procesar=new JButton("Procesar");
       procesar.setBounds(150,340,100,30);
       procesar.setVisible(false);
       add(procesar);
       procesar.addActionListener(this);
       
       nombre=new JLabel("Nombre:");
       nombre.setBounds(80,180,100,30);
       add(nombre);
       
       nombre1=new JTextField();
       nombre1.setBounds(170,180,100,30);
       nombre1.setVisible(false);
       add(nombre1);
       
       apellidoP=new JLabel("Apellido paterno:");
       apellidoP.setBounds(80,220,100,30);
       add(apellidoP);
       
       apellido1=new JTextField();
       apellido1.setBounds(170,220,100,30);
       apellido1.setVisible(false);
       add(apellido1);
       
       apellidoM=new JLabel("Apellido materno:");
       apellidoM.setBounds(80,260,100,30);
       add(apellidoM);
       
       apellido2=new JTextField();
       apellido2.setBounds(170,260,100,30);
       apellido2.setVisible(false);
       add(apellido2);
      
       nomlibro=new JLabel("Nombre de libro:");
       nomlibro.setBounds(80,300,100,30);
       add(nomlibro);
       
       nomlibro1=new JTextField();
       nomlibro1.setBounds(170,300,100,30);
       nomlibro1.setVisible(false);
       add(nomlibro1);
       
       
       retraso=new JLabel();
       retraso.setBounds(320,180,100,30);
       retraso.setVisible(false);
       add(retraso);
       
       
       retra=new JTextField();
       retra.setBounds(320,220,100,30);
       retra.setVisible(false);
       add(retra);
       
       
       
       
       
       
       
       
       
       
       
       
       
    
    }
    
    
    


    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         
        if(e.getSource()==aceptar)
        {
            Consulta consulta=new Consulta();
            String USU=usu.getText();
            String CON=contra.getText();
            boolean vis=consulta.biblio(USU, CON);
            if(vis)
            {
                usu.setEditable(false);
                contra.setEditable(false);
                nombre1.setVisible(true);
                apellido1.setVisible(true);
                apellido2.setVisible(true);
                nomlibro1.setVisible(true);
                aceptar.setVisible(false);
                cerrar.setVisible(true);
                procesar.setVisible(true);
                
                
            }
            else JOptionPane.showMessageDialog(null,"Usuario no encontrado","Error de usuario", HEIGHT);
            
            
            
            
            
            
            }
        
        if(e.getSource()==cerrar)
        {
          
                usu.setEditable(true);
                usu.setText("");
                contra.setEditable(true);
                contra.setText("");
                nombre1.setVisible(false);
                nombre1.setText("");
                apellido1.setVisible(false);
                apellido1.setText("");
                apellido2.setVisible(false);
                apellido2.setText("");
                nomlibro1.setVisible(false);
                nomlibro1.setText("");
                aceptar.setVisible(true);
                cerrar.setVisible(false);
                procesar.setVisible(false);
            
            
            
            
            
            
            }
        
        if(e.getSource()==procesar)
        {
            
            
            Consulta consultar=new Consulta();
            int resultado=consultar.prueba(nombre1.getText(),apellido1.getText(),apellido2.getText(),nomlibro1.getText());
            System.out.println("---->resul"+resultado);
            
            if(resultado>0)
            {
            retraso.setText("Dias restantes");
            retraso.setVisible(true);
            retra.setText(""+resultado);
            retra.setVisible(true);
            retra.setEditable(false);
            }
            else
            {
              retraso.setText("Dias de retraso");
            retraso.setVisible(true);
            retra.setText(""+resultado);
            retra.setVisible(true);
            retra.setEditable(false);  
            }
            
            
            
            
        }
        
        
        
        
        
        
        
        
        
        
        
//        {
//            Update fin=new Update();
//            try {
//                int bus=Integer.parseInt(usu.getText());
//                fin.prestamofin(bus);
//                Consulta opi=new Consulta();
//                opi.prueba();
//                
//            }
//            catch(Exception an)
//            {
//                System.out.println("No es un id de libro");
//            }
       
    }
}
