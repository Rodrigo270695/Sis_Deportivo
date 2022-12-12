package com.deportivo.view.modal;

import com.deportivo.controller.ConfederacionController;
import com.deportivo.model.Confederacion;
import com.deportivo.view.FrmGestionarConfederacion;
import com.deportivo.vista.modal.alerts.Alerta;
import com.deportivo.vista.modal.alerts.AlertaBien;
import com.deportivo.vista.modal.alerts.AlertaError;
import java.awt.Toolkit;
import java.util.Calendar;

public final class ModalRegistrarConfederacion extends javax.swing.JInternalFrame {

    ConfederacionController confederacionC = new ConfederacionController();
    public static int idConfederacion = 0;
    public static boolean vista = false;

    public ModalRegistrarConfederacion() {
        initComponents();
        acciones();
    }

    void acciones() {

        if (vista) {

            txtAcronimo.setEnabled(false);
            txtNombre.setEnabled(false);
            btnGrabar.setEnabled(false);
            txtFechaFundacion.setEnabled(false);
            txtFederaciones.setEnabled(false);
            txtUbicacion.setEnabled(false);
            txtSede.setEnabled(false);

        }

        if (idConfederacion > 0) {

            Confederacion confederacion = (Confederacion) confederacionC.obtenerdato(idConfederacion);
            txtAcronimo.setText(confederacion.getAcronimo());
            txtNombre.setText(confederacion.getNombre_oficial());
            txtFechaFundacion.setDate(confederacion.getFecha_fundacion());
            txtFederaciones.setText(String.valueOf(confederacion.getNumero_federaciones_afiliadas()));
            txtUbicacion.setText(confederacion.getUbicaicon());
            txtSede.setText(confederacion.getSede());

        }

    }

    void grabar() {

        Calendar cal;
        int d, m, a;
        String fecha1;

        cal = txtFechaFundacion.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH) + 1;
        a = cal.get(Calendar.YEAR);
        fecha1 = String.valueOf(a) + "-" + String.valueOf(m) + "-" + String.valueOf(d);

        if (txtNombre.getText().length() == 0 &&  txtAcronimo.getText().length() == 0 ) {
            Alerta alerta = new Alerta("Alerta", "El campo NOMBRE y ACRÓNIMO debe ser obligatorios");
            return;
        }

      
        if (btnGrabar.getText().equalsIgnoreCase("Grabar")) {

            Confederacion confederacion = new Confederacion();
            confederacion.setNombre_oficial(txtNombre.getText().toUpperCase());
            confederacion.setAcronimo(txtAcronimo.getText().toUpperCase());
            confederacion.setUbicaicon(txtUbicacion.getText().toUpperCase());
            confederacion.setSede(txtSede.getText().toUpperCase());
            confederacion.setFecha_fundacion((java.sql.Date.valueOf(fecha1)));
            confederacion.setNumero_federaciones_afiliadas(Integer.valueOf(txtFederaciones.getText()));

            try {
                confederacionC.registrar(confederacion);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente la confederacion");
                FrmGestionarConfederacion.listar("");
                dispose();
            } catch (Exception e) {
                AlertaError err = new AlertaError("Error", e.getMessage());
            }

        } else {

            Confederacion confederacion = new Confederacion();
            confederacion.setNombre_oficial(txtNombre.getText().toUpperCase());
            confederacion.setAcronimo(txtAcronimo.getText().toUpperCase());
            confederacion.setUbicaicon(txtUbicacion.getText().toUpperCase());
            confederacion.setSede(txtSede.getText().toUpperCase());
            confederacion.setFecha_fundacion((java.sql.Date.valueOf(fecha1)));
            confederacion.setNumero_federaciones_afiliadas(Integer.valueOf(txtFederaciones.getText().toUpperCase()));
            confederacion.setConfederacion_id((int) idConfederacion);

            try {
                confederacionC.modificar(confederacion);
                AlertaBien bien = new AlertaBien("Mensaje", "Se modificó correctamente la confederacion");
                FrmGestionarConfederacion.listar("");
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
        jLabel2 = new javax.swing.JLabel();
        txtAcronimo = new org.edisoncor.gui.textField.TextFieldRectBackground();
        btnGrabar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtUbicacion = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel4 = new javax.swing.JLabel();
        txtSede = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel5 = new javax.swing.JLabel();
        txtFederaciones = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel6 = new javax.swing.JLabel();
        txtFechaFundacion = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRAR CONFEDERACIÓN");
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
        jLabel1.setText("Nombre Oficial* ");

        txtNombre.setDescripcion("Ej. CONFEDERACIÓN ASIÁTICA DE FÚTBOL");
        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Acrónimo");

        txtAcronimo.setDescripcion("Ej. AFC");
        txtAcronimo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAcronimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAcronimoKeyTyped(evt);
            }
        });

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

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Ubicación");

        txtUbicacion.setDescripcion("");
        txtUbicacion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Sede");

        txtSede.setDescripcion("");
        txtSede.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSede.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSedeKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Número Federaciones");

        txtFederaciones.setDescripcion("");
        txtFederaciones.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Fecha Fundación");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAcronimo, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSede, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFederaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtFechaFundacion, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(297, 297, 297)
                            .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAcronimo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFederaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSede, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFechaFundacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
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

        idConfederacion = 0;
        vista = false;

    }//GEN-LAST:event_formInternalFrameClosed

    private void txtAcronimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAcronimoKeyTyped

        if (txtAcronimo.getText().length() >= 10) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            Alerta alerta = new Alerta("ALERTA", "Solo acepta 10 caracteres");
        }

    }//GEN-LAST:event_txtAcronimoKeyTyped

    private void txtSedeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSedeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSedeKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGrabar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtAcronimo;
    private com.toedter.calendar.JDateChooser txtFechaFundacion;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtFederaciones;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombre;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtSede;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
