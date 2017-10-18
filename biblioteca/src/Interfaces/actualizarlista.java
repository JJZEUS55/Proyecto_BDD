/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import BD.*;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author DDB 3CV3 2017
 */
public class actualizarlista extends Thread{
  JScrollPane fram;
  int comp;
  JFrame fr;
  JTable table;
  Consulta con=new Consulta();
  Object[][] datos;
  Consulta s;
  JScrollPane pal;
  int drep=0;
  
  
  public actualizarlista(JFrame o,JTable p,JScrollPane pa)
  {

      this.fr=o;
      this.pal=pa;
      this.table=p;
      s=new Consulta();
      this.comp=s.con();
      
  }
  
  @Override
  public void run()
  {
     int i;
     while(true)
     {
         try {
             Thread.sleep(2000);
         } catch (Exception e) {
         }
     if(comp!=con.con())
     {
         
         comp=con.con();
        Consulta s=new Consulta();
        if(drep==0)
        {
        
        table.setVisible(false);
        pal.setVisible(false);
        }
        datos=s.constr();
        String[] columnNames = {"idlibro","titulo","Páginas","Edicion","Año","Editorial"};
        JTable table = new JTable(new Creartabla(datos,columnNames));
            
         
         table.setPreferredScrollableViewportSize(new Dimension(430, 300));

         JScrollPane scrollPane = new JScrollPane(table);
         scrollPane.setBounds(12, 150, 530, 250);
         scrollPane.setVisible(true);
         fr.add(scrollPane);
         System.out.println("Entro...........");
     }
         System.out.println("--no entro\n");

     }
  }
  
    
}
