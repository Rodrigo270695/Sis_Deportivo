package com.deportivo.view.modal;

import com.deportivo.controller.*;
import com.deportivo.model.*;
import com.deportivo.view.FrmGestionarArbitro;
import com.deportivo.vista.modal.alerts.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public final class ModalRegistrarArbitro extends javax.swing.JInternalFrame {

    ArbitroController arbitroC = new ArbitroController();

    FileInputStream fis;
    public static int idArbitro = 0;
    public static boolean vista = false;

    public ModalRegistrarArbitro() {
        initComponents();

        acciones();
    }

    void acciones() {

        if (vista) {

            txtNombre.setEnabled(false);
            btnGrabar.setEnabled(false);

        }

        if (idArbitro > 0) {

            Arbitro arbitro = (Arbitro) arbitroC.obtenerdato(idArbitro);

            txtNombre.setText(arbitro.getNombreCompleto());

        }

    }

    void grabar() {

        
        Arbitro arbitro = new Arbitro();

        if (txtNombre.getText().length() == 0) {
            Alerta alerta = new Alerta("Alerta", "El campo NOMBRE es obligatorio");
            return;
        }

        if (btnGrabar.getText().equalsIgnoreCase("Grabar")) {

            arbitro.setNombreCompleto(txtNombre.getText().toUpperCase());

            try {
                arbitroC.registrar(arbitro);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente el arbitro");
                FrmGestionarArbitro.listar("");
                dispose();
            } catch (Exception e) {
                AlertaError err = new AlertaError("Error", e.getMessage());
            }

        } else {

            arbitro.setNombreCompleto(txtNombre.getText().toUpperCase());

            arbitro.setArbitroId(idArbitro);

            try {
                arbitroC.modificar(arbitro);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente el arbitro");
                FrmGestionarArbitro.listar("");
                dispose();
            } catch (Exception e) {
                AlertaError err = new AlertaError("Error", e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new org.edisoncor.gui.textField.TextFieldRectBackground();
        btnGrabar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Arbitro");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(223, 235, 254));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Nombre Completo* ");

        txtNombre.setDescripcion("Ej. Perú");
        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnGrabar.setBackground(new java.awt.Color(27, 118, 253));
        btnGrabar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnGrabar.setForeground(new java.awt.Color(255, 255, 255));
        btnGrabar.setMnemonic('N');
        btnGrabar.setText("Grabar");
        btnGrabar.setToolTipText("Realizar Nuevo Registro");
        btnGrabar.setBorder(null);
        btnGrabar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed

        grabar();

    }//GEN-LAST:event_btnGrabarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed

        idArbitro = 0;
        vista = false;

    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGrabar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombre;
    // End of variables declaration//GEN-END:variables
}
