/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentarLibro;

import BD.Conexion;
import Pacientes.Pacientes;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class VerLibrosDentista extends javax.swing.JFrame {

    /**
     * Creates new form VerLibrosDentista
     */
    public VerLibrosDentista() {
        initComponents();
        TableLibrosSN.addMouseListener(new MouseAdapter() {

        });
        iniciarLibros();
        iniciarTusLibros();
    }
//INCIIA EN LA TABLA LOS LIBROS QUE HAY DISPONIBLES

    public void iniciarLibros() {
        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();
        Statement s;
        try {
            s = con.createStatement();
            ResultSet rs = s.executeQuery("select l.idlibro, l.titulo, l.nopaginas, l.año, g.nombre as genero\n"
                    + "from libro l, genero g\n"
                    + "where l.genero=g.idgenero; ");
            ResultSetMetaData rsmd = rs.getMetaData();
            int numeroColumnas = rsmd.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            this.TableLibrosSN.setModel(modelo);
            for (int x = 1; x <= numeroColumnas; x++) {
                modelo.addColumn(rsmd.getColumnName(x));
            }
            while (rs.next()) {
                Object[] fila = new Object[numeroColumnas];
                for (int y = 0; y < numeroColumnas; y++) {
                    fila[y] = (String) rs.getObject(y + 1).toString();
                }
                modelo.addRow(fila);
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Pacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //INICIA EN LA TABLA LOS LIBROS QUE TU TIENES
    public void iniciarTusLibros() {
        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();
        Statement s;
        try {
            s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM libro");
            ResultSetMetaData rsmd = rs.getMetaData();
            int numeroColumnas = rsmd.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            this.jTableTusLibros.setModel(modelo);
            for (int x = 1; x <= numeroColumnas; x++) {
                modelo.addColumn(rsmd.getColumnName(x));
            }
            while (rs.next()) {
                Object[] fila = new Object[numeroColumnas];
                for (int y = 0; y < numeroColumnas; y++) {
                    fila[y] = (String) rs.getObject(y + 1).toString();
                }
                modelo.addRow(fila);
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Pacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //SELECCIONAR LOS LIBROS TOTALES
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jIdDentista = new javax.swing.JLabel();
        ScrollLibros = new javax.swing.JScrollPane();
        TableLibrosSN = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTusLibros = new javax.swing.JTable();
        btnAgregarLibro = new javax.swing.JButton();
        btnEliminarLibro = new javax.swing.JButton();
        jtfNombreLibro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnRecomendarLibros = new javax.swing.JButton();

        jIdDentista.setText("jLabel1");

        TableLibrosSN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableLibrosSN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableLibrosSNMouseClicked(evt);
            }
        });
        ScrollLibros.setViewportView(TableLibrosSN);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Libros Disponibles");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tus Libros");

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTableTusLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableTusLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTusLibrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTusLibros);

        btnAgregarLibro.setText("Agregar Libro");

        btnEliminarLibro.setText("Eliminar Libro");

        jtfNombreLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreLibroActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Nombre");

        btnRecomendarLibros.setText("Recomendar Libros");
        btnRecomendarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecomendarLibrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(jLabel2))
                    .addComponent(ScrollLibros, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregarLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jIdDentista)
                        .addGap(207, 207, 207))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(38, 38, 38)))
                .addComponent(jtfNombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRecomendarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIdDentista)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnRecomendarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScrollLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btnAgregarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEliminarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNombreLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreLibroActionPerformed

    private void TableLibrosSNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableLibrosSNMouseClicked
        btnEliminarLibro.setEnabled(false);
        btnAgregarLibro.setEnabled(true);
        DefaultTableModel modelo = (DefaultTableModel) TableLibrosSN.getModel();
        int fila = TableLibrosSN.rowAtPoint(evt.getPoint());
        int columna = 0;
        if ((fila > -1) && (columna > -1)) {
            jtfNombreLibro.setText((String) modelo.getValueAt(fila, columna));

        }
    }//GEN-LAST:event_TableLibrosSNMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTableTusLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTusLibrosMouseClicked
        btnAgregarLibro.setEnabled(false);
        btnEliminarLibro.setEnabled(true);
        DefaultTableModel modelo = (DefaultTableModel) jTableTusLibros.getModel();
        int fila = jTableTusLibros.rowAtPoint(evt.getPoint());
        int columna = 0;
        if ((fila > -1) && (columna > -1)) {
            jtfNombreLibro.setText((String) modelo.getValueAt(fila, columna));

        }
    }//GEN-LAST:event_jTableTusLibrosMouseClicked

    //JJ CAMBIAR EL BUSCADOR POR IDGENERO A UNO DE ODONTOLOGIA
    private void btnRecomendarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecomendarLibrosActionPerformed
        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();
        Statement s;
        try {
            s = con.createStatement();
            ResultSet rs = s.executeQuery("select l.titulo, l.nopaginas, l.año, g.nombre as genero\n"
                    + "from libro l, genero g\n"
                    + "where l.genero=g.idgenero\n"
                    + "and g.idgenero=2; ");
            ResultSetMetaData rsmd = rs.getMetaData();
            int numeroColumnas = rsmd.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            this.TableLibrosSN.setModel(modelo);
            for (int x = 1; x <= numeroColumnas; x++) {
                modelo.addColumn(rsmd.getColumnName(x));
            }
            while (rs.next()) {
                Object[] fila = new Object[numeroColumnas];
                for (int y = 0; y < numeroColumnas; y++) {
                    fila[y] = (String) rs.getObject(y + 1).toString();
                }
                modelo.addRow(fila);
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Pacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRecomendarLibrosActionPerformed

    //METODO MAIN
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
            java.util.logging.Logger.getLogger(VerLibrosDentista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerLibrosDentista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerLibrosDentista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerLibrosDentista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerLibrosDentista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollLibros;
    private javax.swing.JTable TableLibrosSN;
    private javax.swing.JButton btnAgregarLibro;
    private javax.swing.JButton btnEliminarLibro;
    private javax.swing.JButton btnRecomendarLibros;
    public javax.swing.JLabel jIdDentista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTusLibros;
    private javax.swing.JTextField jtfNombreLibro;
    // End of variables declaration//GEN-END:variables
}
