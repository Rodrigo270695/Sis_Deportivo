
package com.deportivo.view;

import com.deportivo.controller.DetallePartidoController;
import com.deportivo.controller.EquipoController;
import com.deportivo.controller.EventoController;
import com.deportivo.controller.FutbolistaController;
import com.deportivo.controller.IncidenciaPartidoController;
import com.deportivo.controller.InstanciaPartidoController;
import com.deportivo.controller.PartidoController;
import com.deportivo.model.DetallePartido;
import com.deportivo.model.IncidenciaPartido;
import com.deportivo.properties.RenderTable;
import static com.deportivo.view.modal.ModalRegistrarIncidenciaPartido.idPartido;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public final class ModuloTV extends javax.swing.JInternalFrame {
    
    DetallePartidoController detallePC = new DetallePartidoController();
    PartidoController partidoC = new PartidoController();
    FutbolistaController futbolistaC = new FutbolistaController();
    EquipoController equipoC = new EquipoController();
    EventoController eventoC = new EventoController();
    IncidenciaPartidoController incidenciaC = new IncidenciaPartidoController();
    InstanciaPartidoController instanciaC = new InstanciaPartidoController();

    public ModuloTV() {
        initComponents();
        listar();
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
        estadio = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnAdd1 = new javax.swing.JButton();
        btnAdd2 = new javax.swing.JButton();
        btnAdd3 = new javax.swing.JButton();
        btnAdd4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListado1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("MODULO TV");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));

        btnAdd1.setBackground(new java.awt.Color(27, 118, 253));
        btnAdd1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd1.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd1.setText("Comentarios");
        btnAdd1.setBorder(null);
        btnAdd1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });

        btnAdd2.setBackground(new java.awt.Color(27, 118, 253));
        btnAdd2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd2.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd2.setText("Resumen");
        btnAdd2.setBorder(null);
        btnAdd2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });

        btnAdd3.setBackground(new java.awt.Color(27, 118, 253));
        btnAdd3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd3.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd3.setText("Estadísticas");
        btnAdd3.setBorder(null);
        btnAdd3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd3ActionPerformed(evt);
            }
        });

        btnAdd4.setBackground(new java.awt.Color(27, 118, 253));
        btnAdd4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd4.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd4.setText("Jugadores");
        btnAdd4.setBorder(null);
        btnAdd4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(btnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(656, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(222, 222, 222)
                    .addComponent(btnAdd3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(460, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(429, Short.MAX_VALUE)
                    .addComponent(btnAdd4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(253, 253, 253)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnAdd2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnAdd3, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnAdd4, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/estadio600.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout estadioLayout = new javax.swing.GroupLayout(estadio);
        estadio.setLayout(estadioLayout);
        estadioLayout.setHorizontalGroup(
            estadioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, estadioLayout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        estadioLayout.setVerticalGroup(
            estadioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, estadioLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(estadio);

        tblListado = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tblListado.setDefaultRenderer(Object.class, new RenderTable());
        tblListado1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblListado1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblListado1.setFillsViewportHeight(true);
        tblListado1.setGridColor(new java.awt.Color(255, 255, 255));
        tblListado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListado1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblListado1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);

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

    private void tblListado1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListado1MouseClicked
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
    }//GEN-LAST:event_tblListado1MouseClicked

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void btnAdd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd3ActionPerformed

    private void btnAdd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnAdd3;
    private javax.swing.JButton btnAdd4;
    private javax.swing.JPanel estadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tblListado;
    public static javax.swing.JTable tblListado1;
    // End of variables declaration//GEN-END:variables
}
