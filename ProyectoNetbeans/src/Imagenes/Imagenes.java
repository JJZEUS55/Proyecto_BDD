/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import BaseDatos.ConexionMySQL;
import Paciente.Paciente;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Tom
 */
public class Imagenes extends javax.swing.JFrame {

    /**
     * Creates new form Imagenes
     */
    public Imagenes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLIDPaciente = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLIDDentista = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(530, 430));
        setMinimumSize(new java.awt.Dimension(530, 430));
        setPreferredSize(new java.awt.Dimension(530, 430));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Imagenes");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Fecha", "ID Imagen"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Radiografias", "Protesis", "Modelos Dentales" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Regresar");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jTextField1.setText(" ");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setText("ID Imagen");

        jButton1.setText("Ver");

        jButton2.setText("Subir Imagen");

        jLIDPaciente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLIDPaciente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLIDPaciente.setText("0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("ID paciente:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("ID Dentista:");

        jLIDDentista.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLIDDentista.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLIDDentista.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel5)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(10, 10, 10)
                        .addComponent(jLIDDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLIDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLIDPaciente))
                    .addComponent(jLIDDentista))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel5)))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(55, 55, 55))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn= mysql.Conectar();
        
        boolean i=false;
        try {
            Statement s1 = cn.createStatement();
            ResultSet rs1 = s1.executeQuery("SELECT nombres,apellidos,edad,sexo,domicilio,curp,dentistaAsignado FROM paciente WHERE mostrar = 1 AND idPaciente = '"+jLIDPaciente.getText()+"'"); 
            while(rs1.next()){
                String sFichero = "src\\ImagenesPaciente\\"+jLIDPaciente.getText()+".jpg";
                File fichero = new File(sFichero);
                ImageIcon icon;
                if (fichero.exists())
                {
                  icon=new ImageIcon("src\\ImagenesPaciente\\"+jLIDPaciente.getText()+".jpg");  
                }
                else
                {
                   icon=new ImageIcon("src\\ImagenesPaciente\\SinImagen.png");  
                }
                Image img= icon.getImage();
                Image newimg = img.getScaledInstance(150, 175, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                Paciente verPaciente=new Paciente();
                try {
                    Statement s2 = cn.createStatement();
                    ResultSet rs2 = s2.executeQuery("SELECT fecha,Descripción FROM citas WHERE idPaciente = '"+jLIDPaciente.getText()+"' AND actual='1'"); 
                    while(rs2.next()){
                        verPaciente.jLFecha.setText((String) rs2.getObject(1).toString());
                        verPaciente.jTMotivo.setText((String) rs2.getObject(2).toString());
                    }
                    rs2.close();
                }
                catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Problema al conectar");
                } 
                // COSTO 
                float cantidadPagada=0;
                float cantidadDebida=0;                
                DecimalFormat df = new DecimalFormat("0.00"); 
                try {
                    Statement s = cn.createStatement();
                    ResultSet rs = s.executeQuery("SELECT cantidadPagada FROM paciente WHERE idPaciente = '"+jLIDPaciente.getText()+"'"); 
                    while(rs.next()){
                        cantidadPagada=Float.parseFloat((String) rs.getObject(1).toString());
                    }
                    rs.close();
                }
                catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Problema al conectar");
                }           
                try {
                    Statement s = cn.createStatement();
                    ResultSet rs = s.executeQuery("SELECT cantidad FROM costos WHERE idPaciente = '"+jLIDPaciente.getText()+"'"); 
                    while(rs.next()){
                        cantidadDebida+=Float.parseFloat((String) rs.getObject(1).toString());
                    }
                    rs.close();
                }
                catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Problema al conectar");
                }    
                verPaciente.jLCantidad.setText("$"+df.format(cantidadDebida-cantidadPagada));
                //Aqui acaba costo
                verPaciente.JLNombre1.setText((String) rs1.getObject(1).toString());
                verPaciente.JLApellidos1.setText((String) rs1.getObject(2).toString());
                verPaciente.JLEdad1.setText((String) rs1.getObject(3).toString());
                verPaciente.JSexo1.setText((String) rs1.getObject(4));
                verPaciente.JLDomicilio1.setText((String) rs1.getObject(5).toString());
                verPaciente.JLCurp1.setText((String) rs1.getObject(6).toString());
                verPaciente.jLimagen.setIcon(newIcon);
                verPaciente.jLimagen.setSize(150,175);   
                verPaciente.setLocationRelativeTo(null);
                verPaciente.jLIDDentista.setText((String) rs1.getObject(7).toString());
                verPaciente.jLIDPaciente.setText(jLIDPaciente.getText());
                verPaciente.setTitle("Información de: "+rs1.getObject(1).toString());
                verPaciente.setVisible(true);
                this.setVisible(false);
                i=true;
            }
            if(i==false){
                JOptionPane.showMessageDialog(null,"El paciente no existe o le corresponde a otro doctor");
            }
            rs1.close();
        }
            catch(SQLException e){
		JOptionPane.showMessageDialog(null,"Problema al conectar");
            } 
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Imagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Imagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Imagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Imagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Imagenes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    public javax.swing.JLabel jLIDDentista;
    public javax.swing.JLabel jLIDPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
