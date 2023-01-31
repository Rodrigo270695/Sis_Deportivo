package com.deportivo.reporte;

import com.deportivo.controller.reporte.Reporte_ocho;
import com.deportivo.properties.RenderTable;
import java.awt.Color;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public final class Reporte_8 extends javax.swing.JInternalFrame {

    Reporte_ocho rp = new Reporte_ocho();

    public Reporte_8() {
        initComponents();

    }

    void listar() {

        String columas[] = {"NOMBRE OFICIAL", "NOMBRE CONOCIDO", "CAPACIDAD", "CIUDAD"};
        DefaultTableModel modelo = new DefaultTableModel();
        ResultSet rs = rp.listarEstadios();

        for (String columa : columas) {
            modelo.addColumn(columa);
        }

        try {
            while (rs.next()) {
                modelo.addRow(
                        new Object[]{
                            rs.getString(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getString(4)
                        });

            }

            tblListado.setRowHeight(30);
            tblListado.setModel(modelo);
            tblListado.setBackground(Color.WHITE);
            tblListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tblListado.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblListado.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblListado.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblListado.getColumnModel().getColumn(3).setPreferredWidth(150);
            lblTotal.setText(String.valueOf(tblListado.getRowCount()));

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("LISTA DE ESTADIOS");

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

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel1.setText("Total");

        lblTotal.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        btnAdd.setBackground(new java.awt.Color(27, 118, 253));
        btnAdd.setText("LISTAR");
        btnAdd.setBorder(null);
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setOpaque(true);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTotal))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        listar();

    }//GEN-LAST:event_btnAddActionPerformed

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
//                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un contrato");
//                        } else {
//                            String valor = String.valueOf(tblListado.getValueAt(fila, 4));
//
//                            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar al contrato " + valor + "?", "Confirmar", 2);
//                            if (opcion == 0) {
//
//                                try {
//                                    contratoC.eliminar(id);
//                                    AlertaBien alertaBien = new AlertaBien("Mensaje", "Contrato eliminado correctamente!");
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
//                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar una contrato");
//                        } else {
//
//                            ModalRegistrarContrato.idContrato = id;
//                            FrmMenuPrincipal.centrarVentana(new ModalRegistrarContrato());
//                            ModalRegistrarContrato.btnGrabar.setText("Modificar");
//
//                        }
//                    }
//                    case "btnVer" -> {
//                        if (filas == 0) {
//                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar una contrato");
//                        } else {
//                            ModalRegistrarContrato.vista = true;
//                            ModalRegistrarContrato.idContrato = id;
//                            FrmMenuPrincipal.centrarVentana(new ModalRegistrarContrato());
//                        }
//                    }
//                }
//            }
//        }

    }//GEN-LAST:event_tblListadoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblTotal;
    public static javax.swing.JTable tblListado;
    // End of variables declaration//GEN-END:variables
}
