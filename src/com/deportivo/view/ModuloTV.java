package com.deportivo.view;

import com.deportivo.controller.*;
import com.deportivo.model.*;
import com.deportivo.properties.RenderTable;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public final class ModuloTV extends javax.swing.JInternalFrame {

    public Timer tiempo;
    DetallePartidoController detallePC = new DetallePartidoController();
    DetalleEquipoController detalleEC = new DetalleEquipoController();
    PartidoController partidoC = new PartidoController();
    FutbolistaController futbolistaC = new FutbolistaController();
    EquipoController equipoC = new EquipoController();
    EventoController eventoC = new EventoController();
    IncidenciaPartidoController incidenciaC = new IncidenciaPartidoController();
    InstanciaPartidoController instanciaC = new InstanciaPartidoController();
    public static int idPartido = 0;

    public ModuloTV() {
        initComponents();
        tiempo = new Timer(60000, null);
        tiempo.start();
        listar();
        tiempo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listar();
            }
        });
    }

    public void listar() {

        DefaultTableModel modelo = new DefaultTableModel();
        List equipos = detallePC.listar(idPartido);
        List incidencias = incidenciaC.listar(idPartido);
        DetallePartido dp;
        IncidenciaPartido ip;
        String local = "", visita = "";
        Object obj[] = new Object[2];
        int equiVisita = 0, equiLocal = 0;

        for (int i = 0; i < equipos.size(); i++) {
            dp = (DetallePartido) equipos.get(i);
            if (dp.getTipo().equalsIgnoreCase("V")) {
                modelo.addColumn(dp.getEquipo().getNombreCorto());
                local = dp.getEquipo().getNombreCorto();
                lblEVisita.setText(dp.getEquipo().getNombreCorto());
            } else {
                modelo.addColumn(dp.getEquipo().getNombreCorto());
                visita = dp.getEquipo().getNombreCorto();
                lblELocal.setText(dp.getEquipo().getNombreCorto());
            }
        }

        for (int i = 0; i < incidencias.size(); i++) {
            ip = (IncidenciaPartido) incidencias.get(i);

            if (ip.getEquipo().getNombreCorto().equals(visita)) {
                obj[0] = "'" + ip.getMinuto() + "'" + ip.getFutbolista().getNombreCompleto() + " " + ip.getEvento().getNombre();
                obj[1] = "";
                modelo.addRow(obj);
                if (ip.getEvento().getEventoId() == 1) {
                    equiLocal++;
                }
            } else if (ip.getEquipo().getNombreCorto().equals(local)) {
                obj[0] = "";
                obj[1] = "'" + ip.getMinuto() + "'" + ip.getFutbolista().getNombreCompleto() + " " + ip.getEvento().getNombre();
                modelo.addRow(obj);
                if (ip.getEvento().getEventoId() == 1) {
                    equiVisita++;
                }
            }

            lblLocal.setText("" + equiLocal);
            lblVisita.setText("" + equiVisita);
        }

        tblListado.setModel(modelo);
    }
    
    public void listarJugadores() {

        DefaultTableModel modelo = new DefaultTableModel();
        List equipos = detallePC.listar(idPartido);
        List incidencias = incidenciaC.listar(idPartido);
        DetallePartido dp;
        DetalleEquipo de;
        IncidenciaPartido ip;
        String local = "", visita = "";
        Object obj[] = new Object[2];
        int equiVisita = 0, equiLocal = 0;
        List fLocal = null;
        List fVisita = null;
        String aLocal[] = new String[11];
        String aVisita[] = new String[11];

        for (int i = 0; i < equipos.size(); i++) {
            dp = (DetallePartido) equipos.get(i);
            if (dp.getTipo().equalsIgnoreCase("V")) {
                modelo.addColumn(dp.getEquipo().getNombreCorto());
                local = dp.getEquipo().getNombreCorto();
                lblEVisita.setText(dp.getEquipo().getNombreCorto());
                fVisita = detalleEC.listar(dp.getEquipo().getEquipoId());
            } else {
                modelo.addColumn(dp.getEquipo().getNombreCorto());
                visita = dp.getEquipo().getNombreCorto();
                lblELocal.setText(dp.getEquipo().getNombreCorto());
                fLocal = detalleEC.listar(dp.getEquipo().getEquipoId());
            }
        }

        for (int i = 0; i < 11; i++) {
            de =  (DetalleEquipo) fLocal.get(i);
            aLocal[i] = de.getFutbolista().getNombreCompleto();
        }
        
        for (int i = 0; i < 11; i++) {
            de =  (DetalleEquipo) fLocal.get(i);
            aVisita[i] = de.getFutbolista().getNombreCompleto();
        }
        
        for (int i = 0; i < 11; i++) {
            obj[0] = aLocal[i];
            obj[1] = aVisita[i];
            modelo.addRow(obj);
        }
        
        tblListado.setModel(modelo);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/deportivo/iconos/marcador.jpg"));
        Image image = icon.getImage();
        pantalla = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        lblVisita = new javax.swing.JLabel();
        lblLocal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblELocal = new javax.swing.JLabel();
        lblEVisita = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnAdd1 = new javax.swing.JButton();
        btnAdd2 = new javax.swing.JButton();
        btnAdd3 = new javax.swing.JButton();
        btnAdd4 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("MODULO TV");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        pantalla.setBackground(new java.awt.Color(255, 255, 255));

        lblVisita.setFont(new java.awt.Font("Segoe UI", 1, 52)); // NOI18N
        lblVisita.setForeground(new java.awt.Color(255, 255, 255));
        lblVisita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblLocal.setFont(new java.awt.Font("Segoe UI", 1, 52)); // NOI18N
        lblLocal.setForeground(new java.awt.Color(255, 255, 255));
        lblLocal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("■ En Vivo");
        jLabel1.setOpaque(true);

        lblELocal.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblELocal.setForeground(new java.awt.Color(255, 255, 255));

        lblEVisita.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblEVisita.setForeground(new java.awt.Color(255, 255, 255));

        pantalla.setLayer(lblVisita, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(lblLocal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(lblELocal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(lblEVisita, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pantallaLayout = new javax.swing.GroupLayout(pantalla);
        pantalla.setLayout(pantallaLayout);
        pantallaLayout.setHorizontalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pantallaLayout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addGroup(pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pantallaLayout.createSequentialGroup()
                        .addComponent(lblLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179))
                    .addGroup(pantallaLayout.createSequentialGroup()
                        .addComponent(lblELocal, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(lblEVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(187, Short.MAX_VALUE))))
        );
        pantallaLayout.setVerticalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pantallaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblELocal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEVisita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93))
        );

        jPanel1.add(pantalla);

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
        jScrollPane2.setViewportView(tblListado);

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
                .addComponent(btnAdd3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnAdd4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(btnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(656, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnAdd3, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnAdd4, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnAdd2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        
        listar();
        
    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void btnAdd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd3ActionPerformed

    private void btnAdd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd4ActionPerformed
       
        listarJugadores();
        
    }//GEN-LAST:event_btnAdd4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnAdd3;
    private javax.swing.JButton btnAdd4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblELocal;
    private javax.swing.JLabel lblEVisita;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblVisita;
    private javax.swing.JDesktopPane pantalla;
    public static javax.swing.JTable tblListado;
    // End of variables declaration//GEN-END:variables
}
