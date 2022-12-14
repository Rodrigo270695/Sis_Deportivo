package com.deportivo.view.modal;

import com.deportivo.controller.*;
import com.deportivo.model.*;
import com.deportivo.view.FrmGestionarPartido;
import com.deportivo.vista.modal.alerts.*;
import java.util.List;

public final class ModalRegistrarPartido extends javax.swing.JInternalFrame {

    PartidoController partidoC = new PartidoController();
    JornadaController jornadaC = new JornadaController();
    EstadioController estadioC = new EstadioController();
    EtapaFixtureController etapaC = new EtapaFixtureController();
    CompetenciaController competenciaC = new CompetenciaController();
    TernaArbitralController ternaC = new TernaArbitralController();
    public static int idPartido = 0;
    public static boolean vista = false;

    public ModalRegistrarPartido() {
        initComponents();
        cargarCompetencias();
        cargarEstadios();
        cargarFixture();
        cargarJornadas();
        cargarTernas();
        acciones();
    }
    
    private void cargarEstadios(){
        
        cbxEstadio.removeAllItems();
        
        List<Estadio> lista = estadioC.listar();
        
        for (Estadio estadio : lista) {
            cbxEstadio.addItem(estadio.getNombreOficial());
        }
        
    }
    
    private void cargarCompetencias(){
        
        cbxCompetencia.removeAllItems();
        
        List<Competencia> lista = competenciaC.listar();
        
        for (Competencia competencia : lista) {
            cbxCompetencia.addItem(competencia.getNombre());
        }
        
    }
    
    private void cargarFixture(){
        
        cbxFixture.removeAllItems();
        
        List<EtapaFixture> lista = etapaC.listar();
        
        for (EtapaFixture ef : lista) {
            cbxFixture.addItem(ef.getDescripcion());
        }
        
    }
    
    private void cargarJornadas(){
        
        cbxJornada.removeAllItems();
        
        List<Jornada> lista = jornadaC.listar();
        
        for (Jornada jornada : lista) {
            cbxJornada.addItem(jornada.getNombre_jornada());
        }
        
    }
    
    private void cargarTernas(){
        
        cbxTernaArbitral.removeAllItems();
        
        List<TernaArbitral> lista = ternaC.listar();
        
        for (TernaArbitral ternaArbitral : lista) {
            cbxTernaArbitral.addItem(ternaArbitral.getNombre());
        }
        
    }

    void acciones() {

        if (vista) {

            txtHora.setEnabled(false);
            cbxCompetencia.setEnabled(false);
            cbxEstadio.setEnabled(false);
            cbxFixture.setEnabled(false);
            cbxJornada.setEnabled(false);
            cbxTernaArbitral.setEnabled(false);
            btnGrabar.setEnabled(false);

        }

        if (idPartido > 0) {

            Partido partido = (Partido) partidoC.obtenerdato(idPartido);

            txtHora.setText(""+partido.getHora());
            cbxCompetencia.setSelectedItem(partido.getCompetencia().getNombre());
            cbxEstadio.setSelectedItem(partido.getEstadio().getNombreOficial());
            cbxFixture.setSelectedItem(partido.getEtapaFixture().getDescripcion());
            cbxJornada.setSelectedItem(partido.getJornada().getNombre_jornada());
            cbxTernaArbitral.setSelectedItem(partido.getTernaArbitral().getNombre());

        }

    }

    void grabar() {

        Partido partido = new Partido();
        
        if (txtHora.getText().isEmpty() ) {
            Alerta alerta = new Alerta("Alerta", "El campo Hora es obligatorio");
            return;
        }

        partido.setHora(java.sql.Time.valueOf(txtHora.getText()));
        partido.setCompetencia((Competencia) competenciaC.obtenerdato(cbxCompetencia.getSelectedItem().toString()));
        partido.setEstadio((Estadio) estadioC.obtenerdato(cbxEstadio.getSelectedItem().toString()));
        partido.setEtapaFixture((EtapaFixture) etapaC.obtenerdato(cbxFixture.getSelectedItem().toString()));
        partido.setJornada((Jornada) jornadaC.obtenerdato(cbxJornada.getSelectedItem().toString()));
        partido.setTernaArbitral((TernaArbitral) ternaC.obtenerdato(cbxTernaArbitral.getSelectedItem().toString()));

        if (btnGrabar.getText().equalsIgnoreCase("Grabar")) {

            try {
                partidoC.registrar(partido);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente la Partido");
                FrmGestionarPartido.listar("");
                dispose();
            } catch (Exception e) {
                AlertaError err = new AlertaError("Error", e.getMessage());
            }

        } else {

            partido.setPartidoId(idPartido);

            try {
                partidoC.modificar(partido);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente el Partido");
                FrmGestionarPartido.listar("");
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
        btnGrabar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtHora = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxEstadio = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbxJornada = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbxCompetencia = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbxFixture = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbxTernaArbitral = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRAR JORNADA");
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
        jLabel3.setText("Hora");

        txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Estadio");

        cbxEstadio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Jornada");

        cbxJornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Competencia");

        cbxCompetencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Etapa Fixture");

        cbxFixture.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Terna Arbitral");

        cbxTernaArbitral.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxCompetencia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbxTernaArbitral, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxFixture, 0, 206, Short.MAX_VALUE))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtHora)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxEstadio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(24, 24, 24))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(7, 7, 7)
                        .addComponent(cbxJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(7, 7, 7)
                        .addComponent(cbxFixture, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(7, 7, 7)
                .addComponent(cbxCompetencia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(7, 7, 7)
                .addComponent(cbxTernaArbitral, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
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

        idPartido = 0;
        vista = false;

    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGrabar;
    private javax.swing.JComboBox<String> cbxCompetencia;
    private javax.swing.JComboBox<String> cbxEstadio;
    private javax.swing.JComboBox<String> cbxFixture;
    private javax.swing.JComboBox<String> cbxJornada;
    private javax.swing.JComboBox<String> cbxTernaArbitral;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txtHora;
    // End of variables declaration//GEN-END:variables
}
