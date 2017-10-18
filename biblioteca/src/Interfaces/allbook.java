/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import BD.*;
import Interfaces.alta.AltaUsuario;
import com.sun.glass.ui.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
/**
 *
 * @author DDB 3CV3 2017
 */
public class allbook extends JFrame implements ItemListener,ActionListener{
    
    public ResultSet rs;
    JTable table;
    public JScrollPane scrollPane ;
    public JList lista;
    public Connection conexion;
//    public JScrollPane baj;
    public ArrayList<String> bas=new ArrayList<>();
    String ber[];
    int i=0,j=0,in=0;
    public Object[][] datos;
    JButton consultar,usuario,newusuario,consultar2;
    public JCTextField consu;
    fondo fon;
    JComboBox Edi,Aut,Gen;
    public allbook()
    {
       super("Catalogo de libros") ;
       fon=new fondo();
       setLayout(null);
       Conexion con=new Conexion();
       Connection cone=con.getConexion();
       Consulta s=new Consulta(); 

        datos=s.constr();
        String[] columnNames = {"idlibro","titulo","Páginas","Edicion","Año","Editorial"};
        table = new JTable(new Creartabla(datos,columnNames));

         table.setPreferredScrollableViewportSize(new Dimension(430, 300));

         scrollPane = new JScrollPane(table);
         scrollPane.setBounds(12, 150, 530, 250);
         add(scrollPane);
         
         
         consu = new JCTextField();
         consu.setBounds(150, 405, 200, 40);
         consu.setPlaceholder("Escribe el id del libro ");
         consu.setVisible(true);
         add(consu);
         consultar=new JButton("Consultar");
         consultar.setBounds(360, 410, 100, 35);
         add(consultar);
         consultar.addActionListener(this);
         consu.addActionListener(this);
         
        usuario=new JButton("Ingresar");
        usuario.setBounds(350,2,100,40);
        usuario.setOpaque(false);
        usuario.setContentAreaFilled(false);
        usuario.setBorderPainted(false);
        usuario.setFocusable(false);
        usuario.setRolloverEnabled(true);
        usuario.setRequestFocusEnabled(true);
        
        add(usuario);
         newusuario=new JButton("Nuevo usuario");
        newusuario.setBounds(430,2,140,40);
        newusuario.setOpaque(false);
        newusuario.setContentAreaFilled(false);
        newusuario.setBorderPainted(false);
        newusuario.setFocusable(false);
        newusuario.setRolloverEnabled(true);
        newusuario.setRequestFocusEnabled(true);
        add(newusuario);
        usuario.addActionListener(this);
        newusuario.addActionListener(this);
        
        
        JLabel et1=new JLabel("Editorial"),et2=new JLabel("Autor"),et3=new JLabel("Genero");
        et1.setBounds(300,35,80,20);
        add(et1);
        et2.setBounds(390,35,80,20);
        add(et2);
        et3.setBounds(475,35,80,20);
        add(et3);
        
        //Editoria
        Edi=new JComboBox();
        Edi.setBounds(290,55,80,20);
        add(Edi);
        Edi.addItem("DE BOLSILLO");
        Edi.addItem("SALAMANDRA");
        Edi.addItem("ALIANZA");
        Edi.addItem("HARPER");
        Edi.addItem("REIMPRESA");
        Edi.addItem("EDHASA");
        
        
        
        //Autor
        Aut=new JComboBox();
        Aut.setBounds(375,55,80,20);
        add(Aut);
        Aut.addItem("STEPHEN");
        Aut.addItem("GABRIEL ANTONIO");
        Aut.addItem("GEORGE");
        Aut.addItem("MARIO");
        Aut.addItem("GABRIEL");
        
        //Genero
        Gen=new JComboBox();
        Gen.setBounds(460,55,80,20);
        add(Gen);
        Gen.addItem("THRILLER");
        Gen.addItem("PSICOSIS");
        Gen.addItem("EPICA O NARRATIVO");
        Gen.addItem("DRAMA");
        Gen.addItem("FICCION");
        Gen.addItem("INFANTIL");
        Gen.addItem("AUTOAYUDA");
        Gen.addItem("HOGAR");
        Gen.addItem("EROTICA");
        Gen.addItem("ENCICLOPEDIA");
        Gen.addItem("POLITICA");
        Gen.addItem("ECONOMIA");
        Gen.addItem("SOCIEDAD");
        Gen.addItem("DEPORTES");
        Gen.addItem("VIAJES");
        Gen.addItem("BIOGRAFIAS");
        Gen.addItem("NOVELA");
        Aut.addActionListener(this);
        Edi.addActionListener(this);
        Gen.addActionListener(this);
        
       
       add(fon);
       
       actualizarlista a=new actualizarlista(this,table,scrollPane);
       a.start();
       scrollPane=a.fram;
       
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        
        if(e.getSource()==Edi)
        {
            String al=(String)Edi.getSelectedItem();
            System.out.println("Selecciono editar en Editor "+al);
            Consulta con=new Consulta();
            Object[][] ob=con.Edi(al);
            int len=ob.length;
            for (int k = 0; k < len; k++) {
                System.out.println("-->"+ob[k][0]+"----"+ob[k][1]);
            }
            String[] val={"Titulo","Editorial"};
            Datosparticulares VER=new Datosparticulares("Editorial",ob,val);
            VER.setSize(560,480);
            VER.setVisible(true);
            VER.setLocation(450, 200);
            VER.setResizable(false);
            VER.setEnabled(true);
            
            
            
        }
        if(e.getSource()==Aut)
        {
            System.out.println("Selecciono editar en Autor "+(String)Aut.getSelectedItem());
            Consulta con=new Consulta();
            Object[][] ob=con.Aut((String)Aut.getSelectedItem());
            int len=ob.length;
            for (int k = 0; k < len; k++) {
                System.out.println("-->"+ob[k][0]+"----"+ob[k][1]);
            }
            String[] val={"Titulo","Autor"};
            Datosparticulares VER=new Datosparticulares("Autor",ob,val);
            VER.setSize(560,480);
            VER.setVisible(true);
            VER.setLocation(450, 200);
            VER.setResizable(false);
            VER.setEnabled(true);  
        
        }
        if(e.getSource()==Gen)
        {
            System.out.println("Selecciono editar en Genero "+(String)Gen.getSelectedItem());
            Consulta con=new Consulta();
            Object[][] ob=con.Gen((String)Gen.getSelectedItem());
            int len=ob.length;
            for (int k = 0; k < len; k++) {
                System.out.println("-->"+ob[k][0]+"----"+ob[k][1]);
            }
            String[] val={"Titulo","Genero"};
            Datosparticulares VER=new Datosparticulares("Genero",ob,val);
            VER.setSize(560,480);
            VER.setVisible(true);
            VER.setLocation(450, 200);
            VER.setResizable(false);
            VER.setEnabled(true);
        }
        if(e.getSource()==consultar)
        {
            String buscar=consu.getText();
            
            if(!(buscar.isEmpty()))
            {
                try {
                    int bus=Integer.parseInt(buscar);
                    procesando VER=new procesando();
                    VER.setSize(230,230);
                    VER.setVisible(true);
                    VER.setLocation(450, 200);
                    VER.setResizable(false);
                    VER.setEnabled(true);
                    Consulta con=new Consulta();
                    Object[] a=(Object[]) con.idlibro(bus);
                    new monitoreo(VER,a);
                    consu.setVisible(false);
                    consu=null;
                    consu = new JCTextField();
                    consu.setBounds(150, 405, 200, 40);
                    consu.setPlaceholder("Escribe el id del libro ");
                    consu.setVisible(true);
                    add(consu);
                    
                    
                    
                } catch (Exception el) {
                   JOptionPane.showMessageDialog(null,"Por favor ingrese el id del libro","Error en la busqueda", JOptionPane.WARNING_MESSAGE);
                }
            
            
           
            
            }
            else JOptionPane.showMessageDialog(null,"Por favor ingrese un id de libro","", HEIGHT);
            
            
        }
        if(e.getSource()==usuario)
        {
            login VER=new login();
            VER.setSize(560,480);
            VER.setVisible(true);
            VER.setLocation(450, 200);
            VER.setResizable(false);
            VER.setEnabled(true);
           
            
        }
        
        if(e.getSource()==newusuario)
        {
            AltaUsuario vistausuario = new AltaUsuario();
            vistausuario.setVisible(true);
        }
        
      
    
    }

    public JTable getTable(){
        return table;
    }
    
   
        
}
