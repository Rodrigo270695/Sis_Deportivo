package com.deportivo.view;

import com.deportivo.controller.AlineacionController;
import com.deportivo.controller.AlineacionController;
import com.deportivo.controller.FutbolistaController;
import com.deportivo.model.Alineacion;
import com.deportivo.model.Alineacion;
import com.deportivo.model.Futbolista;
import com.deportivo.properties.RenderTable;
import com.deportivo.view.modal.ModalRegistrarAlineacion;
import com.deportivo.vista.modal.alerts.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmGestionarAlineacion extends javax.swing.JInternalFrame {

    FutbolistaController futbolistaC = new FutbolistaController();
    public static AlineacionController alineacionC = new AlineacionController();
    public static int idPartido;
    public static int idEquipo;

    public FrmGestionarAlineacion() {
        initComponents();
        listar();
    }

    public static void listar() {

        String columas[] = {"idPartido","idEquipo", "FUTBOLISTA", "TIPO", "POSICIÓN",  ""};
        DefaultTableModel modelo = new DefaultTableModel();

        for (String columa : columas) {
            modelo.addColumn(columa);
        }

        Alineacion alineacion;
        List lista = alineacionC.listar(idPartido, idEquipo);
        Object obj[] = new Object[6];

        for (int i = 0; i < lista.size(); i++) {
            alineacion = (Alineacion) lista.get(i);
            obj[0] = alineacion.getPartido().getPartidoId();
            obj[1] = alineacion.getEquipo().getEquipoId();
            obj[2] = alineacion.getFutbolista().getNombreCompleto();
            obj[3] = alineacion.getTipoJugador().getDescripcion();
            obj[4] = alineacion.getPosicion().getDescripcion();

            ImageIcon icono = new ImageIcon("src/com/deportivo/iconos/eliminar.png");
            Icon btnEliminar = new ImageIcon(icono.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            JButton botonEliminar = new JButton("", btnEliminar);
            botonEliminar.setName("btnEliminar");
            botonEliminar.setToolTipText("eliminar");
            botonEliminar.setBorder(null);
            botonEliminar.setBackground(new Color(223, 68, 83));
            obj[5] = botonEliminar;


            modelo.addRow(obj);

        }

        tblListado.setRowHeight(30);
        tblListado.setModel(modelo);
        tblListado.setBackground(Color.WHITE);
        tblListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblListado.getColumnModel().getColumn(0).setMaxWidth(0);
        tblListado.getColumnModel().getColumn(0).setMinWidth(0);
        tblListado.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblListado.getColumnModel().getColumn(1).setMaxWidth(0);
        tblListado.getColumnModel().getColumn(1).setMinWidth(0);
        tblListado.getColumnModel().getColumn(1).setPreferredWidth(0);
        tblListado.getColumnModel().getColumn(2).setPreferredWidth(210);
        tblListado.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblListado.getColumnModel().getColumn(4).setPreferredWidth(210);
        tblListado.getColumnModel().getColumn(5).setPreferredWidth(30);
        lblTotal.setText(String.valueOf(tblListado.getRowCount()));

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
        setTitle("GESTIONAR ALINEACIÓN");

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
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/mas20.png"))); // NOI18N
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal)
                        .addGap(0, 526, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
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

        ModalRegistrarAlineacion.idEquipo = idEquipo;
        ModalRegistrarAlineacion.idPartido = idPartido;
        ModalRegistrarAlineacion frm = new ModalRegistrarAlineacion();
        FrmMenuPrincipal.centrarVentana(frm);

    }//GEN-LAST:event_btnAddActionPerformed

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked

        int fila = tblListado.getSelectedRow();
        int idParti = Integer.parseInt(tblListado.getValueAt(fila, 0).toString());
        int idEqui = Integer.parseInt(tblListado.getValueAt(fila, 1).toString());

        int colum = tblListado.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblListado.getRowHeight();

        if (row < tblListado.getRowCount() && row >= 0 && colum < tblListado.getColumnCount() && colum >= 0) {
            Object value = tblListado.getValueAt(row, colum);

            if (value instanceof JButton jButton) {
                jButton.doClick();
                JButton boton = jButton;
                int filas = tblListado.getSelectedRowCount();

                switch (boton.getName()) {
                    case "btnEliminar" -> {
                        if (filas == 0) {//si no elije ninguna fila
                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un alineacion");
                        } else {
                            String valor = String.valueOf(tblListado.getValueAt(fila, 2));
                            Futbolista fut = (Futbolista)futbolistaC.obtenerdato(valor);

                            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la alineacion " + valor + "?", "Confirmar", 2);
                            if (opcion == 0) {

                                try {
                                    alineacionC.eliminar(idParti,idEqui, fut.getFutbolistaId());
                                    AlertaBien alertaBien = new AlertaBien("Mensaje", "Alineacion eliminado correctamente!");
                                    listar();
                                } catch (Exception ex) {
                                    AlertaError err = new AlertaError("ERROR", ex.getMessage());
                                }

                            } else {
                                Alerta alerta = new Alerta("Alerta", "Operación cancelada!");
                            }

                        }
                    }
                }
            }
        }

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
