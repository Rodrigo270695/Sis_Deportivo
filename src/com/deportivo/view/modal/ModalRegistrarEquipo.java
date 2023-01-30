package com.deportivo.view.modal;

import com.deportivo.controller.*;
import com.deportivo.model.Confederacion;
import com.deportivo.model.CuerpoTecnico;
import com.deportivo.model.Equipo;
import com.deportivo.model.Pais;
import com.deportivo.view.*;
import com.deportivo.vista.modal.alerts.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public final class ModalRegistrarEquipo extends javax.swing.JInternalFrame {

    EquipoController equipoC = new EquipoController();
    PaisController paisC = new PaisController();
    CuerpoTecnicoController cuerpoC = new CuerpoTecnicoController();
    ConfederacionController confederacionC = new ConfederacionController();
    FileInputStream fis;
    public static int idEquipo = 0;
    public static boolean vista = false;

    public ModalRegistrarEquipo() {
        initComponents();
        if (lblFoto.getIcon() == null) {
            lblFoto.setIcon(new ImageIcon("src/com/deportivo/iconos/foto_default.png"));
        }
        cargarCuerpoTecnico();
        cargarConfederacion();
        cargarPais();
        acciones();
    }

    private void cargarCuerpoTecnico() {

        cbxCuerpoTecnico.removeAllItems();

        List<CuerpoTecnico> lista = cuerpoC.listar();

        for (CuerpoTecnico cuerpoTecnico : lista) {
            cbxCuerpoTecnico.addItem(cuerpoTecnico.getNombre());
        }

    }

    private void cargarConfederacion() {

        cbxConfederacion.removeAllItems();

        List<Confederacion> lista = confederacionC.listar();

        for (Confederacion confederacion : lista) {
            cbxConfederacion.addItem(confederacion.getAcronimo());
        }

    }

    private void cargarPais() {

        cbxPais.removeAllItems();

        List<Pais> lista = paisC.listar();

        for (Pais pais : lista) {
            cbxPais.addItem(pais.getNombre());
        }

    }

    void acciones() {

        if (vista) {

            txtSeudonimo.setEnabled(false);
            txtFechaFundacion.setEnabled(false);
            txtCodFifa.setEnabled(false);
            txtNombreCompleto.setEnabled(false);
            txtNombreCorto.setEnabled(false);
            txtNumeroSocios.setEnabled(false);
            txtUbicacion.setEnabled(false);
            cbxConfederacion.setEnabled(false);
            cbxCuerpoTecnico.setEnabled(false);
            cbxPais.setEnabled(false);
            btnGrabar.setEnabled(false);
            btnFoto.setEnabled(false);

        }

        if (idEquipo > 0) {

            ImageIcon foto;
            Equipo equipo = (Equipo) equipoC.obtenerdato(idEquipo);

            txtNumeroSocios.setText("" + equipo.getNumSocios());
            txtUbicacion.setText(equipo.getUbicacion());
            txtSeudonimo.setText(equipo.getSeudonimo());
            txtFechaFundacion.setDate(equipo.getFundacion());
            txtNombreCompleto.setText(equipo.getNombreOficial());
            txtNombreCorto.setText(equipo.getNombreCorto());
            txtCodFifa.setText(equipo.getCodigoFifa());
            cbxConfederacion.setSelectedItem(equipo.getConfederacion().getAcronimo());
            cbxCuerpoTecnico.setSelectedItem(equipo.getCuerpoTecnico().getNombre());
            cbxPais.setSelectedItem(equipo.getPais().getNombre());

            try {
                BufferedImage bi = ImageIO.read(equipo.getFoto());
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

        Calendar cal;
        int d, m, a;
        String fecha1;
        cal = txtFechaFundacion.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH) + 1;
        a = cal.get(Calendar.YEAR);
        fecha1 = String.valueOf(a) + "-" + String.valueOf(m) + "-" + String.valueOf(d);

        Equipo equipo = new Equipo();
        equipo.setNombreCorto(txtNombreCorto.getText().toUpperCase());
        equipo.setNombreOficial(txtNombreCompleto.getText().toUpperCase());
        equipo.setSeudonimo(txtSeudonimo.getText().toUpperCase());
        equipo.setUbicacion(txtUbicacion.getText().toUpperCase());
        equipo.setCodigoFifa(txtCodFifa.getText().toUpperCase());
        equipo.setNumSocios(Integer.parseInt(txtNumeroSocios.getText()));
        equipo.setFundacion((java.sql.Date.valueOf(fecha1)));
        equipo.setCuerpoTecnico((CuerpoTecnico) cuerpoC.obtenerdato(cbxCuerpoTecnico.getSelectedItem().toString()));
        equipo.setPais((Pais) paisC.obtenerdato(cbxPais.getSelectedItem().toString()));
        equipo.setConfederacion((Confederacion) confederacionC.obtenerdatoAcronimo(cbxConfederacion.getSelectedItem().toString()));

        if (btnGrabar.getText().equalsIgnoreCase("Grabar")) {

            if (fis == null) {
                try {
                    fis = new FileInputStream(new File("src/com/deportivo/iconos/foto_default.png"));

                } catch (FileNotFoundException e) {
                }

            }

            equipo.setFoto(fis);

            try {
                equipoC.registrar(equipo);
                AlertaBien bien = new AlertaBien("Mensaje", "Se registró correctamente el equipo");
                FrmGestionarEquipo.listar("");
                FrmMenuPrincipal.txtCantEquipo.setText("" + equipoC.listar().size());
                dispose();
            } catch (Exception e) {
                AlertaError err = new AlertaError("Error", e.getMessage());
            }

        } else {

            equipo.setEquipoId(idEquipo);

            if (fis == null) {
                try {
                    fis = new FileInputStream(new File("src/com/deportivo/iconos/foto_default.png"));

                } catch (FileNotFoundException e) {
                }

            }

            equipo.setFoto(fis);

            try {
                equipoC.modificar(equipo);
                AlertaBien bien = new AlertaBien("Mensaje", "Se modificó correctamente el equipo");
                FrmGestionarEquipo.listar("");
                FrmMenuPrincipal.txtCantEquipo.setText("" + equipoC.listar().size());
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
        txtSeudonimo = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel8 = new javax.swing.JLabel();
        txtNombreCorto = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtUbicacion = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtFechaFundacion = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        txtNumeroSocios = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel13 = new javax.swing.JLabel();
        txtCodFifa = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel14 = new javax.swing.JLabel();
        cbxCuerpoTecnico = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cbxConfederacion = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbxPais = new javax.swing.JComboBox<>();

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
        jLabel5.setText("Seudonimo");

        txtSeudonimo.setDescripcion("Ej. LOS MONOS");
        txtSeudonimo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSeudonimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSeudonimoKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Nombre Corto");

        txtNombreCorto.setDescripcion("Ej. BRC");
        txtNombreCorto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombreCorto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCortoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Fecha Fundación");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Ubicación");

        txtUbicacion.setDescripcion("Ej. av...");
        txtUbicacion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Num. socios");

        txtNumeroSocios.setDescripcion("Ej. 3");
        txtNumeroSocios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNumeroSocios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroSociosKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Cod. Fifa");

        txtCodFifa.setDescripcion("Ej. 3");
        txtCodFifa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCodFifa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodFifaKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Cuerpo Técnico");

        cbxCuerpoTecnico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Confederación");

        cbxConfederacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("País");

        cbxPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbxConfederacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCodFifa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxPais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(17, 17, 17))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtNumeroSocios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSeudonimo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                            .addComponent(txtNombreCorto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtFechaFundacion, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxCuerpoTecnico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(txtNombreCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFoto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                    .addComponent(txtSeudonimo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreCorto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumeroSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnFoto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCuerpoTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaFundacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxConfederacion, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(txtCodFifa, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxPais)))
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

        idEquipo = 0;
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

    private void txtSeudonimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSeudonimoKeyTyped
        char caracter = evt.getKeyChar();

        if (!((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            Alerta alerta = new Alerta("ALERTA", "Solo acepta letras");
        }

    }//GEN-LAST:event_txtSeudonimoKeyTyped

    private void txtNombreCortoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCortoKeyTyped
        char caracter = evt.getKeyChar();

        if (!((caracter < '0') || (caracter > '9')) && (caracter != '\b') || txtNombreCorto.getText().length() >= 30) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            Alerta alerta = new Alerta("ALERTA", "Solo acepta 30 letras");
        }
    }//GEN-LAST:event_txtNombreCortoKeyTyped

    private void txtNumeroSociosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroSociosKeyTyped
        char caracter = evt.getKeyChar();

        if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            Alerta alerta = new Alerta("ALERTA", "Solo se aceptan números");
        }
    }//GEN-LAST:event_txtNumeroSociosKeyTyped

    private void txtCodFifaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodFifaKeyTyped
        char caracter = evt.getKeyChar();

        if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            Alerta alerta = new Alerta("ALERTA", "Solo se aceptan números");
        }
    }//GEN-LAST:event_txtCodFifaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnFoto;
    public static javax.swing.JButton btnGrabar;
    private javax.swing.JComboBox<String> cbxConfederacion;
    private javax.swing.JComboBox<String> cbxCuerpoTecnico;
    private javax.swing.JComboBox<String> cbxPais;
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
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCodFifa;
    private com.toedter.calendar.JDateChooser txtFechaFundacion;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombreCompleto;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombreCorto;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNumeroSocios;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtSeudonimo;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
