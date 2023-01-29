package com.deportivo.view.modal;

import com.deportivo.controller.*;
import com.deportivo.model.*;
import com.deportivo.view.FrmGestionarFutbolista;
import com.deportivo.vista.modal.alerts.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public final class ModalRegistrarFutbolista extends javax.swing.JInternalFrame {

    FutbolistaController futbolistaC = new FutbolistaController();
    TipoDocumentoIdentidadController tipoDocC = new TipoDocumentoIdentidadController();
    FileInputStream fis;
    public static int idFutbolista = 0;
    public static boolean vista = false;

    public ModalRegistrarFutbolista() {
        initComponents();
        cargarTipoDocs();
        if (lblFoto.getIcon() == null) {
            lblFoto.setIcon(new ImageIcon("src/com/deportivo/iconos/foto_default.png"));
        }
        acciones();
    }

    void cargarTipoDocs() {

        cbxTipoDoc.removeAllItems();
        List<TipoDocumentoIdentidad> lista = tipoDocC.listar();

        for (TipoDocumentoIdentidad tipo : lista) {
            cbxTipoDoc.addItem(tipo.getDescripcion_larga());
        }

    }

    void acciones() {

        if (vista) {

            txtAltura.setEnabled(false);
            txtCorreo.setEnabled(false);
            txtDocIdentidad.setEnabled(false);
            txtFechaNac.setEnabled(false);
            txtNombre.setEnabled(false);
            txtNombreCorto.setEnabled(false);
            txtPeso.setEnabled(false);
            txtNumCamiseta.setEnabled(false);
            cbxTipoDoc.setEnabled(false);
            txtValorMercado.setEnabled(false);
            btnGrabar.setEnabled(false);
            btnFoto.setEnabled(false);

        }

        if (idFutbolista > 0) {

            ImageIcon foto;
            Futbolista futbolista = (Futbolista) futbolistaC.obtenerdato(idFutbolista);

            txtAltura.setText("" + futbolista.getAltura());
            txtCorreo.setText(futbolista.getEmail());
            txtDocIdentidad.setText(futbolista.getDocumentoIdentidad());
            txtFechaNac.setDate(futbolista.getFechaNacimiento());
            txtNombre.setText(futbolista.getNombreCompleto());
            txtNombreCorto.setText(futbolista.getNombreCorto());
            txtPeso.setText("" + futbolista.getPeso());
            txtValorMercado.setText("" + futbolista.getValorMercado());
            cbxTipoDoc.setSelectedItem(futbolista.getTipoDocumentoIdentidad().getDescripcion_larga());
            txtNumCamiseta.setText("" + futbolista.getNumeroCamiseta());

            try {
                BufferedImage bi = ImageIO.read(futbolista.getFoto());
                foto = new ImageIcon(bi);

                Image img = foto.getImage().getScaledInstance(178, 172, Image.SCALE_SMOOTH);
                lblFoto.setIcon(new ImageIcon(img));

            } catch (IOException e) {
                Alerta alert = new Alerta("ALERTS", "Ocurrió un error al cargar la imagen");
            }
        }

    }


    void grabar() {

        Calendar cal;
        int d, m, a;
        String fecha1;
        Futbolista futbolista = new Futbolista();

        cal = txtFechaNac.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH) + 1;
        a = cal.get(Calendar.YEAR);
        fecha1 = String.valueOf(a) + "-" + String.valueOf(m) + "-" + String.valueOf(d);

        if (txtNombre.getText().length() == 0 | txtDocIdentidad.getText().length() == 0) {
            Alerta alerta = new Alerta("Alerta", "El campo NOMBRE y DOC IDENTIDAD son obligatorio");
            return;
        }

        futbolista.setNombreCorto(txtNombreCorto.getText().toUpperCase());
        futbolista.setNombreCompleto(txtNombre.getText().toUpperCase());
        futbolista.setDocumentoIdentidad(txtDocIdentidad.getText().toUpperCase());
        futbolista.setValorMercado(Double.parseDouble(txtNumCamiseta.getText().toUpperCase()));
        futbolista.setNumeroCamiseta(Integer.parseInt(txtNumCamiseta.getText()));
        futbolista.setEmail(txtCorreo.getText().toUpperCase());
        futbolista.setTipoDocumentoIdentidad((TipoDocumentoIdentidad) tipoDocC.obtenerdato(cbxTipoDoc.getSelectedItem().toString()));
        futbolista.setFechaNacimiento((java.sql.Date.valueOf(fecha1)));
        futbolista.setPeso(Float.parseFloat(txtPeso.getText()));
        futbolista.setAltura(Float.parseFloat(txtAltura.getText()));

        if (btnGrabar.getText().equalsIgnoreCase("Grabar")) {

            if (fis == null) {
                try {
                    fis = new FileInputStream(new File("src/com/deportivo/iconos/foto_default.png"));

                } catch (FileNotFoundException e) {
                }

            }

            futbolista.setFoto(fis);

            try {
                futbolistaC.registrar(futbolista);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente el futbolista");
                FrmGestionarFutbolista.listar("");
                dispose();
            } catch (Exception e) {
                AlertaError err = new AlertaError("Error", e.getMessage());
            }

        } else {

            futbolista.setFutbolistaId(idFutbolista);

            if (fis == null) {
                try {
                    fis = new FileInputStream(new File("src/com/deportivo/iconos/foto_default.png"));

                } catch (FileNotFoundException e) {
                }

            }

            futbolista.setFoto(fis);

            try {
                futbolistaC.modificar(futbolista);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente el futbolista");
                FrmGestionarFutbolista.listar("");
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
        cbxTipoDoc = new javax.swing.JComboBox<>();
        lblFoto = new javax.swing.JLabel();
        btnFoto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtDocIdentidad = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel7 = new javax.swing.JLabel();
        txtPeso = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel8 = new javax.swing.JLabel();
        txtNombreCorto = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCorreo = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtFechaNac = new com.toedter.calendar.JDateChooser();
        txtAltura = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel12 = new javax.swing.JLabel();
        txtNumCamiseta = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtValorMercado = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel13 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Futbolista");
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
        jLabel1.setText("Nombre Completo* ");

        txtNombre.setDescripcion("Ej. Perú");
        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        btnGrabar.setBackground(new java.awt.Color(27, 118, 253));
        btnGrabar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnGrabar.setForeground(new java.awt.Color(255, 255, 255));
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
        jLabel3.setText("Tipo Documemto");

        cbxTipoDoc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxTipoDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnFoto.setForeground(new java.awt.Color(51, 51, 51));
        btnFoto.setMnemonic('N');
        btnFoto.setText("Abrir...");
        btnFoto.setToolTipText("Realizar Nuevo Registro");
        btnFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Documento de Identidad");

        txtDocIdentidad.setDescripcion("Ej. PER");
        txtDocIdentidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDocIdentidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocIdentidadKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Peso");

        txtPeso.setDescripcion("Ej. PER");
        txtPeso.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesoKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Nom Corto");

        txtNombreCorto.setDescripcion("Ej. PER");
        txtNombreCorto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombreCorto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCortoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Fecha Nac.");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Altura");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Correo");

        txtCorreo.setDescripcion("Ej. PER");
        txtCorreo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtAltura.setDescripcion("Ej. PER");
        txtAltura.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAlturaKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("N° Camiseta");

        txtNumCamiseta.setDescripcion("Ej. PER");
        txtNumCamiseta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNumCamiseta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumCamisetaKeyTyped(evt);
            }
        });

        txtValorMercado.setDescripcion("Ej. PER");
        txtValorMercado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtValorMercado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorMercadoKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Valor Mercado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxTipoDoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtDocIdentidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValorMercado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombreCorto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNumCamiseta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFoto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreCorto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDocIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumCamiseta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorMercado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnFoto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxTipoDoc, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(txtFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
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

        idFutbolista = 0;
        vista = false;

    }//GEN-LAST:event_formInternalFrameClosed

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed

        lblFoto.setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);

        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(j.getSelectedFile());

                try {

                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);
                    lblFoto.setIcon(new ImageIcon(icono));
                    lblFoto.updateUI();

                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace(System.err);
            }
        }
    }//GEN-LAST:event_btnFotoActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char caracter = evt.getKeyChar();

        if (!((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            Alerta alerta = new Alerta("ALERTA", "Solo acepta letras");
        }

    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombreCortoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCortoKeyTyped
        char caracter = evt.getKeyChar();

        if (!((caracter < '0') || (caracter > '9')) && (caracter != '\b') || txtNombreCorto.getText().length() >= 25) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            Alerta alerta = new Alerta("ALERTA", "Solo acepta 25 letras");
        }
    }//GEN-LAST:event_txtNombreCortoKeyTyped

    private void txtDocIdentidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocIdentidadKeyTyped
        char caracter = evt.getKeyChar();

        if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') || txtDocIdentidad.getText().length() >= 15) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            Alerta alerta = new Alerta("ALERTA", "Solo acepta 15 dígitos");
        }

    }//GEN-LAST:event_txtDocIdentidadKeyTyped

    private void txtNumCamisetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumCamisetaKeyTyped
        char caracter = evt.getKeyChar();

        if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') ) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            Alerta alerta = new Alerta("ALERTA", "Solo se aceptan números");
        }
    }//GEN-LAST:event_txtNumCamisetaKeyTyped

    private void txtValorMercadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorMercadoKeyTyped
        char caracter = evt.getKeyChar();

        if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            Alerta alerta = new Alerta("ALERTA", "Solo se aceptan números");
        }
    }//GEN-LAST:event_txtValorMercadoKeyTyped

    private void txtPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoKeyTyped
        char caracter = evt.getKeyChar();

        if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') || txtPeso.getText().length() >= 3) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            Alerta alerta = new Alerta("ALERTA", "Solo se aceptar numero posistivos y limite de 3 dígitos");
        }
    }//GEN-LAST:event_txtPesoKeyTyped

    private void txtAlturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlturaKeyTyped
        char caracter = evt.getKeyChar();

        if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') || txtAltura.getText().length() >= 3) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            Alerta alerta = new Alerta("ALERTA", "Solo se aceptar numero posistivos y limite de 3 dígitos" );
        }
    }//GEN-LAST:event_txtAlturaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnFoto;
    public static javax.swing.JButton btnGrabar;
    private javax.swing.JComboBox<String> cbxTipoDoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFoto;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtAltura;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCorreo;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDocIdentidad;
    private com.toedter.calendar.JDateChooser txtFechaNac;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombre;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombreCorto;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNumCamiseta;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtPeso;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtValorMercado;
    // End of variables declaration//GEN-END:variables
}
