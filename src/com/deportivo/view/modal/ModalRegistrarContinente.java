package com.deportivo.view.modal;

import com.deportivo.controller.ContinenteController;
import com.deportivo.model.Continente;
import com.deportivo.view.FrmGestionarContinente;
import com.deportivo.vista.modal.alerts.Alerta;
import com.deportivo.vista.modal.alerts.AlertaBien;
import com.deportivo.vista.modal.alerts.AlertaError;
import java.awt.Toolkit;

public final class ModalRegistrarContinente extends javax.swing.JInternalFrame {

    ContinenteController continenteC = new ContinenteController();
    public static boolean activarContinente = false;
    public static int idContinente = 0;
    public static boolean vista = false;

    public ModalRegistrarContinente() {
        initComponents();
        acciones();
    }

    void acciones() {

        if (vista) {

            txtAbreviatura.setEnabled(false);
            txtNombre.setEnabled(false);
            btnGrabar.setEnabled(false);

        }

        if (idContinente > 0) {

            Continente continente = (Continente) continenteC.obtenerdato(idContinente);
            txtAbreviatura.setText(continente.getAbreviatura());
            txtNombre.setText(continente.getNombre());

        }

    }

    void grabar() {

        if (txtNombre.getText().length() == 0) {
            Alerta alerta = new Alerta("Alerta", "El campo NOMBRE es obligatorio");
            return;
        }

        if (btnGrabar.getText().equalsIgnoreCase("Grabar")) {

            Continente continente = new Continente();
            continente.setNombre(txtNombre.getText().toUpperCase());
            continente.setAbreviatura(txtAbreviatura.getText().toUpperCase());

            try {
                continenteC.registrar(continente);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente el continente");
                if (activarContinente == false) {
                    FrmGestionarContinente.listar("");
                } else {
                    ModalRegistrarPais.cargarContinentes();

                }
                dispose();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                AlertaError err = new AlertaError("Error", e.getMessage());
            }

        } else {

            Continente continente = new Continente();
            continente.setNombre(txtNombre.getText().toUpperCase());
            continente.setAbreviatura(txtAbreviatura.getText().toUpperCase());
            continente.setContinenteId((byte) idContinente);

            try {
                continenteC.modificar(continente);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente el continente");
                FrmGestionarContinente.listar("");
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
        jLabel2 = new javax.swing.JLabel();
        txtAbreviatura = new org.edisoncor.gui.textField.TextFieldRectBackground();
        btnGrabar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Continente");
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

        txtNombre.setDescripcion("Ej. Europa");
        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Abreviatura");

        txtAbreviatura.setDescripcion("Ej. EU");
        txtAbreviatura.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAbreviatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAbreviaturaKeyTyped(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAbreviatura, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 19, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAbreviatura, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
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

        idContinente = 0;
        vista = false;

    }//GEN-LAST:event_formInternalFrameClosed

    private void txtAbreviaturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbreviaturaKeyTyped

      char caracter = evt.getKeyChar();

        if (!((caracter < '0') || (caracter > '9')) && (caracter != '\b') || txtAbreviatura.getText().length() >= 3) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            Alerta alerta = new Alerta("ALERTA", "Solo acepta 3 caracteres y letras");
        }


    }//GEN-LAST:event_txtAbreviaturaKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
         char caracter = evt.getKeyChar();

        
        if (!((caracter < '0')|| (caracter > '9'))&& (caracter != '\b')) {
            evt.consume();  
            Toolkit.getDefaultToolkit().beep();
            Alerta alerta = new Alerta("ALERTA", "Solo acepta letras");
        }
    }//GEN-LAST:event_txtNombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGrabar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtAbreviatura;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombre;
    // End of variables declaration//GEN-END:variables
}
