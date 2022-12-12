/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.deportivo.view;


public class FrmModulos extends javax.swing.JFrame {


    public FrmModulos() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnFutbolistico = new javax.swing.JButton();
        btnEstadistico = new javax.swing.JButton();
        btnTV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PANEL ADMINISTRATIVO");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/cerrar80.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setLayout(new java.awt.GridLayout(1, 3));

        btnFutbolistico.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        btnFutbolistico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/futbolistico.png"))); // NOI18N
        btnFutbolistico.setText("Modo Futbolistico");
        btnFutbolistico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFutbolistico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFutbolistico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFutbolistico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFutbolisticoActionPerformed(evt);
            }
        });
        jPanel3.add(btnFutbolistico);

        btnEstadistico.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        btnEstadistico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/estadistico200.png"))); // NOI18N
        btnEstadistico.setText("Modo Estadistico");
        btnEstadistico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstadistico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEstadistico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEstadistico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadisticoActionPerformed(evt);
            }
        });
        jPanel3.add(btnEstadistico);

        btnTV.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        btnTV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/estadio200.png"))); // NOI18N
        btnTV.setText("Modo TV");
        btnTV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTV.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(btnTV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnFutbolisticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFutbolisticoActionPerformed
        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
        FrmLogin.rol = 2;
        this.dispose();
    }//GEN-LAST:event_btnFutbolisticoActionPerformed

    private void btnEstadisticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadisticoActionPerformed
        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
        FrmLogin.rol = 3;
        this.dispose();
    }//GEN-LAST:event_btnEstadisticoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmModulos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEstadistico;
    private javax.swing.JButton btnFutbolistico;
    private javax.swing.JButton btnTV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
