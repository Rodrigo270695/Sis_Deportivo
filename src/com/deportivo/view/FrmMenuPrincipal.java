package com.deportivo.view;

import com.deportivo.controller.EquipoController;
import com.deportivo.controller.RolPermisoController;
import com.deportivo.model.Permiso;
import com.deportivo.model.RolPermiso;
import com.deportivo.model.Usuario;
import com.deportivo.reporte.Reporte_1;
import com.deportivo.reporte.Reporte_2;
import com.deportivo.reporte.Reporte_3;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

public class FrmMenuPrincipal extends javax.swing.JFrame {

    RolPermisoController rolPC = new RolPermisoController();
    EquipoController equipoC = new EquipoController();
    public static Usuario usuario;

    public FrmMenuPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("..:: SISTEMA DEPORTIVO - GRUPO GO ::..");
        txtCantEquipo.setText("" + equipoC.listar().size());

        if (usuario == null) {
            mnuUsuario.setText("Visitante");
        } else {

            mnuUsuario.setText(usuario.getNombre());
        }
        desactivarControles();
        cargarPermisos();
    }

    private void cargarPermisos() {

        if (usuario == null) {
            mnuTv.setVisible(true);
        } else {
            RolPermiso detalleP = rolPC.listar(usuario.getDocumento());

            for (Permiso permiso : detalleP.getPermisos()) {

                switch (permiso.getDescripcion()) {
                    case "mnuMantenimiento" -> {
                        mnuMantenimiento.setVisible(true);
                    }
                    case "mnuAdministracion" -> {
                        mnuAdministracion.setVisible(true);
                    }
                    case "mnuGestion" -> {
                        mnuGestion.setVisible(true);
                    }
                    case "mnuReportes" -> {
                        mnuReportes.setVisible(true);
                    }
                    case "mnuTv" -> {
                        mnuTv.setVisible(true);
                    }
                    case "itemArbitro" -> {
                        itemArbitro.setVisible(true);
                    }
                    case "itemCategoriaArbitro" -> {
                        itemCategoriaArbitro.setVisible(true);
                    }
                    case "itemCompetencia" -> {
                        itemCompetencia.setVisible(true);
                    }
                    case "itemConfedacion" -> {
                        itemConfedacion.setVisible(true);
                    }
                    case "itemContinente" -> {
                        itemContinente.setVisible(true);
                    }
                    case "itemContrato" -> {
                        itemContrato.setVisible(true);
                    }
                    case "itemCuerpoTecnico" -> {
                        itemCuerpoTecnico.setVisible(true);
                    }
                    case "itemCuidad" -> {
                        itemCuidad.setVisible(true);
                    }
                    case "itemEquipo" -> {
                        itemEquipo.setVisible(true);
                    }
                    case "itemEtapaFixture" -> {
                        itemEtapaFixture.setVisible(true);
                    }
                    case "itemEvento" -> {
                        itemEvento.setVisible(true);
                    }
                    case "itemFixture" -> {
                        itemFixture.setVisible(true);
                    }
                    case "itemFormacion" -> {
                        itemFormacion.setVisible(true);
                    }
                    case "itemFutbolista" -> {
                        itemFutbolista.setVisible(true);
                    }
                    case "itemGrupo" -> {
                        itemGrupo.setVisible(true);
                    }
                    case "itemInstanciaPartido" -> {
                        itemInstanciaPartido.setVisible(true);
                    }
                    case "itemJornada" -> {
                        itemJornada.setVisible(true);
                    }
                    case "itemPais" -> {
                        itemPais.setVisible(true);
                    }
                    case "itemPosicion" -> {
                        itemPosicion.setVisible(true);
                    }
                    case "itemProfesional" -> {
                        itemProfesional.setVisible(true);
                    }
                    case "itemRol" -> {
                        itemRol.setVisible(true);
                    }
                    case "itemTernaArbitral" -> {
                        itemTernaArbitral.setVisible(true);
                    }
                    case "itemTipoJugador" -> {
                        itemTipoJugador.setVisible(true);
                    }
                    case "itemTipoProfesional" -> {
                        itemTipoProfesional.setVisible(true);
                    }
                    case "itemTipoTernaArbitral" -> {
                        itemTipoTernaArbitral.setVisible(true);
                    }
                    case "itemUsuario" -> {
                        itemUsuario.setVisible(true);
                    }
                }

            }
        }

    }

    private void desactivarControles() {

        mnuAdministracion.setVisible(false);
        mnuGestion.setVisible(false);
        mnuMantenimiento.setVisible(false);
        mnuMantenimiento.setVisible(false);
        mnuReportes.setVisible(false);
        mnuTv.setVisible(false);
        itemArbitro.setVisible(false);
        itemCategoriaArbitro.setVisible(false);
        itemCompetencia.setVisible(false);
        itemConfedacion.setVisible(false);
        itemContinente.setVisible(false);
        itemContrato.setVisible(false);
        itemCuerpoTecnico.setVisible(false);
        itemCuidad.setVisible(false);
        itemEquipo.setVisible(false);
        itemEtapaFixture.setVisible(false);
        itemEvento.setVisible(false);
        itemFixture.setVisible(false);
        itemFormacion.setVisible(false);
        itemFutbolista.setVisible(false);
        itemGrupo.setVisible(false);
        itemInstanciaPartido.setVisible(false);
        itemJornada.setVisible(false);
        itemPais.setVisible(false);
        itemPosicion.setVisible(false);
        itemProfesional.setVisible(false);
        itemRol.setVisible(false);
        itemTernaArbitral.setVisible(false);
        itemTipoJugador.setVisible(false);
        itemTipoProfesional.setVisible(false);
        itemTipoTernaArbitral.setVisible(false);
        itemUsuario.setVisible(false);

    }

    public static void centrarVentana(JInternalFrame frame) {
        escritorio.add(frame);
        Dimension dimension = escritorio.getSize();
        Dimension ventana = frame.getSize();
        frame.setLocation((dimension.width - ventana.width) / 2, (dimension.height - ventana.height) / 2);
        frame.show();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/com/deportivo/iconos/fondo-depor.png"));
        Image image = icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCantEquipo = new javax.swing.JLabel();
        txtCantEquipo1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuMantenimiento = new javax.swing.JMenu();
        itemContinente = new javax.swing.JMenuItem();
        itemArbitro = new javax.swing.JMenuItem();
        itemTernaArbitral = new javax.swing.JMenuItem();
        itemCuerpoTecnico = new javax.swing.JMenuItem();
        itemTipoProfesional = new javax.swing.JMenuItem();
        itemPosicion = new javax.swing.JMenuItem();
        itemEvento = new javax.swing.JMenuItem();
        itemGrupo = new javax.swing.JMenuItem();
        itemEquipo = new javax.swing.JMenuItem();
        itemCompetencia = new javax.swing.JMenuItem();
        itemConfedacion = new javax.swing.JMenuItem();
        itemProfesional = new javax.swing.JMenuItem();
        itemTipoDoc = new javax.swing.JMenuItem();
        itemDimensionEstadio = new javax.swing.JMenuItem();
        mnuGestion = new javax.swing.JMenu();
        itemPais = new javax.swing.JMenuItem();
        itemFutbolista = new javax.swing.JMenuItem();
        itemContrato = new javax.swing.JMenuItem();
        itemCuidad = new javax.swing.JMenuItem();
        itemFixture = new javax.swing.JMenuItem();
        itemEtapaFixture = new javax.swing.JMenuItem();
        itemJornada = new javax.swing.JMenuItem();
        itemFormacion = new javax.swing.JMenuItem();
        itemInstanciaPartido = new javax.swing.JMenuItem();
        itemTipoJugador = new javax.swing.JMenuItem();
        itemTipoTernaArbitral = new javax.swing.JMenuItem();
        itemCategoriaArbitro = new javax.swing.JMenuItem();
        itemEstadio = new javax.swing.JMenuItem();
        itemPartido = new javax.swing.JMenuItem();
        itemIncidencias = new javax.swing.JMenuItem();
        mnuReportes = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        mnuTv = new javax.swing.JMenu();
        itemPartidosEnVivo = new javax.swing.JMenuItem();
        ItemPartidosAnteriores = new javax.swing.JMenuItem();
        mnuAdministracion = new javax.swing.JMenu();
        itemRol = new javax.swing.JMenuItem();
        itemUsuario = new javax.swing.JMenuItem();
        mnuUsuario = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/com/deportivo/iconos/sin_fondo_depor.png")).getImage());

        escritorio.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(74, 130, 94));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/equipo40.png"))); // NOI18N

        txtCantEquipo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCantEquipo.setForeground(new java.awt.Color(255, 255, 255));
        txtCantEquipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtCantEquipo1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCantEquipo1.setForeground(new java.awt.Color(255, 255, 255));
        txtCantEquipo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCantEquipo1.setText("Equipo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantEquipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantEquipo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCantEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(txtCantEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        escritorio.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(692, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(434, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 51, 0));
        jMenuBar1.setToolTipText("Menú Principal");

        mnuMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/Mantenimiento30.png"))); // NOI18N
        mnuMantenimiento.setText("Mantenimiento");
        mnuMantenimiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemContinente.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        itemContinente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/Continente25.png"))); // NOI18N
        itemContinente.setText("Gestionar Continente");
        itemContinente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemContinenteActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(itemContinente);

        itemArbitro.setText("Gestionar Arbitro");
        itemArbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemArbitroActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(itemArbitro);

        itemTernaArbitral.setText("Gestionar Terna Arbitral ");
        itemTernaArbitral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTernaArbitralActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(itemTernaArbitral);

        itemCuerpoTecnico.setText("Gestionar Cuerpo Técnico");
        itemCuerpoTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCuerpoTecnicoActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(itemCuerpoTecnico);

        itemTipoProfesional.setText("Gestionar Tipo Profesional");
        itemTipoProfesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTipoProfesionalActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(itemTipoProfesional);

        itemPosicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/posicion25.png"))); // NOI18N
        itemPosicion.setText("Gestionar Posición");
        itemPosicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPosicionActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(itemPosicion);

        itemEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/evento25.png"))); // NOI18N
        itemEvento.setText("Gestionar Evento");
        itemEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEventoActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(itemEvento);

        itemGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/grupo25.png"))); // NOI18N
        itemGrupo.setText("Gestionar Grupo");
        itemGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGrupoActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(itemGrupo);

        itemEquipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/equipo25.png"))); // NOI18N
        itemEquipo.setText("Gestionar equipo");
        itemEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEquipoActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(itemEquipo);

        itemCompetencia.setText("Gestionar Competencia");
        itemCompetencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCompetenciaActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(itemCompetencia);

        itemConfedacion.setText("Gestionar Confederacion");
        itemConfedacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConfedacionActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(itemConfedacion);

        itemProfesional.setText("Gestionar Profesional");
        itemProfesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProfesionalActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(itemProfesional);

        itemTipoDoc.setText("Gestionar Tipo Documento");
        itemTipoDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTipoDocActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(itemTipoDoc);

        itemDimensionEstadio.setText("Gestionar Dimension Estadio");
        itemDimensionEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDimensionEstadioActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(itemDimensionEstadio);

        jMenuBar1.add(mnuMantenimiento);

        mnuGestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/Gestion30.png"))); // NOI18N
        mnuGestion.setText("Gestión");
        mnuGestion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemPais.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        itemPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/Pais25.png"))); // NOI18N
        itemPais.setText("Gestionar Pais");
        itemPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPaisActionPerformed(evt);
            }
        });
        mnuGestion.add(itemPais);

        itemFutbolista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/futbolista25.png"))); // NOI18N
        itemFutbolista.setText("Gestionar Futbolista");
        itemFutbolista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFutbolistaActionPerformed(evt);
            }
        });
        mnuGestion.add(itemFutbolista);

        itemContrato.setText("Gestionar Contrato");
        itemContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemContratoActionPerformed(evt);
            }
        });
        mnuGestion.add(itemContrato);

        itemCuidad.setText("Gestionar Ciudad");
        itemCuidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCuidadActionPerformed(evt);
            }
        });
        mnuGestion.add(itemCuidad);

        itemFixture.setText("Gestionar Fixture");
        itemFixture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFixtureActionPerformed(evt);
            }
        });
        mnuGestion.add(itemFixture);

        itemEtapaFixture.setText("Gestionar Etapa Fixture");
        itemEtapaFixture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEtapaFixtureActionPerformed(evt);
            }
        });
        mnuGestion.add(itemEtapaFixture);

        itemJornada.setText("Gestionar Jornada");
        itemJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemJornadaActionPerformed(evt);
            }
        });
        mnuGestion.add(itemJornada);

        itemFormacion.setText("Gestionar Formación");
        itemFormacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFormacionActionPerformed(evt);
            }
        });
        mnuGestion.add(itemFormacion);

        itemInstanciaPartido.setText("Gestionar Instancia Partido");
        itemInstanciaPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemInstanciaPartidoActionPerformed(evt);
            }
        });
        mnuGestion.add(itemInstanciaPartido);

        itemTipoJugador.setText("Tipo de Jugador");
        itemTipoJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTipoJugadorActionPerformed(evt);
            }
        });
        mnuGestion.add(itemTipoJugador);

        itemTipoTernaArbitral.setText("Tipo de Terna Arbitral");
        itemTipoTernaArbitral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTipoTernaArbitralActionPerformed(evt);
            }
        });
        mnuGestion.add(itemTipoTernaArbitral);

        itemCategoriaArbitro.setText("Categoria Arbitro");
        itemCategoriaArbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCategoriaArbitroActionPerformed(evt);
            }
        });
        mnuGestion.add(itemCategoriaArbitro);

        itemEstadio.setText("Gestionar estadio");
        itemEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEstadioActionPerformed(evt);
            }
        });
        mnuGestion.add(itemEstadio);

        itemPartido.setText("Gestionar Partido");
        itemPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPartidoActionPerformed(evt);
            }
        });
        mnuGestion.add(itemPartido);

        itemIncidencias.setText("Gestionar Incidencias");
        itemIncidencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemIncidenciasActionPerformed(evt);
            }
        });
        mnuGestion.add(itemIncidencias);

        jMenuBar1.add(mnuGestion);

        mnuReportes.setText("REPORTES");

        jMenuItem19.setText("Reporte detallado de grupo");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        mnuReportes.add(jMenuItem19);

        jMenuItem2.setText("Reporte de jornada");
        mnuReportes.add(jMenuItem2);

        jMenuItem3.setText("Reporte Terna Arbitral Partido");
        mnuReportes.add(jMenuItem3);

        jMenuItem4.setText("Reporte Alineación de partido");
        mnuReportes.add(jMenuItem4);

        jMenuItem5.setText("Listado de partidos por grupo");
        mnuReportes.add(jMenuItem5);

        jMenuItem6.setText("Tabla de Goleadores");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mnuReportes.add(jMenuItem6);

        jMenuItem7.setText("Primero puestos por mundial");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        mnuReportes.add(jMenuItem7);

        jMenuItem8.setText("Reporte Participante de equipos por competencia");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        mnuReportes.add(jMenuItem8);

        jMenuBar1.add(mnuReportes);

        mnuTv.setText("TELEVISION");

        itemPartidosEnVivo.setText("Partidos en vivo");
        itemPartidosEnVivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPartidosEnVivoActionPerformed(evt);
            }
        });
        mnuTv.add(itemPartidosEnVivo);

        ItemPartidosAnteriores.setText("Partido Anteriores");
        mnuTv.add(ItemPartidosAnteriores);

        jMenuBar1.add(mnuTv);

        mnuAdministracion.setText("ADMINISTRACIÓN");

        itemRol.setText("Gestionar Rol");
        itemRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRolActionPerformed(evt);
            }
        });
        mnuAdministracion.add(itemRol);

        itemUsuario.setText("Gestionar Usuario");
        itemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUsuarioActionPerformed(evt);
            }
        });
        mnuAdministracion.add(itemUsuario);

        jMenuBar1.add(mnuAdministracion);

        mnuUsuario.setText("USER");

        jMenuItem1.setText("Cerrar Sesión");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuUsuario.add(jMenuItem1);

        jMenuBar1.add(mnuUsuario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPaisActionPerformed

        centrarVentana(new FrmGestionarPais());

    }//GEN-LAST:event_itemPaisActionPerformed

    private void itemFutbolistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFutbolistaActionPerformed

        centrarVentana(new FrmGestionarFutbolista());

    }//GEN-LAST:event_itemFutbolistaActionPerformed

    private void itemCompetenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCompetenciaActionPerformed

        centrarVentana(new FrmGestionarCompetencia());

    }//GEN-LAST:event_itemCompetenciaActionPerformed

    private void itemEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEquipoActionPerformed

        centrarVentana(new FrmGestionarEquipo());

    }//GEN-LAST:event_itemEquipoActionPerformed

    private void itemGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGrupoActionPerformed

        centrarVentana(new FrmGestionarGrupo());
    }//GEN-LAST:event_itemGrupoActionPerformed

    private void itemEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEventoActionPerformed

        centrarVentana(new FrmGestionarEvento());
    }//GEN-LAST:event_itemEventoActionPerformed

    private void itemPosicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPosicionActionPerformed

        centrarVentana(new FrmGestionarPosicion());

    }//GEN-LAST:event_itemPosicionActionPerformed

    private void itemTipoProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTipoProfesionalActionPerformed

        centrarVentana(new FrmGestionarTipoProfesional());
    }//GEN-LAST:event_itemTipoProfesionalActionPerformed

    private void itemCuerpoTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCuerpoTecnicoActionPerformed

        centrarVentana(new FrmGestionarCuerpoTecnico());
    }//GEN-LAST:event_itemCuerpoTecnicoActionPerformed

    private void itemTernaArbitralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTernaArbitralActionPerformed
        centrarVentana(new FrmGestionarTernaArbitral());
    }//GEN-LAST:event_itemTernaArbitralActionPerformed

    private void itemArbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemArbitroActionPerformed

        centrarVentana(new FrmGestionarArbitro());

    }//GEN-LAST:event_itemArbitroActionPerformed

    private void itemContinenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemContinenteActionPerformed

        centrarVentana(new FrmGestionarContinente());
    }//GEN-LAST:event_itemContinenteActionPerformed

    private void itemConfedacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConfedacionActionPerformed

        centrarVentana(new FrmGestionarConfederacion());

    }//GEN-LAST:event_itemConfedacionActionPerformed

    private void itemProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProfesionalActionPerformed

        centrarVentana(new FrmGestionarProfesional());
    }//GEN-LAST:event_itemProfesionalActionPerformed

    private void itemContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemContratoActionPerformed
        centrarVentana(new FrmGestionarContrato());
    }//GEN-LAST:event_itemContratoActionPerformed

    private void itemCuidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCuidadActionPerformed
        centrarVentana(new FrmGestionarCiudad());
    }//GEN-LAST:event_itemCuidadActionPerformed

    private void itemFixtureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFixtureActionPerformed
        centrarVentana(new FrmGestionarFixture());
    }//GEN-LAST:event_itemFixtureActionPerformed

    private void itemEtapaFixtureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEtapaFixtureActionPerformed
        centrarVentana(new FrmGestionarEtapaFixture());
    }//GEN-LAST:event_itemEtapaFixtureActionPerformed

    private void itemJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemJornadaActionPerformed
        centrarVentana(new FrmGestionarJornada());
    }//GEN-LAST:event_itemJornadaActionPerformed

    private void itemFormacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFormacionActionPerformed
        centrarVentana(new FrmGestionarFormacionEquipo());
    }//GEN-LAST:event_itemFormacionActionPerformed

    private void itemInstanciaPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInstanciaPartidoActionPerformed
        centrarVentana(new FrmGestionarInstanciaPartido());
    }//GEN-LAST:event_itemInstanciaPartidoActionPerformed

    private void itemTipoJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTipoJugadorActionPerformed
        centrarVentana(new FrmGestionarTipoJugador());
    }//GEN-LAST:event_itemTipoJugadorActionPerformed

    private void itemTipoTernaArbitralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTipoTernaArbitralActionPerformed
        centrarVentana(new FrmGestionarTipoTernaArbitral());
    }//GEN-LAST:event_itemTipoTernaArbitralActionPerformed

    private void itemCategoriaArbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCategoriaArbitroActionPerformed
        centrarVentana(new FrmGestionarCategoriaArbitro());
    }//GEN-LAST:event_itemCategoriaArbitroActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed

        centrarVentana(new Reporte_1());

    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void itemRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRolActionPerformed
        centrarVentana(new FrmGestionarRol());
    }//GEN-LAST:event_itemRolActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
        this.dispose();
        usuario = null;

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void itemTipoDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTipoDocActionPerformed

        centrarVentana(new FrmGestionarTipoDocumentoIdentidad());
    }//GEN-LAST:event_itemTipoDocActionPerformed

    private void itemDimensionEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDimensionEstadioActionPerformed

        centrarVentana(new FrmGestionarDimensionCampo());

    }//GEN-LAST:event_itemDimensionEstadioActionPerformed

    private void itemEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEstadioActionPerformed

        centrarVentana(new FrmGestionarEstadio());

    }//GEN-LAST:event_itemEstadioActionPerformed

    private void itemPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPartidoActionPerformed

        centrarVentana(new FrmGestionarPartido());

    }//GEN-LAST:event_itemPartidoActionPerformed

    private void itemIncidenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIncidenciasActionPerformed
        centrarVentana(new FrmGestionarIncidencias());
    }//GEN-LAST:event_itemIncidenciasActionPerformed

    private void itemPartidosEnVivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPartidosEnVivoActionPerformed
        FrmGestionarIncidencias.verPartido = true;
        centrarVentana(new FrmGestionarIncidencias());
    }//GEN-LAST:event_itemPartidosEnVivoActionPerformed

    private void itemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUsuarioActionPerformed
        
        centrarVentana(new FrmGestionarUsuario());
        
    }//GEN-LAST:event_itemUsuarioActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        centrarVentana(new Reporte_2());
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        centrarVentana(new Reporte_3());
    }//GEN-LAST:event_jMenuItem8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemPartidosAnteriores;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem itemArbitro;
    private javax.swing.JMenuItem itemCategoriaArbitro;
    private javax.swing.JMenuItem itemCompetencia;
    private javax.swing.JMenuItem itemConfedacion;
    private javax.swing.JMenuItem itemContinente;
    private javax.swing.JMenuItem itemContrato;
    private javax.swing.JMenuItem itemCuerpoTecnico;
    private javax.swing.JMenuItem itemCuidad;
    private javax.swing.JMenuItem itemDimensionEstadio;
    private javax.swing.JMenuItem itemEquipo;
    private javax.swing.JMenuItem itemEstadio;
    private javax.swing.JMenuItem itemEtapaFixture;
    private javax.swing.JMenuItem itemEvento;
    private javax.swing.JMenuItem itemFixture;
    private javax.swing.JMenuItem itemFormacion;
    private javax.swing.JMenuItem itemFutbolista;
    private javax.swing.JMenuItem itemGrupo;
    private javax.swing.JMenuItem itemIncidencias;
    private javax.swing.JMenuItem itemInstanciaPartido;
    private javax.swing.JMenuItem itemJornada;
    private javax.swing.JMenuItem itemPais;
    private javax.swing.JMenuItem itemPartido;
    private javax.swing.JMenuItem itemPartidosEnVivo;
    private javax.swing.JMenuItem itemPosicion;
    private javax.swing.JMenuItem itemProfesional;
    private javax.swing.JMenuItem itemRol;
    private javax.swing.JMenuItem itemTernaArbitral;
    private javax.swing.JMenuItem itemTipoDoc;
    private javax.swing.JMenuItem itemTipoJugador;
    private javax.swing.JMenuItem itemTipoProfesional;
    private javax.swing.JMenuItem itemTipoTernaArbitral;
    private javax.swing.JMenuItem itemUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu mnuAdministracion;
    private javax.swing.JMenu mnuGestion;
    private javax.swing.JMenu mnuMantenimiento;
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JMenu mnuTv;
    private javax.swing.JMenu mnuUsuario;
    public static javax.swing.JLabel txtCantEquipo;
    private javax.swing.JLabel txtCantEquipo1;
    // End of variables declaration//GEN-END:variables
}
