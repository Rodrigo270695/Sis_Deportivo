package com.deportivo.view.modal;

import com.deportivo.controller.ContinenteController;
import com.deportivo.controller.DetalleProfesionalController;
import com.deportivo.controller.PaisController;
import com.deportivo.controller.ProfesionalController;
import com.deportivo.controller.TipoProfesionalController;
import com.deportivo.model.Continente;
import com.deportivo.model.DetalleProfesional;
import com.deportivo.model.Pais;
import com.deportivo.model.Profesional;
import com.deportivo.model.TipoProfesional;
import com.deportivo.view.FrmGestionarPais;
import com.deportivo.vista.modal.alerts.*;
import java.awt.Toolkit;
import java.util.List;

public final class ModalRegistrarDetalleProfesional extends javax.swing.JInternalFrame {

    DetalleProfesionalController detalleC = new DetalleProfesionalController();
    ProfesionalController profesionalC = new ProfesionalController();
    TipoProfesionalController tipoC = new TipoProfesionalController();

    public static int idDetalle = 0;
    public static boolean vista = false;

    public ModalRegistrarDetalleProfesional() {
        initComponents();
        cargarProfesionales();
        cargarTipoProfesionales();
        acciones();
    }

    void cargarProfesionales() {

        cbxProfesional.removeAllItems();
        List<Profesional> lista = profesionalC.listar();

        for (Profesional profesional : lista) {
            cbxProfesional.addItem(profesional.getNombre_completo());
        }

    }

    void cargarTipoProfesionales() {

        cbxTipo.removeAllItems();
        List<TipoProfesional> lista = tipoC.listar();

        for (TipoProfesional tipoPro : lista) {
            cbxTipo.addItem(tipoPro.getNombre());
        }

    }

    void acciones() {

        if (vista) {

            cbxProfesional.setEnabled(false);
            cbxTipo.setEnabled(false);
            btnGrabar.setEnabled(false);

        }

        if (idDetalle > 0) {

            DetalleProfesional detalle = (DetalleProfesional) detalleC.obtenerdato(idDetalle);

            cbxProfesional.setSelectedItem(detalle.getProfesional().getNombre_completo());
            cbxTipo.setSelectedItem(detalle.getTipoProfesional().getNombre());

        }

    }

    void grabar() {

        if (cbxProfesional.getSelectedItem()== null || cbxTipo.getSelectedItem()==null) {
            Alerta alerta = new Alerta("Alerta", "El campo PROFESIONAL Y TIPO  es obligatorio");
            return;
        }

        if (btnGrabar.getText().equalsIgnoreCase("Grabar")) {

            DetalleProfesional detalle = new DetalleProfesional();
        
            detalle.setProfesional((Profesional) detalleC.obtenerdato(cbxProfesional.getSelectedIndex()));
            detalle.setTipoProfesional((TipoProfesional) detalleC.obtenerdato(cbxTipo.getSelectedIndex()));

            try {
                detalleC.registrar(detalle);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente el detaelle de profesional");
                FrmGestionarPais.listar("");
                dispose();
            } catch (Exception e) {
                AlertaError err = new AlertaError("Error", e.getMessage());
            }

        } else {

            DetalleProfesional detalle = new DetalleProfesional();
    
            detalle.setProfesional((Profesional) detalleC.obtenerdato(cbxProfesional.getSelectedIndex()));
            detalle.setTipoProfesional((TipoProfesional) detalleC.obtenerdato(cbxTipo.getSelectedIndex()));
            

            try {
                detalleC.modificar(detalle);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente el detalle de profesional");
                FrmGestionarPais.listar("");
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
        jLabel2 = new javax.swing.JLabel();
        btnGrabar = new javax.swing.JButton();
        cbxProfesional = new javax.swing.JComboBox<>();
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

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Profesional *");

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

        cbxProfesional.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxProfesional.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxProfesional, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProfesional, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
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

        idDetalle = 0;
        vista = false;

    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGrabar;
    private javax.swing.JComboBox<String> cbxProfesional;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}