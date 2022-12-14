package com.deportivo.view.modal;

import com.deportivo.controller.DetalleTernaArbitralController;
import com.deportivo.controller.TernaArbitralController;
import com.deportivo.controller.TipoTernaArbitralController;
import com.deportivo.model.TipoTernaArbitral;
import com.deportivo.view.FrmGestionarDetalleTernaArbitral;
import com.deportivo.vista.modal.alerts.*;
import java.awt.Toolkit;
import java.util.List;

public final class ModalRegistrarDetalleTernaArbitral extends javax.swing.JInternalFrame {

    DetalleTernaArbitralController detalleC = new DetalleTernaArbitralController();
    TernaArbitralController profesionalC = new TernaArbitralController();
    TipoTernaArbitralController tipoC = new TipoTernaArbitralController();

    public static int idProfesional;

    public ModalRegistrarDetalleTernaArbitral() {
        initComponents();
        cargarTipoProfesionales();
    }

    void cargarTipoProfesionales() {

        cbxTipo.removeAllItems();
        List<TipoTernaArbitral> lista = tipoC.listar();

        for (TipoTernaArbitral tipoPro : lista) {
            cbxTipo.addItem(tipoPro.getDescripcion());
        }

    }

    void grabar() {

        TipoTernaArbitral tipoP = (TipoTernaArbitral) tipoC.obtenerdato(cbxTipo.getSelectedItem().toString());

        try {
            detalleC.registrarDetalle(idProfesional, tipoP.getTipo_terna_arbitral_id());
            AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente el detaelle de terna arbitral");
            FrmGestionarDetalleTernaArbitral.listar("");
            dispose();
        } catch (Exception e) {
            AlertaError err = new AlertaError("Error", e.getMessage());
        }

    }
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnGrabar = new javax.swing.JButton();
        cbxTipo = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRAR DETALLE PROFESIONAL");
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

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Tipo Profesional*");

        btnGrabar.setBackground(new java.awt.Color(27, 118, 253));
        btnGrabar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnGrabar.setForeground(new java.awt.Color(255, 255, 255));
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/grabar25.png"))); // NOI18N
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

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
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

        idProfesional = 0;

    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGrabar;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
