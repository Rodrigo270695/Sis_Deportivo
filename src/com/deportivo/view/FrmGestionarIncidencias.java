package com.deportivo.view;

import com.deportivo.controller.DetallePartidoController;
import com.deportivo.model.DetallePartido;
import com.deportivo.properties.RenderTable;
import com.deportivo.view.modal.ModalRegistrarIncidenciaPartido;
import com.deportivo.vista.modal.alerts.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmGestionarIncidencias extends javax.swing.JInternalFrame {

    public static DetallePartidoController detallePC = new DetallePartidoController();
    public static boolean verPartido = false;

    public FrmGestionarIncidencias() {
        initComponents();
        listar("");
    }

    public static void listar(String texto) {

        String columas[] = {"#", "EQUIPOS", "FECHA", "HORA", "ESTADIO", "", ""};
        DefaultTableModel modelo = new DefaultTableModel();
        Object obj[] = new Object[7];
        DetallePartido detalleP;
        DetallePartido detalleP2;
        List lista;
        List listaId;

        for (String columa : columas) {
            modelo.addColumn(columa);
        }

        lista = detallePC.listar();

        for (int i = 0; i < lista.size(); i++) {
            detalleP = (DetallePartido) lista.get(i);
            StringBuilder equipos = new StringBuilder();

            listaId = detallePC.listar(detalleP.getPartido().getPartidoId());
            obj[0] = detalleP.getPartido().getPartidoId();

            for (int j = 0; j < listaId.size(); j++) {
                detalleP2 = (DetallePartido) listaId.get(j);
                equipos.append(detalleP2.getEquipo().getNombreCorto());
                if (j != (listaId.size() - 1)) {
                    equipos.append(" VS ");
                }
            }
            obj[1] = equipos.toString();

            obj[2] = detalleP.getPartido().getJornada().getFecha_corta();
            obj[3] = detalleP.getPartido().getHora();
            obj[4] = detalleP.getPartido().getEstadio().getNombreConocido();

            ImageIcon iconoAdd = new ImageIcon("src/com/deportivo/iconos/incidencia28.png");
            Icon btnAdd = new ImageIcon(iconoAdd.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            JButton botonAdd = new JButton("", btnAdd);
            botonAdd.setName("btnAdd");
            botonAdd.setToolTipText("AñadirTipo");
            botonAdd.setBorder(null);
            botonAdd.setBackground(new Color(25, 38, 49));
            obj[5] = botonAdd;

            ImageIcon iconoVer = new ImageIcon("src/com/deportivo/iconos/ver.png");
            Icon btnVer = new ImageIcon(iconoVer.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            JButton botonVer = new JButton("", btnVer);
            botonVer.setName("btnVer");
            botonVer.setToolTipText("vista del registro");
            botonVer.setBorder(null);
            botonVer.setBackground(new Color(41, 143, 96));
            obj[6] = botonVer;

            if (detalleP.getPartido().isEstado() == true) {
                if (i % 2 == 0) {
                    modelo.addRow(obj);
                }
            }

        }

        tblListado.setRowHeight(30);
        tblListado.setModel(modelo);
        tblListado.setBackground(Color.WHITE);
        tblListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblListado.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblListado.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblListado.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblListado.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblListado.getColumnModel().getColumn(4).setPreferredWidth(200);
        tblListado.getColumnModel().getColumn(5).setPreferredWidth(30);

        if (verPartido == true) {
            tblListado.getColumnModel().getColumn(5).setMaxWidth(0);
            tblListado.getColumnModel().getColumn(5).setMinWidth(0);
            tblListado.getColumnModel().getColumn(5).setPreferredWidth(0);
        }

        tblListado.getColumnModel().getColumn(6).setPreferredWidth(30);
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
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new org.edisoncor.gui.textField.TextFieldRectBackground();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("GESTIONAR INCIDENCIAS");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
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

        jLabel2.setBackground(new java.awt.Color(27, 118, 253));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/buscar20.png"))); // NOI18N
        jLabel2.setOpaque(true);

        txtBuscar.setBackground(new java.awt.Color(223, 235, 254));
        txtBuscar.setDescripcion("Ingrese el nombre");
        txtBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotal))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
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

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked

        int fila = tblListado.getSelectedRow();
        int id = Integer.parseInt(tblListado.getValueAt(fila, 0).toString());

        int colum = tblListado.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblListado.getRowHeight();

        if (row < tblListado.getRowCount() && row >= 0 && colum < tblListado.getColumnCount() && colum >= 0) {
            Object value = tblListado.getValueAt(row, colum);

            if (value instanceof JButton jButton) {
                jButton.doClick();
                JButton boton = jButton;
                int filas = tblListado.getSelectedRowCount();

                switch (boton.getName()) {

                    case "btnAdd" -> {
                        if (filas == 0) {
                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un partido");
                        } else {
                            ModalRegistrarIncidenciaPartido.idPartido = id;
                            FrmMenuPrincipal.centrarVentana(new ModalRegistrarIncidenciaPartido());
                        }
                    }
                    case "btnVer" ->{
                        
                        ModuloTV.idPartido = id;
                        FrmMenuPrincipal.centrarVentana(new ModuloTV());
                        this.dispose();
                        
                    }
                }
            }
        }

    }//GEN-LAST:event_tblListadoMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

//        if (txtBuscar.getText().length() % 2 == 0) {
//            listar(txtBuscar.getText().toUpperCase());
//        }

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        verPartido = false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        verPartido = false;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblTotal;
    public static javax.swing.JTable tblListado;
    public static org.edisoncor.gui.textField.TextFieldRectBackground txtBuscar;
    // End of variables declaration//GEN-END:variables
}
