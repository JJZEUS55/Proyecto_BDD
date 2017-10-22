/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentarLibro;

import BD.Conexion;
import Dentista.BibliotecarioDent;
import Dentista.Dentista;
import Pacientes.Pacientes;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class VerLibrosDentista extends javax.swing.JFrame {

    private static String id = null;
    private Dentista dent;
    private BibliotecarioDent biblioDent;

    public VerLibrosDentista(String id) {
        this.id = id;
        dent = new Dentista().getDentistaporID(Integer.parseInt(id));
        biblioDent = new BibliotecarioDent().getBibliotecariobyUsuario(dent.getUsuario());
        initComponents();
        jIdDent.setText(id);
        jIdDent.setVisible(false);
        TableLibrosSN.addMouseListener(new MouseAdapter() {

        });

        TableLibrosRecomendados.addMouseListener(new MouseAdapter() {

        });

        jTableTusLibros.addMouseListener(new MouseAdapter() {

        });

        iniciarLibros();
        iniciarTusLibros();
    }

    public void setId(String id) {
        this.id = id;
        jIdDent.setText(id);
    }

//INCIIA EN LA TABLA LOS LIBROS QUE HAY DISPONIBLES
    public void iniciarLibros() {
        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();
        Statement s;
        try {
            s = con.createStatement();
            ResultSet rs = s.executeQuery("select l.idlibro, l.titulo, l.nopaginas, l.año, g.nombre as genero\n"
                    + "                    from libro l, genero g\n"
                    + "                    where l.genero=g.idgenero\n"
                    + "                    and l.idbibliotecario=11; ");
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
        int idDentista = Integer.parseInt(id);
        Dentista dentista = new Dentista().getDentistaporID(idDentista);
        String usuario = dentista.getUsuario();
        //JOptionPane.showConfirmDialog(this, "Prueba", "Mi usuario es :" + usuario, JOptionPane.DEFAULT_OPTION);
        try {
            s = con.createStatement();
            ResultSet rs = s.executeQuery("select l.idlibro, l.titulo, l.nopaginas, l.año, g.nombre as genero\n"
                    + "                    from libro l, genero g, bibliotecario b\n"
                    + "                    where l.genero=g.idgenero\n"
                    + "                    and l.idbibliotecario=b.idbibliotecario\n"
                    + "                    and b.correo like '%" + usuario + "%';");
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

    public void buscarLibro(JTable tabla) {

    }

    //SELECCIONAR LOS LIBROS TOTALES
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTusLibros = new javax.swing.JTable();
        btnEliminarLibro = new javax.swing.JButton();
        jIdDent = new javax.swing.JLabel();
        jtfNombreLibro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblIdlibro = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ScrollLibros = new javax.swing.JScrollPane();
        TableLibrosSN = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAgregarLibro = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtfNombreLibro1 = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        btnRefrescar1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblIdlibro1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ScrollLibros1 = new javax.swing.JScrollPane();
        TableLibrosRecomendados = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnRecomendarLibros = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtfNombreLibro2 = new javax.swing.JTextField();
        btnBuscar2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblIdlibro2 = new javax.swing.JLabel();

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

        btnEliminarLibro.setText("Devolver Libro");
        btnEliminarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLibroActionPerformed(evt);
            }
        });

        jIdDent.setText("a");

        jtfNombreLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreLibroActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Nombre");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRefrescar.setText("Refresh");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        jLabel7.setText("ID Libro : ");

        lblIdlibro.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jIdDent)
                .addGap(125, 125, 125)
                .addComponent(jLabel3)
                .addGap(38, 38, 38)
                .addComponent(jtfNombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefrescar)
                .addGap(47, 47, 47))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(305, 305, 305)))
                        .addComponent(btnEliminarLibro))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIdlibro)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfNombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jIdDent)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnEliminarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblIdlibro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        jTabbedPane1.addTab("Mis Libros", jPanel2);

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

        btnAgregarLibro.setText("Agregar Libro");
        btnAgregarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLibroActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Nombre");

        jtfNombreLibro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreLibro1ActionPerformed(evt);
            }
        });

        btnBuscar1.setText("Buscar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        btnRefrescar1.setText("Refresh");
        btnRefrescar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescar1ActionPerformed(evt);
            }
        });

        jLabel8.setText("ID Libro : ");

        lblIdlibro1.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(ScrollLibros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(406, 406, 406))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIdlibro1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(38, 38, 38)
                        .addComponent(jtfNombreLibro1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(btnRefrescar1)
                        .addGap(134, 134, 134))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfNombreLibro1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRefrescar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblIdlibro1))
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adquirir Libros", jPanel3);

        TableLibrosRecomendados.setModel(new javax.swing.table.DefaultTableModel(
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
        TableLibrosRecomendados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableLibrosRecomendadosMouseClicked(evt);
            }
        });
        ScrollLibros1.setViewportView(TableLibrosRecomendados);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Libros Disponibles");

        btnRecomendarLibros.setText("Recomendar Libros");
        btnRecomendarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecomendarLibrosActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Nombre");

        jtfNombreLibro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreLibro2ActionPerformed(evt);
            }
        });

        btnBuscar2.setText("Buscar");
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
            }
        });

        jLabel9.setText("ID Libro : ");

        lblIdlibro2.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(ScrollLibros1)
                        .addGap(138, 138, 138))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 120, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(250, 250, 250)
                                .addComponent(btnRecomendarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblIdlibro2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(38, 38, 38)
                                        .addComponent(jtfNombreLibro2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(239, 239, 239))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfNombreLibro2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblIdlibro2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(ScrollLibros1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRecomendarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        jTabbedPane1.addTab("Recomendaciones", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            lblIdlibro1.setText((String) modelo.getValueAt(fila, columna));

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
            lblIdlibro.setText((String) modelo.getValueAt(fila, columna));

        }
    }//GEN-LAST:event_jTableTusLibrosMouseClicked

    //JJ CAMBIAR EL BUSCADOR POR IDGENERO A UNO DE ODONTOLOGIA
    private void btnRecomendarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecomendarLibrosActionPerformed
        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();
        Statement s;
//        JOptionPane.showMessageDialog(this, "Prueba", "Soy el bibliotecario " + biblioDent.getUsuario() + " con id " + biblioDent.getIdBibliotecario() , WIDTH);
//        JOptionPane.showMessageDialog(this, "Prueba", "Soy el bibliotecario " + dent.getUsuario() + " con id " + dent.getId() , WIDTH);
        try {
            s = con.createStatement();
            ResultSet rs = s.executeQuery("select l.idlibro, l.titulo, l.nopaginas, l.año, g.nombre as genero\n"
                    + "from libro l, genero g\n"
                    + "where l.genero=g.idgenero\n"
                    + "and g.idgenero=19\n"
                    + "and l.idbibliotecario != " + biblioDent.getIdBibliotecario() + "; ");
            ResultSetMetaData rsmd = rs.getMetaData();
            int numeroColumnas = rsmd.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            this.TableLibrosRecomendados.setModel(modelo);
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

    private void TableLibrosRecomendadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableLibrosRecomendadosMouseClicked
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) TableLibrosRecomendados.getModel();
        int fila = TableLibrosRecomendados.rowAtPoint(evt.getPoint());
        int columna = 0;
        if ((fila > -1) && (columna > -1)) {
            lblIdlibro2.setText((String) modelo.getValueAt(fila, columna));

        }
    }//GEN-LAST:event_TableLibrosRecomendadosMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String nomLibro = jtfNombreLibro.getText().toString();

        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();
        Statement s;
        try {
            s = con.createStatement();
            ResultSet rs = s.executeQuery("select l.idlibro, l.titulo, l.nopaginas, l.año, g.nombre as genero\n"
                    + "from libro l, genero g\n"
                    + "where l.genero=g.idgenero\n"
                    + "and l.titulo like \"%" + nomLibro + "%\"\n"
                    + "and l.idbibliotecario != " + biblioDent.getIdBibliotecario() + "\n"
                    + "group by l.titulo;");
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
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        // TODO add your handling code here:
        iniciarTusLibros();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    //TABLA 2
    private void btnAgregarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLibroActionPerformed
        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();
        Statement s, sUpdate;
        try {
            s = con.createStatement();
            sUpdate = con.createStatement();
            sUpdate.executeUpdate("update libro\n"
                    + "set idbibliotecario='" + biblioDent.getIdBibliotecario() + "'\n"
                    + "where idlibro='" + lblIdlibro1.getText().toString() + "';");
            iniciarLibros();
            iniciarTusLibros();

            JOptionPane.showMessageDialog(this, "Se ha agregado el libro correctamente", "Confirmacion", WIDTH);

        } catch (SQLException ex) {
            Logger.getLogger(Pacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarLibroActionPerformed

    private void jtfNombreLibro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreLibro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreLibro1ActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:
        String nomLibro = jtfNombreLibro1.getText().toString();

        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();
        Statement s;
        try {
            s = con.createStatement();
            ResultSet rs = s.executeQuery("select l.idlibro, l.titulo, l.nopaginas, l.año, g.nombre as genero\n"
                    + "from libro l, genero g\n"
                    + "where l.genero=g.idgenero\n"
                    + "and l.titulo like \"%" + nomLibro + "%\"\n"
                    + "and l.idbibliotecario != " + biblioDent.getIdBibliotecario() + "\n"
                    + "group by l.titulo;");
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
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnRefrescar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescar1ActionPerformed
        // TODO add your handling code here:
        iniciarLibros();
    }//GEN-LAST:event_btnRefrescar1ActionPerformed

    private void jtfNombreLibro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreLibro2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreLibro2ActionPerformed

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
        String nomLibro = jtfNombreLibro2.getText().toString();

        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();
        Statement s;
        try {
            s = con.createStatement();
            ResultSet rs = s.executeQuery("select l.idlibro, l.titulo, l.nopaginas, l.año, g.nombre as genero\n"
                    + "from libro l, genero g\n"
                    + "where l.genero=g.idgenero\n"
                    + "and l.titulo like \"%" + nomLibro + "%\"\n"
                    + "and l.idbibliotecario != " + biblioDent.getIdBibliotecario() + "\n"
                    + "group by l.titulo;");
            ResultSetMetaData rsmd = rs.getMetaData();
            int numeroColumnas = rsmd.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            this.TableLibrosRecomendados.setModel(modelo);
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
    }//GEN-LAST:event_btnBuscar2ActionPerformed

    //BOTON PARA ELIMINAR LIBROS DE TABLA 1
    private void btnEliminarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLibroActionPerformed
        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();
        Statement s, sUpdate;
        try {
            s = con.createStatement();
            sUpdate = con.createStatement();
            sUpdate.executeUpdate("update libro\n"
                    + "set idbibliotecario='11'\n"
                    + "where idlibro='" + lblIdlibro.getText().toString() + "';");
            iniciarTusLibros();
            iniciarLibros();
            JOptionPane.showMessageDialog(this, "Se ha devuelto el libro correctamente", "Confirmacion", WIDTH);

        } catch (SQLException ex) {
            Logger.getLogger(Pacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarLibroActionPerformed

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
                new VerLibrosDentista(id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollLibros;
    private javax.swing.JScrollPane ScrollLibros1;
    private javax.swing.JTable TableLibrosRecomendados;
    private javax.swing.JTable TableLibrosSN;
    private javax.swing.JButton btnAgregarLibro;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnEliminarLibro;
    private javax.swing.JButton btnRecomendarLibros;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnRefrescar1;
    public javax.swing.JLabel jIdDent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableTusLibros;
    private javax.swing.JTextField jtfNombreLibro;
    private javax.swing.JTextField jtfNombreLibro1;
    private javax.swing.JTextField jtfNombreLibro2;
    private javax.swing.JLabel lblIdlibro;
    private javax.swing.JLabel lblIdlibro1;
    private javax.swing.JLabel lblIdlibro2;
    // End of variables declaration//GEN-END:variables
}
