package com.deportivo.view.modal;

import com.deportivo.controller.CompetenciaController;
import com.deportivo.controller.FixtureController;
import com.deportivo.model.*;
import com.deportivo.view.FrmGestionarCompetencia;
import com.deportivo.vista.modal.alerts.Alerta;
import com.deportivo.vista.modal.alerts.AlertaBien;
import com.deportivo.vista.modal.alerts.AlertaError;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.List;

public final class ModalRegistrarCompetencia extends javax.swing.JInternalFrame {

    FixtureController fixtureC = new FixtureController();
    CompetenciaController competenciaC = new CompetenciaController();
    public static int idCompetencia = 0;
    public static boolean vista = false;

    public ModalRegistrarCompetencia() {
        initComponents();
        cargarFixtures();
        acciones();
    }
    
    private void cargarFixtures(){
        
        cbxFixture.removeAllItems();
        
        List<Fixture> lista = fixtureC.listar();
        
        for (Fixture fixture : lista) {
            cbxFixture.addItem(fixture.getNombre());
        }
        
    }

    //Para el boton de ver
    void acciones() {

        if (vista) {

            txtNombre.setEnabled(false);
            txtFechaFin.setEnabled(false);
            txtFechaInicio.setEnabled(false);
            btnGrabar.setEnabled(false);
            cbxFixture.setEnabled(false);

        }

        if (idCompetencia > 0) {

            Competencia competencia = (Competencia) competenciaC.obtenerdato(idCompetencia);
            txtNombre.setText(competencia.getNombre());
            txtFechaFin.setDate(competencia.getFechaFin());
            txtFechaInicio.setDate(competencia.getFechaInicio());
            cbxFixture.setSelectedItem(competencia.getFixture().getNombre());

        }

    }

    void grabar() {

        try {
            if (txtNombre.getText().length() == 0 | txtFechaFin.getDate().toString().length() == 0 | txtFechaInicio.getDate().toString().length() == 0) {
                Alerta alerta = new Alerta("Alerta", "Los Campos son obligatorios");
                return;
            }

        } catch (NullPointerException e) {
            Alerta alerta = new Alerta("Alerta", "Los Campos son obligatorios");
        }

        Calendar cal, cal2;
        int d, m, a, d2, m2, a2;
        String fecha1, fecha2;
        Competencia competencia = new Competencia();

        cal = txtFechaFin.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH) + 1;
        a = cal.get(Calendar.YEAR);

        cal2 = txtFechaInicio.getCalendar();
        d2 = cal2.get(Calendar.DAY_OF_MONTH);
        m2 = cal2.get(Calendar.MONTH) + 1;
        a2 = cal2.get(Calendar.YEAR);

        fecha1 = String.valueOf(a) + "-" + String.valueOf(m) + "-" + String.valueOf(d);
        fecha2 = String.valueOf(a2) + "-" + String.valueOf(m2) + "-" + String.valueOf(d2);
        competencia.setNombre(txtNombre.getText().toUpperCase());
        competencia.setFechaFin((java.sql.Date.valueOf(fecha1)));
        competencia.setFechaInicio((java.sql.Date.valueOf(fecha2)));
        competencia.setFixture((Fixture) fixtureC.obtenerdato(cbxFixture.getSelectedItem().toString()));

        if (btnGrabar.getText().equalsIgnoreCase("Grabar")) {

            try {
                competenciaC.registrar(competencia);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente la competencia");
                FrmGestionarCompetencia.listar("");
                dispose();
            } catch (Exception e) {
                AlertaError err = new AlertaError("Error", e.getMessage());
            }

        } else {

            competencia.setCompetenciaId(idCompetencia);

            try {
                competenciaC.modificar(competencia);
                AlertaBien bien = new AlertaBien("Mensaje", "Se modificó correctamente la Competencia");
                FrmGestionarCompetencia.listar("");
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
        jLabel2 = new javax.swing.JLabel();
        txtFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txtFechaFin = new com.toedter.calendar.JDateChooser();
        Fixture = new javax.swing.JLabel();
        cbxFixture = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Competencia");
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
        jLabel1.setText("Nombre*");

        txtNombre.setDescripcion("Ej. Z");
        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

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

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Fecha Inicio");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Fecha Fin");

        Fixture.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Fixture.setForeground(new java.awt.Color(102, 102, 102));
        Fixture.setText("Fixture");

        cbxFixture.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Fixture, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFixture, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Fixture)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxFixture, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
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

        idCompetencia = 0;
        vista = false;

    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fixture;
    public static javax.swing.JButton btnGrabar;
    private javax.swing.JComboBox<String> cbxFixture;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser txtFechaFin;
    private com.toedter.calendar.JDateChooser txtFechaInicio;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombre;
    // End of variables declaration//GEN-END:variables
}
