package com.deportivo.view;

import com.deportivo.controller.FutbolistaController;
import com.deportivo.model.Futbolista;
import com.deportivo.properties.RenderTable;
import com.deportivo.view.modal.ModalRegistrarFutbolista;
import com.deportivo.vista.modal.alerts.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmGestionarFutbolista extends javax.swing.JInternalFrame {

    public static FutbolistaController futbolistaC = new FutbolistaController();

    public FrmGestionarFutbolista() {
        initComponents();
        listar("");
    }

    public static void listar(String texto) {

        String columas[] = {"#", "FOTO", "NOMBRE", "DOC. IDENTIDAD", "EDAD", "N° Camiseta", "", "", "", "", ""};
        DefaultTableModel modelo = new DefaultTableModel();

        for (String columa : columas) {
            modelo.addColumn(columa);
        }

        Futbolista futbolista;
        List lista;
        if (txtBuscar.getText().length() == 0) {
            lista = futbolistaC.listar();
        } else {
            lista = futbolistaC.buscar(texto);
        }
        Object obj[] = new Object[11];
        ImageIcon foto;
        Image img = null;
        LocalDate hoy = LocalDate.now();

        for (int i = 0; i < lista.size(); i++) {
            futbolista = (Futbolista) lista.get(i);

            try {
                BufferedImage bi = ImageIO.read(futbolista.getFoto());
                foto = new ImageIcon(bi);
                img = foto.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
            } catch (IOException e) {
            }
            obj[0] = futbolista.getFutbolistaId();
            obj[1] = new JLabel(new ImageIcon(img));
            obj[2] = futbolista.getNombreCompleto();
            obj[3] = futbolista.getDocumentoIdentidad();
            obj[4] = hoy.getYear() - futbolista.getFechaNacimiento().getYear() - 1900;
            obj[5] = futbolista.getNumeroCamiseta();

            ImageIcon iconoModi = new ImageIcon("src/com/deportivo/iconos/editar.png");
            Icon btnModificar = new ImageIcon(iconoModi.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            JButton botonModificar = new JButton("", btnModificar);
            botonModificar.setName("btnModificar");
            botonModificar.setToolTipText("modificar");
            botonModificar.setBorder(null);
            botonModificar.setBackground(new Color(255, 198, 26));
            obj[6] = botonModificar;

            ImageIcon icono = new ImageIcon("src/com/deportivo/iconos/eliminar.png");
            Icon btnEliminar = new ImageIcon(icono.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            JButton botonEliminar = new JButton("", btnEliminar);
            botonEliminar.setName("btnEliminar");
            botonEliminar.setToolTipText("eliminar");
            botonEliminar.setBorder(null);
            botonEliminar.setBackground(new Color(223, 68, 83));
            obj[7] = botonEliminar;

            ImageIcon iconoVer = new ImageIcon("src/com/deportivo/iconos/ver.png");
            Icon btnVer = new ImageIcon(iconoVer.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            JButton botonVer = new JButton("", btnVer);
            botonVer.setName("btnVer");
            botonVer.setToolTipText("vista del registro");
            botonVer.setBorder(null);
            botonVer.setBackground(new Color(41, 143, 96));
            obj[8] = botonVer;

            ImageIcon iconoAdd = new ImageIcon("src/com/deportivo/iconos/add28.png");
            Icon btnAdd = new ImageIcon(iconoAdd.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            JButton botonAdd = new JButton("", btnAdd);
            botonAdd.setName("btnAdd");
            botonAdd.setToolTipText("AñadirTipo");
            botonAdd.setBorder(null);
            botonAdd.setBackground(new Color(25, 38, 49));
            obj[9] = botonAdd;

            ImageIcon iconoAdd2 = new ImageIcon("src/com/deportivo/iconos/add28.png");
            Icon btnAdd2 = new ImageIcon(iconoAdd2.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            JButton botonAdd2 = new JButton("", btnAdd2);
            botonAdd2.setName("btnAdd2");
            botonAdd2.setToolTipText("AñadirTipo");
            botonAdd2.setBorder(null);
            botonAdd2.setBackground(new Color(25, 38, 49));
            obj[10] = botonAdd2;

            modelo.addRow(obj);

        }

        tblListado.setRowHeight(70);
        tblListado.setModel(modelo);
        tblListado.setBackground(Color.WHITE);
        tblListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblListado.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblListado.getColumnModel().getColumn(1).setPreferredWidth(70);
        tblListado.getColumnModel().getColumn(2).setPreferredWidth(270);
        tblListado.getColumnModel().getColumn(3).setPreferredWidth(120);
        tblListado.getColumnModel().getColumn(4).setPreferredWidth(110);
        tblListado.getColumnModel().getColumn(5).setPreferredWidth(170);
        tblListado.getColumnModel().getColumn(6).setPreferredWidth(30);
        tblListado.getColumnModel().getColumn(7).setPreferredWidth(30);
        tblListado.getColumnModel().getColumn(8).setPreferredWidth(30);
        tblListado.getColumnModel().getColumn(9).setPreferredWidth(30);
        tblListado.getColumnModel().getColumn(10).setPreferredWidth(30);
        lblTotal.setText(String.valueOf(tblListado.getRowCount()));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new org.edisoncor.gui.textField.TextFieldRectBackground();
        btnAdd = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("GESTIONAR FUTBOLISTA");

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

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel1.setText("Total");

        lblTotal.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(27, 118, 253));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/buscar20.png"))); // NOI18N
        jLabel2.setOpaque(true);

        txtBuscar.setBackground(new java.awt.Color(223, 235, 254));
        txtBuscar.setDescripcion("Ingrese el nombre");
        txtBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(27, 118, 253));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/deportivo/iconos/mas20.png"))); // NOI18N
        btnAdd.setBorder(null);
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setOpaque(true);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal)
                        .addGap(0, 927, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTotal))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        ModalRegistrarFutbolista frm = new ModalRegistrarFutbolista();
        FrmMenuPrincipal.centrarVentana(frm);

    }//GEN-LAST:event_btnAddActionPerformed

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked

        int fila = tblListado.getSelectedRow();
        int id = Integer.parseInt(tblListado.getValueAt(fila, 0).toString());

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
                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un futbolista");
                        } else {
                            String valor = String.valueOf(tblListado.getValueAt(fila, 2));

                            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar al futbolista " + valor + "?", "Confirmar", 2);
                            if (opcion == 0) {

                                try {
                                    futbolistaC.eliminar(id);
                                    AlertaBien alertaBien = new AlertaBien("Mensaje", "futbolista eliminado correctamente!");
                                    listar("");
                                } catch (Exception ex) {
                                    AlertaError err = new AlertaError("ERROR", ex.getMessage());
                                }

                            } else {
                                Alerta alerta = new Alerta("Alerta", "Operación cancelada!");
                            }

                        }
                    }
                    case "btnModificar" -> {
                        if (filas == 0) {//si no elije ninguna fila
                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un futbolista");
                        } else {

                            ModalRegistrarFutbolista.idFutbolista = id;
                            FrmMenuPrincipal.centrarVentana(new ModalRegistrarFutbolista());
                            ModalRegistrarFutbolista.btnGrabar.setText("Modificar");

                        }
                    }

                    case "btnAdd" -> {
                        if (filas == 0) {
                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un futbolista");
                        } else {
                            FrmGestionarDetallePosicionFutbolista.idFubolista = id;
                            FrmMenuPrincipal.centrarVentana(new FrmGestionarDetallePosicionFutbolista());
                        }
                    }
                    
                      case "btnAdd2" -> {
                        if (filas == 0) {
                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un futbolista");
                        } else {
                            FrmGestionarDetallePaisFutbolista.idFutbolista2 = id;
                            FrmMenuPrincipal.centrarVentana(new FrmGestionarDetallePaisFutbolista());
                        }
                    }

                    case "btnVer" -> {
                        if (filas == 0) {
                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un futbolista");
                        } else {
                            ModalRegistrarFutbolista.vista = true;
                            ModalRegistrarFutbolista.idFutbolista = id;
                            FrmMenuPrincipal.centrarVentana(new ModalRegistrarFutbolista());
                        }
                    }
                }
            }
        }

    }//GEN-LAST:event_tblListadoMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        if (txtBuscar.getText().length() % 2 == 0) {
            listar(txtBuscar.getText().toUpperCase());
        }

    }//GEN-LAST:event_txtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblTotal;
    public static javax.swing.JTable tblListado;
    public static org.edisoncor.gui.textField.TextFieldRectBackground txtBuscar;
    // End of variables declaration//GEN-END:variables
}
