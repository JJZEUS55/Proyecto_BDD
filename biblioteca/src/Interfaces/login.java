/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import BD.*;
import javax.swing.JOptionPane;

/**
 *
 * @author DDB 3CV3 2017
 */
public class login extends JFrame implements ItemListener,ActionListener{
    static fondologin fon;
    public JCTextField consu;
    public JPasswordField contra;
    public JButton ingresar;
    public JLabel bien,usu,pass;
    public login()
    {
        super("Login");
        setLayout(null);
        fon=new fondologin();
        String path="/imagenes/log.png/";
        URL url = this.getClass().getResource(path); 
        ImageIcon icon;
        icon=reducirimagenes(url);
        bien=new JLabel();
        bien.setIcon(icon);
        bien.setBounds(2,320,200,130);
        add(bien);
        
        usu=new JLabel("Usuario");
        usu.setBounds(280, 10, 40, 40);
        add(usu);
        consu=new JCTextField();
        consu = new JCTextField();
         consu.setBounds(350, 10, 200, 40);
         consu.setPlaceholder("Escriba su usuario");
         consu.setVisible(true);
         add(consu);
         
         pass=new JLabel("Contraseña");
         pass.setBounds(280, 60, 60, 40);
         add(pass);
         
         
         contra=new JPasswordField();
         contra.setBounds(350, 60, 200, 40);
         add(contra);
         
         ingresar=new JButton("Ingresar");
         ingresar.setBounds(380, 120, 120, 30);
         add(ingresar);
         ingresar.addActionListener(this);
        
        
        
        
        
        add(fon);
        
    }
    public ImageIcon reducirimagenes(URL a)
    {
      ImageIcon b1=new ImageIcon(a);
      Image conversion=b1.getImage();
      Image tam=conversion.getScaledInstance(150,130,Image.SCALE_SMOOTH);
      ImageIcon fin=new ImageIcon(tam);
      return fin;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
    if(e.getSource()==ingresar)
    {
        System.out.println("Estoy tratando de acceder");
        Consulta con=new Consulta();
        String us=consu.getText();
        String pa=contra.getText();
        System.out.println("-->"+pa);
        boolean bol=con.acceso(us,pa);
        if(bol==true)
        {
            iniciousuario VER=new iniciousuario(us);
            VER.setSize(560,480);
                    VER.setVisible(true);
                    VER.setLocation(450, 200);
                    VER.setResizable(false);
                    VER.setEnabled(true);
                     
        }
        else{
        bol=con.accesoBibliotecario(us,pa);
        if(bol == true){
            Administrador administrador = new Administrador();
            administrador.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"Cuenta erronea","Usuario no encontrado",JOptionPane.WARNING_MESSAGE);
        }
        }
    }
    
    
    
    }
    
    
    
    
    
    
}
