/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import BD.Consulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import modelo.Prestamo;

/**
 *
 * @author DDB 3CV3 2017
 */
public class prestamo extends JFrame implements ItemListener,ActionListener{
    public JLabel usuario,con;
    public JTextField usu;
    public JPasswordField contra;
    public JLabel ejemplar,fechapre,fechadev,idusuario,idbiblioteca;
    public JCTextField eje,idusu,idbiblioteca1;
    com.toedter.calendar.JDateChooser DateChooser,DateChooser1;
    public JButton aceptar,procesar,cerrar;
    String guardar;
    Consulta consulta;
    
    public prestamo()
    {
       super("Prestamo");
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
       
       cerrar=new JButton("Cerrar sesion");
       cerrar.setBounds(190,120,100, 35);
       cerrar.setVisible(false);
       add(cerrar);
       cerrar.addActionListener(this);
       
       procesar=new JButton("Procesar");
       procesar.setBounds(230, 350,100, 30);
       procesar.setVisible(false);
       add(procesar);
       procesar.addActionListener(this);
       
       
       
       ejemplar=new JLabel("Ejemplar");
       ejemplar.setBounds(40,210,100,30);
       add(ejemplar);

       eje=new JCTextField();
       eje.setPlaceholder("Escribe el id del ejemplar");
       eje.setBounds(125,210,130,25);
       eje.setEditable(false);
       add(eje);


       fechapre=new JLabel("Fecha prestamo");
       fechapre.setBounds(40,245,130,30);
       add(fechapre);

       DateChooser = new com.toedter.calendar.JDateChooser();
       DateChooser.setVisible(true); 
       DateChooser.setEnabled(false);
       DateChooser.getCalendar();
       DateChooser.setBounds(125,245,130,30);
       
       add(DateChooser);


       fechadev=new JLabel("Fecha devolución");
       fechadev.setBounds(40,285,130,30);
       add(fechadev);

       DateChooser1 = new com.toedter.calendar.JDateChooser();
       DateChooser1.setVisible(true); 
       DateChooser1.setEnabled(false);
       DateChooser1.getCalendar();
       DateChooser1.setBounds(125,285,130,30);
       
       add(DateChooser1);

       idusuario=new JLabel("Usuario");
       idusuario.setBounds(280,210,130,25);
       add(idusuario);

       idusu=new JCTextField();
       idusu.setPlaceholder("Escribe el id del usuario");
       idusu.setBounds(350,210,130,25);
       idusu.setEditable(false);
       add(idusu);

       idbiblioteca=new JLabel("Biblioteca");
       idbiblioteca.setBounds(280,245,130,25);
       add(idbiblioteca);

       idbiblioteca1=new JCTextField();
       idbiblioteca1.setPlaceholder("Escriba id de la biblioteca");
       idbiblioteca1.setBounds(350,245,130,25);
       idbiblioteca1.setEditable(false);
       add(idbiblioteca1);
       
       
       




        
        
        
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==aceptar)
        {
            consulta=new Consulta();
            String USU=usu.getText();
            guardar=USU;
            String CON=contra.getText();
            boolean vis=consulta.biblio(USU, CON);
            if(vis==true)
            {
                usu.setEditable(false);
                contra.setEditable(false);
                eje.setEditable(true);
                idusu.setEditable(true);
                String idbi=""+consulta.idprestamo(guardar);
                idbiblioteca1.setText(idbi);
                DateChooser1.setEnabled(true);
                DateChooser.setEnabled(true);
                procesar.setVisible(true);
                aceptar.setVisible(false);
                cerrar.setVisible(true);
                add(eje,idusu);
                add(idbiblioteca1);
                add(procesar);
                add(cerrar,aceptar);
                
                
                
                 
            }
            else JOptionPane.showMessageDialog(null,"Bibliotecario no encontrado","Inicio fallido",JOptionPane.WARNING_MESSAGE);
            
        }
        if(e.getSource()==cerrar)
        {       
                usu.setEditable(true);
                contra.setEditable(true);
                eje.setEditable(false);
                eje.setText("");
                idusu.setEditable(false);
                idusu.setText("");
                idbiblioteca1.setText("");
                DateChooser1.setEnabled(false);
                DateChooser.setEnabled(false);
                procesar.setVisible(false);
                aceptar.setVisible(true);
                cerrar.setVisible(false);
                add(eje,idusu);
                add(idbiblioteca1);
                add(procesar);
                add(aceptar);
                add(cerrar);
            
        }
        
        if(e.getSource()==procesar)
        {
            try {
                int bus=Integer.parseInt(eje.getText());
                    try {
                        int bus1=Integer.parseInt(idusu.getText());
                            try {
                            int bus2=Integer.parseInt(idbiblioteca1.getText());
                            Consulta con=new Consulta();
                            int usua=con.idbliotecario(guardar);
                            
                            
                            String p1="'"+new SimpleDateFormat("yyyy-MM-dd").format(DateChooser.getDate())+"'";
                            String p2="'"+new SimpleDateFormat("yyyy-MM-dd").format(DateChooser1.getDate())+"'";
                            Prestamo pres=new Prestamo();
                            pres.Pres(bus, bus1, bus2, p1, p2, usua);
                              
                            
                            
                            

                        } catch (Exception o) {
                            JOptionPane.showMessageDialog(null,"indique el id de la biblioteca","Prestamo fallido",JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception ej) {
                        //idusu
                        Consulta con=new Consulta();
                        int idpro=con.idusuario1(idusu.getText());
                        if(idpro!=0)
                        {
                           JOptionPane.showMessageDialog(null,"Usario"+idusu.getText()+"  "+idpro,"Posible usuario",JOptionPane.WARNING_MESSAGE); 
                        }
                        
                        
                        
                        else JOptionPane.showMessageDialog(null,"indique el id del usuario--no encontrado en la base","Prestamo fallido",JOptionPane.WARNING_MESSAGE);
                    }
            } catch (Exception el) {
                JOptionPane.showMessageDialog(null,"indique el id del ejemplar","Prestamo fallido",JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
