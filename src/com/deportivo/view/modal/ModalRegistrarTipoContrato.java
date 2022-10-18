package com.deportivo.view.modal;

import com.deportivo.controller.TipoContratoController;
import com.deportivo.model.TipoContrato;
import com.deportivo.view.FrmGestionarTipoContrato;
import com.deportivo.vista.modal.alerts.Alerta;
import com.deportivo.vista.modal.alerts.AlertaBien;
import com.deportivo.vista.modal.alerts.AlertaError;
import java.awt.Toolkit;

public final class ModalRegistrarTipoContrato extends javax.swing.JInternalFrame {

    TipoContratoController tipoContratoC = new TipoContratoController();
    public static int idTipoContrato = 0;
    public static boolean vista = false;

    public ModalRegistrarTipoContrato() {
        initComponents();
        acciones();
    }
    
    //Para el boton de ver
    void acciones() {

        if (vista) {

            txtDescripcion.setEnabled(false);
            btnGrabar.setEnabled(false);

        }

        if (idTipoContrato > 0) {

            TipoContrato tipoContrato = (TipoContrato) tipoContratoC.obtenerdato(idTipoContrato);
            txtDescripcion.setText(tipoContrato.getDescripcion());

        }

    }

    void grabar() {

        if (txtDescripcion.getText().length() == 0) {
            Alerta alerta = new Alerta("Alerta", "El campo DESCRIPCIÓN es obligatorio");
            return;
        }

        if (btnGrabar.getText().equalsIgnoreCase("Grabar")) {

            TipoContrato tipoContrato = new TipoContrato();
            tipoContrato.setDescripcion(txtDescripcion.getText().toUpperCase());

            try {
                tipoContratoC.registrar(tipoContrato);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente el tipoContrato");
                FrmGestionarTipoContrato.listar("");
                dispose();
            } catch (Exception e) {
                AlertaError err = new AlertaError("Error", e.getMessage());
            }

        }else{
            
            TipoContrato tipoContrato = new TipoContrato();
            tipoContrato.setDescripcion(txtDescripcion.getText().toUpperCase());
            tipoContrato.setTipoContratoId(idTipoContrato);

            try {
                tipoContratoC.modificar(tipoContrato);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente el tipo de Contrato");
                FrmGestionarTipoContrato.listar("");
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
        txtDescripcion = new org.edisoncor.gui.textField.TextFieldRectBackground();
        btnGrabar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Tipo de Contrato");
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

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Descripción*");

        txtDescripcion.setDescripcion("Ej. Europa");
        txtDescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnGrabar.setForeground(new java.awt.Color(51, 51, 51));
        btnGrabar.setMnemonic('N');
        btnGrabar.setText("Grabar");
        btnGrabar.setToolTipText("Realizar Nuevo Registro");
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
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        
        idTipoContrato = 0;
        vista = false;
        
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGrabar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
