package com.deportivo.view.modal;

import com.deportivo.controller.*;
import com.deportivo.model.*;
import com.deportivo.properties.RenderTable;
import static com.deportivo.view.FrmGestionarCiudad.lblTotal;
import static com.deportivo.view.FrmGestionarCiudad.tblListado;
import com.deportivo.view.FrmGestionarIncidencias;
import com.deportivo.vista.modal.alerts.Alerta;
import com.deportivo.vista.modal.alerts.AlertaBien;
import com.deportivo.vista.modal.alerts.AlertaError;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public final class ModalRegistrarIncidenciaPartido extends javax.swing.JInternalFrame {

    DetallePartidoController detallePC = new DetallePartidoController();
    PartidoController partidoC = new PartidoController();
    FutbolistaController futbolistaC = new FutbolistaController();
    EquipoController equipoC = new EquipoController();
    EventoController eventoC = new EventoController();
    IncidenciaPartidoController incidenciaC = new IncidenciaPartidoController();
    InstanciaPartidoController instanciaC = new InstanciaPartidoController();
    DetalleEquipoController detalleEC = new DetalleEquipoController();
    DetalleGrupoController detalleGC = new DetalleGrupoController();
    String local, visita;
    int idLocal, idvisita;
    public static int idPartido;
    DetalleGrupo equipo1;
    DetalleGrupo equipo2;

    public ModalRegistrarIncidenciaPartido() {
        initComponents();
        cargarEventos();
        cargarEquipos();
        cargarInstancias();
        listar();
        equipo1 = detalleGC.listarEquipoGrupo(local);
        equipo2 = detalleGC.listarEquipoGrupo(visita);
    }

    void cargarEventos() {

        cbxEvento.removeAllItems();

        List<Evento> lista = eventoC.listar();

        for (Evento evento : lista) {
            cbxEvento.addItem(evento.getNombre());
        }

    }

    void cargarEquipos() {

        cbxEquipo.removeAllItems();
        cbxEquipo2.removeAllItems();

        List<DetallePartido> equipos = detallePC.listar(idPartido);

        for (DetallePartido equipo : equipos) {
            cbxEquipo.addItem(equipo.getEquipo().getNombreCorto());
            cbxEquipo2.addItem(equipo.getEquipo().getNombreCorto());
        }

    }

    void cargarInstancias() {

        cbxInstancia.removeAllItems();

        List<InstanciaPartido> lista = instanciaC.listar();

        for (InstanciaPartido instancia : lista) {
            cbxInstancia.addItem(instancia.getDescripcion());
        }

    }

    void grabar() {

        int valorMax = 0;

        if (cbxInstancia.getSelectedItem().toString().equals("TANDA DE PENALES")) {
            valorMax = -20;
        } else {
            valorMax = incidenciaC.minutoMaximo(idPartido);
        }

        if (Integer.parseInt(txtMinuto.getValue().toString()) >= 0 & Integer.parseInt(txtMinuto.getValue().toString()) > valorMax) {

            IncidenciaPartido ip = new IncidenciaPartido();
            ip.setEvento((Evento) eventoC.obtenerdato(cbxEvento.getSelectedItem().toString()));
            ip.setPartido((Partido) partidoC.obtenerdato(idPartido));
            ip.setFutbolista((Futbolista) futbolistaC.obtenerdato(cbxFutbolista.getSelectedItem().toString()));
            ip.setInstanciaPartido((InstanciaPartido) instanciaC.obtenerdato(cbxInstancia.getSelectedItem().toString()));
            ip.setMinuto((byte) Integer.parseInt(txtMinuto.getValue().toString()));
            ip.setEquipo((Equipo) equipoC.obtenerdato(cbxEquipo.getSelectedItem().toString()));
            if (!cbxFutbolista2.getSelectedItem().toString().equals("Seleccionar")
                    & !cbxInstancia.getSelectedItem().toString().equals("TANDA DE PENALES")) {
                ip.setFutbolista2((Futbolista) futbolistaC.obtenerdato(cbxFutbolista2.getSelectedItem().toString()));
            } else {
                ip.setFutbolista2(new Futbolista());
            }
            ip.setDetalle(txtDetalle.getText());
            try {
                if (ip.getInstanciaPartido().getInstancia_partido_id() == 1 & Integer.parseInt(txtMinuto.getValue().toString()) <= 45) {
                    incidenciaC.registrar(ip);
                } else if (ip.getInstanciaPartido().getInstancia_partido_id() == 2
                        & (Integer.parseInt(txtMinuto.getValue().toString()) > 45 & Integer.parseInt(txtMinuto.getValue().toString()) <= 90)) {
                    incidenciaC.registrar(ip);
                } else if (ip.getInstanciaPartido().getInstancia_partido_id() == 3
                        & (Integer.parseInt(txtMinuto.getValue().toString()) > 90 & Integer.parseInt(txtMinuto.getValue().toString()) <= 105)) {
                    incidenciaC.registrar(ip);
                } else if (ip.getInstanciaPartido().getInstancia_partido_id() == 4
                        & (Integer.parseInt(txtMinuto.getValue().toString()) > 105 & Integer.parseInt(txtMinuto.getValue().toString()) <= 120)) {
                    incidenciaC.registrar(ip);
                } else if (ip.getInstanciaPartido().getInstancia_partido_id() == 5) {
                    ip.setMinuto((byte) 127);
                    incidenciaC.registrar(ip);
                } else {
                    AlertaError error = new AlertaError("ERROR", "Minuto inválido");
                    return;
                }
                listar();
                txtDetalle.setText("");
                AlertaBien bien = new AlertaBien("MENSAJE", "Se agregó la incidencia correctamente");

            } catch (Exception e) {
                AlertaError error = new AlertaError("ERROR", "Ocurrió un error vuelva a intentarlo");
            }
        } else {
            AlertaError error = new AlertaError("ERROR", "Minuto inválido");
        }

    }

    public void listar() {

        DefaultTableModel modelo = new DefaultTableModel();
        List equipos = detallePC.listar(idPartido);
        List incidencias = incidenciaC.listar(idPartido);
        DetallePartido dp;
        IncidenciaPartido ip;
        Object obj[] = new Object[3];
        int equiVisita = 0, equiLocal = 0;
        String minuto;
        String jugador2;
        ImageIcon icono = new ImageIcon("src/com/deportivo/iconos/var.png");
        Icon btnEliminar = new ImageIcon(icono.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
        JButton botonEliminar = new JButton("", btnEliminar);
        botonEliminar.setName("btnEliminar");
        botonEliminar.setToolTipText("var");
        botonEliminar.setBorder(null);
        botonEliminar.setBackground(new Color(223, 68, 83));
        for (int i = 0; i < equipos.size(); i++) {
            dp = (DetallePartido) equipos.get(i);
            if (dp.getTipo().equalsIgnoreCase("V")) {
                modelo.addColumn(dp.getEquipo().getNombreCorto());
                local = dp.getEquipo().getNombreCorto();
                idLocal = dp.getEquipo().getEquipoId();
            } else {
                modelo.addColumn(dp.getEquipo().getNombreCorto());
                visita = dp.getEquipo().getNombreCorto();
                idvisita = dp.getEquipo().getEquipoId();
            }
        }
        modelo.addColumn("");

        for (int i = 0; i < incidencias.size(); i++) {
            ip = (IncidenciaPartido) incidencias.get(i);

            if (ip.getMinuto() == 127) {
                minuto = "";
            } else {
                minuto = "" + ip.getMinuto();
            }

            if (ip.getFutbolista2().getNombreCompleto() == null) {
                jugador2 = "";
            } else {
                jugador2 = " (" + ip.getFutbolista2().getNombreCompleto() + ")";
            }

            if (ip.getEquipo().getNombreCorto().equals(visita)) {
                obj[0] = "" + minuto + "' - " + ip.getEvento().getNombre() + " - " + ip.getFutbolista().getNombreCompleto() + jugador2+ (ip.isVar() ? " -- VAR": "");
                obj[1] = "";
                obj[2] = botonEliminar;
                modelo.addRow(obj);
                if (ip.getEvento().getEventoId() == 1) {
                    equiLocal++;
                }
            } else if (ip.getEquipo().getNombreCorto().equals(local)) {
                obj[0] = "";
                obj[1] = "" + minuto + "' - " + ip.getEvento().getNombre() + " - " + ip.getFutbolista().getNombreCompleto() + jugador2+(ip.isVar() ? " -- VAR": "");
                obj[2] = botonEliminar;
                modelo.addRow(obj);
                if (ip.getEvento().getEventoId() == 1) {
                    equiVisita++;
                }
            }

            lblLocal.setText("" + equiLocal);
            lblVisita.setText("" + equiVisita);
        }

        tblListado.setRowHeight(30);
        tblListado.setModel(modelo);
        tblListado.setBackground(Color.WHITE);
        tblListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblListado.getColumnModel().getColumn(0).setPreferredWidth(360);
        tblListado.getColumnModel().getColumn(1).setPreferredWidth(360);
        tblListado.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    private void agregarDetallePartido() {

        DetallePartido detalleP1 = new DetallePartido();
        DetallePartido detalleP2 = new DetallePartido();
        DetalleGrupo equi1 = new DetalleGrupo();
        DetalleGrupo equi2 = new DetalleGrupo();

        int golesV = 0, golesL = 0;
        int faltasL = 0, faltasV = 0;
        int taL = 0, taV = 0;
        int trL = 0, trV = 0;
        int tL = 0, tV = 0;
        int fueraL = 0, fueraV = 0;
        int teL = 0, teV = 0;
        String cL, cV;

        int pj1, g1, e1, p1, gf1, gc1, df1, pts1;
        int pj2, g2, e2, p2, gf2, gc2, df2, pts2;
        pj1 = 0;
        g1 = 0;
        e1 = 0;
        p1 = 0;
        gf1 = 0;
        gc1 = 0;
        df1 = 0;
        pts1 = 0;

        pj2 = 0;
        g2 = 0;
        e2 = 0;
        p2 = 0;
        gf2 = 0;
        gc2 = 0;
        df2 = 0;
        pts2 = 0;

        List incidencias = incidenciaC.listar(idPartido);
        IncidenciaPartido incidencia;

        for (int i = 0; i < incidencias.size(); i++) {

            incidencia = (IncidenciaPartido) incidencias.get(i);

            if (incidencia.getEquipo().getNombreCorto().equals(visita)) {

                if (incidencia.isVar() == false) {
                    switch (incidencia.getEvento().getNombre()) {
                        case "GOAL" -> {
                            golesV++;
                        }
                        case "FALTA" -> {
                            faltasV++;
                        }
                        case "TARJETA AMARILLA" -> {
                            taV++;
                        }
                        case "TARJETA ROJA" -> {
                            trV++;
                        }
                        case "TIRO DE ESQUINA" -> {
                            teV++;
                        }
                        case "TIRO" -> {
                            tV++;
                        }
                        case "FUERA DE LUGAR" -> {
                            fueraV++;
                        }
                    }
                }

            } else {

                if (incidencia.isVar() == false) {

                    switch (incidencia.getEvento().getNombre()) {
                        case "GOAL" -> {
                            golesL++;
                        }
                        case "FALTA" -> {
                            faltasL++;
                        }
                        case "TARJETA AMARILLA" -> {
                            taL++;
                        }
                        case "TARJETA ROJA" -> {
                            trL++;
                        }
                        case "TIRO DE ESQUINA" -> {
                            teL++;
                        }
                        case "TIRO" -> {
                            tL++;
                        }
                        case "FUERA DE LUGAR" -> {
                            fueraL++;
                        }
                    }
                }

            }

        }
        detalleP1.setGoles((byte) golesL);
        detalleP1.setFaltas((short) faltasL);
        detalleP1.setTarjetasAmarillas((byte) taL);
        detalleP1.setTarjtetasRojas((byte) trL);
        detalleP1.setTirosEquina((byte) teL);
        detalleP1.setTiros((byte) tL);
        detalleP1.setFueraLugar((byte) fueraL);
        detalleP1.setPartido(new Partido(idPartido));
        detalleP1.setEquipo(new Equipo(idLocal));

        detalleP2.setGoles((byte) golesV);
        detalleP2.setFaltas((short) faltasV);
        detalleP2.setTarjetasAmarillas((byte) taV);
        detalleP2.setTarjtetasRojas((byte) trV);
        detalleP2.setTirosEquina((byte) teV);
        detalleP2.setTiros((byte) tV);
        detalleP2.setFueraLugar((byte) fueraV);
        detalleP2.setPartido(new Partido(idPartido));
        detalleP2.setEquipo(new Equipo(idvisita));

        detallePC.actualizarDetalle(detalleP1);
        detallePC.actualizarDetalle(detalleP2);

        pj1++;
        pj2++;
        if (golesL > golesV) {
            g1++;
            p2++;
            gf1 += golesL;
            gf2 += golesV;
            gc1 += golesV;
            gc2 += golesL;
            pts1 += 3;
        } else if (golesL < golesV) {
            g2++;
            p1++;
            gf2 += golesV;
            gf1 += golesL;
            gc1 += golesL;
            gc2 += golesV;
            pts2 += 3;
        } else {
            e1++;
            e2++;
            gf2 += golesV;
            gf1 += golesL;
            gc1 += golesL;
            gc2 += golesV;
            pts1++;
            pts2++;
        }
        df1 = gf1 - gc1;
        df2 = gf2 - gc2;

        equi1.setPj((short) (pj1 + equipo1.getPj()));
        equi1.setG((short) (g1 + equipo1.getG()));
        equi1.setE((short) (e1 + equipo1.getE()));
        equi1.setP((short) (p1 + equipo1.getP()));
        equi1.setGc((short) (gc1 + equipo1.getGc()));
        equi1.setGf((short) (gf1 + equipo1.getGf()));
        equi1.setDf((short) (df1 + equipo1.getDf()));
        equi1.setPts((short) (pts1 + equipo1.getPts()));
        equi1.setEquipo((Equipo) equipoC.obtenerdato(local));

        equi2.setPj((short) (pj2 + equipo2.getPj()));
        equi2.setG((short) (g2 + equipo2.getG()));
        equi2.setE((short) (e2 + equipo2.getE()));
        equi2.setP((short) (p2 + equipo2.getP()));
        equi2.setGc((short) (gc2 + equipo2.getGc()));
        equi2.setGf((short) (gf2 + equipo2.getGf()));
        equi2.setDf((short) (df2 + equipo2.getDf()));
        equi2.setPts((short) (pts2 + equipo2.getPts()));
        equi2.setEquipo((Equipo) equipoC.obtenerdato(visita));

        detalleGC.actualizarDetalle(equi1);
        detalleGC.actualizarDetalle(equi2);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cbxEvento = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxInstancia = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbxEquipo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbxFutbolista = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtDetalle = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel9 = new javax.swing.JLabel();
        txtMinuto = new javax.swing.JSpinner();
        btnGrabar = new javax.swing.JButton();
        btnMostrarEquipos = new javax.swing.JButton();
        btnGrabar1 = new javax.swing.JButton();
        lblLocal = new javax.swing.JLabel();
        lblVisita = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxEquipo2 = new javax.swing.JComboBox<>();
        btnMostrarEquipos1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbxFutbolista2 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRAR INCIDENCIAS");

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

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Evento");

        cbxEvento.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Instancia");

        cbxInstancia.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxInstancia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxInstancia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxInstanciaMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Equipo");

        cbxEquipo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Futbolista");

        cbxFutbolista.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxFutbolista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Detalle");

        txtDetalle.setDescripcion("Ej. De cabeza");
        txtDetalle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Minuto");

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

        btnMostrarEquipos.setText("...");
        btnMostrarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarEquiposActionPerformed(evt);
            }
        });

        btnGrabar1.setBackground(new java.awt.Color(255, 102, 102));
        btnGrabar1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnGrabar1.setForeground(new java.awt.Color(255, 255, 255));
        btnGrabar1.setMnemonic('N');
        btnGrabar1.setText("Terminar Partido");
        btnGrabar1.setToolTipText("Realizar Nuevo Registro");
        btnGrabar1.setBorder(null);
        btnGrabar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGrabar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabar1ActionPerformed(evt);
            }
        });

        lblLocal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        lblVisita.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblVisita.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Equipo");

        cbxEquipo2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxEquipo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnMostrarEquipos1.setText("...");
        btnMostrarEquipos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarEquipos1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Futbolista 2");

        cbxFutbolista2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxFutbolista2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxInstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                        .addGap(154, 154, 154))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(cbxEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnMostrarEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                            .addComponent(cbxFutbolista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(cbxEquipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnMostrarEquipos1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbxFutbolista2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnGrabar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxEvento))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxInstancia))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxEquipo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxFutbolista, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btnMostrarEquipos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMostrarEquipos1)
                            .addComponent(cbxEquipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(8, 8, 8)
                        .addComponent(cbxFutbolista2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGrabar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked

        int fila = tblListado.getSelectedRow();
        int id = 0;
        if (!tblListado.getValueAt(fila, 0).toString().isEmpty()) {
            id = Integer.parseInt(String.valueOf(tblListado.getValueAt(fila, 0).toString().charAt(0)));
        }else{
            id = Integer.parseInt(String.valueOf(tblListado.getValueAt(fila, 1).toString().charAt(0)));
        }

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
                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un partido");
                        } else {
                            String valor = String.valueOf(tblListado.getValueAt(fila, 1));

                            int opcion = JOptionPane.showConfirmDialog(null, "¿Estas seguro de enular la incidencia?", "Confirmar", 2);
                            if (opcion == 0) {

                                try {
                                    AlertaBien alertaBien = new AlertaBien("Mensaje", "Incidencia anulada correctamente!");
                                    incidenciaC.anularIncidencia(id, idPartido);
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

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed

        grabar();
        agregarDetallePartido();

    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnGrabar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabar1ActionPerformed

        agregarDetallePartido();
        partidoC.acabarpartido(idPartido);
        AlertaBien bien = new AlertaBien("MENSAJE", "El partido a culminado");
        FrmGestionarIncidencias.listar("");
        this.dispose();

    }//GEN-LAST:event_btnGrabar1ActionPerformed

    private void cbxInstanciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxInstanciaMouseClicked
        if (cbxInstancia.getSelectedItem().toString().equals("TANDA DE PENALES")) {
            txtMinuto.setEnabled(false);
        } else {
            txtMinuto.setEnabled(true);
        }
    }//GEN-LAST:event_cbxInstanciaMouseClicked

    private void btnMostrarEquipos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarEquipos1ActionPerformed

        Equipo equipo = (Equipo) equipoC.obtenerdato(cbxEquipo2.getSelectedItem().toString());

        List<DetalleEquipo> lista = detalleEC.listar(equipo.getEquipoId());

        cbxFutbolista2.removeAllItems();
        cbxFutbolista2.addItem("Seleccionar");

        for (DetalleEquipo detalle : lista) {
            cbxFutbolista2.addItem(detalle.getFutbolista().getNombreCompleto());
        }
    }//GEN-LAST:event_btnMostrarEquipos1ActionPerformed

    private void btnMostrarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarEquiposActionPerformed

        Equipo equipo = (Equipo) equipoC.obtenerdato(cbxEquipo.getSelectedItem().toString());

        List<DetalleEquipo> lista = detalleEC.listar(equipo.getEquipoId());

        cbxFutbolista.removeAllItems();
        cbxFutbolista.addItem("Seleccionar");

        for (DetalleEquipo detalle : lista) {
            cbxFutbolista.addItem(detalle.getFutbolista().getNombreCompleto());
        }
    }//GEN-LAST:event_btnMostrarEquiposActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGrabar;
    public static javax.swing.JButton btnGrabar1;
    private javax.swing.JButton btnMostrarEquipos;
    private javax.swing.JButton btnMostrarEquipos1;
    public static javax.swing.JComboBox<String> cbxEquipo;
    public static javax.swing.JComboBox<String> cbxEquipo2;
    public static javax.swing.JComboBox<String> cbxEvento;
    public static javax.swing.JComboBox<String> cbxFutbolista;
    public static javax.swing.JComboBox<String> cbxFutbolista2;
    public static javax.swing.JComboBox<String> cbxInstancia;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblVisita;
    public static javax.swing.JTable tblListado;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDetalle;
    private javax.swing.JSpinner txtMinuto;
    // End of variables declaration//GEN-END:variables
}
