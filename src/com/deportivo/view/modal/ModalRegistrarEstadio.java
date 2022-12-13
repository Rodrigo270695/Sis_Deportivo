package com.deportivo.view.modal;

import com.deportivo.controller.*;
import com.deportivo.model.Ciudad;
import com.deportivo.model.Confederacion;
import com.deportivo.model.CuerpoTecnico;
import com.deportivo.model.DimensionCampo;
import com.deportivo.model.Estadio;
import com.deportivo.model.Pais;
import com.deportivo.view.*;
import com.deportivo.vista.modal.alerts.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public final class ModalRegistrarEstadio extends javax.swing.JInternalFrame {

    EstadioController estadioC = new EstadioController();
    DimensionCampoController dimensionC = new DimensionCampoController();
    CiudadController ciudadC = new CiudadController();
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    FileInputStream fis;
    public static int idEstadio = 0;
    public static boolean vista = false;

    public ModalRegistrarEstadio() {
        initComponents();
        if (lblFoto.getIcon() == null) {
            lblFoto.setIcon(new ImageIcon("src/com/deportivo/iconos/foto_default.png"));
        }
        cargarCiudad();
        cargarDimensiones();
        acciones();
    }

    private void cargarCiudad() {

        cbxCuidad.removeAllItems();

        List<Ciudad> lista = ciudadC.listar();

        for (Ciudad ciudad : lista) {
            cbxCuidad.addItem(ciudad.getNombre_completo());
        }

    }

    private void cargarDimensiones() {

        cbxDemension.removeAllItems();

        List<DimensionCampo> lista = dimensionC.listar();

        for (DimensionCampo dimension : lista) {
            cbxDemension.addItem(dimension.getDescripcion());
        }

    }


    void acciones() {

        if (vista) {

            txtNombreConocido.setEnabled(false);
            txtFechaFundacion.setEnabled(false);
            txtCosto.setEnabled(false);
            txtNombreCompleto.setEnabled(false);
            txtCapacidad.setEnabled(false);
            txtTribunas.setEnabled(false);
            txtDireccion.setEnabled(false);
            txtPropietario.setEnabled(false);
            cbxDemension.setEnabled(false);
            cbxCuidad.setEnabled(false);
            btnGrabar.setEnabled(false);
            btnFoto.setEnabled(false);

        }

        if (idEstadio > 0) {

            ImageIcon foto;
            Estadio estadio = (Estadio) estadioC.obtenerdato(idEstadio);

            txtTribunas.setText("" + estadio.getTribunas());
            txtDireccion.setText(estadio.getDireccion());
            txtPropietario.setText(estadio.getEquipoPropietario());
            txtNombreConocido.setText(estadio.getNombreConocido());
            txtFechaFundacion.setDate(estadio.getFechaFundacion());
            txtNombreCompleto.setText(estadio.getNombreOficial());
            txtCapacidad.setText(""+estadio.getCapacidad());
            txtCosto.setText(""+estadio.getCosto());
            cbxDemension.setSelectedItem(estadio.getDimensionCampo().getDescripcion());
            cbxCuidad.setSelectedItem(estadio.getCiudad().getNombre_completo());

            try {
                BufferedImage bi = ImageIO.read(estadio.getFoto());
                foto = new ImageIcon(bi);

                Image img = foto.getImage().getScaledInstance(178, 172, Image.SCALE_SMOOTH);
                lblFoto.setIcon(new ImageIcon(img));

            } catch (IOException e) {
                Alerta alert = new Alerta("ALERTS", "Ocurrió un error al cargar la imagen");
            }
        }

    }

    void grabar() {

        try {

            if (txtNombreCompleto.getText().length() == 0 | txtFechaFundacion.getDate().toString().length() == 0) {
                Alerta alerta = new Alerta("Alerta", "El campo NOMBRE y Fecha Fundación son obligatorio");
                return;
            }

        } catch (NullPointerException e) {
            Alerta alerta = new Alerta("Alerta", "El campo NOMBRE y Fecha Fundación son obligatorio");
        }

        Estadio estadio = new Estadio();
        estadio.setCapacidad(Integer.parseInt(txtCapacidad.getText().toUpperCase()));
        estadio.setNombreOficial(txtNombreCompleto.getText().toUpperCase());
        estadio.setNombreConocido(txtNombreConocido.getText().toUpperCase());
        estadio.setDireccion(txtDireccion.getText().toUpperCase());
        estadio.setCosto(Double.parseDouble(txtCosto.getText().toUpperCase()));
        estadio.setTribunas(Byte.parseByte(txtTribunas.getText()));
        estadio.setFechaFundacion(java.sql.Date.valueOf(formato.format(txtFechaFundacion.getDate())));
        estadio.setEquipoPropietario();
        estadio.setPais((Pais) paisC.obtenerdato(cbxCuidad.getSelectedItem().toString()));
        estadio.setConfederacion((Confederacion) confederacionC.obtenerdatoAcronimo(cbxDemension.getSelectedItem().toString()));

        if (btnGrabar.getText().equalsIgnoreCase("Grabar")) {

            if (fis == null) {
                try {
                    fis = new FileInputStream(new File("src/com/deportivo/iconos/foto_default.png"));

                } catch (FileNotFoundException e) {
                }

            }

            estadio.setFoto(fis);

            try {
                estadioC.registrar(estadio);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente el estadio");
                FrmGestionarEstadio.listar("");
//                FrmMenuPrincipal.txtCantEstadio.setText("" + estadioC.listar().size());
                dispose();
            } catch (Exception e) {
                AlertaError err = new AlertaError("Error", e.getMessage());
            }

        } else {

            estadio.setEstadioId(idEstadio);

            if (fis == null) {
                try {
                    fis = new FileInputStream(new File("src/com/deportivo/iconos/foto_default.png"));

                } catch (FileNotFoundException e) {
                }

            }

            estadio.setFoto(fis);

            try {
                estadioC.modificar(estadio);
                AlertaBien bien = new AlertaBien("Mensaje", "Se modificó correctamente el estadio");
                FrmGestionarEstadio.listar("");
//                FrmMenuPrincipal.txtCantEstadio.setText("" + estadioC.listar().size());
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
        txtNombreCompleto = new org.edisoncor.gui.textField.TextFieldRectBackground();
        btnGrabar = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        btnFoto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtNombreConocido = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel8 = new javax.swing.JLabel();
        txtCapacidad = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDireccion = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtFechaFundacion = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        txtTribunas = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel13 = new javax.swing.JLabel();
        txtCosto = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbxDemension = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbxCuidad = new javax.swing.JComboBox<>();
        txtPropietario = new org.edisoncor.gui.textField.TextFieldRectBackground();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Equipo");
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
        jLabel1.setText("Nombre Oficial*");

        txtNombreCompleto.setDescripcion("Ej. SELECCION NACIONAL DE ECUADOR");
        txtNombreCompleto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

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
        jLabel5.setText("Nombre Conocido");

        txtNombreConocido.setDescripcion("Ej. LOS MONOS");
        txtNombreConocido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("capacidad");

        txtCapacidad.setDescripcion("Ej. BRC");
        txtCapacidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Fecha Fundación");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Dirección");

        txtDireccion.setDescripcion("Ej. av...");
        txtDireccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Tribunas");

        txtTribunas.setDescripcion("Ej. 3");
        txtTribunas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Costo");

        txtCosto.setDescripcion("Ej. 3");
        txtCosto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Propietario");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Dimensión");

        cbxDemension.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Cuidad");

        cbxCuidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtPropietario.setDescripcion("Ej. LOS MONOS");
        txtPropietario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

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
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbxDemension, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxCuidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(17, 17, 17))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTribunas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 68, Short.MAX_VALUE))
                                            .addComponent(txtNombreConocido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCapacidad, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtFechaFundacion, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtPropietario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(txtNombreCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFoto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombreConocido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTribunas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnFoto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaFundacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCosto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxDemension, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxCuidad)))
                .addGap(17, 17, 17)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
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

        idEstadio = 0;
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnFoto;
    public static javax.swing.JButton btnGrabar;
    private javax.swing.JComboBox<String> cbxCuidad;
    private javax.swing.JComboBox<String> cbxDemension;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFoto;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCapacidad;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCosto;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDireccion;
    private com.toedter.calendar.JDateChooser txtFechaFundacion;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombreCompleto;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombreConocido;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtPropietario;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtTribunas;
    // End of variables declaration//GEN-END:variables
}
