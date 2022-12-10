
package com.deportivo.view.modal;

import com.deportivo.controller.RolPermisoController;
import com.deportivo.model.RolPermiso;
import com.deportivo.model.Permiso;
import com.deportivo.vista.modal.alerts.AlertaBien;


public class ModalDarPermisos extends javax.swing.JInternalFrame {

    RolPermisoController dpC = new RolPermisoController();
    
    public static int idRol;

    public ModalDarPermisos() {
        initComponents();
        mostrarPermisos();
    }
    
    private void mostrarPermisos(){
        
        RolPermiso detalleP = dpC.listar(idRol);
        
        for (Permiso permiso : detalleP.getPermisos()) {
            
            switch (permiso.getPermisoId()) {
                case 1 -> {
                    chkMantenimiento.setSelected(true);
                }
                case 2 -> {
                    chkTarifas.setSelected(true);
                }
                case 3 -> {
                    chkIngreso.setSelected(true);
                }
                case 4 -> {
                    chkSalida.setSelected(true);
                }
                case 5 -> {
                    chkCaja.setSelected(true);
                }
                case 6 -> {
                    chkReporte.setSelected(true);
                }
                case 7 -> {
                    chkAdmin.setSelected(true);
                }
            }
            
        }
        
    }
    
    private void grabar(){

        dpC.eliminarPermisos(idRol);

        if (chkMantenimiento.isSelected()) {
            dpC.RegistrarPermisos(idRol, Integer.parseInt(chkMantenimiento.getName()));
        }
        if (chkTarifas.isSelected()) {
            dpC.RegistrarPermisos(idRol, Integer.parseInt(chkTarifas.getName()));
        }
        if (chkIngreso.isSelected()) {
            dpC.RegistrarPermisos(idRol, Integer.parseInt(chkIngreso.getName()));
        }
        if (chkSalida.isSelected()) {
            dpC.RegistrarPermisos(idRol, Integer.parseInt(chkSalida.getName()));
        }
        if (chkCaja.isSelected()) {
            dpC.RegistrarPermisos(idRol, Integer.parseInt(chkCaja.getName()));
        }
        if (chkReporte.isSelected()) {
            dpC.RegistrarPermisos(idRol, Integer.parseInt(chkReporte.getName()));
        }
        if (chkAdmin.isSelected()) {
            dpC.RegistrarPermisos(idRol, Integer.parseInt(chkAdmin.getName()));
        }

        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        chkMantenimiento = new javax.swing.JCheckBox();
        chkTarifas = new javax.swing.JCheckBox();
        chkIngreso = new javax.swing.JCheckBox();
        chkCaja = new javax.swing.JCheckBox();
        chkReporte = new javax.swing.JCheckBox();
        chkAdmin = new javax.swing.JCheckBox();
        chkSalida = new javax.swing.JCheckBox();
        btnGrabar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Permisos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        chkMantenimiento.setMnemonic('1');
        chkMantenimiento.setText("Menu Mantenimiento");
        chkMantenimiento.setName("1"); // NOI18N

        chkTarifas.setMnemonic('2');
        chkTarifas.setText("Menu Tarifas");
        chkTarifas.setName("2"); // NOI18N

        chkIngreso.setMnemonic('3');
        chkIngreso.setText("Menu Ingreso");
        chkIngreso.setName("3"); // NOI18N

        chkCaja.setMnemonic('5');
        chkCaja.setText("Menu Caja");
        chkCaja.setName("5"); // NOI18N

        chkReporte.setMnemonic('6');
        chkReporte.setText("Menu Reporte");
        chkReporte.setName("6"); // NOI18N

        chkAdmin.setMnemonic('7');
        chkAdmin.setText("Menu Admin");
        chkAdmin.setName("7"); // NOI18N

        chkSalida.setMnemonic('4');
        chkSalida.setText("Menu Salida");
        chkSalida.setName("4"); // NOI18N

        btnGrabar.setBackground(new java.awt.Color(27, 118, 253));
        btnGrabar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnGrabar.setForeground(new java.awt.Color(255, 255, 255));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkSalida)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkIngreso)
                            .addComponent(chkTarifas)
                            .addComponent(chkMantenimiento))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkAdmin)
                            .addComponent(chkReporte)
                            .addComponent(chkCaja))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chkCaja)
                        .addGap(18, 18, 18)
                        .addComponent(chkReporte)
                        .addGap(18, 18, 18)
                        .addComponent(chkAdmin))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chkMantenimiento)
                        .addGap(18, 18, 18)
                        .addComponent(chkTarifas)
                        .addGap(18, 18, 18)
                        .addComponent(chkIngreso)))
                .addGap(18, 18, 18)
                .addComponent(chkSalida)
                .addGap(36, 36, 36)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
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
        AlertaBien alertaB = new AlertaBien("MENSAJE", "Permisos registrados Correctamente");
        this.dispose();
        
    }//GEN-LAST:event_btnGrabarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGrabar;
    private javax.swing.JCheckBox chkAdmin;
    private javax.swing.JCheckBox chkCaja;
    private javax.swing.JCheckBox chkIngreso;
    private javax.swing.JCheckBox chkMantenimiento;
    private javax.swing.JCheckBox chkReporte;
    private javax.swing.JCheckBox chkSalida;
    private javax.swing.JCheckBox chkTarifas;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
