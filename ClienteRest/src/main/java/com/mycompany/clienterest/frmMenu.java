/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.clienterest;

import Entidades.Alumno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ws.ClienteAlumnos;

/**
 *
 * @author Marcos T.
 */
public class frmMenu extends javax.swing.JFrame {

    /**
     * Creates new form frmMenu
     */
    ClienteAlumnos cliente = new ClienteAlumnos();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    Alumno[] listaAlumnos;

    public frmMenu() {
        initComponents();
        consultarTodos();
    }

    public void consultarTodos() {
        modeloTabla.setRowCount(0);
        modeloTabla.setColumnCount(0);
        tblAlumnos.setModel(modeloTabla);
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        listaAlumnos = cliente.getJson(Alumno[].class);
        for (Alumno alumno : listaAlumnos) {
            Object[] fila = {alumno.getId(), alumno.getNombre()};
            modeloTabla.addRow(fila);
        }
        tblAlumnos.repaint();
    }

    public void consultarPorID(int idBuscado) {

        modeloTabla.setRowCount(0);
        modeloTabla.setColumnCount(0);
        tblAlumnos.setModel(modeloTabla);
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        Alumno alumno = cliente.getById(Alumno.class, String.valueOf(idBuscado));

        Object[] fila = {alumno.getId(), alumno.getNombre()};
        modeloTabla.addRow(fila);
        System.out.println("Se ha encontrado el alumno del id " + alumno.getId());

        tblAlumnos.repaint();
    }
    
    public void consultarPorNombre(String nombre) {

        modeloTabla.setRowCount(0);
        modeloTabla.setColumnCount(0);
        tblAlumnos.setModel(modeloTabla);
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        Alumno alumno = cliente.getUsuariosQuery(Alumno.class,null, String.valueOf(nombre));

        Object[] fila = {alumno.getId(), alumno.getNombre()};
        modeloTabla.addRow(fila);
        System.out.println("Se ha encontrado el alumno con el nombre " + alumno.getNombre());

        tblAlumnos.repaint();
    }

    public void eliminarPorId(int idAlumno) {
        
       Alumno alumno= cliente.deleteAlumno(String.valueOf(idAlumno), Alumno.class);
        if (alumno!=null) {
             JOptionPane.showMessageDialog(null, "Eliminado", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
       
        }else{
             JOptionPane.showMessageDialog(null, "No se encontró ningún alumno con el ID proporcionado.", "No encontrado", JOptionPane.INFORMATION_MESSAGE);
       
        }
        
        consultarTodos();
    }
    
    public void actualizar(int idAlumno) {
       String nombreNuevo = JOptionPane.showInputDialog("Ingrese el nombre nuevo del alumno:");
            
            if (nombreNuevo != null && !nombreNuevo.isEmpty()) { // Corrección aquí
                 Alumno alumnoNuevo = new Alumno(idAlumno, nombreNuevo);
                 cliente.actualizarAlumno(alumnoNuevo);
                System.out.println("Se ha actualizado el alumno con ID: " + idAlumno);
            } else {
                System.out.println("La actualización del alumno con ID: " + idAlumno + " ha sido cancelada.");
            }
            
    }
    
    public void insertar(Alumno nuevoAlumno) {
        
        if (nuevoAlumno!=null) {
             cliente.addAlumno(nuevoAlumno);
             JOptionPane.showMessageDialog(null, "Insertado", "Insertado", JOptionPane.INFORMATION_MESSAGE);
       
        }else{
             JOptionPane.showMessageDialog(null, "No se encontró ningún alumno con el ID proporcionado.", "No encontrado", JOptionPane.INFORMATION_MESSAGE);
       
        }
        
        consultarTodos();
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        btnConsultarID = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEliminar = new javax.swing.JTextField();
        btnEliminarID = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnNombre = new javax.swing.JButton();
        lblInsertar = new javax.swing.JLabel();
        txtInsertar = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        lblActualizar = new javax.swing.JLabel();
        txtActualizar = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblAlumnos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAlumnos);

        btnConsultarID.setBackground(new java.awt.Color(204, 255, 204));
        btnConsultarID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConsultarID.setText("Consultar");
        btnConsultarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarIDActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Consultar por ID:");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jackblack.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Eliminar por ID:");

        txtEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEliminarActionPerformed(evt);
            }
        });

        btnEliminarID.setBackground(new java.awt.Color(204, 255, 204));
        btnEliminarID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarID.setText("Eliminar");
        btnEliminarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarIDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Consultar por nombre:");

        btnNombre.setBackground(new java.awt.Color(204, 255, 204));
        btnNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNombre.setText("Consultar");
        btnNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNombreActionPerformed(evt);
            }
        });

        lblInsertar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblInsertar.setText("Insertar:");

        txtInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInsertarActionPerformed(evt);
            }
        });

        btnInsertar.setBackground(new java.awt.Color(204, 255, 204));
        btnInsertar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        lblActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblActualizar.setText("Actualizar:");

        txtActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActualizarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(204, 255, 204));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminarID))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblInsertar)
                                        .addGap(61, 61, 61)
                                        .addComponent(jLabel5)
                                        .addGap(39, 39, 39)
                                        .addComponent(txtInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblActualizar)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnActualizar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnInsertar)
                                .addGap(79, 79, 79))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConsultarID)
                                .addGap(258, 258, 258))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(btnNombre)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarID)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNombre))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 109, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarID))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblInsertar)
                            .addComponent(txtInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInsertar)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblActualizar)
                            .addComponent(txtActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarIDActionPerformed
        // TODO add your handling code here:
        String idTexto = txtID.getText();

        if (idTexto.isEmpty() || !idTexto.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido (números enteros).", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si la validación falla
        }

        int idBuscado = Integer.parseInt(idTexto);
        boolean encontrado = false;

        for (Alumno alumno : listaAlumnos) {
            if (alumno.getId() == idBuscado) {
                consultarPorID(idBuscado);
                encontrado = true;
                break;
            }
        }

        // Si el alumno no se encuentra, mostrar un mensaje al usuario
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún alumno con el ID proporcionado.", "No encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultarIDActionPerformed

    private void btnEliminarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarIDActionPerformed
        String idTexto = txtEliminar.getText();
        System.out.println(idTexto);
        int idEliminar = Integer.parseInt(idTexto);
        eliminarPorId(idEliminar);

        // Si el alumno no se encuentra, mostrar un mensaje al usuario

    }//GEN-LAST:event_btnEliminarIDActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEliminarActionPerformed

    private void btnNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNombreActionPerformed
        // TODO add your handling code here:
        String nombre = txtNombre.getText();

        if (nombre.isEmpty() || !nombre.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si la validación falla
        }

        
        boolean encontrado = false;

        for (Alumno alumno : listaAlumnos) {
            if (alumno.getNombre() == nombre) {
                consultarPorNombre(nombre);
                encontrado = true;
                break;
            }
        }

        // Si el alumno no se encuentra, mostrar un mensaje al usuario
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún alumno con el nombre proporcionado.", "No encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnNombreActionPerformed

    private void txtInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInsertarActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtInsertarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        // TODO add your handling code here:
        
        String nombre = txtNombre.getText();

        if(nombre.isEmpty() || !nombre.matches("\\d+")){
            Alumno alumnoNuevo = new Alumno(listaAlumnos.length+1,txtInsertar.getText());
            insertar(alumnoNuevo);
        }
        
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void txtActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActualizarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        String idTexto = txtActualizar.getText();
        int idActualizar = Integer.parseInt(idTexto);
        actualizar(idActualizar);
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(frmMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnConsultarID;
    private javax.swing.JButton btnEliminarID;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblActualizar;
    private javax.swing.JLabel lblInsertar;
    private javax.swing.JTable tblAlumnos;
    private javax.swing.JTextField txtActualizar;
    private javax.swing.JTextField txtEliminar;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtInsertar;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
