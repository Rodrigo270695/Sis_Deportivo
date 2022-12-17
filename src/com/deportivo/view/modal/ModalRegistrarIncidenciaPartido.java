package com.deportivo.view.modal;

import com.deportivo.controller.DetallePartidoController;
import com.deportivo.controller.IncidenciaPartidoController;
import com.deportivo.model.DetallePartido;
import com.deportivo.model.IncidenciaPartido;
import com.deportivo.properties.RenderTable;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public final class ModalRegistrarIncidenciaPartido extends javax.swing.JInternalFrame {

    DetallePartidoController detallePC = new DetallePartidoController();
    IncidenciaPartidoController incidenciaC = new IncidenciaPartidoController();
    public static int idPartido;

    public ModalRegistrarIncidenciaPartido() {
        initComponents();
        listar();
    }

    void grabar() {

    }

    public void listar() {

        DefaultTableModel modelo = new DefaultTableModel();
        List equipos = detallePC.listar(idPartido);
        List incidencias = incidenciaC.listar(idPartido);
        DetallePartido dp;
        IncidenciaPartido ip;
        String local = "", visita="";
        Object obj[] = new Object[2];

        for (int i = 0; i < equipos.size(); i++) {
            dp = (DetallePartido) equipos.get(i);
            if (dp.getTipo().equalsIgnoreCase("V")) {
                modelo.addColumn(dp.getEquipo().getNombreCorto());
                local = dp.getEquipo().getNombreCorto();
            } else {
                modelo.addColumn(dp.getEquipo().getNombreCorto());
                visita = dp.getEquipo().getNombreCorto();
            }
        }

        for (int i = 0; i < incidencias.size(); i++) {
            ip = (IncidenciaPartido) incidencias.get(i);

            if (ip.getEquipo().getNombreCorto().equals(visita)) {
                obj[0] = "'"+ip.getMinuto()+"'"+ip.getFutbolista().getNombreCorto()+" "+ip.getEvento().getNombre();
                obj[1] = "";
                modelo.addRow(obj);
            }else if (ip.getEquipo().getNombreCorto().equals(local)){
                obj[0] = "";
                obj[1] = "'"+ip.getMinuto()+"'"+ip.getFutbolista().getNombreCorto()+" "+ip.getEvento().getNombre();
                modelo.addRow(obj);
            }
            
        }

        tblListado.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cbxEvento = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxInstancia = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbxEquipo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbxFutbolista = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbxContinente = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel9 = new javax.swing.JLabel();
        txtMinuto = new javax.swing.JSpinner();
        btnGrabar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRAR INCIDENCIAS");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblListado = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tblListado.setDefaultRenderer(Object.class, new RenderTable());
        tblListado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblListado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblListado.setFillsViewportHeight(true);
        tblListado.setGridColor(new java.awt.Color(255, 255, 255));
        tblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListado);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Evento");

        cbxEvento.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Instancia");

        cbxInstancia.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxInstancia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Equipo");

        cbxEquipo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Futbolista");

        cbxFutbolista.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxFutbolista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Continente");

        cbxContinente.setDescripcion("Ej. De cabeza");
        cbxContinente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Minuto");

        btnGrabar.setBackground(new java.awt.Color(27, 118, 253));
        btnGrabar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnGrabar.setForeground(new java.awt.Color(255, 255, 255));
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/grabar25.png"))); // NOI18N
        btnGrabar.setMnemonic('N');
        btnGrabar.setText("Grabar");
        btnGrabar.setToolTipText("Realizar Nuevo Registro");
        btnGrabar.setBorder(null);
        btnGrabar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cbxFutbolista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxInstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxContinente, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))))
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxEvento))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxInstancia))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxContinente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(7, 7, 7)
                        .addComponent(cbxFutbolista)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        //
        //        int fila = tblListado.getSelectedRow();
        //        int id = Integer.parseInt(tblListado.getValueAt(fila, 0).toString());
        //
        //        int colum = tblListado.getColumnModel().getColumnIndexAtX(evt.getX());
        //        int row = evt.getY() / tblListado.getRowHeight();
        //
        //        if (row < tblListado.getRowCount() && row >= 0 && colum < tblListado.getColumnCount() && colum >= 0) {
        //            Object value = tblListado.getValueAt(row, colum);
        //
        //            if (value instanceof JButton jButton) {
        //                jButton.doClick();
        //                JButton boton = jButton;
        //                int filas = tblListado.getSelectedRowCount();
        //
        //                switch (boton.getName()) {
        //                    case "btnEliminar" -> {
        //                        if (filas == 0) {//si no elije ninguna fila
        //                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un partido");
        //                        } else {
        //                            String valor = String.valueOf(tblListado.getValueAt(fila, 1));
        //
        //                            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar al partido " + valor + "?", "Confirmar", 2);
        //                            if (opcion == 0) {
        //
        //                                try {
        //                                    detallePC.eliminar(id);
        //                                    AlertaBien alertaBien = new AlertaBien("Mensaje", "partido eliminado correctamente!");
        //                                    listar("");
        //                                } catch (Exception ex) {
        //                                    AlertaError err = new AlertaError("ERROR", ex.getMessage());
        //                                }
        //
        //                            } else {
        //                                Alerta alerta = new Alerta("Alerta", "Operación cancelada!");
        //                            }
        //
        //                        }
        //                    }
        //                    case "btnModificar" -> {
        //                        if (filas == 0) {//si no elije ninguna fila
        //                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un partido");
        //                        } else {
        //
        //                            ModalRegistrarPartido.idPartido = id;
        //                            FrmMenuPrincipal.centrarVentana(new ModalRegistrarPartido());
        //                            ModalRegistrarPartido.btnGrabar.setText("Modificar");
        //
        //                        }
        //                    }
        //                    case "btnAdd" -> {
        //                        if (filas == 0) {
        //                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un partido");
        //                        } else {
        //                            FrmGestionarDetallePartido.idPartido = id;
        //                            FrmMenuPrincipal.centrarVentana(new FrmGestionarDetallePartido());
        //                        }
        //                    }
        //                    case "btnVer" -> {
        //                        if (filas == 0) {
        //                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un partido");
        //                        } else {
        //                            ModalRegistrarPartido.vista = true;
        //                            ModalRegistrarPartido.idPartido = id;
        //                            FrmMenuPrincipal.centrarVentana(new ModalRegistrarPartido());
        //                        }
        //                    }
        //                }
        //            }
        //        }
    }//GEN-LAST:event_tblListadoMouseClicked

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed

        grabar();
    }//GEN-LAST:event_btnGrabarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGrabar;
    private org.edisoncor.gui.textField.TextFieldRectBackground cbxContinente;
    public static javax.swing.JComboBox<String> cbxEquipo;
    public static javax.swing.JComboBox<String> cbxEvento;
    public static javax.swing.JComboBox<String> cbxFutbolista;
    public static javax.swing.JComboBox<String> cbxInstancia;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblListado;
    private javax.swing.JSpinner txtMinuto;
    // End of variables declaration//GEN-END:variables
}
