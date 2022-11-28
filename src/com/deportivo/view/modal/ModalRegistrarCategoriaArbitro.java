package com.deportivo.view.modal;

import com.deportivo.controller.CategoriaArbitroController;
import com.deportivo.controller.TipoTernaArbitralController;
import com.deportivo.model.CategoriaArbitro;
import com.deportivo.model.TipoTernaArbitral;
import com.deportivo.view.FrmGestionarCategoriaArbitro;
import com.deportivo.vista.modal.alerts.*;
import java.util.List;

public final class ModalRegistrarCategoriaArbitro extends javax.swing.JInternalFrame {

    CategoriaArbitroController categoriaArbitroC = new CategoriaArbitroController();
    TipoTernaArbitralController tipoTernaArbitralC = new TipoTernaArbitralController();
    public static int idCategoriaArbitro = 0;
    public static boolean vista = false;

    public ModalRegistrarCategoriaArbitro() {
        initComponents();
        cargarTiposTernaArbitral();
        acciones();
    }

    void cargarTiposTernaArbitral() {

        cbxTipoTA.removeAllItems();
        List<TipoTernaArbitral> lista = tipoTernaArbitralC.listar();

        for (TipoTernaArbitral tipoTernaArbitral : lista) {
            cbxTipoTA.addItem(tipoTernaArbitral.getDescripcion());
        }

    }

    void acciones() {

        if (vista) {

            txtNombre.setEnabled(false);
            txtSigla.setEnabled(false);
            cbxTipoTA.setEnabled(false);
            btnGrabar.setEnabled(false);
        }

        if (idCategoriaArbitro > 0) {

            CategoriaArbitro categoriaArbitro = (CategoriaArbitro) categoriaArbitroC.obtenerdato(idCategoriaArbitro);
            cbxTipoTA.setSelectedItem(categoriaArbitro.getTipoTA().getDescripcion());
            txtNombre.setText(categoriaArbitro.getNombre());
            txtSigla.setText(categoriaArbitro.getSigla());

        }

    }

    void grabar() {

        if (txtNombre.getText().length() == 0) {
            Alerta alerta = new Alerta("Alerta", "El campo NOMBRE COMPLETO es obligatorio");
            return;
        }

        if (btnGrabar.getText().equalsIgnoreCase("Grabar")) {

            CategoriaArbitro categoriaArbitro = new CategoriaArbitro();
            categoriaArbitro.setNombre(txtNombre.getText().toUpperCase());
            categoriaArbitro.setSigla(txtSigla.getText().toUpperCase());
            categoriaArbitro.setTipoTA((TipoTernaArbitral) tipoTernaArbitralC.obtenerdato(cbxTipoTA.getSelectedItem().toString()));

            try {
                categoriaArbitroC.registrar(categoriaArbitro);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente la Categoría de Árbitro");
                FrmGestionarCategoriaArbitro.listar("");
                dispose();
            } catch (Exception e) {
                AlertaError err = new AlertaError("Error", e.getMessage());
            }

        } else {

            CategoriaArbitro categoriaArbitro = new CategoriaArbitro();
            categoriaArbitro.setNombre(txtNombre.getText().toUpperCase());
            categoriaArbitro.setSigla(txtSigla.getText().toUpperCase());
            categoriaArbitro.setTipoTA((TipoTernaArbitral) tipoTernaArbitralC.obtenerdato(cbxTipoTA.getSelectedItem().toString()));
            categoriaArbitro.setCategoria_arbitro_id(idCategoriaArbitro);

            try {
                categoriaArbitroC.modificar(categoriaArbitro);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente la Categoría de Árbitro");
                FrmGestionarCategoriaArbitro.listar("");
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
        jLabel3 = new javax.swing.JLabel();
        cbxTipoTA = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtSigla = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRAR CATEGORÍA DE ÁRBITRO");
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
        jLabel1.setText("Nombre* ");

        txtNombre.setDescripcion("");
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

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Sigla");

        cbxTipoTA.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxTipoTA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Tipo de Terna Arbitral");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTipoTA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cbxTipoTA, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
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

        idCategoriaArbitro = 0;
        vista = false;

    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGrabar;
    private javax.swing.JComboBox<String> cbxTipoTA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombre;
    private javax.swing.JTextField txtSigla;
    // End of variables declaration//GEN-END:variables
}
