package com.deportivo.view.modal;


import com.deportivo.controller.DetalleEquipoController;
import com.deportivo.controller.FutbolistaController;
import com.deportivo.controller.PosicionController;
import com.deportivo.model.Futbolista;
import com.deportivo.model.Posicion;
import com.deportivo.view.FrmGestionarDetalleEquipo;
import com.deportivo.view.FrmGestionarDetallePartido;
import com.deportivo.vista.modal.alerts.*;
import java.util.List;

public final class ModalRegistrarDetalleEquipo extends javax.swing.JInternalFrame {

    FutbolistaController futbolistaC = new FutbolistaController();
    PosicionController posicionC = new PosicionController();
    DetalleEquipoController detalleC = new DetalleEquipoController();

    public static int idEquipo;

    public ModalRegistrarDetalleEquipo() {
        initComponents();
        cargarFutbolistas();
        cargarPosiciones();
    }

    private void cargarFutbolistas() {
        
        cbxFutbolista.removeAllItems();

        List<Futbolista> lista = futbolistaC.listar();

        for (Futbolista futbolista : lista) {
            cbxFutbolista.addItem(futbolista.getNombreCompleto());
        }
        
    }

    private void cargarPosiciones() {
    
        cbxPosicion.removeAllItems();
        
        List<Posicion> lista = posicionC.listar();

        for (Posicion posicion : lista) {
            cbxPosicion.addItem(posicion.getDescripcion());
        }
    }

    void grabar() {

        Futbolista futbolista = (Futbolista) futbolistaC.obtenerdato(cbxFutbolista.getSelectedItem().toString());
        Posicion posicion = (Posicion) posicionC.obtenerdato(cbxPosicion.getSelectedItem().toString());

        try {
            detalleC.registrarDetalle(idEquipo, futbolista.getFutbolistaId(), posicion.getPosicionId());
            FrmGestionarDetalleEquipo.listar("");
            AlertaBien bien = new AlertaBien("MENSAJE", "Se agregó correctamente el futbolista al equipo");
            dispose();

        } catch (Exception e) {
            e.printStackTrace(System.err);
            AlertaError error = new AlertaError("Error", e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnGrabar = new javax.swing.JButton();
        cbxFutbolista = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxPosicion = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRAR JUGADOR");
        setToolTipText("");
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
        jLabel2.setText("Futbolista");

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

        cbxFutbolista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Posición");

        cbxPosicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFutbolista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(204, 204, 204)))
                    .addComponent(cbxPosicion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxFutbolista, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
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

        idEquipo = 0;

    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGrabar;
    private javax.swing.JComboBox<String> cbxFutbolista;
    private javax.swing.JComboBox<String> cbxPosicion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
